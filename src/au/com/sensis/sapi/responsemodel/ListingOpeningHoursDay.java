package au.com.sensis.sapi.responsemodel;

public enum ListingOpeningHoursDay {

    MONDAY("monday"),
    TUESDAY("tuesday"),
    WEDNESDAY("wednesday"),
    THURSDAY("thursday"),
    FRIDAY("friday"),
    SATURDAY("saturday"),
    SUNDAY("sunday"),
    PUBLIC_HOLIDAYS("publicHolidays");

    private String value;

    private ListingOpeningHoursDay(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }

}
