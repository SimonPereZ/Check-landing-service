package se.abalon.dto;

/**
 * Data Transfer Object that holds the status for an offer, Valid, Redeemed or Invalid.
 */
public enum OfferStatusDTO {

    VALID("Valid"),
    REDEEMED("Redeemed"),
    INVALID("Invalid");

    private String description;

    OfferStatusDTO(String description) {
        this.description = description;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
