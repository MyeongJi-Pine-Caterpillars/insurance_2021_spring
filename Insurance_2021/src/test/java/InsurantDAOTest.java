import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.insurance.sce.dao.InsurantDAO;
import com.insurance.sce.global.Constants.eUsageOfStructure;
import com.insurance.sce.model.customer.Insurant;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/**/root-context.xml")

public class InsurantDAOTest {
	@Inject
	private InsurantDAO insurantDao;
	
	@Test
	public void testInserInsurant() throws Exception{
		Insurant insurant = new Insurant();
		insurant.setInsurantId("4");
		insurant.setCustomerId("kim");
		insurant.setName("1");
		insurant.setAddress("1");
		insurant.setPhoneNumber("1");
		insurant.setAge(1);
		insurant.setAccidentHistory(1);
		insurant.setPostedPriceOfStructure(1);
		insurant.setUsageOfStructure(eUsageOfStructure.factory);
		insurantDao.insertInsurant(insurant);
	}
	
	@Test
	public void testSelectInsurantList() {
		List<Insurant> insurantList = insurantDao.selectInsurantList();
		for(Insurant insurant : insurantList) {
			System.out.println(insurant.getName());
		}
	}
	
	@Test
	public void testSelectInsurant() {
		Insurant insurant = insurantDao.selectInsurant("1");
		System.out.println(insurant.getName());
	}
	
	@Test
	public void testSelectByCustomerId() {
		Insurant insurant = insurantDao.selectByCustomerId("hong");
		System.out.println(insurant.getName());
	}
	
	@Test
	public void testUpdateName() {
		Insurant insurant = new Insurant();
		insurant.setInsurantId("4");
		insurant.setName("test");
		insurantDao.updateName(insurant);
	} 
}