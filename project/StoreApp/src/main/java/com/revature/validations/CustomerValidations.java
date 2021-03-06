package com.revature.validations;

public class CustomerValidations {

	public static boolean isValidUserName(String i) {
		if (i != null && i.matches("[a-zA-Z0-9]{4,20}")) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean isValidPassword(String password) {
		if (password != null && password.matches("[a-zA-Z0-9]{4,20}")) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean isValidCity(String city) {
		if (city != null && city.matches("[a-zA-Z]{4,20}")) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean isValidFirstName(String name) {
		if (name != null && name.matches("[a-zA-Z]{3,15}")) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean isValidLastName(String name) {
		if (name != null && name.matches("[a-zA-Z]{3,15}")) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean isValidPhoneNumber(String phonenumber) {
		if (phonenumber != null && phonenumber.matches("[0-9]{6}")) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean isValidAge(int age) {
		if (age >= 18 && age <= 70) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean isValidGender(String i) {
		if (i != null && i.matches("[mMfF]{1}")) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean isValidCustomerStatus(int status) {
		if (status > 0 && status < 3) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean isValidUserId(int id) {
	
		if (id > 0) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean isValidemail(String email) {
		if (email != null && email.matches(
				"^[\\w!#$%&?*+/=?`{|}~^-]+(?:\\.[\\w!#$%&?*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$")) {
			return true;
		} else {
			return false;
		}

	}
	
	public static boolean isValidCustomerId(int customerId) {
		if (customerId > 0 ) {
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean isValidType(String type) {
		if (type != null && type.matches("[a-zA-Z]{4,20}")) {
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean isValidWeight(double weight) {
		if (weight > 0 && weight< 10000) {
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean isValidPrice(double price) {
		if (price > 0 && price < 10000) {
			return true;
		} else {
			return false;
		}
	}
}
