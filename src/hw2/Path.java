package hw2;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * This is path information
 * zheng wen
 * 4/6/2105
 */

public class Path {
	private ArrayList <Location> locationlist = new ArrayList();
	private Location currentLocation; 

	/*
	 * Add the information of the location to the location list. The function will do nothing when the information is existent, 
	 */
	public void addLocation(String name,Double latitude,Double longtitude) 
	{
		if (! locExist(name)){
		Location location = new Location(name,latitude,longtitude);
		locationlist.add(location);
		}	
	}
	/*
	 *Using "boolean locExist" to check the user's information is existent or not existent. 
	 */

	private boolean locExist(String name) {
		for (Location temp:locationlist){
			if(temp.getName().equals(name)){
			 return true;
			}
		}
		return false;
	}
	
	/*
	 * Using "override toString" to display the list of location
	 */
	
	@Override
	public String toString() {
		StringBuffer string = new StringBuffer("");
		for(Location location : locationlist)
			string.append("location: " + location.getName() +  " at (" + location.getLatitude() + ", " + location.getLongtitude() +")\n");
		return new String(string);
	}

	/*
	 * Using "setCurrLoc" to choice one location which exist in location list as staring location
	 * If the information of the location is existent, the location will be the staring location.
	 * If the information of the location is not existent,  the program will print out an error message
	 */
	public void setCurrLoc(String name) { 
		
		if(locExist(name))
		{
		for (Location temp:locationlist){
			if (name.equals(temp.getName())){
				
				currentLocation = temp;
			}
			
		  }
		}
		else{
			System.out.println("Please choice one location which exist in location list.");
			System.out.println("\n");
		}
	}
/*
 *Using "computeBearing" to get the degree of bearing 
 */
	public double computeBearing() { 
		
		/*
		 * If the information of the location is existent, the "computeBearing" will compute the bearing
		 * If the information of the location is not existent,  the program will print out an error message
		 */
			Location name = null;
			if (currentLocation == null)
			{
				System.out.println("Please enter a name as starting location.");
			}
			else {// get the next location's information
			for (int i=0;i<locationlist.size();i++){
				if (locationlist.get(i) == currentLocation){
					name = locationlist.get(i+1);
					}
				
			}
		
			}
		//if next location is not equals null,then compute the bearing
			if(name != null){
			double currLatRadians, currLongRadians, nextLatRadians, nextLongRadians, bearing;	
			currLatRadians = currentLocation.getLatitude() * Math.acos(-1.0) / 180.0;
			currLongRadians = currentLocation.getLongtitude() * Math.acos(-1.0) / 180.0;
			nextLatRadians = name.getLatitude() * Math.acos(-1.0) / 180.0;
			nextLongRadians = name.getLongtitude() * Math.acos(-1.0) / 180.0;
			
			//Using formula to get bearing
			bearing = Math.atan2(Math.sin(nextLongRadians-currLongRadians) 
					* Math.cos(nextLatRadians),
					Math.cos(currLatRadians) * Math.sin(nextLatRadians)
					- Math.sin(currLatRadians) * Math.cos(nextLatRadians)
					* Math.cos(nextLongRadians-currLongRadians));
			
			bearing = bearing * 180.0 / Math.acos(-1.0);
			if (bearing < 0.0)
				bearing += 360.0;
			return bearing;
		}
		return Double.NaN;	
	}

}

