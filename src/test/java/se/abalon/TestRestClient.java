package se.abalon;

import org.springframework.stereotype.Component;
import se.abalon.dto.CurrencyDTO;
import se.abalon.dto.OfferDTO;
import se.abalon.dto.RedeemOfferDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * A mock Rest Client used only when running tests.
 */
@Component
public class TestRestClient implements RestClientInterface {


    @Override
    public List<OfferDTO> getOffers(String company, String customerId) {
        CurrencyDTO currencyDTO = new CurrencyDTO();
        currencyDTO.setCode("SEK");
        currencyDTO.setName("Svenska kronor");

        OfferDTO offerDTO = new OfferDTO();
        offerDTO.setCode("offerCode");
        offerDTO.setCurrency(currencyDTO);
        offerDTO.setAllowedNumberOfRedemptions(1L);

        List<OfferDTO> offerDTOS = new ArrayList<>();
        offerDTOS.add(offerDTO);

        return offerDTOS;

    }

    @Override
    public RedeemOfferDTO redeemOffers(String company, OfferDTO offer, String memberId) {
        RedeemOfferDTO redeemOfferDTO = new RedeemOfferDTO();
        redeemOfferDTO.setMemberId(memberId);
        redeemOfferDTO.setOfferCode("offerCode");
        redeemOfferDTO.setWorkPlaceNumber("0");

        return redeemOfferDTO;
    }
}
