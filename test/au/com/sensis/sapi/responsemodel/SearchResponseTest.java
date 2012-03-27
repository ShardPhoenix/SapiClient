package au.com.sensis.sapi.responsemodel;

import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;

public class SearchResponseTest {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @Test
    public void shouldDeserializeFullResponseWithoutException() throws JsonParseException, JsonMappingException, IOException {

        // This is a real response from the api for "tyres" in "melbourne" (limited to 1 result)
        String result = "{\"count\":1,\"results\":[{\"name\":\"Bob Jane T-Marts\",\"id\":\"14263587\"," +
        		"\"productKeywords\":{\"Vehicle Type\":[\"4WDs\",\"Cars\",\"Light Trucks\",\"Utes\"," +
        		"\"Vans\"],\"Brand\":[\"BF Goodrich\",\"Bridgestone\",\"Century\",\"Falken\",\"Firestone\"," +
        		"\"Kumho Tyres\",\"Maxxis\",\"Michelin\",\"Pirelli\",\"Yokohama\"],\"Service\":[\"Balancing\"," +
        		"\"Inspections\",\"Installation\",\"Rotation\",\"Wheel Alignments\"],\"Tyre Feature\":[\"High Performance\"," +
        		"\"Nitrogen-filled\"],\"Concern\":[\"Punctures\"],\"Service Option\":[\"Delivery\"]," +
        		"\"Payment Concern\":[\"Interest Free\",\"Lay-bys\",\"Leasing\",\"No Deposit\",\"Package Deals\"," +
        		"\"Senior Discounts\"],\"Payment Method\":[\"American Express\",\"Cash\",\"Diners Club\"," +
        		"\"EFT\",\"EFTPOS\",\"Fleetcard\",\"Mastercard\",\"Motorpass\",\"Visa\"],\"Assurance\":[\"Accredited\"," +
        		"\"Guaranteed\",\"Warranties\"],\"Ownership\":[\"Australian Owned\",\"Family Owned\"," +
        		"\"Independently Owned\"],\"Hours of Operation\":[\"Flexible Hours\",\"Open Monday - Friday\"," +
        		"\"Open Saturdays\"]},\"categories\":[{\"name\":\"Tyres--Retail\",\"id\":\"24058\",\"sensitive\":false}]," +
        		"\"primaryAddress\":{\"state\":\"VIC\",\"type\":\"PHYSICAL\",\"suburb\":\"Melbourne\",\"postcode\":\"3000\"," +
        		"\"latitude\":\"-37.802017\",\"longitude\":\"144.95703\",\"addressLine\":\"697 Elizabeth St\"," +
        		"\"geoCodeGranularity\":\"PROPERTY\"},\"primaryContacts\":[{\"value\":\"(03) 9326 3921\",\"type\":\"PHONE\"}," +
        		"{\"value\":\"bjmelbourne@tmarts.com.au\",\"type\":\"EMAIL\"},{\"value\":\"http://www.bobjanemelbourne.com.au\"," +
        		"\"type\":\"URL\"}],\"reportingId\":\"eyJzb3VyY2UiOiJZRUxMT1ciLCJwcm9kdWN0SWQiOiI0NzI3NDUxNjUiLCJwcm9kdWN0VmVyc2lvbiI6IjEwIn0\"," +
        		"\"detailsLink\":\"http://www.yellowpages.com.au/vic/melbourne/bob-jane-t-marts-14263587-listing.html?referredBy=TAPI-KhKC-OS-HPdHv3hKLejbDpUZbqC2CtEr\"," +
        		"\"orderedProductKeywords\":[{\"values\":[\"4WDs\",\"Cars\",\"Light Trucks\",\"Utes\",\"Vans\"]," +
        		"\"label\":\"Vehicle Type\"},{\"values\":[\"BF Goodrich\",\"Bridgestone\",\"Century\",\"Falken\"," +
        		"\"Firestone\",\"Kumho Tyres\",\"Maxxis\",\"Michelin\",\"Pirelli\",\"Yokohama\"],\"label\":\"Brand\"}," +
        		"{\"values\":[\"Balancing\",\"Inspections\",\"Installation\",\"Rotation\",\"Wheel Alignments\"],\"label\":\"Service\"}," +
        		"{\"values\":[\"High Performance\",\"Nitrogen-filled\"],\"label\":\"Tyre Feature\"},{\"values\":[\"Punctures\"]," +
        		"\"label\":\"Concern\"},{\"values\":[\"Delivery\"],\"label\":\"Service Option\"},{\"values\":[\"Interest Free\"," +
        		"\"Lay-bys\",\"Leasing\",\"No Deposit\",\"Package Deals\",\"Senior Discounts\"],\"label\":\"Payment Concern\"}," +
        		"{\"values\":[\"American Express\",\"Cash\",\"Diners Club\",\"EFT\",\"EFTPOS\",\"Fleetcard\",\"Mastercard\"," +
        		"\"Motorpass\",\"Visa\"],\"label\":\"Payment Method\"},{\"values\":[\"Accredited\",\"Guaranteed\",\"Warranties\"]," +
        		"\"label\":\"Assurance\"},{\"values\":[\"Australian Owned\",\"Family Owned\",\"Independently Owned\"],\"label\":\"Ownership\"}," +
        		"{\"values\":[\"Flexible Hours\",\"Open Monday - Friday\",\"Open Saturdays\"],\"label\":\"Hours of Operation\"}]," +
        		"\"shortDescriptor\":\"Low Prices, Expert Advice. Tyres, Wheels, Batteries. 100% Aust. Owned.\"," +
        		"\"mediumDescriptor\":\"Australia's largest independent tyre retailer - offering the biggest brands and the widest choice in tyres, wheels & batteries.\"," +
        		"\"listingType\":\"Business\",\"pureMobileBusiness\":false,\"businessLogo\":" +
        		"{\"url\":\"http://www.yellowpages.com.au/content/if/PRODUCTS/65/472745165/10/CONTENTS/53/21742153/1/45145729/logo_010911.gif\"}," +
        		"\"hasExposureProducts\":false,\"externalLinks\":[{\"type\":\"DEEP_LINK\",\"description\":\"Finance Available\"," +
        		"\"displayValue\":\"More information\",\"label\":\"Other\",\"url\":\"http://www.bobjane.com.au/finance.html\"}," +
        		"{\"type\":\"DEEP_LINK\",\"description\":\"Top 10 Tyre Tips\",\"displayValue\":\"More information\"," +
        		"\"label\":\"Other\",\"url\":\"http://www.bobjane.com.au/top-ten-tyre-tips.html\"},{\"type\":\"DEEP_LINK\"," +
        		"\"description\":\"Lowest Tyre Price Guarantee\",\"displayValue\":\"More information\",\"label\":\"Other\"," +
        		"\"url\":\"http://www.bobjane.com.au/lowest-tyre-price-guarantee.html\"},{\"type\":\"DEEP_LINK\"," +
        		"\"description\":\"Tyre Recycling\",\"displayValue\":\"More information\",\"label\":\"Other\"," +
        		"\"url\":\"http://www.bobjane.com.au/tyrecycle.html\"},{\"type\":\"DEEP_LINK\",\"description\":\"Store Locator\"," +
        		"\"displayValue\":\"More information\",\"label\":\"Other\",\"url\":\"http://www.bobjane.com.au/dealer.html\"}," +
        		"{\"type\":\"EDITORIAL\",\"description\":\"Fleet Services\",\"displayValue\":\"More information\",\"label\":\"Other\"," +
        		"\"url\":\"http://www.bobjane.com.au/fleet.html\"},{\"type\":\"EDITORIAL\",\"description\":\"Batteries\"," +
        		"\"displayValue\":\"More information\",\"label\":\"Other\",\"url\":\"http://www.bobjane.com.au/batteries.html\"}," +
        		"{\"type\":\"EDITORIAL\",\"description\":\"Browse Tyres\",\"displayValue\":\"More information\",\"label\":\"Other\"," +
        		"\"url\":\"http://www.bobjane.com.au/tyre-manufacturers.html\"},{\"type\":\"EDITORIAL\",\"description\":\"Browse Wheels\"," +
        		"\"displayValue\":\"More information\",\"label\":\"Other\",\"url\":\"http://www.bobjane.com.au/wheel-manufacturers.html\"}," +
        		"{\"type\":\"FEED\",\"displayValue\":\"Follow us on Twitter\",\"label\":\"Twitter Profile Link\",\"url\":\"http://www.twitter.com/#!/BJTMarts\"}," +
        		"{\"type\":\"FEED\",\"displayValue\":\"Find us on Facebook\",\"label\":" +
        		"\"Facebook Profile Link\",\"url\":\"http://www.facebook.com/pages/Bob-Jane-T-Marts-Official/233645836647827\"}],\"openingHours\"" +
        		":{\"monday\":{\"status\":\"open\",\"times\":[{\"open\":\"08:00\",\"close\":\"17:30\"}]},\"tuesday\":{\"status\":\"open\",\"times\"" +
        		":[{\"open\":\"08:00\",\"close\":\"17:30\"}]},\"wednesday\":{\"status\":\"open\",\"times\":[{\"open\":\"08:00\",\"close\":\"17:30\"}]}," +
        		"\"thursday\":{\"status\":\"open\",\"times\":[{\"open\":\"08:00\",\"close\":\"17:30\"}]},\"friday\":{\"status\":\"open\",\"times\"" +
        		":[{\"open\":\"08:00\",\"close\":\"17:30\"}]},\"saturday\":{\"status\":\"open\",\"times\":[{\"open\":\"08:00\",\"close\":\"16:00\"}]}," +
        		"\"sunday\":{\"status\":\"closed\"}},\"numberOfAdditionalListings\":12,\"secondaryContacts\":{\"Other Contacts\":" +
        		"[{\"value\":\"info@janefleet.com.au\",\"type\":\"EMAIL\",\"description\":\"Fleet Enquiries\"}," +
        		"{\"value\":\"feedback@bobjane.com.au\",\"type\":\"EMAIL\",\"description\":\"Customer Service\"}," +
        		"{\"value\":\"(03) 9326 5031\",\"type\":\"FAX\"}]},\"orderedSecondaryContacts\":[{\"name\":\"Other Contacts\",\"contacts\":" +
        		"[{\"value\":\"info@janefleet.com.au\",\"type\":\"EMAIL\",\"description\":\"Fleet Enquiries\"},{\"value\":\"feedback@bobjane.com.au\"," +
        		"\"type\":\"EMAIL\",\"description\":\"Customer Service\"},{\"value\":\"(03) 9326 5031\",\"type\":\"FAX\"}]}]}],\"totalResults\":295,\"totalPages\":295," +
        		"\"currentPage\":1,\"executedQuery\":\"tyres\",\"originalQuery\":\"tyres\",\"message\":\"OK\"," +
        		"\"date\":\"2012-03-27T14:54:52.763+1100\",\"time\":145,\"code\":200}";
        
        SearchResponse response = OBJECT_MAPPER.readValue(result, SearchResponse.class);
    }

}
