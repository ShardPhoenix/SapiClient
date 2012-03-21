package au.com.sensis.sapi.responsemodel;

public class StreetAddress {

    public static final StreetAddress NULL = new StreetAddress();
    private String prefix;
    private String optionalAddress;
    private String apartment;
    private String houseNumber;
    private String name;
    private String type;
    private String direction;
    private String suffix;

    public StreetAddress() {
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public void setApartment(String apartment) {
        this.apartment = apartment;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setOptionalAddress(String optionalAddress) {
        this.optionalAddress = optionalAddress;
    }

    public String getPrefix() {
        return prefix;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public String getName() {
        return name;
    }

    public String getDirection() {
        return direction;
    }

    public String getType() {
        return type;
    }

    public String getApartment() {
        return apartment;
    }

    public String getOptionalAddress() {
        return optionalAddress;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }
}
