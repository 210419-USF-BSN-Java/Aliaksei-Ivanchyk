package test_classes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.revature.customer.dao.CustomerCRUDDAO;
import com.revature.customer.dao.CustomerSearchDAO;
import com.revature.customer.dao.impl.CustomerCRUDDAOImpl;
import com.revature.customer.dao.impl.CustomerSearchDAOImpl;
import com.revature.exception.BusinessException;

class CustomerDAOTest {
	CustomerSearchDAO csd = new CustomerSearchDAOImpl();
	CustomerCRUDDAO ccd = new CustomerCRUDDAOImpl();
	
	@Test
	public void testUpdateBalance() {
		
		try {
			assert(ccd.updateBalance(5, 4)) == 1;
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} // passed
	
	@Test
	public void testGetOffer() {
		try {
			assert(ccd.getOffer(1, 3)) != null;
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} // passed
	
	@Test
	public void testLogIn() {
		try {
			assert csd.logIn("alex111", "alex111") != null;
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} // passed
	

}
