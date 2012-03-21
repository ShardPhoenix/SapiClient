package au.com.sensis.sapi.requestmodel;

public enum ReportingEvent {
    
    ADD_TO_CONTACTS("addToContacts"), ADD_TO_FAVOURITES("addToFavourites"), APPEARANCE("appearance"), 
    CLICK_TO_CALL("dial"), GET_DIRECTIONS("getDirections"), PRINT_BUSINESS_DETAILS_PAGE("printBusinessDetails"),
    SEND_EMAIL("sendEmail"), SEND_TO_FRIEND("sendToFriend"), SEND_TO_MOBILE("sendToMobile"), VIEW_BUSINESS_DETAILS_PAGE("viewDetails"),
    VIEW_MAP("viewMap"), WEBSITE_REFERRAL("viewWebsite"), VIEW_EXTERNAL_LINK("viewExternalLink"), VIEW_YOUTUBE_VIDEO("viewVideo"),
    WRITE_REVIEW("writeReview");
    
    private final String endpoint;
    
    private ReportingEvent(String endPoint) {
        this.endpoint = endPoint;
    }
    
    @Override
    public String toString() {
        return endpoint;
    }
}
