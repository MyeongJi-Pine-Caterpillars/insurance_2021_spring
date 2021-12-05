import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.insurance.sce.dao.contract.CompensationCauseDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/**/root-context.xml")

public class CompensationCauseDAOTest {
	@Inject
	private CompensationCauseDAO compensationCauseDAO;
	
	@Test
	public void testInsert() throws Exception{
		compensationCauseDAO.insert("4001", "testcase");
	}
	
	@Test
	public void testSelect() {
		String cause = compensationCauseDAO.select("2001");
		System.out.println(cause);
	}
}
