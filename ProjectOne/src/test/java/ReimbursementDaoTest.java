import org.junit.jupiter.api.Test;

import com.revature.exception.BusinessException;
import com.revature.reimbursement.dao.ReimbursementDAO;
import com.revature.reimbursement.dao.impl.ReimbursementDAOImpl;

class ReimbursementDaoTest {
	ReimbursementDAO rd = new ReimbursementDAOImpl();

	@Test
	void testGetPendReim() {
		try {
			assert(rd.getAllPendingReiumbursementRequests()) != null;
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	void testGetPendReimById() {
		try {
			assert(rd.getAllPendingReiumbursementRequestsByEmployeeId(1)) != null;
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	void testGetResolvedReimById() {
		try {
			assert(rd.getAllResolvedReiumbursementRequestsByEmployeeId(1)) != null;
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
