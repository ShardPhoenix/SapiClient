package au.com.sensis.sapi.responsemodel;

import org.codehaus.jackson.annotate.JsonCreator;

public enum ListingOpeningHoursStatus {

    USE_TIMES("open"),
    CLOSED("closed"),
    BY_APPOINTMENT("byAppointment"),
    TWENTY_FOUR_HOURS("24hours");

    private String value;

    private ListingOpeningHoursStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }
    
    @JsonCreator
    public static ListingOpeningHoursStatus fromString(String value) {
    	for (ListingOpeningHoursStatus status : values()) {
    		if (status.getValue().equals(value)) {
    			return status;
    		}
    	}
    	return null;
    	
    }

}
