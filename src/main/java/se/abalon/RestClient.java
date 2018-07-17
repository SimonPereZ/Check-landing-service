package se.abalon;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;
import se.abalon.dto.OfferDTO;
import se.abalon.dto.RedeemOfferDTO;
import se.abalon.exception.EntityNotFoundException;
import se.abalon.exception.UnableToRedeemException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * RestClient uses a RestTemplate to make calls to the Abalon Relevate API.
 * Implements: RestClientInterface
 *
 * Abalon Api has been removed
 */
public class RestClient implements RestClientInterface {

    private final RestTemplate restTemplate;
    private static final Logger log = LoggerFactory.getLogger(RestClient.class);

    private final String WORKPLACE_NUMBER = "0";


    public RestClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    /**
     *
     * uses a RestTemplate to make calls to the Abalon Relevate API. Specifically the endpoint to retrieve all valid offers for a customer.
     *
     * @param company determines which company's database to use.
     * @param customerId the id for a specific customer.
     * @return
     */
    public List<OfferDTO> getOffers(String company, String customerId) throws EntityNotFoundException {

        OfferDTO[] offerDTOs = restTemplate.getForObject("https://" + company + ".abalonrelevate.se..." + customerId + "/offers", OfferDTO[].class);

        log.info("Got Offers for customer with id: " + customerId);

        List<OfferDTO> offerDTOList = new ArrayList<>(Arrays.asList(offerDTOs));

        return offerDTOList;
    }


    /**
     *
     * uses a RestTemplate to make calls to the Abalon Relevate API. Specifically the endpoint to redeem an offer connected to a specific customer.
     *
     * @param offer Data Transfer Object for the Offer Entity.
     * @param company determines which company's database to use.
     * @param memberId the id for a specific member.
     * @return
     */
    public RedeemOfferDTO redeemOffers(String company, OfferDTO offer, String memberId) throws UnableToRedeemException {

        RedeemOfferDTO redeemOfferDTO = new RedeemOfferDTO();
        redeemOfferDTO.setMemberId(memberId);
        redeemOfferDTO.setOfferCode(offer.getCode());
        redeemOfferDTO.setWorkPlaceNumber(WORKPLACE_NUMBER);

        RedeemOfferDTO response = restTemplate.postForObject("https://" + company + ".abalonrelevate...", redeemOfferDTO, RedeemOfferDTO.class);

        return response;
    }


}
