package au.com.sensis.sapi.responsemodel;

public class ExternalLink {

    private ExternalLinkType type;
    private String actualValue;
    private String displayValue;
    private String description;
    private String customLogo;
    private String label;

    public ExternalLink(ExternalLinkType type, String actualValue, String displayValue,
            String label, String description, String customLogo) {
        this.type = type;
        this.actualValue = actualValue;
        this.displayValue = displayValue;
        this.label = label;
        this.description = description;
        this.customLogo = customLogo;
    }

    // For JSON deserialization
    public ExternalLink() {

    }

    public ExternalLinkType getType() {
        return type;
    }

    public String getActualValue() {
        return actualValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }

    public String getDescription() {
        return description;
    }

    public String getCustomLogo() {
        return customLogo;
    }

    public void setType(ExternalLinkType type) {
        this.type = type;
    }

    public void setActualValue(String actualValue) {
        this.actualValue = actualValue;
    }

    public void setDisplayValue(String displayValue) {
        this.displayValue = displayValue;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCustomLogo(String customLogo) {
        this.customLogo = customLogo;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
