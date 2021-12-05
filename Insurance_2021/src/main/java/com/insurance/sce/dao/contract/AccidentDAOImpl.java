package com.insurance.sce.dao.contract;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.insurance.sce.model.contract.Accident;

@Component
public class AccidentDAOImpl implements AccidentDAO{
	@Inject
	private SqlSession sqlSession;

	private static final String Insert = "accidentMapper.insert";
	private static final String SelectAll = "accidentMapper.selectAll";
	private static final String SelectListByContractId = "accidentMapper.selectListByContractId";
	private static final String SelectByAccidentId = "accidentMapper.selectByAccidentId";
	private static final String UpdateCompensation = "accidentMapper.updateCompensation";
	private static final String UpdateHandlingStatus= "accidentMapper.updateHandlingStatus";
	private static final String Delete = "accidentMapper.delete";

	// Insert
	public int insert(Accident accident) {return sqlSession.insert(Insert, accident);}

	// Select
	public List<Accident> selectAll() {return sqlSession.selectList(SelectAll);}
	public List<Accident> selectListByContractId(String contractId) {return sqlSession.selectList(SelectListByContractId, contractId);}
	public Accident selectByAccidentId(String accidentId) {return sqlSession.selectOne(SelectByAccidentId, accidentId);}
	
	// Update
	public int updateCompensation(Accident accident) {return sqlSession.update(UpdateCompensation, accident);}
	public int updateHandlingStatus(Accident accident) {return sqlSession.update(UpdateHandlingStatus, accident);}

	// Delete
	public int delete(String accidentId) {return sqlSession.delete(Delete, accidentId);}
}
