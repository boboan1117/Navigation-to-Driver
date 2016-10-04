package hw2;

import java.util.Scanner;
/*
 * this is the menu
 * zheng wen
 * 4/6/2015
 */
public class NavigatorDriver { //create several static variables to print out the information of the menu 
	final static int QUIT =0;  
	final static int ADD_LOCATION =1; 
	final static int DISPLAY_PATH =2; 
	final static int MOVE =3; 
	final static int DISPLAY_BEARING =4; 
	final static int INVALID =-1;

	public static void main(String [] args){
	    int choice = INVALID;
		ConsoleMenu menu = initializeMenu() ; // call the function "ConsoleMenu  initializeMenu()"
		Path path = new Path(); 
		intro(); // the function to print out the introduction 
		do{
			
			System.out.println("Please enter one of the following choices: ");
			choice = menu.getChoice(new Scanner (System.in)); 
			
			switch (choice){ 
			case QUIT:
				break;
			case ADD_LOCATION: 
				// get the information of the location, then use "Path" class to save the information to the "Location" class
				System.out.println("Please enter the name of the next location: ");
				String name= new Scanner(System.in).next();// get and add the name of location
				System.out.println("Please enter the latitude of the next location: ");
				Double latitude = new Scanner(System.in).nextDouble();// get and add the latitude of location
				System.out.println("Please enter the longtitude of the next location: ");
				Double longtitude = new Scanner(System.in).nextDouble(); // get and add the longitude of location
				path.addLocation(name,latitude,longtitude);
				break;

			case DISPLAY_PATH:// print out the information of the path
				System.out.println(path);
	            break;
			case MOVE:// enter a name as starting location
				System.out.println("Please enter name of location to move to: ");
				String crrname = new Scanner(System.in).next(); 
	            path.setCurrLoc(crrname);
	            break;
			case DISPLAY_BEARING:// print out the bearing 
				double bearing = path.computeBearing();   
				//System.out.println( "Head out on a bearing of " + bearing + " degrees");
				if(Double.isNaN(bearing))
					//print out the "error" information when users don't enter the name of location 
					System.out.println("Error: Must set location to location in path before the last location.");
				else {
					//print our the bearing 
					System.out.println("Head out on a bearing of "+ bearing +" degrees");
				}
	            break;
	        default:
	        	throw new UnsupportedOperationException();
			}
		}while(QUIT != choice);
	}

	private static ConsoleMenu  initializeMenu() {
	    ConsoleMenu  menu = new ConsoleMenu();
	    menu.add("0. Quit");
	    menu.add("1. Add a location to the path");
	    menu.add("2. Display path");
	    menu.add("3. Move to named location");
	    menu.add("4. Display the initial bearings to take from current location to get to the next on the path");
		return menu;
	}

	private static void intro() {
		// use this function to show the introduction
		System.out.println("This is a crude navigator for flying a chosen path. \n" +
				"It just stores a sequence of latitudes and longitudes of locations\n"+
				"and allows the user to get bearings from each location to follow the path");
	}
}
