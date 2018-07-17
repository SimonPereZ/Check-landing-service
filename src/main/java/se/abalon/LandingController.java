package se.abalon;


import org.springframework.web.bind.annotation.*;
import se.abalon.dto.OfferDTO;
import se.abalon.dto.RedeemOfferDTO;
import se.abalon.exception.EntityNotFoundException;
import se.abalon.exception.UnableToRedeemException;

import java.util.List;

@RestController
@RequestMapping("/landing")
public class LandingController {

    private final CheckService checkService;

    public LandingController(CheckService checkService) {
        this.checkService = checkService;
    }

    /**
     *  The Rest Endpoint to retrieve all valid offers for a specific customer.
     *
     * @param company determines which company's database to use.
     * @param customerId the id for a specific customer.
     * @return an OfferDTO.
     * @throws se.abalon.exception.EntityNotFoundException
     */
    @CrossOrigin
    @GetMapping("/{company}/{customerId}")
    public List<OfferDTO> getOffers(@PathVariable(value = "company") String company, @PathVariable(value = "customerId") String customerId) throws EntityNotFoundException {

        List<OfferDTO> offerDTOs = checkService.getOffers(company, customerId);
        return offerDTOs;
    }

    /**
     * The Rest Endpoint to redeem a specific offer connected to one customer.
     *
     * @param offerDTO Data Transfer Object for the Offer Entity.
     * @param company determines which company's database to use.
     * @param memberId the id for a specific member.
     * @return an RedeemOfferDTO.
     * @throws se.abalon.exception.UnableToRedeemException
     */
    @CrossOrigin
    @PostMapping("/{company}/redeemoffer/{memberId}")
    public RedeemOfferDTO redeemOffer (@RequestBody OfferDTO offerDTO, @PathVariable(value = "company") String company, @PathVariable(value = "memberId") String memberId) throws UnableToRedeemException {

        RedeemOfferDTO offerRedeemed = checkService.redeemOffers(company, offerDTO, memberId);


        return offerRedeemed;
    }
}