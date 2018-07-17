package se.abalon.dto;

/**
 * Data Transfer Object that holds the code and name for an Offers Currency.
 */
public class CurrencyDTO {

    private String code;
    private String name;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
