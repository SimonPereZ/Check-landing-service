package se.abalon.dto;

/**
 * Data Transfer Object that holds the necessary parameters to be able to redeem an offer.
 */
public class RedeemOfferDTO {

    private String offerCode;
    private String memberId;
    private String workPlaceNumber;

    public String getOfferCode() {
        return offerCode;
    }

    public void setOfferCode(String offerCode) {
        this.offerCode = offerCode;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getWorkPlaceNumber() {
        return workPlaceNumber;
    }

    public void setWorkPlaceNumber(String workPlaceNumber) {
        this.workPlaceNumber = workPlaceNumber;
    }
}
