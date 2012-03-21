package au.com.sensis.sapi.responsemodel;

import java.util.List;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonProperty;

public class ProductKeywordList {

    private String label;
    private List<String> values;

    @JsonCreator
    public ProductKeywordList(@JsonProperty("label") String label, @JsonProperty("values") List<String> values) {
        this.label = label;
        this.values = values;
    }

    public String getLabel() {
        return label;
    }

    public List<String> getValues() {
        return values;
    }

}
