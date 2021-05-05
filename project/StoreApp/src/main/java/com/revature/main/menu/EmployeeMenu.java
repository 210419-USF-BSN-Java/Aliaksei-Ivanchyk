package com.revature.main.menu;

import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.customer.dao.CustomerCRUDDAO;
import com.revature.customer.dao.CustomerSearchDAO;
import com.revature.customer.dao.impl.CustomerCRUDDAOImpl;
import com.revature.customer.dao.impl.CustomerSearchDAOImpl;
import com.revature.employee.service.EmployeeSearchService;
import com.revature.employee.service.impl.EmployeeSearchServiceImpl;
import com.revature.exception.BusinessException;
import com.revature.model.Employee;
import com.revature.model.Offer;
import com.revature.model.Rock;
import com.revature.offer.OfferCRUDDAO;
import com.revature.offer.impl.OfferCRUDDAOImpl;
import com.revature.offer.service.OfferCRUDService;
import com.revature.offer.service.impl.OfferCRUDServiceImpl;
import com.revature.scanner.Input;
import com.revature.store.StoreCRUDDAO;
import com.revature.store.dao.impl.StoreCRUDDAOImpl;
import com.revature.store.service.StoreCRUDService;
import com.revature.store.service.impl.StoreCRUDServiceImpl;

public class EmployeeMenu {
	private EmployeeSearchService ess = new EmployeeSearchServiceImpl();
	private Logger Log = Logger.getLogger(EmployeeMenu.class);
	Scanner scanner = Input.getScanner();
	private EmployeePrintMenu epm = new EmployeePrintMenu();
	StoreCRUDDAO scd = new StoreCRUDDAOImpl();
	OfferCRUDDAO ocd = new OfferCRUDDAOImpl();
	OfferCRUDService ocs = new OfferCRUDServiceImpl();
	CustomerSearchDAO csd = new CustomerSearchDAOImpl();
	StoreCRUDService scs = new StoreCRUDServiceImpl();
	CustomerCRUDDAO ccd = new CustomerCRUDDAOImpl();

