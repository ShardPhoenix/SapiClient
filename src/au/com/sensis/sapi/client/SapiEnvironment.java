package au.com.sensis.sapi.client;

public enum SapiEnvironment {
    
    TEST("test"), PROD("prod");
    
    private String name;
    
    private SapiEnvironment(String name) {
        this.name = name;
    }
    
    @Override
    public String toString() {
        return name;
    }
    
    public SapiEnvironment fromName(String name) {
        for (SapiEnvironment env : values()) {
            if (env.toString().equals(name)) {
                return env;
            }
        }
        return null;
    }
}
