package au.com.sensis.sapi.requestmodel;

public enum ContentFilter {
	SHORT_DESCRIPTOR("shortDescriptor"), MEDIUM_DESCRIPTOR("mediumDescriptor"), DESCRIPTOR("descriptor"),
	BUSINESS_LOGO("businessLogo"), IMAGE_GALLERY("imageGallery"), IMAGE("image"), VIDEO("video");
	
	private String name;

	private ContentFilter(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return name;
	}
}