	public void logIn() throws BusinessException {
		boolean logedIn = false;
		Employee employee = null;
		Log.info("Enter username: ");
		String username = scanner.nextLine();
		Log.info("Enter password: ");
		String password = (scanner.nextLine());

		try {
			employee = ess.logIn(username, password);
//			Log.info(employee);
			logedIn = true;

		} catch (BusinessException e) {

			Log.warn("Entered User name and password do not match our records");

		}

		if (logedIn) {
			int ch = 0;

			do {
				epm.printLogedInMenu();
				try {
					ch = Integer.parseInt(scanner.nextLine());
				} catch (NumberFormatException e) {
					Log.warn("Please enter a number only");
				}

				switch (ch) {

				case 1:
					try {
						viewAvailableItems();
					} catch (BusinessException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;

				case 2:
					try {
						viewOffers();
					} catch (BusinessException e) {
						e.printStackTrace();
					}
					break;

				case 3:
					try {
						addItem();
					} catch (NumberFormatException | NullPointerException e) {
//						e.printStackTrace();
						Log.warn("Wrong format input");
					}
					break;

				case 4:
					break;

				default:
					Log.info("Invalid Choice... Please enter a proper choice between 1-4 only.......");
					break;
				}

			} while (ch != 4);
		}
	}

	private void addItem() {
		Rock rock = new Rock();
		Log.info("Enter type of rock: ");
		rock.setType(scanner.nextLine());
		Log.info("Enter weight: ");
		rock.setWeight(Double.parseDouble(scanner.nextLine()));
		Log.info("Enter price: ");
		rock.setPrice(Double.parseDouble(scanner.nextLine()));
		rock.setStatus(1);
		try {
			scs.addRockItem(rock);
			Log.info("Added item successfully");
		} catch (BusinessException e) {
			Log.info("Unable to add the item");
			// TODO Auto-generated catch block
//			e.printStackTrace();
		}
		
		
	}

	private void viewOffers() throws BusinessException {
		List<Offer> offers = null;

		offers = ocd.getAllActiveOffers();

		for (int i = 0; i < offers.size(); i++) {
			Log.info((i + 1) + ") a offer with id " + offers.get(i).getOffer_id() + " and price amount "
					+ offers.get(i).getOfferAmount() + " for a customer with id " + offers.get(i).getCustomer_id() 
			+ " with a rock_id of " + offers.get(i).getRock_id());
		}

		int ch = 0;
		start: {
			do {
				boolean activateItem = false;
				Offer offer = null;
				Log.info("\nSelect an item or press 9 to exit");
				try {
					ch = Integer.parseInt(scanner.nextLine());
					if (ch == 9) {
						break start;
					}
					offer = offers.get((ch - 1));
					Log.info(offer);
					activateItem = true;
//					Log.info(activateItem);

				} catch (NumberFormatException | IndexOutOfBoundsException e) {
					Log.warn("Wrong choice or wrong format");
				}

				if (activateItem) {
					int ch2 = 0;
					do {

						try {

							epm.printOfferMenu();
							ch2 = Integer.parseInt(scanner.nextLine());
						} catch (NumberFormatException e) {
							Log.warn("Please enter a number only");
						}
						
						switch (ch2) {
						
						case 1:
							double oldBalance = csd.returnCustomerBalance(offer.getCustomer_id());
							double newBalance = oldBalance + offer.getOfferAmount();
							Rock rock = scd.getRockItem(offer.getRock_id());
							Log.info(offer);
							ocs.acceptOffer(newBalance, offer, rock);
							break start;
						case 2:
							int c = ocd.rejectOffer(offer.getOffer_id());
							if (c>0) {
								Log.info("Offer was rejected succesfully");
							} else {
								Log.info("Something went wrong");
							}
							break start;
						case 3:
							break start;
						
						default:
							Log.info("Invalid Choice... Please enter a proper choice between 1-2 only.......");
							break;
							
						}
					} while (ch2 != 3);

				}

			} while (ch != 3);
		}

	}

	public void viewAvailableItems() throws BusinessException {
		List<Rock> rocks = null;

		rocks = scd.getAllAvailableRock();

		for (int i = 0; i < rocks.size(); i++) {
			Log.info((i + 1) + ") a " + rocks.get(i).getType() + " of weight " + rocks.get(i).getWeight()
					+ " grams with a price of " + rocks.get(i).getPrice());
		}

		int ch = 0;
		start: {
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
//					Log.info(activateItem);

				} catch (NumberFormatException | IndexOutOfBoundsException e) {
					Log.warn("Wrong choice or wrong format");
				}

				if (activateItem) {

					int ch1 = 0;
					do {
//						epm.printActiveItemMenu();
						try {
							epm.printActiveItemMenu();
							ch1 = Integer.parseInt(scanner.nextLine());
						} catch (NumberFormatException e) {
							Log.warn("Please enter a number only");
						}

						switch (ch1) {

						case 1:
							int c = 0;
							try {
								epm.printActiveItemMenu();
								c = scd.removeRockItem(rock.getRock_id());
							} catch (BusinessException e) {
								Log.warn("Item has offers on it and cannot be deleted");
							}
		
							if (c > 0) {
								Log.info("Item removed succesfully");
							} else {
								Log.info("Unable to remove the item");
							}
							break start;

						case 2:
							int ch2 = 0;
							do {
//								int ch2 = 0;
								try {
									epm.printUpdateItemMenu();
									ch2 = Integer.parseInt(scanner.nextLine());
								} catch (NumberFormatException e) {
									Log.warn("Please enter a number only");
								}

								switch (ch2) {

								case 1:
									try {
										Log.info("Enter new type");
										String type = scanner.nextLine();
										rock.setType(type);
										int c1 = scd.updateRockItem(rock);
										if (c1 > 0) {
											Log.info("The item was updated succesfully");
										}
									} catch (NumberFormatException e) {
										Log.warn("Please enter a number only");
									}
									break;
								case 2:
									try {
										Log.info("Enter new weight");
										Double weight = Double.parseDouble(scanner.nextLine());
										rock.setWeight(weight);
										int c1 = scd.updateRockItem(rock);
										if (c1 > 0) {
											Log.info("The item was updated succesfully");
										}
									} catch (NumberFormatException e) {
										Log.warn("Please enter a number only");
									}
									break;

								case 3:
									try {
										Log.info("Enter new price");
										Double price = Double.parseDouble(scanner.nextLine());
										rock.setPrice(price);
										int c1 = scd.updateRockItem(rock);
										if (c1 > 0) {
											Log.info("The item was updated succesfully");
										}
									} catch (NumberFormatException e) {
										Log.warn("Please enter a number only");
									}
									break;

								case 4:
									try {
										Log.info("Enter new status (1 or 0)");
										int status = Integer.parseInt(scanner.nextLine());
										if (status == 1 || status == 0) {
										rock.setStatus(status);
										int c1 = scd.updateRockItem(rock);
										if (c1 > 0) {
											Log.info("The item was updated succesfully");
										}
										} else {
											Log.info("The status entered is incorrect");
										}
									} catch (NumberFormatException e) {
										Log.warn("Please enter a number only");

									}
									break;

								case 5:
									break;

								default:
									Log.info("Invalid Choice... Please enter a proper choice between 1-2 only.......");
									break;

								}
//								break;

							} while (ch2 != 5);
							break;

						case 3:
							break start;

						default:
							Log.info("Invalid Choice... Please enter a proper choice between 1-3 only.......");
							break;
						}

					} while (ch1 != 3);
				}

			} while (ch != 9);
		}

	}
}
