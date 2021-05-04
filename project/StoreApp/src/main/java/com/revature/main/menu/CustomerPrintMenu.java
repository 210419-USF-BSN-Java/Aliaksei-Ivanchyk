package com.revature.main.menu;

import org.apache.log4j.Logger;



public class CustomerPrintMenu {
	private static Logger Log = Logger.getLogger(CustomerPrintMenu.class);
	
	public void printLogedInMenu() {
		Log.info("\nMenu");
		Log.info("1) View available rock specimens for sale");
		Log.info("2) View owned rock specimens");
		Log.info("3) View balance");
		Log.info("4) Exit");
	}
	
	public void printMakeAPaymentMenu() {
		Log.info("\nMenu");
		Log.info("1) Make a payment");
		Log.info("2) Exit");
	}
	
	public void printOfferMenu() {
		Log.info("\nMenu");
		Log.info("1) Make an offer");
		Log.info("2) Exit");
	}
	
	public void printIfHaveOfferMenu() {
		Log.info("\nMenu");
		Log.info("1) Cancel this offer");
		Log.info("2) Exit");
	}

}
