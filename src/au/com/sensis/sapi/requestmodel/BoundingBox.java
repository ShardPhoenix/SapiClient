package au.com.sensis.sapi.requestmodel;

public class BoundingBox {
	
	private final Double topLeftLat;
	private final Double topLeftLong;
	private final Double bottomRightLat;
	private final Double bottomRightLong;
	
	public BoundingBox(Double topLeftLat, Double topLeftLong,
			Double bottomRightLat, Double bottomRightLong) {
		this.topLeftLat = topLeftLat;
		this.topLeftLong = topLeftLong;
		this.bottomRightLat = bottomRightLat;
		this.bottomRightLong = bottomRightLong;
	}
	
	@Override
	public String toString() {
		return topLeftLat + "," + topLeftLong + "," + bottomRightLat + "," + bottomRightLong;
	}
	
	public Double getBottomRightLat() {
		return bottomRightLat;
	}
	
	public Double getBottomRightLong() {
		return bottomRightLong;
	}
	
	public Double getTopLeftLat() {
		return topLeftLat;
	}
	
	public Double getTopLeftLong() {
		return topLeftLong;
	}

}
