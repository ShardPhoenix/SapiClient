package au.com.sensis.sapi.responsemodel;

import java.util.List;

public class MetadataResponse {

    private List<Category> categories;
    private List<CategoryGroup> groups;
    private Integer time;
    private Integer code;

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public List<CategoryGroup> getGroups() {
        return groups;
    }

    public void setGroups(List<CategoryGroup> groups) {
        this.groups = groups;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

}
