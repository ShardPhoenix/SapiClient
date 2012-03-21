package au.com.sensis.sapi.requestmodel;

import junit.framework.Assert;

import org.junit.Test;

public class ContentFilterTest {

    @Test
    public void toStringShouldReturnCamelCaseName() {
        Assert.assertEquals("businessLogo", ContentFilter.BUSINESS_LOGO.toString());
    }

}
