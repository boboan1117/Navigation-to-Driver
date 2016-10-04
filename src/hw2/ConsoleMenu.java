package hw2;

import java.util.ArrayList;
import java.util.Scanner;
/*
 * this is the list of the menu
 * zheng wen
 * 4/6/2015
 */
public class ConsoleMenu {
	private ArrayList <String> menus = new ArrayList(); // use ArrayList to save the information of the menu

	public int getChoice(Scanner stdin){
		System.out.println("Please enter one of the follwing choices : ");
		for(String option: menus){ 
		    System.out.println(option);
		}
		while(!stdin.hasNextInt())
			stdin.nextLine();
		    return Integer.valueOf(stdin.nextLine());
	}
	
	public void add(String option){
		menus.add(option);
	}
	
}