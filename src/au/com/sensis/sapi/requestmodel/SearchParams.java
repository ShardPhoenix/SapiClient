package au.com.sensis.sapi.requestmodel;

import java.util.ArrayList;
import java.util.List;


/**
 * Represents the query parameters to be passed to the /search endpoint of SAPI.
 * For a description of what these parameters mean, see:
 * http://developers.sensis.com.au/docs/endpoint_reference/Search
 * You can also try out searches with the API explorer:
 * http://developers.sensis.com.au/page/api_explorer
 *
 */
public class SearchParams {
	
	private final String query;
	private final String location;
	private final SortBy sortBy;
	private final Integer page;
	private final Integer rows;
	private final List<State> states;
	private final List<ContentFilter> contentFilters;
	private final List<String> suburbs;
	private final List<String> categoryIds;
	private final List<Integer> postcodes;
	private final Boolean sensitiveCategories;
	private final List<ProductKeyword> productKeywords;
	private final Double radius;
	private final BoundingBox boundingBox;
	private final Integer locationTiers;
	
	private SearchParams(Builder builder) {
		this.query = builder.query;
		this.location = builder.location;
		this.sortBy = builder.sortBy;
		this.page = builder.page;
		this.rows = builder.rows;
		this.states = builder.states;
		this.contentFilters = builder.contentFilters;
		this.suburbs = builder.suburbs;
		this.categoryIds = builder.categoryIds;
		this.postcodes = builder.postcodes;
		this.sensitiveCategories = builder.sensitiveCategories;
		this.productKeywords = builder.productKeywords;
		this.radius = builder.radius;
		this.boundingBox = builder.boundingBox;
		this.locationTiers = builder.locationTiers;
	}
	
	public static class Builder {

		private String query;
		private String location;
		private SortBy sortBy;
		private Integer page;
		private Integer rows;
		private List<String> categoryIds = new ArrayList<String>();
		private List<Integer> postcodes = new ArrayList<Integer>();
		private List<String> suburbs = new ArrayList<String>();
		private List<State> states = new ArrayList<State>();
		private List<ContentFilter> contentFilters = new ArrayList<ContentFilter>();
		private Integer locationTiers;
		private BoundingBox boundingBox;
		private Double radius;
		private List<ProductKeyword> productKeywords = new ArrayList<ProductKeyword>();
		private Boolean sensitiveCategories;
		
		public Builder withQuery(String query) {
			this.query = query;
			return this;
		}
		
		public Builder withLocation(String location) {
			this.location = location;
			return this;
		}
		
		public Builder withSortBy(SortBy sortBy) {
			this.sortBy = sortBy;
			return this;
		}
		
		public Builder withPage(Integer page) {
			this.page = page;
			return this;
		}
		
		public Builder withRows(Integer rows) {
			this.rows = rows;
			return this;
		}
		
		public Builder withCategoryId(String categoryId) {
			this.categoryIds.add(categoryId);
			return this;
		}
		
		public Builder withPostcode(Integer postcode) {
			this.postcodes.add(postcode);
			return this;
		}
		
		public Builder withSuburb(String suburb) {
			this.suburbs.add(suburb);
			return this;
		}
		
		public Builder withState(State state) {
			this.states.add(state);
			return this;
		}
		
		public Builder withContent(ContentFilter filter) {
			this.contentFilters.add(filter);
			return this;
		}
		
		public SearchParams build() {
			return new SearchParams(this);
		}
		
		public Builder withLocationTiers(Integer locationTiers) {
			this.locationTiers = locationTiers;
			return this;
		}
		
		public Builder withBoundingBox(BoundingBox boundingBox) {
			this.boundingBox = boundingBox;
			return this;
		}
		
		public Builder withRadius(Double radius) {
			this.radius = radius;
			return this;
		}
		
		public Builder withProductKeyword(ProductKeyword keyword) {
			this.productKeywords.add(keyword);
			return this;
		}
		
		public Builder withSensitiveCategories(Boolean includeSenstiveCategories) {
			this.sensitiveCategories = includeSenstiveCategories;
			return this;
		}
		
	}
	
	public String getQuery() {
		return query;
	}

	public String getLocation() {
		return location;
	}

	public SortBy getSortBy() {
		return sortBy;
	}

	public Integer getPage() {
		return page;
	}

	public Integer getRows() {
		return rows;
	}

	public List<State> getStates() {
		return states;
	}

	public List<ContentFilter> getContentFilters() {
		return contentFilters;
	}

	public List<String> getSuburbs() {
		return suburbs;
	}

	public List<String> getCategoryIds() {
		return categoryIds;
	}

	public List<Integer> getPostcodes() {
		return postcodes;
	}

	public List<ProductKeyword> getProductKeywords() {
		return productKeywords;
	}

	public Boolean getSensitiveCategories() {
		return sensitiveCategories;
	}

	public Double getRadius() {
		return radius;
	}

	public Integer getLocationTiers() {
		return locationTiers;
	}

	public BoundingBox getBoundingBox() {
		return boundingBox;
	}
}
