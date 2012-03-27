package au.com.sensis.sapi.requestmodel;

import java.io.IOException;

import junit.framework.Assert;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;

import au.com.sensis.sapi.requestmodel.BoundingBox;
import au.com.sensis.sapi.requestmodel.ContentFilter;
import au.com.sensis.sapi.requestmodel.ProductKeyword;
import au.com.sensis.sapi.requestmodel.SearchParams;
import au.com.sensis.sapi.requestmodel.SortBy;
import au.com.sensis.sapi.requestmodel.State;

public class SearchParamsTest {
    
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    
    @Test
    public void testBuilder() throws JsonGenerationException, JsonMappingException, IOException {
        SearchParams params = new SearchParams.Builder()
            .withBoundingBox(new BoundingBox(55.0, 56.0, 22.0, 23.0))
            .withBoundingBox(new BoundingBox(1.0, 2.0, 3.0, 4.0))
            .withCategoryId("categoryId1")
            .withCategoryId("categoryId2")
            .withContent(ContentFilter.BUSINESS_LOGO)
            .withContent(ContentFilter.IMAGE_GALLERY)
            .withLocation("location1")
            .withLocation("location2")
            .withLocationTiers(4)
            .withLocationTiers(5)
            .withPage(2)
            .withPage(3)
            .withPostcode(1234)
            .withPostcode(3000)
            .withProductKeyword(new ProductKeyword("field1", "value1"))
            .withProductKeyword(new ProductKeyword("field2", "value2"))
            .withQuery("query1")
            .withQuery("query2")
            .withRadius(10.0)
            .withRadius(12.0)
            .withRows(10)
            .withRows(20)
            .withSensitiveCategories(false)
            .withSensitiveCategories(true)
            .withSortBy(SortBy.DISTANCE)
            .withSortBy(SortBy.RELEVANCE)
            .withState(State.VIC)
            .withState(State.QLD)
            .withSuburb("Prahran")
            .withSuburb("Windsor")
            .build();

        String expected = 
                "{\"query\":\"query2\"," +
        		"\"location\":\"location2\"," +
        		"\"sortBy\":\"RELEVANCE\"," +
        		"\"page\":3," +
        		"\"rows\":20," +
        		"\"states\":[\"VIC\",\"QLD\"]," +
        		"\"contentFilters\":[\"BUSINESS_LOGO\",\"IMAGE_GALLERY\"]," +
        		"\"suburbs\":[\"Prahran\",\"Windsor\"]," +
        		"\"categoryIds\":[\"categoryId1\",\"categoryId2\"]," +
        		"\"postcodes\":[1234,3000]," +
        		"\"sensitiveCategories\":true," +
        		"\"productKeywords\":[{\"field\":\"field1\",\"value\":\"value1\"},{\"field\":\"field2\",\"value\":\"value2\"}]," +
        		"\"radius\":12.0," +
        		"\"boundingBox\":{\"topLeftLat\":1.0,\"topLeftLong\":2.0,\"bottomRightLat\":3.0,\"bottomRightLong\":4.0}," +
        		"\"locationTiers\":5}";
        
        String paramsJson = OBJECT_MAPPER.writeValueAsString(params);
        
        Assert.assertEquals(expected, paramsJson);
    }
}
