package au.com.sensis.sapi.responsemodel;

import static au.com.sensis.sapi.responsemodel.Granularity.NOT_FOUND;

public class Address {

    public static final String KEY_TYPE = "type";
    public static final String KEY_ADDRESS_LINE = "addressLine";
    public static final String KEY_EMS_FRIENDLY_ADDRESS = "emsFriendlyAddress";
    public static final String KEY_SUBURB = "suburb";
    public static final String KEY_STATE = "state";
    public static final String KEY_POSTCODE = "postcode";
    public static final String KEY_LATITUDE = "latitude";
    public static final String KEY_LONGITUDE = "longitude";
    public static final String KEY_IS_GEOCODABLE = "isGeocodable";
    public static final String KEY_GRANULARITY = "geoCodeGranularity";

    private AddressType type;
    private String addressLine;
    private String suburb;
    private String state;
    private String postcode;
    private String latitude;
    private String longitude;
    private Granularity geoCodeGranularity = NOT_FOUND;
    private StreetAddress streetAddress;

    public Address(AddressType type, String addressLine, String suburb, String state, String postcode, String latitude, String longitude, Granularity geoCodeGranularity) {
        this.type = type;
        this.addressLine = addressLine;
        this.suburb = suburb;
        this.state = state;
        this.postcode = postcode;
        this.latitude = latitude;
        this.longitude = longitude;
        this.geoCodeGranularity = geoCodeGranularity;
    }

    public Address(AddressType type, String addressLine, String suburb, String state, String postcode) {
        this(type, addressLine, suburb, state, postcode, null, null, null);
    }

    public Address(Address address) {
        this.type = address.getType();
        this.addressLine = address.getAddressLine();
        this.suburb = address.getSuburb();
        this.state = address.getState();
        this.postcode = address.getPostcode();
        this.latitude = address.getLatitude();
        this.longitude = address.getLongitude();
        this.geoCodeGranularity = Granularity.findByName(address.getGeoCodeGranularity());
    }

    public Address() {
    }

    public AddressType getType() {
        return type;
    }

    public void setType(AddressType type) {
        this.type = type;
    }

    public String getAddressLine() {
        return addressLine;
    }

    public void setAddressLine(String addressLine) {
        this.addressLine = addressLine;
    }

    public String getSuburb() {
        return suburb;
    }

    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String addressAsString() {
        StringBuilder builder = new StringBuilder();

        if (addressLine != null) {
            builder.append(addressLine);
            builder.append("\n");
        }

        if (suburb != null) {
            builder.append(suburb);
            builder.append("\n");
        }

        if (state != null) {
            builder.append(state);
            builder.append(" ");
            builder.append(postcode);
        }

        return builder.toString();
    }

    public String getGeoCodeGranularity() {
        return geoCodeGranularity == null || NOT_FOUND.equals(geoCodeGranularity) ? null : geoCodeGranularity.name();
    }

    public void setGeoCodeGranularity(Granularity geoCodeGranularity) {
        this.geoCodeGranularity = geoCodeGranularity;
    }

    // For jackson serialisation
    public StreetAddress getStreetAddress() {
        return streetAddress;
    }

    // For jackson serialisation
    public void setStreetAddress(StreetAddress streetAddress) {
        this.streetAddress = streetAddress;
    }
}
