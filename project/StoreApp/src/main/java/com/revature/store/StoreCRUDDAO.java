package com.revature.store;

import java.util.List;

import com.revature.exception.BusinessException;
import com.revature.model.Rock;

public interface StoreCRUDDAO {
	public List<Rock> getAllAvailableRock() throws BusinessException;
	public List<Rock> getRockItemsOwnedByCustomerID(int id) throws BusinessException;
	public int removeRockItem(int id) throws BusinessException;
	public int updateRockItem(Rock rock) throws BusinessException;
	public int addRockItem(Rock rock) throws BusinessException;

}
