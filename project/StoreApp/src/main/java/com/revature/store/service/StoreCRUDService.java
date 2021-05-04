package com.revature.store.service;

import com.revature.exception.BusinessException;
import com.revature.model.Rock;

public interface StoreCRUDService {
	public int addRockItem(Rock rock) throws BusinessException;

}
