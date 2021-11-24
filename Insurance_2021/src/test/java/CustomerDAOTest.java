import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.insurance.sce.dao.CustomerDAO;
import com.insurance.sce.model.customer.Customer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/**/root-context.xml")

public class CustomerDAOTest {
	@Inject
	private CustomerDAO customerDao;
	
	@Test
	public void testInsertCustomer() throws Exception{
		Customer custoemr = new Customer();
		custoemr.setCustomerId("test3");
		custoemr.setPassword("test3");
		custoemr.setName("테스트3");
		custoemr.setAddress("테스트시3");
		custoemr.setPhoneNumber("010-1234-5678");
		
		customerDao.insertCustomer(custoemr);
	}
	
	@Test
	public void testSelectCustomerList() {
		List<Customer> customerList = customerDao.selectCustomerList();
		for(Customer customer : customerList) {
			System.out.println(customer.getName() + " / " + customer.getAddress());
		}
	}
	
	@Test
	public void testSelectCustomer() {
		Customer customer = customerDao.selectCustomer("kim");
		System.out.println(customer.getName() + " / " + customer.getAddress());
	}
	
	@Test
	public void testUpdateAddress() {
		Customer customer = new Customer();
		customer.setCustomerId("hong");
		customer.setAddress("과천시");
		
		customerDao.updateAddress(customer);
	}
	
	@Test
	public void testUpdatePhoneNumber() {
		Customer customer = new Customer();
		customer.setCustomerId("hong");
		customer.setPhoneNumber("010-9876-5432");
		customerDao.updatePhoneNumber(customer);
	}
	
	@Test
	public void testDeleteCustomer() {
		customerDao.deleteCustomer("test2");
	}
}
