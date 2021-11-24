package com.insurance.sce.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.insurance.sce.model.contract.Accident;

@Repository
public class AccidentDAOImpl extends DBConnector implements AccidentDAO{
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
	@Override
	public int insert(Accident accident) {return sqlSession.insert(Insert, accident);}

	// Select
	@Override
	public List<Accident> selectAll() {return sqlSession.selectList(SelectAll);}
	@Override
	public List<Accident> selectListByContractId(String contractId) {return sqlSession.selectList(SelectListByContractId, contractId);}
	@Override
	public Accident selectByAccidentId(String accidentId) {return sqlSession.selectOne(SelectByAccidentId, accidentId);}
	
	// Update
	@Override
	public int updateCompensation(Accident accident) {return sqlSession.update(UpdateCompensation, accident);}
	@Override
	public int updateHandlingStatus(Accident accident) {return sqlSession.update(UpdateHandlingStatus, accident);}

	// Delete
	@Override
	public int delete(String accidentId) {return sqlSession.delete(Delete, accidentId);}
}
