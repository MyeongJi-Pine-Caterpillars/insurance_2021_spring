package com.insurance.sce.dao.contract;

import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;
import com.insurance.sce.model.contract.Contract;

@Component
public class ContractDAOImpl implements ContractDAO{
	@Inject
	private SqlSession sqlSession;

	private static final String Insert = "contractMapper.insert";
	private static final String SelectAll = "contractMapper.selectAll";
	private static final String SelectAllContractId = "contractMapper.selectAllContractId";
	private static final String SelectAllIds = "contractMapper.selectAllIds";
	private static final String SelectListByInsurant = "contractMapper.selectListByInsurant";
	private static final String Select = "contractMapper.select";
	private static final String SelectUnpaidAndFee = "contractMapper.selectUnpaidAndFee";
	private static final String SelectNotEffectiveContract = "contractMapper.selectNotEffectiveContract";
	private static final String UpdateFee = "contractMapper.updateFee";
	private static final String UpdateEffectiveness = "contractMapper.updateEffectiveness";
	private static final String UpdateLifespan = "contractMapper.updateLifespan";
	private static final String UpdateUnpaidPeriod = "contractMapper.updateUnpaidPeriod";
	private static final String UpdateSpecial = "contractMapper.updateSpecial";
	private static final String Delete = "contractMapper.delete";
	private static final String SelectContractInsurance = "contractMapper.selectContractInsurance";
	
	static final String GetAllData = "contractMapper.selectAllData";
	// Insert
	public int insert(Contract contract) {return sqlSession.insert(Insert, contract);}

	// Select
	public List<Contract> selectAll() {return sqlSession.selectList(SelectAll);}
	public List<String> selectAllContractId() {return sqlSession.selectList(SelectAllContractId);}
	public List<Contract> selectAllIds() {return sqlSession.selectList(SelectAllIds);}
	public List<Contract> selectListByInsurant(String insurantId) {return sqlSession.selectList(SelectListByInsurant, insurantId);}
	public Contract select(String contractId) {return (Contract) sqlSession.selectOne(Select, contractId);}
	public Contract selectUnpaidAndFee(String contractId) {return (Contract) sqlSession.selectList(SelectUnpaidAndFee, contractId);}
	public List<Contract> selectNotEffectiveContract() {return sqlSession.selectList(SelectNotEffectiveContract);}
	public List<Map<String, Object>> selectContractInsurance(String customerId) {return sqlSession.selectList(SelectContractInsurance, customerId);}

	// Update
	public int updateFee(Contract contract) {return sqlSession.update(UpdateFee, contract);}
	public int updateEffectiveness(Contract contract) {return sqlSession.update(UpdateEffectiveness, contract);}
	public int updateLifespan(Contract contract) {return sqlSession.update(UpdateLifespan, contract);}
	public int updateUnpaidPeriod(Contract contract) {return sqlSession.update(UpdateUnpaidPeriod, contract);}
	public int updateSpecial(Contract contract) {return sqlSession.update(UpdateSpecial, contract);}

	// Delete
	public int delete(String contractId) {return sqlSession.update(Delete, contractId);}

	public List<Map<String, Object>> getAllData() {
		return sqlSession.selectList(GetAllData);
	}
	
}
