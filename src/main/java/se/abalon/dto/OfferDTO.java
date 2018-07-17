package se.abalon.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Data Transfer Object for the Offer Entity.
 */
public class OfferDTO {

    private String activator;
    private Long allowedNumberOfRedemptions;
    private String availableFromTime;
    private String availableToTime;
    private String code;
    private Boolean combinable;
    private CurrencyDTO currency;
    private String dutyText;
    private Date effectiveDate;
    private String imageUrl;
    private String internalDescription;
    private String name;
    private String note;
    private Boolean preselected;
    private OfferStatusDTO status;
    private String type;
    private String unit;
    private List<String> validForProductCodes = new ArrayList<String>();
    private Date validityDate;
    private BigDecimal value;

    public String getActivator() {
        return activator;
    }

    public void setActivator(String activator) {
        this.activator = activator;
    }

    public Long getAllowedNumberOfRedemptions() {
        return allowedNumberOfRedemptions;
    }

    public void setAllowedNumberOfRedemptions(Long allowedNumberOfRedemptions) {
        this.allowedNumberOfRedemptions = allowedNumberOfRedemptions;
    }

    public String getAvailableFromTime() {
        return availableFromTime;
    }

    public void setAvailableFromTime(String availableFromTime) {
        this.availableFromTime = availableFromTime;
    }

    public String getAvailableToTime() {
        return availableToTime;
    }

    public void setAvailableToTime(String availableToTime) {
        this.availableToTime = availableToTime;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Boolean getCombinable() {
        return combinable;
    }

    public void setCombinable(Boolean combinable) {
        this.combinable = combinable;
    }

    public CurrencyDTO getCurrency() {
        return currency;
    }

    public void setCurrency(CurrencyDTO currency) {
        this.currency = currency;
    }

    public String getDutyText() {
        return dutyText;
    }

    public void setDutyText(String dutyText) {
        this.dutyText = dutyText;
    }

    public Date getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getInternalDescription() {
        return internalDescription;
    }

    public void setInternalDescription(String internalDescription) {
        this.internalDescription = internalDescription;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Boolean getPreselected() {
        return preselected;
    }

    public void setPreselected(Boolean preselected) {
        this.preselected = preselected;
    }

    public OfferStatusDTO getStatus() {
        return status;
    }

    public void setStatus(OfferStatusDTO status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public List<String> getValidForProductCodes() {
        return validForProductCodes;
    }

    public void setValidForProductCodes(List<String> validForProductCodes) {
        this.validForProductCodes = validForProductCodes;
    }

    public Date getValidityDate() {
        return validityDate;
    }

    public void setValidityDate(Date validityDate) {
        this.validityDate = validityDate;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }
}
