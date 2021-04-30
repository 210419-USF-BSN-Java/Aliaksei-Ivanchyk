package com.revature.main;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.main.menu.CustomerMenu;
import com.revature.main.menu.EmployeeMenu;
import com.revature.scanner.Input;


public class Main {
	private static Logger Log = Logger.getLogger(Main.class);
	private static CustomerMenu cm = new CustomerMenu();
	
	public static void main(String[] args) {
		
		Log.info("Welcome to the Rough Around the Edges Rock store");
		Log.info("========================================");

		
		int ch = 0;
		Scanner scanner = Input.getScanner();
		
		do {
			Main.printUserMenu();
			
			try {
				ch = Integer.parseInt(scanner.nextLine());
			} catch (NumberFormatException e) {
//				Log.info("Enter only a number between 1 - 4");
			}
			
			switch (ch) {
			case 1:
				cm.LogIn();
				break;
			
			
			case 2:
				EmployeeMenu.LogIn();
				break;
				
			case 3:
				Log.info("under construction");
				break;
			case 4:
				Log.info("Thank you for vising our store," + " Hope you to see you again in the future!");
				break;
				
			default:
				Log.info("Invalid Choice... Please enter a proper choice between 1-4 only.......");
				break;
			}
			
			
		} while (ch != 4);

	}
	
	
	public static void printUserMenu() {
		Log.info("User MENU");
		Log.info("------------------");
		Log.info("Are you a employee or customer?");
		Log.info("1) Customer");
		Log.info("2) Employee");
		Log.info("3) Manager");
		Log.info("4) Exit");
	}
}


