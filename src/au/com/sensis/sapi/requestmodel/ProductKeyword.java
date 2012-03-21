package au.com.sensis.sapi.requestmodel;

public class ProductKeyword {
	
	private final String field;
	private final String value;
	
	public ProductKeyword(String field, String value) {
		this.field = field;
		this.value = value;
	}
	
	@Override
	public String toString() {
		return field + ":" + value;
	}
	
	public String getField() {
		return field;
	}
	
	public String getValue() {
		return value;
	}

}
