package au.com.sensis.sapi.responsemodel;

import org.codehaus.jackson.annotate.JsonIgnore;

public class ListingBusinessLogo {

    private String url;
    private String altText;

    public ListingBusinessLogo() {
    }

    public ListingBusinessLogo(Logo logo) {
        this.url = logo.getPath();
        this.altText = logo.getAltText();
    }

    @JsonIgnore
    public boolean isEmpty() {
        return equals(new ListingBusinessLogo());
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAltText() {
        return altText;
    }

    public void setAltText(String altText) {
        this.altText = altText;
    }

}
