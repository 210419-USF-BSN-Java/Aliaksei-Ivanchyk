package com.revature.main.menu;


import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.customer.dao.CustomerCRUDDAO;
import com.revature.customer.dao.impl.CustomerCRUDDAOImpl;
import com.revature.customer.service.CustomerCRUDService;
import com.revature.customer.service.CustomerSearchService;
import com.revature.customer.service.impl.CustomerCRUDServiceImpl;
import com.revature.customer.service.impl.CustomerSearchServiceImpl;
import com.revature.exception.BusinessException;
import com.revature.model.Customer;
import com.revature.model.Employee;
import com.revature.model.Offer;
import com.revature.model.Rock;
import com.revature.scanner.Input;
import com.revature.store.StoreCRUDDAO;
import com.revature.store.dao.impl.StoreCRUDDAOImpl;



public class CustomerMenu {
	CustomerSearchService csm = new CustomerSearchServiceImpl();
	Scanner scanner = Input.getScanner();
	private static Logger Log = Logger.getLogger(CustomerMenu.class);
	CustomerPrintMenu cpm = new CustomerPrintMenu();
	StoreCRUDDAO scd = new StoreCRUDDAOImpl();
	CustomerCRUDService ccs = new CustomerCRUDServiceImpl();
	CustomerCRUDDAO ccd = new CustomerCRUDDAOImpl();
	

