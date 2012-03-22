package au.com.sensis.sapi.client;

public enum MetadataType {
    
    CATEGORIES("categories"), CATEGORY_GROUPS("categoryGroups");
    
    private final String path;

    private MetadataType(String path) {
        this.path = path;
    }
    
    @Override
    public String toString() {
        return path;
    }

}
