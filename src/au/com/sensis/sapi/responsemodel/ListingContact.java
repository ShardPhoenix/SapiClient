package au.com.sensis.sapi.responsemodel;

public class ListingContact {

    private ContactType type;
    private String value;
    private String description;
    private Boolean isMetered;
    private String originalValue;
    
    public ListingContact() {
    }

    public ContactType getType() {
        return type;
    }

    public void setType(ContactType type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getIsMetered() {
        return isMetered;
    }

    public void setIsMetered(Boolean isMetered) {
        this.isMetered = isMetered;
    }

    public String getOriginalValue() {
        return originalValue;
    }

    public void setOriginalValue(String originalValue) {
        this.originalValue = originalValue;
    }
}
