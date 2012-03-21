package au.com.sensis.sapi.requestmodel;

import org.junit.Assert;
import org.junit.Test;

public class ProductKeywordTest {
    
    @Test
    public void toStringShouldConcatFieldsWithColon() {
        ProductKeyword keyword = new ProductKeyword("field", "value");
        
        Assert.assertEquals("field:value", keyword.toString());
    }

}