	public  void LogIn() {
		boolean logedIn = false;
		Customer customer = new Customer();;
		Log.info("Enter username: ");
		String username = scanner.nextLine();
		Log.info("Enter password: ");
		String password = (scanner.nextLine());
		customer.setPassword(password);
		customer.setUsername(username);
		
		try {
			customer = csm.logIn(username, password);
			Log.info("\nWelcome " + customer.getFirstName());
			logedIn = true;

		} catch (BusinessException e) {

			Log.warn("Entered User name and password do not match our records");

		}
		
		if (logedIn) {
			int ch = 0;
			
			do {
				cpm.printLogedInMenu();
				try {
					ch = Integer.parseInt(scanner.nextLine());
				} catch (NumberFormatException e) {
					Log.warn("Please enter a number only");
				}
				
				switch(ch) {
				
				case 1:
					try {
						viewAvailableItems(customer);
					} catch (BusinessException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				
				
				case 2:
						viewItemsOwned(customer);


					break;
					
				case 3:
					Log.info("The current balance is " + customer.getBalance());
					int ch1=0;
					do {
						cpm.printMakeAPaymentMenu();
						try {
							ch1 = Integer.parseInt(scanner.nextLine());
						} catch (NumberFormatException e) {
							Log.warn("Please enter a number only");
						}
						
						switch(ch1) {
						
						case 1:
							double paymentAmount;
							Log.info("What is your payment amount?");
							paymentAmount = Double.parseDouble(scanner.nextLine()); 
							try {
								double newBalance = ccs.updateBalance( customer.getBalance(), customer.getCustomer_id(), paymentAmount);
								customer.setBalance(newBalance);
							} catch (BusinessException e) {
								// TODO Auto-generated catch block
								
							}
							break;
						case 2:
							Log.info("Exiting to the previos menu");
							break;
						default:
							Log.info("Invalid Choice... Please enter a proper choice between 1-4 only.......");
							break;
							
						}
					} while (ch1 != 2); 
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
		
		
		
	}
	
	public void viewAvailableItems(Customer customer) throws BusinessException {
		List<Rock> rocks = null;
		
		rocks = scd.getAllAvailableRock();
		
		for (int i = 0; i < rocks.size(); i++) {
			Log.info((i + 1) + ") a " + rocks.get(i).getType() + " of weight " + rocks.get(i).getWeight() 
					+ " grams with a price of $" + rocks.get(i).getPrice());
		}
		
		int ch = 0;
		start : {
		do {
			boolean activateItem = false;
			Rock rock = null;
			Log.info("\nSelect an item or press 9 to exit");
			try {
				ch = Integer.parseInt(scanner.nextLine());
				if (ch == 9) {
					break start;
				}
				rock = rocks.get((ch - 1));
				Log.info(rock);
				activateItem = true;
//				Log.info(activateItem);

			} catch (NumberFormatException | IndexOutOfBoundsException e) {
				Log.warn("Wrong choice or wrong format");
			}
			
			if (activateItem) {
//				Log.info(rock);
				Offer offer = ccd.getOffer(customer.getCustomer_id(), rock.getRock_id());
				if (offer != null) {
					Log.info("You have already made an offer for this item");
					Log.info(offer);
					int ch2 = 0;
					try {
						
						cpm.printIfHaveOfferMenu();
						ch2 = Integer.parseInt(scanner.nextLine());
					} catch (NumberFormatException e) {
						Log.warn("Please enter a number only");
					}
					
					switch (ch2) {
					
					case 1:
						int c = ccd.cancelOffer(customer.getCustomer_id(), rock.getRock_id());
						if (c > 0) {
						Log.info("Offer has been canceled succesfully");
						} else {
							Log.info("Offer has not  been canceled");
						}
						break start;
					case 2:
						break start;
						
					
					
				default:
					Log.info("Invalid Choice... Please enter a proper choice between 1-2 only.......");
					break;
					}
					
				} else {
					Log.info("Your offer has been either rejected or you have not made any offers on this item yet");
					Log.info("\nWould you like to make an offer?");
					int ch1 = 0;
//					cpm.printOfferMenu();
					try {
						cpm.printOfferMenu();
						ch1 = Integer.parseInt(scanner.nextLine());
					} catch (NumberFormatException e) {
						Log.warn("Please enter a number only");
					}
					
					switch (ch1) {
					
					case 1:
						double amount = 0;
						try {
							Log.info("Enter offer amount");
							amount = Double.parseDouble(scanner.nextLine());
						} catch (NumberFormatException e) {
							Log.warn("Please enter a number only");
						}
						
						int c = ccs.makeAnOffer(amount, customer.getCustomer_id(), rock.getRock_id());
						if (c > 0) {
							Log.info("Offer made successfully");
						} else {
							Log.info("Unable to make an offer on this item");
						}
						break start;
						
						
					case 2:
						break start;
						
					default:
						Log.info("Invalid Choice... Please enter a proper choice between 1-2 only.......");
						break;
					}
					
				}
			}
			
			
		} while (ch != 9);
		} ;
		
	}
	
	public void viewItemsOwned(Customer customer) {
		List<Rock> rocks = null;
		try {
			rocks = scd.getRockItemsOwnedByCustomerID(customer.getCustomer_id());

		
		for (int i = 0; i < rocks.size(); i++) {
			Log.info((i + 1) + ") A rock of type " + rocks.get(i).getType() + " of weight " + rocks.get(i).getWeight() 
					+ " grams purchased for a  price of $" + rocks.get(i).getPrice());
		}
		} catch (BusinessException | NullPointerException e) {
			// TODO Auto-generated catch block
			
		}
	}

	public void registerNewCustomer() {
		Customer customer = new Customer();
		Log.info("Enter first name: ");
		customer.setFirstName(scanner.nextLine());
		Log.info("Enter last name: ");
		customer.setLastName(scanner.nextLine());
		Log.info("Enter username name: ");
		customer.setUsername(scanner.nextLine());
		Log.info("Enter password: ");
		customer.setPassword(scanner.nextLine());
		Log.info("Enter email: ");
		customer.setEmail(scanner.nextLine());
		Log.info("Enter phoneNumber: ");
		customer.setPhoneNumber(scanner.nextLine());
		customer.setBalance(0);
		try {
			ccs.registerNewCustomer(customer);
		} catch (BusinessException e) {
			Log.info("Unable to register new customer");
			e.printStackTrace();
		}
	}
	
	

}
