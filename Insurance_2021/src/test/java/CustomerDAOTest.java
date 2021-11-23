import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.insurance.sce.dao.MyCustomerDAO;
import com.insurance.sce.model.customer.Customer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/**/root-context.xml")

public class CustomerDAOTest {
	@Inject
	private MyCustomerDAO customerDao;
	
	@Test
	public void testSelectCustomer() {
		Customer customer = customerDao.selectCustomer("kim");
		System.out.println(customer.getName() + " / " + customer.getAddress());
	}
}
