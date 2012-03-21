package au.com.sensis.sapi.responsemodel;

public enum Granularity {

    PROPERTY,
    INTERSECTION,
    STREET,
    SUBURB,
    STATE,
    REGION,
    LAT_LONG,
    OTHER,
    NOT_FOUND,
    NULL;

    public static Granularity findByName(String granularity) {
        try {
            return Granularity.valueOf(granularity);
        } catch (IllegalArgumentException e) {
            return OTHER;
        }
    }

    public static boolean isReverseLookupable(Granularity granularity) {
        return PROPERTY.equals(granularity) || INTERSECTION.equals(granularity);
    }

    public static boolean isSuburbOrSmaller(Granularity granularity) {
        return SUBURB == granularity
                || STREET == granularity
                || LAT_LONG == granularity
                || PROPERTY == granularity
                || INTERSECTION == granularity;
    }

}
