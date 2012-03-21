package au.com.sensis.sapi.requestmodel;

import org.junit.Assert;
import org.junit.Test;

public class BoundingBoxTest {
    
    @Test
    public void toStringShouldContactFieldsInCorrectOrderWithComma() {
        BoundingBox boundingBox = new BoundingBox(123.0, 456.0, 789.0, 999.0);
        
        Assert.assertEquals("123.0,456.0,789.0,999.0", boundingBox.toString());
    }

}
