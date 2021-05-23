package com.revature.models;

import java.sql.Timestamp;

public class Reimbursement {
	int user_id;
	int reim_id;
	double amount;
	String description;
	int status;
	String type;
	String submitDate;
	String resolveDate;
	int manager_id;
	
	public Reimbursement() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

	public Reimbursement(int user_id, int reim_id, double amount, String description, int status, String type,
			String submitDate, String resolveDate, int manager_id) {
		super();
		this.user_id = user_id;
		this.reim_id = reim_id;
		this.amount = amount;
		this.description = description;
		this.status = status;
		this.type = type;
		this.submitDate = submitDate;
		this.resolveDate = resolveDate;
		this.manager_id = manager_id;
	}






	public int getManager_id() {
		return manager_id;
	}



	public void setManager_id(int manager_id) {
		this.manager_id = manager_id;
	}



	public int getReim_id() {
		return reim_id;
	}

	public void setReim_id(int reim_id) {
		this.reim_id = reim_id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getSubmitDate() {
		return submitDate;
	}

	public void setSubmitDate(String date) {
		this.submitDate = date;
	}
	
	

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getResolveDate() {
		return resolveDate;
	}

	public void setResolveDate(String resolveDate) {
		this.resolveDate = resolveDate;
	}


	public int getUser_id() {
		return user_id;
	}



	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}



	@Override
	public String toString() {
		return "Reimbursement [user_id=" + user_id + ", reim_id=" + reim_id + ", amount=" + amount + ", description="
				+ description + ", status=" + status + ", type=" + type + ", submitDate=" + submitDate
				+ ", resolveDate=" + resolveDate + "]";
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + reim_id;
		result = prime * result + ((resolveDate == null) ? 0 : resolveDate.hashCode());
		result = prime * result + status;
		result = prime * result + ((submitDate == null) ? 0 : submitDate.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + user_id;
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reimbursement other = (Reimbursement) obj;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (reim_id != other.reim_id)
			return false;
		if (resolveDate == null) {
			if (other.resolveDate != null)
				return false;
		} else if (!resolveDate.equals(other.resolveDate))
			return false;
		if (status != other.status)
			return false;
		if (submitDate == null) {
			if (other.submitDate != null)
				return false;
		} else if (!submitDate.equals(other.submitDate))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (user_id != other.user_id)
			return false;
		return true;
	}












	
	
	

}
