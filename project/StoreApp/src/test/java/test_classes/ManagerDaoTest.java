package test_classes;

import org.junit.jupiter.api.Test;

import com.revature.exception.BusinessException;
import com.revature.manager.ManagerDAOCRUD;
import com.revature.manager.dao.impl.ManagerCRUDDAOImpl;

class ManagerDaoTest {
	
	ManagerDAOCRUD mdc = new ManagerCRUDDAOImpl();

	@Test
	public void testLogIn() {
		try {
			assert mdc.logIn("john111", "john111") != null;
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} // passed
	
	@Test
	public void testGetSaleHistory() {
		try {
			assert mdc.getSalesHistory() != null;
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} // passed

}
