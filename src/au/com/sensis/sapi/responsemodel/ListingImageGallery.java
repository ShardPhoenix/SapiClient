package au.com.sensis.sapi.responsemodel;

public class ListingImageGallery {

    private String thumbnailUrl;
    private String largeUrl;
    private String altText;

    public ListingImageGallery() {
    }

    public ListingImageGallery(ImageGallery imageGallery) {
        this.thumbnailUrl = imageGallery.getThumbImageUrl();
        this.largeUrl = imageGallery.getLargeImageUrl();
        this.altText = imageGallery.getThumbImageAltText();
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public String getLargeUrl() {
        return largeUrl;
    }

    public void setLargeUrl(String largeUrl) {
        this.largeUrl = largeUrl;
    }

    public String getAltText() {
        return altText;
    }

    public void setAltText(String altText) {
        this.altText = altText;
    }

}
