package au.com.sensis.sapi.responsemodel;

public class Logo {

    private String path;
    private String altText;

    protected Logo() {
    }

    public Logo(String path, String altText) {
        this.path = path;
        this.altText = altText;
    }

    public String getPath() {
        return this.path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getAltText() {
        return altText;
    }

    public void setAltText(String altText) {
        this.altText = altText;
    }
}
