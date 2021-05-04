package com.revature.store.service.impl;

import com.revature.exception.BusinessException;
import com.revature.model.Rock;
import com.revature.store.StoreCRUDDAO;
import com.revature.store.dao.impl.StoreCRUDDAOImpl;
import com.revature.store.service.StoreCRUDService;
import com.revature.validations.CustomerValidations;

public class StoreCRUDServiceImpl implements StoreCRUDService  {
	StoreCRUDDAO scd = new StoreCRUDDAOImpl();

	@Override
	public int addRockItem(Rock rock) throws BusinessException {
		int c = 0;
		if (CustomerValidations.isValidPrice(rock.getPrice()) && CustomerValidations.isValidType(rock.getType()) 
				&& CustomerValidations.isValidWeight(rock.getWeight())) {
			c = scd.addRockItem(rock);
		}
		return 0;
	}

}
