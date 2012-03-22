package au.com.sensis.sapi.responsemodel;

import java.util.List;

public class CategoryGroup {

    private String name;
    private List<CategoryGroup> children;
    private List<Category> categories;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CategoryGroup> getChildren() {
        return children;
    }

    public void setChildren(List<CategoryGroup> children) {
        this.children = children;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

}
