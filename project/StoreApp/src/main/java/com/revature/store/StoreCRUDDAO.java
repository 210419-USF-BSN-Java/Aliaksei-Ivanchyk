package com.revature.store;

import java.util.List;

import com.revature.model.Rock;

public interface StoreCRUDDAO {
	public List<Rock> getAvailableRock();
	public List<Rock> getItemsOwnedByCustomerID(int id);
	public int removeRock(int id);
	public int updateRock(Rock rock);
	public int addRock(Rock rock);

}
