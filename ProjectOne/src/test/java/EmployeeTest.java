import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.Test;

import com.revature.employee.dao.EmployeeDAO;
import com.revature.employee.dao.impl.EmployeeDAOImpl;
import com.revature.exception.BusinessException;

class EmployeeTest {
	EmployeeDAO ed = new EmployeeDAOImpl();

	@Test
	public void testgetEmployee() {
		try {
			assert(ed.getEmployeeById(1))!= null;
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} // passed
	
	@Test
	public void testupdateEmployee() {
		try {
			assert(ed.getEmployee("bob222", "bob222"))!= null;
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} // passed
}
