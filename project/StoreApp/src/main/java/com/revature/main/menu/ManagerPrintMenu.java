package com.revature.main.menu;

import org.apache.log4j.Logger;

import com.revature.manager.dao.impl.ManagerCRUDDAOImpl;

public class ManagerPrintMenu {
	private static Logger Log = Logger.getLogger(ManagerCRUDDAOImpl.class);
	
	public void printActiveMenu() {
		
		Log.info("\nMenu");
		Log.info("1) Make a new employee account");
		Log.info("2) Delete employee account");
		Log.info("3) View Sales History");
		Log.info("4) Exit");
		
	}

}
