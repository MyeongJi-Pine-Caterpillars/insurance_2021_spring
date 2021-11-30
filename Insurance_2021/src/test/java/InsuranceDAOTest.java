import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.insurance.sce.dao.CustomerDAO;
import com.insurance.sce.dao.InsuranceDAO;
import com.insurance.sce.model.customer.Customer;
import com.insurance.sce.model.insurance.CancerInsurance;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/**/root-context.xml")

public class InsuranceDAOTest {
	@Inject
	private InsuranceDAO insuranceDAO;
	
//	@Test
//	public void testInsertCustomer() throws Exception{
//		
//	}
//	
	@Test
	public void testSelectCancerInsurance() {
		List<CancerInsurance> list = insuranceDAO.selectAllCancerInsurance();
		for(CancerInsurance insurance : list) {
			System.out.println(insurance.getName() + " " + insurance.getEType());
		}
	}
//	
//	@Test
//	public void testSelectCustomer() {
//	}
//	
//	@Test
//	public void testUpdateAddress() {
//	}
//	
//	@Test
//	public void testUpdatePhoneNumber() {
//	}
//	
//	@Test
//	public void testDeleteCustomer() {
//	}
}
