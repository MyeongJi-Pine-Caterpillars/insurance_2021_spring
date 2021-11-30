import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.insurance.sce.dao.ContractDAO;
import com.insurance.sce.dao.InsuranceDAO;
import com.insurance.sce.dao.InsurantDAO;
import com.insurance.sce.global.Constants.eGender;
import com.insurance.sce.global.Constants.eInsuranceType;
import com.insurance.sce.global.Constants.eUsageOfStructure;
import com.insurance.sce.model.contract.Contract;
import com.insurance.sce.model.customer.Insurant;
import com.insurance.sce.model.employee.Employee;
import com.insurance.sce.model.insurance.ActualCostInsurance;
import com.insurance.sce.model.insurance.CancerInsurance;
import com.insurance.sce.model.insurance.Insurance;
import com.insurance.sce.service.UnderWriterService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/**/root-context.xml")

public class InsurantDAOTest {

	@Inject
	UnderWriterService underWriterService;
	InsurantDAO insurantDAO;
	
	@Test
	public void testSelectInsurantList() {
		Insurant Insurant = underWriterService.getInsurant(underWriterService.getContract("test").getInsurantId());
		System.out.println(Insurant.getName());
	}
}
