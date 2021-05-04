package com.revature.main.menu;

import org.apache.log4j.Logger;

public class EmployeePrintMenu {
	private static Logger Log = Logger.getLogger(EmployeePrintMenu.class);
	
	public void printLogedInMenu() {
		Log.info("\nMenu");
		Log.info("1) View available rock specimens for sale");
		Log.info("2) View current offers");
		Log.info("3) Add item to store");
		Log.info("4) Exit");
	}
	
	public void printActiveItemMenu() {
		Log.info("\nMenu");
		Log.info("1) Remove item from shop");
		Log.info("2) Edit an item");
		Log.info("3) Exit");
	}
	
	public void printUpdateItemMenu() {
		Log.info("\nMenu");
		Log.info("1) Update type");
		Log.info("2) Update weight");
		Log.info("3) Update price");
		Log.info("4) Update status");
		Log.info("5) Exit");
	}
	
	public void printOfferMenu() {
		Log.info("\nMenu");
		Log.info("1) Accept an offer");
		Log.info("2) Decline an offer");
		Log.info("3) Exit");
	}

}
