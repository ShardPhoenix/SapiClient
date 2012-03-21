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
import au.com.sensis.sapi.responsemodel.ReportReponse;
import au.com.sensis.sapi.responsemodel.SearchResponse;

public class SapiClient {
	public static final String SAPI_HOST = "api.sensis.com.au";
	private static final int SAPI_PORT = 80;
	public static final String SEARCH_PATH = "/ob-20110511/test/search"; //TODO: can this change? - test vs prod - make configurable?
	public static final String REPORT_PATH = "/ob-20110511/test/report";
	
	public static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

	static {
		// Don't fail if something new was added to the response that isn't in our domain model yet
		OBJECT_MAPPER.configure(Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}
	
	private final String apiKey;
	
	private String proxyUrl;
	private int proxyPort;
	
	/**
	 * SapiClient is a simple client for making requests to SAPI, the Sensis API.
	 * 
	 * Example usage:
	 * SapiClient client = new Client("my-sapi-api-key");
	 * SearchParams params = new SearchParams.Builder()
	 * 		.withQuery("tyres").withLocation("melbourne").withPage(2).withPostcode(3000).withPostcode(3001).build();
	 * SearchResponse response = client.search(params);
	 * This will query SAPI for the 2nd page of tyre-related listings near Melbourne, restricted to postcodes 3000 and 3001.
	 * 
	 * If using SapiClient from Android, you must use it from either an AsyncTask or a Service (network IO is not allowed on the main thread).
	 * If you don't have an api key yet, you need to register for one at http://developers.sensis.com.au/
	 * @param apiKey
	 */
	public SapiClient(String apiKey) {
		this.apiKey = apiKey;
	}
	
	//TODO: add getByListingId endpoint, **report**, metadata
	
	//TODO: javadoc
	public ReportReponse report(ReportingEvent reportEvent, String userIp, String userAgent, 
	        String userSessionId, String content, String reportingId, String... additionalReportingIds) {
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
        
        uri = URIUtils.createURI("http", SAPI_HOST, SAPI_PORT, REPORT_PATH + "/" + reportEvent.toString(), URLEncodedUtils.format(queryParams, "UTF-8"), null);
        
        System.out.println(uri); //TODO: remove
        
        HttpGet request = new HttpGet(uri);
        
        HttpResponse httpResponse = client.execute(request);
        
        jsonResponse = extractJsonResponse(httpResponse);
        
        System.out.println(jsonResponse); //TODO: remove
        
        ReportReponse reportResponse = OBJECT_MAPPER.readValue(jsonResponse, ReportReponse.class);
        
        return reportResponse;
        } catch (Exception e) {
            String errorMessage = "";
            if (jsonResponse != null) {
                errorMessage = "Successfully called SAPI, but could not parse response: " + jsonResponse;
            } else {
                errorMessage = "Could not successfully call SAPI with url " + uri + " due to exception";
            }
            throw new RuntimeException(errorMessage, e);
        }
        
	}
	
	/**
	 * Calls the search endpoint with desired parameters, returning a SearchResponse object which contains listings and various metadata.
	 * This method will throw a runtime exception if there is an exception during the search request.
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
			
			//TODO: handle error if both query and location are null or empty (or either is!)
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
			
			uri = URIUtils.createURI("http", SAPI_HOST, SAPI_PORT, SEARCH_PATH, URLEncodedUtils.format(queryParams, "UTF-8"), null);
			
			System.out.println(uri); //TODO: remove
			
			HttpGet request = new HttpGet(uri);
			
			HttpResponse httpResponse = client.execute(request);
			
			jsonResponse = extractJsonResponse(httpResponse);
			
			System.out.println(jsonResponse); //TODO: remove
			
			SearchResponse searchResponse = OBJECT_MAPPER.readValue(jsonResponse, SearchResponse.class);
			
			return searchResponse;
		} catch (Exception e) {
			String errorMessage = "";
			if (jsonResponse != null) {
				errorMessage = "Successfully called SAPI, but could not parse response: " + jsonResponse;
			} else {
				errorMessage = "Could not successfully call SAPI with url " + uri + " due to exception";
			}
			throw new RuntimeException(errorMessage, e);
		}
			
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
	
	/**
	 * May need to be set if you have a proxy in your test environment.
	 * @param host
	 * @param port
	 */
	public void setProxyInfo(String proxyUrl, int port) {
		this.proxyUrl = proxyUrl;
		this.proxyPort = port;
	}
	

}
