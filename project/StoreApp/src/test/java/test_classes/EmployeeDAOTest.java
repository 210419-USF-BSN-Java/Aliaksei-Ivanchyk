package test_classes;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.revature.employee.dao.EmployeeSearchDAO;
import com.revature.employee.dao.impl.EmployeeSearchDAOImpl;
import com.revature.exception.BusinessException;

class EmployeeDAOTest {
	EmployeeSearchDAO esd = new EmployeeSearchDAOImpl();
	

	@Test
	public void testLogIn() {
		try {
			assert esd.logIn("john111", "john111") != null;
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} // passed
	
	

}
