package au.com.sensis.sapi.responsemodel;

import java.util.Date;
import java.util.List;

public class SearchResponse {
    
    //TODO: add a toJson() method?

	private List<Listing> results;
	private List<String> details;
	private Long count;
	private Long totalResults;
	private String executedQuery;
	private String originalQuery;
	private Long currentPage;
	private Long totalPages;
	private List<Category> relatedCategories;
	private List<String> validationErrors;
	private Date date;
	private Long time;
	private Integer code;
	private String message;

	/**
	 * The business listings that the search found, containing various business details.
	 */
	public List<Listing> getResults() {
		return results;
	}

	public void setResults(List<Listing> results) {
		this.results = results;
	}

	public List<String> getDetails() {
		return details;
	}

	public void setDetails(List<String> details) {
		this.details = details;
	}

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

	public Long getTotalResults() {
		return totalResults;
	}

	public void setTotalResults(Long totalResults) {
		this.totalResults = totalResults;
	}

	public String getExecutedQuery() {
		return executedQuery;
	}

	public void setExecutedQuery(String executedQuery) {
		this.executedQuery = executedQuery;
	}

	public String getOriginalQuery() {
		return originalQuery;
	}

	public void setOriginalQuery(String originalQuery) {
		this.originalQuery = originalQuery;
	}

	public Long getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Long currentPage) {
		this.currentPage = currentPage;
	}

	public Long getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(Long totalPages) {
		this.totalPages = totalPages;
	}

	public List<Category> getRelatedCategories() {
		return relatedCategories;
	}

	public void setRelatedCategories(List<Category> relatedCategories) {
		this.relatedCategories = relatedCategories;
	}

	public List<String> getValidationErrors() {
		return validationErrors;
	}

	public void setValidationErrors(List<String> validationErrors) {
		this.validationErrors = validationErrors;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Long getTime() {
		return time;
	}

	public void setTime(Long time) {
		this.time = time;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
