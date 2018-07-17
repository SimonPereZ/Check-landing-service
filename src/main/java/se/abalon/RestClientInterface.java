package se.abalon;

import se.abalon.dto.OfferDTO;
import se.abalon.dto.RedeemOfferDTO;
import se.abalon.exception.EntityNotFoundException;
import se.abalon.exception.UnableToRedeemException;

import java.util.List;

/**
 *  Interface that RestClient implements.
 */
public interface RestClientInterface {

    List<OfferDTO> getOffers(String company, String customerId) throws EntityNotFoundException;

    RedeemOfferDTO redeemOffers(String company, OfferDTO offer, String memberId) throws UnableToRedeemException;
}
