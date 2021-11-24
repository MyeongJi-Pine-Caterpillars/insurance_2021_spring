import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.insurance.sce.dao.ContractDAO;
import com.insurance.sce.model.contract.Contract;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/**/root-context.xml")

public class ContractDAOTest {
	@Inject
	private ContractDAO contractDao;
	
	@Test
	public void testInsert() throws Exception{
		Contract contract= new Contract();
		contract.setContractId("test");
		contract.setInsurantId("1");
		contract.setInsuranceId("1213");
		contract.setEffectiveness(false);
		contract.setSpecial(false);
		contract.setLifespan(111);
		contract.setFee(111);
		contract.setUnpaidPeriod(111);
		
		contractDao.insert(contract);
	}
	
	@Test
	public void testSelectAll() {
		List<Contract> contractList = contractDao.selectAll();
		for(Contract contract : contractList) {
			System.out.println(contract.getContractId() + " / " + contract.getFee());
		}
	}
	
	@Test
	public void testUpdateAddress() {
		Contract contract= new Contract();
		contract.setContractId("1");
		contract.setFee(36000);
		
		contractDao.updateFee(contract);
	}
	
	@Test
	public void testDelete() {
		contractDao.delete("5");
	}
}
