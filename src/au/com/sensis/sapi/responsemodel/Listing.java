package au.com.sensis.sapi.responsemodel;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Listing {

	private List<ExternalCoupon> coupons;
	private String id;
	private Map<String, List<String>> externalSourceIds;
	private String name;

	private String reportingId;

	private List<Category> categories;

	private LinkedHashMap<String, List<String>> productKeywords;
	private List<ProductKeywordList> orderedProductKeywords;

	private String shortDescriptor;
	private String mediumDescriptor;
	private String serviceNotes;

	private String listingType;

	private Boolean freeListing;

	private String detailsLink;
	private Boolean pureMobileBusiness;
	private String priceQualifier;
	private List<String> tradingAliases;

	private ListingBusinessLogo businessLogo;
	private ListingBusinessInfo businessInfo;

	private Boolean hasExposureProducts;

	private List<ListingImageGallery> imageGallery;

	private List<ListingExternalLink> externalLinks;

	private Address primaryAddress;
	private List<Address> additionalAddresses;

	private List<ListingContact> primaryContacts;
	private Map<String, List<ListingContact>> secondaryContacts;
	private List<GroupedContacts<ListingContact>> orderedSecondaryContacts;

	private ListingOpeningHours openingHours;

	private Long numberOfAdditionalListings;

	private Double distance;

	private Boolean hasMeteredTn;

	public List<ExternalCoupon> getCoupons() {
		return coupons;
	}

	public void setCoupons(List<ExternalCoupon> coupons) {
		this.coupons = coupons;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Map<String, List<String>> getExternalSourceIds() {
		return externalSourceIds;
	}

	public void setExternalSourceIds(Map<String, List<String>> externalSourceIds) {
		this.externalSourceIds = externalSourceIds;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getReportingId() {
		return reportingId;
	}

	public void setReportingId(String reportingId) {
		this.reportingId = reportingId;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public LinkedHashMap<String, List<String>> getProductKeywords() {
		return productKeywords;
	}

	public void setProductKeywords(
			LinkedHashMap<String, List<String>> productKeywords) {
		this.productKeywords = productKeywords;
	}

	public List<ProductKeywordList> getOrderedProductKeywords() {
		return orderedProductKeywords;
	}

	public void setOrderedProductKeywords(
			List<ProductKeywordList> orderedProductKeywords) {
		this.orderedProductKeywords = orderedProductKeywords;
	}

	public String getShortDescriptor() {
		return shortDescriptor;
	}

	public void setShortDescriptor(String shortDescriptor) {
		this.shortDescriptor = shortDescriptor;
	}

	public String getMediumDescriptor() {
		return mediumDescriptor;
	}

	public void setMediumDescriptor(String mediumDescriptor) {
		this.mediumDescriptor = mediumDescriptor;
	}

	public String getServiceNotes() {
		return serviceNotes;
	}

	public void setServiceNotes(String serviceNotes) {
		this.serviceNotes = serviceNotes;
	}

	public String getListingType() {
		return listingType;
	}

	public void setListingType(String listingType) {
		this.listingType = listingType;
	}

	public Boolean getFreeListing() {
		return freeListing;
	}

	public void setFreeListing(Boolean freeListing) {
		this.freeListing = freeListing;
	}

	public String getDetailsLink() {
		return detailsLink;
	}

	public void setDetailsLink(String detailsLink) {
		this.detailsLink = detailsLink;
	}

	public Boolean getPureMobileBusiness() {
		return pureMobileBusiness;
	}

	public void setPureMobileBusiness(Boolean pureMobileBusiness) {
		this.pureMobileBusiness = pureMobileBusiness;
	}

	public String getPriceQualifier() {
		return priceQualifier;
	}

	public void setPriceQualifier(String priceQualifier) {
		this.priceQualifier = priceQualifier;
	}

	public List<String> getTradingAliases() {
		return tradingAliases;
	}

	public void setTradingAliases(List<String> tradingAliases) {
		this.tradingAliases = tradingAliases;
	}

	public ListingBusinessLogo getBusinessLogo() {
		return businessLogo;
	}

	public void setBusinessLogo(ListingBusinessLogo businessLogo) {
		this.businessLogo = businessLogo;
	}

	public ListingBusinessInfo getBusinessInfo() {
		return businessInfo;
	}

	public void setBusinessInfo(ListingBusinessInfo businessInfo) {
		this.businessInfo = businessInfo;
	}

	public Boolean getHasExposureProducts() {
		return hasExposureProducts;
	}

	public void setHasExposureProducts(Boolean hasExposureProducts) {
		this.hasExposureProducts = hasExposureProducts;
	}

	public List<ListingImageGallery> getImageGallery() {
		return imageGallery;
	}

	public void setImageGallery(List<ListingImageGallery> imageGallery) {
		this.imageGallery = imageGallery;
	}

	public List<ListingExternalLink> getExternalLinks() {
		return externalLinks;
	}

	public void setExternalLinks(List<ListingExternalLink> externalLinks) {
		this.externalLinks = externalLinks;
	}

	public Address getPrimaryAddress() {
		return primaryAddress;
	}

	public void setPrimaryAddress(Address primaryAddress) {
		this.primaryAddress = primaryAddress;
	}

	public List<Address> getAdditionalAddresses() {
		return additionalAddresses;
	}

	public void setAdditionalAddresses(List<Address> additionalAddresses) {
		this.additionalAddresses = additionalAddresses;
	}

	public List<ListingContact> getPrimaryContacts() {
		return primaryContacts;
	}

	public void setPrimaryContacts(List<ListingContact> primaryContacts) {
		this.primaryContacts = primaryContacts;
	}

	public Map<String, List<ListingContact>> getSecondaryContacts() {
		return secondaryContacts;
	}

	public void setSecondaryContacts(
			Map<String, List<ListingContact>> secondaryContacts) {
		this.secondaryContacts = secondaryContacts;
	}

	public List<GroupedContacts<ListingContact>> getOrderedSecondaryContacts() {
		return orderedSecondaryContacts;
	}

	public void setOrderedSecondaryContacts(
			List<GroupedContacts<ListingContact>> orderedSecondaryContacts) {
		this.orderedSecondaryContacts = orderedSecondaryContacts;
	}

	public ListingOpeningHours getOpeningHours() {
		return openingHours;
	}

	public void setOpeningHours(ListingOpeningHours openingHours) {
		this.openingHours = openingHours;
	}

	public Long getNumberOfAdditionalListings() {
		return numberOfAdditionalListings;
	}

	public void setNumberOfAdditionalListings(Long numberOfAdditionalListings) {
		this.numberOfAdditionalListings = numberOfAdditionalListings;
	}

	public Double getDistance() {
		return distance;
	}

	public void setDistance(Double distance) {
		this.distance = distance;
	}

	public Boolean getHasMeteredTn() {
		return hasMeteredTn;
	}

	public void setHasMeteredTn(Boolean hasMeteredTn) {
		this.hasMeteredTn = hasMeteredTn;
	}

}
