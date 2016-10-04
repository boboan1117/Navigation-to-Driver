package hw2;

/*
 * this class initialize a List<Location> field to represent the path
 * zheng wen
 * 4/7/2015
 */
public class Location {
	private String name;
	public String getName() {
		return name;
	}

	private Double latitude;
	public Double getLatitude(){
		return latitude;
	}
	
	private Double longtitude;
	public Double getLongtitude(){
		return longtitude;
	}
	
public Location(String name,Double latitude,Double longtitude)
{
	this.name = name;
	this.latitude = latitude;
	this.longtitude = longtitude;
	
	
}
}

