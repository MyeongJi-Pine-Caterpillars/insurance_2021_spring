import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.insurance.sce.dao.EmployeeDAO;
import com.insurance.sce.dao.InsuranceDAO;
import com.insurance.sce.dao.InsurantDAO;
import com.insurance.sce.global.Constants.eGender;
import com.insurance.sce.global.Constants.eInsuranceType;
import com.insurance.sce.global.Constants.eUsageOfStructure;
import com.insurance.sce.model.customer.Insurant;
import com.insurance.sce.model.employee.Employee;
import com.insurance.sce.model.insurance.ActualCostInsurance;
import com.insurance.sce.model.insurance.Insurance;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/**/root-context.xml")

public class InsurantDAOTest {

	@Inject
	private InsuranceDAO InsuranceDAO;
	
	@Test
	public void testSelectInsurantList() {
		
	}
}
