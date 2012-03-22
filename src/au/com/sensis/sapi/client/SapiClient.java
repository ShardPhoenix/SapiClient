package au.com.sensis.sapi.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIUtils;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.conn.params.ConnRoutePNames;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.codehaus.jackson.map.DeserializationConfig.Feature;
import org.codehaus.jackson.map.ObjectMapper;

import au.com.sensis.sapi.requestmodel.ReportingEvent;
import au.com.sensis.sapi.responsemodel.MetadataResponse;
import au.com.sensis.sapi.responsemodel.ReportReponse;
import au.com.sensis.sapi.responsemodel.SearchResponse;

public class SapiClient {
    public static final String SAPI_HOST = "api.sensis.com.au";
    public static final int SAPI_PORT = 80;
    
    public static final String SEARCH_PATH_TEMPLATE = "/ob-20110511/%s/search";
    public static final String REPORT_PATH_TEMPLATE = "/ob-20110511/%s/report";
    private static final String GET_BY_LISTING_ID_PATH_TEMPLATE = "/ob-20110511/%s/getByListingId";
    private static final String METADATA_PATH_TEMPLATE = "/ob-20110511/%s/metadata";
    
    public static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    static {
        // Don't fail if something new was added to the response that isn't in our domain model yet
        OBJECT_MAPPER.configure(Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    private final String apiKey;
    private final String searchPath;
    private final String reportPath;
    private final String getByListingIdPath;
    private final String metadataPath;

    private String proxyUrl;
    private int proxyPort;

    /**
     * SapiClient is a simple client for making requests to SAPI, the Sensis API.
     * 
     * Example usage:
     * SapiClient client = new SapiClient("my-sapi-api-key", SapiEnvironment.TEST);
     * SearchParams params = new SearchParams.Builder()
     * 		.withQuery("tyres").withLocation("melbourne").withPage(2).withPostcode(3000).withPostcode(3001).build();
     * SearchResponse response = client.search(params);
     * This will query SAPI for the 2nd page of tyre-related listings near Melbourne, restricted to postcodes 3000 and 3001.
     * 
     * If using SapiClient from Android, you must use it from either an AsyncTask or a Service (network IO is not allowed on the main thread).
     * If you don't have an api key yet, you need to register for one at http://developers.sensis.com.au/
     * @param apiKey
     */
    public SapiClient(String apiKey, SapiEnvironment environment) {
        this.apiKey = apiKey;
        this.searchPath = String.format(SEARCH_PATH_TEMPLATE, environment.toString());
        this.reportPath = String.format(REPORT_PATH_TEMPLATE, environment.toString());
        this.getByListingIdPath = String.format(GET_BY_LISTING_ID_PATH_TEMPLATE, environment.toString());
        this.metadataPath = String.format(METADATA_PATH_TEMPLATE, environment.toString());
    }
    
    /**
     * Calls the search endpoint with desired parameters, returning a SearchResponse object which contains listings and various metadata.
     * This method will throw a runtime exception if there is an exception during the search request.
     * 
     * If you don't get any results when it seems like you should, check the ValidationErrors in the SearchResponse
     * 
     * More info at: http://developers.sensis.com.au/docs/endpoint_reference/Search
     * Interactive API explorer: http://developers.sensis.com.au/page/api_explorer
     * @param params
     * @return
     */
    public SearchResponse search(SearchParams params) {
        URI uri = null;
        String jsonResponse = null;
        try {
            HttpClient client = getHttpClient();

            List<BasicNameValuePair> queryParams = new ArrayList<BasicNameValuePair>();

            addQueryParam(queryParams, "key", apiKey);

            addQueryParam(queryParams, "query", params.getQuery());
            addQueryParam(queryParams, "location", params.getLocation());
            addQueryParam(queryParams, "sortBy", params.getSortBy());
            addQueryParam(queryParams, "page", params.getPage());
            addQueryParam(queryParams, "rows", params.getRows());

            addQueryParams(queryParams, "categoryId", params.getCategoryIds());
            addQueryParams(queryParams, "postcode", params.getPostcodes());
            addQueryParams(queryParams, "suburb", params.getSuburbs());
            addQueryParams(queryParams, "state", params.getStates());
            addQueryParams(queryParams, "content", params.getContentFilters());
            addQueryParams(queryParams, "productKeyword", params.getProductKeywords());

            addQueryParam(queryParams, "sensitiveCategories", params.getSensitiveCategories());
            addQueryParam(queryParams, "radius", params.getRadius());
            addQueryParam(queryParams, "locationTiers", params.getLocationTiers());
            addQueryParam(queryParams, "boundingBox", params.getBoundingBox());

            uri = URIUtils.createURI("http", SAPI_HOST, SAPI_PORT, searchPath, URLEncodedUtils.format(queryParams, "UTF-8"), null);

            System.out.println(uri); //TODO: remove

            HttpGet request = new HttpGet(uri);

            HttpResponse httpResponse = client.execute(request);

            jsonResponse = extractJsonResponse(httpResponse);

            System.out.println(jsonResponse); //TODO: remove

            SearchResponse searchResponse = OBJECT_MAPPER.readValue(jsonResponse, SearchResponse.class);

            return searchResponse;
        } catch (Exception e) {
            throw wrapException(uri, jsonResponse, e);
        }
    }
    
    /**
     * This endpoint retrieves a single listing based on a known listing id. The response format is the same as for a search,
     * except that only one listing will be included in the results (or zero if the listing id is not found).
     * (The listing id is the top-level "id" field in a listing object.)
     */
    public SearchResponse getByListingId(String listingId) {
        URI uri = null;
        String jsonResponse = null;
        try {
            HttpClient client = getHttpClient();

            List<BasicNameValuePair> queryParams = new ArrayList<BasicNameValuePair>();

            addQueryParam(queryParams, "key", apiKey);
            addQueryParam(queryParams, "query", listingId);

            uri = URIUtils.createURI("http", SAPI_HOST, SAPI_PORT, getByListingIdPath, URLEncodedUtils.format(queryParams, "UTF-8"), null);

            System.out.println(uri); //TODO: remove

            HttpGet request = new HttpGet(uri);

            HttpResponse httpResponse = client.execute(request);

            jsonResponse = extractJsonResponse(httpResponse);

            System.out.println(jsonResponse); //TODO: remove

            SearchResponse searchResponse = OBJECT_MAPPER.readValue(jsonResponse, SearchResponse.class);

            return searchResponse;
        } catch (Exception e) {
            throw wrapException(uri, jsonResponse, e);
        }
    }
    
    /**
     * This endpoint allows for the retrieval of various tyres of reference data from SAPI. 
     * (Currently, a list of the categories or category groups).
     * See http://developers.sensis.com.au/docs/endpoint_reference/Metadata
     */
    public MetadataResponse metadata(MetadataType dataType) {
        URI uri = null;
        String jsonResponse = null;
        try {
            HttpClient client = getHttpClient();

            List<BasicNameValuePair> queryParams = new ArrayList<BasicNameValuePair>();

            addQueryParam(queryParams, "key", apiKey);

            uri = URIUtils.createURI("http", SAPI_HOST, SAPI_PORT, metadataPath + "/" + dataType.toString(),
                    URLEncodedUtils.format(queryParams, "UTF-8"), null);

            System.out.println(uri); //TODO: remove

            HttpGet request = new HttpGet(uri);

            HttpResponse httpResponse = client.execute(request);

            jsonResponse = extractJsonResponse(httpResponse);

            System.out.println(jsonResponse); //TODO: remove

            MetadataResponse searchResponse = OBJECT_MAPPER.readValue(jsonResponse, MetadataResponse.class);

            return searchResponse;
        } catch (Exception e) {
            throw wrapException(uri, jsonResponse, e);
        }
    }
    
    /**
     * It is required that you use this endpoint to report various user actions back to Sensis. For an explanation of
     * what needs to be reported and how, see: http://developers.sensis.com.au/docs/using_endpoints/Reporting_Usage_Events
     * You can check the ReportResponse to ensure that the report was successful.
     * 
     * @param reportEvent
     * @param userIp
     * @param userAgent
     * @param userSessionId
     * @param content
     * @param reportingId
     * @param additionalReportingIds
     * @return
     */
    public ReportReponse report(ReportingEvent reportEvent, String userIp, String userAgent, String userSessionId, String content,
            String reportingId, String... additionalReportingIds) {
        URI uri = null;
        String jsonResponse = null;
        try {
            HttpClient client = getHttpClient();

            List<BasicNameValuePair> queryParams = new ArrayList<BasicNameValuePair>();

            addQueryParam(queryParams, "key", apiKey);

            addQueryParam(queryParams, "userIp", userIp);
            addQueryParam(queryParams, "userAgent", userAgent);
            addQueryParam(queryParams, "userSessionId", userSessionId);
            addQueryParam(queryParams, "content", content);
            addQueryParam(queryParams, "id", reportingId);
            addQueryParams(queryParams, "id", Arrays.asList(additionalReportingIds));

            uri = URIUtils.createURI("http", SAPI_HOST, SAPI_PORT, reportPath + "/" + reportEvent.toString(),
                    URLEncodedUtils.format(queryParams, "UTF-8"), null);

            System.out.println(uri); //TODO: remove

            HttpGet request = new HttpGet(uri);

            HttpResponse httpResponse = client.execute(request);

            jsonResponse = extractJsonResponse(httpResponse);

            System.out.println(jsonResponse); //TODO: remove

            ReportReponse reportResponse = OBJECT_MAPPER.readValue(jsonResponse, ReportReponse.class);

            return reportResponse;
        } catch (Exception e) {
            throw wrapException(uri, jsonResponse, e);
        }

    }

    /**
     * May need to be set if you have a proxy in your test environment.
     */
    public void setProxy(String proxyUrl, int port) {
        this.proxyUrl = proxyUrl;
        this.proxyPort = port;
    }

    private HttpClient getHttpClient() {
        HttpClient client = new DefaultHttpClient(new BasicHttpParams());

        if (proxyUrl != null) {
            HttpHost proxyHost = new HttpHost(proxyUrl, proxyPort);
            client.getParams().setParameter(ConnRoutePNames.DEFAULT_PROXY, proxyHost);
        }
        return client;
    }

    private String extractJsonResponse(HttpResponse httpResponse) throws IOException {
        String jsonResponse = "";
        BufferedReader rd = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent()));
        String line = "";
        while ((line = rd.readLine()) != null) {
            jsonResponse += line;
        }
        return jsonResponse;
    }

    private void addQueryParam(List<BasicNameValuePair> builder, String key, Object value) {
        if (value != null) {
            builder.add(new BasicNameValuePair(key, value.toString()));
        }
    }

    private void addQueryParams(List<BasicNameValuePair> builder, String key, List<?> values) {
        if (values != null && !values.isEmpty()) {
            for (Object value : values) {
                if (value != null) {
                    builder.add(new BasicNameValuePair(key, value.toString()));
                }
            }
        }
    }
    
    private RuntimeException wrapException(URI uri, String jsonResponse, Exception e) {
        String errorMessage = "";
        if (jsonResponse != null) {
            errorMessage = "Successfully called SAPI, but could not parse response: " + jsonResponse;
        } else {
            errorMessage = "Could not successfully call SAPI with url " + uri + " due to exception";
        }
        return new RuntimeException(errorMessage, e);
    }
}
