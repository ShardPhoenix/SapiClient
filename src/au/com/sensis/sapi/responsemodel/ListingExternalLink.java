package au.com.sensis.sapi.responsemodel;

public class ListingExternalLink {

    private String url;
    private String displayValue;
    private String label;
    private String description;
    private String logo;
    private ExternalLinkType type;

    public ListingExternalLink() {
    }

    public ListingExternalLink(ExternalLink externalLink) {
        this.type = externalLink.getType();
        this.url = externalLink.getActualValue();
        this.displayValue = externalLink.getDisplayValue();
        this.label = externalLink.getLabel();
        this.description = externalLink.getDescription();
        this.logo = externalLink.getCustomLogo();
    }

    public ExternalLinkType getType() {
        return type;
    }

    public void setType(ExternalLinkType type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDisplayValue() {
        return displayValue;
    }

    public void setDisplayValue(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

}
