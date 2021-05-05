package test_classes;

import org.junit.jupiter.api.Test;

import com.revature.exception.BusinessException;
import com.revature.offer.OfferCRUDDAO;
import com.revature.offer.impl.OfferCRUDDAOImpl;

class OfferDAOTest {
	OfferCRUDDAO ocd = new OfferCRUDDAOImpl();

	@Test
	public void testCheckIfOfferAlreadyMade() {
		try {
			assert ocd.checkIfOfferAlreadyMade(1, 3) != null;
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} // passed
	
	@Test
	public void testGetAllOffers() {
		try {
			assert ocd.getAllActiveOffers() != null;
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} // passed

}
