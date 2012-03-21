package au.com.sensis.sapi.responsemodel;

public class ImageGallery {

    private String thumbImageUrl;
    private String largeImageUrl;
    private String thumbImageAltText;

    public ImageGallery(String thumbImageUrl, String largeImageUrl, String thumbImageAltText) {
        this.thumbImageUrl = thumbImageUrl;
        this.largeImageUrl = largeImageUrl;
        this.thumbImageAltText = thumbImageAltText;
    }

    public ImageGallery() {

    }

    public String getThumbImageAltText() {
        return thumbImageAltText;
    }

    public void setThumbImageAltText(String thumbImageAltText) {
        this.thumbImageAltText = thumbImageAltText;
    }

    public String getThumbImageUrl() {
        return thumbImageUrl;
    }

    public void setThumbImageUrl(String thumbImageUrl) {
        this.thumbImageUrl = thumbImageUrl;
    }

    public String getLargeImageUrl() {
        return largeImageUrl;
    }

    public void setLargeImageUrl(String largeImageUrl) {
        this.largeImageUrl = largeImageUrl;
    }
}
