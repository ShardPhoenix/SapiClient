package au.com.sensis.sapi.responsemodel;

public class Category {

    private String id;
    private String name;
    private boolean sensitive;

    public Category(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Category(String id, String name, boolean sensitive) {
        this.id = id;
        this.name = name;
        this.sensitive = sensitive;
    }

    public Category() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSensitive() {
        return sensitive;
    }

    public void setSensitive(boolean sensitive) {
        this.sensitive = sensitive;
    }

}
