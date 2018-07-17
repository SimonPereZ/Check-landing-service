package se.abalon;

import org.springframework.stereotype.Service;
import se.abalon.dto.OfferDTO;
import se.abalon.dto.RedeemOfferDTO;
import se.abalon.exception.EntityNotFoundException;
import se.abalon.exception.UnableToRedeemException;

import java.util.ArrayList;
import java.util.List;


/**
 *  This Service is the middle ground between the Controllers and the RestClientInterface.
 */
@Service
public class CheckService {

    private final RestClientInterface restClientInterface;

    public CheckService(RestClientInterface restClientInterface) {
        this.restClientInterface = restClientInterface;
    }

    public List<OfferDTO> getOffers(String company, String customerId) throws EntityNotFoundException {
        List<OfferDTO> offerDTOs = restClientInterface.getOffers(company, customerId);

        /*Removes the Offer if either Currency or Value is null*/

        offerDTOs.removeIf(offerDTO -> offerDTO.getCurrency() == null || offerDTO.getValue() == null);

        return offerDTOs;
    }

    public RedeemOfferDTO redeemOffers(String company, OfferDTO offer, String memberId) throws UnableToRedeemException {
        RedeemOfferDTO offerRedeemed = restClientInterface.redeemOffers(company, offer, memberId);

        return offerRedeemed;
    }

}
