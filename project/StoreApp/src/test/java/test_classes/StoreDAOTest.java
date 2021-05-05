package test_classes;

import org.junit.jupiter.api.Test;

import com.revature.exception.BusinessException;
import com.revature.model.Rock;
import com.revature.store.StoreCRUDDAO;
import com.revature.store.dao.impl.StoreCRUDDAOImpl;

class StoreDAOTest {
	StoreCRUDDAO scd = new StoreCRUDDAOImpl();

	@Test
	public void testGetAllItemsForSale() {
		try {
			assert(scd.getAllAvailableRock()) != null;
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} // passed
	
	@Test
	public void testGetItemsOwnedByCustomer() {
		try {
			assert(scd.getRockItemsOwnedByCustomerID(1)) != null;
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} // passed
	
	@Test
	public void testAddRockItem() {
		Rock rock = new Rock();
		rock.setPrice(200);
		rock.setWeight(10);
		rock.setType("granite");
		try {
			assert(scd.addRockItem(rock)) == 1;
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} // passed

}
