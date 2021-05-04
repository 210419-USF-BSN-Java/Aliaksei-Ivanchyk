package com.revature.model;

public class Employee {

	private String firstName;
	private String lastName;
	private int employee_id;
	private String username;
	private String password;
	private int manager_id;
	private int employee_type;
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	public Employee(String firstName, String lastName, int employee_id, String username, String password,
			int manager_id, int employee_type) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.employee_id = employee_id;
		this.username = username;
		this.password = password;
		this.manager_id = manager_id;
		this.employee_type = employee_type;
	}
	
	
	public int getEmployee_type() {
		return employee_type;
	}



	public void setEmployee_type(int employee_type) {
		this.employee_type = employee_type;
	}



	public int getManager_id() {
		return manager_id;
	}
	public void setManager_id(int manager_id) {
		this.manager_id = manager_id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(int i) {
		this.employee_id = i;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}



	@Override
	public String toString() {
		return "Employee [firstName=" + firstName + ", lastName=" + lastName + ", employee_id=" + employee_id
				+ ", username=" + username + ", password=" + password + ", manager_id=" + manager_id
				+ ", employee_type=" + employee_type + "]";
	}


	
	
	
}
