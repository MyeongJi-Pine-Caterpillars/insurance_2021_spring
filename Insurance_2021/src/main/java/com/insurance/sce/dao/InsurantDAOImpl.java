package com.insurance.sce.dao;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.insurance.sce.model.customer.Insurant;

@Repository
public class InsurantDAOImpl implements InsurantDAO {
	

	@Inject
	private SqlSession sqlSession;
	
	private static final String Insert = "insurantMapper.insertInsurant";
	
	private static final String SelectInsurantList = "insurantMapper.selectInsurantList";
	private static final String SelectInsurant = "insurantMapper.selectInsurant";
	private static final String SelectByCustomerId = "insurantMapper.selectByCustomerId";
	private static final String SelectCustomerId = "insurantMapper.selectCustomerId";
	
	private static final String UpdateName = "insurantMapper.updateName";
	private static final String UpdateAddress = "insurantMapper.updateAddress";
	private static final String UpdatePhoneNumber = "insurantMapper.updatePhoneNumber";
	private static final String UpdateAge = "insurantMapper.updateAge";
	private static final String UpdateAccidentHistory = "insurantMapper.updateAccidentHistory";
	private static final String UpdatePostedPriceOfStructure = "insurantMapper.updatePostedPriceOfStructure";
	private static final String UpdateUsageOfStructure = "insurantMapper.updateUsageOfStructure";
	private static final String UpdateGender = "insurantMapper.updateGender";
	private static final String UpdateJob = "insurantMapper.updateJob";
	private static final String UpdateTypeOfCar = "insurantMapper.updateTypeOfCar";
	private static final String UpdateRankOfCar = "insurantMapper.updateRankOfCar";
	private static final String UpdateRiskOfTripCountry = "insurantMapper.updateRiskOfTripCountry";
	private static final String UpdateForRecontract = "insurantMapper.updateForRecontract";
	private static final String UpdateFamilyMedicalRelationship = "insurantMapper.updateFamilyMedicalRelationship";
	private static final String UpdateFamilyMedicalDisease = "insurantMapper.updateFamilyMedicalDisease";
	
	private static final String Delete = "insurantMapper.delete";
	
	public int insertInsurant(Insurant insurant) {
		InsurantDB insurantDB = new InsurantDB(insurant);
		return sqlSession.insert(Insert, insurantDB);
	}

	public List<Insurant> selectInsurantList() {
		ArrayList<Insurant> insurantList = new ArrayList<Insurant>();
		List<InsurantDB> insurantDB = sqlSession.selectList(SelectInsurantList);
		for(InsurantDB insurant : insurantDB) {
			insurant.setEnum();
			insurantList.add(insurant);
		}
		return insurantList;
	}
	public Insurant selectInsurant(String InsurantId) {
		InsurantDB insurantDB = sqlSession.selectOne(SelectInsurant, InsurantId);
		insurantDB.setEnum();
		return (Insurant)insurantDB;
	}

	public Insurant selectByCustomerId(String customerId) {
		return sqlSession.selectOne(SelectByCustomerId, customerId);
	}

	public String selectCustomerId(String insurantId) {
		return sqlSession.selectOne(SelectCustomerId, insurantId);
	}

	public int updateName(Insurant insurant) {
		return sqlSession.update(UpdateName, insurant);
	}

	public int updateAddress(Insurant insurant) {
		return sqlSession.update(UpdateAddress, insurant);
	}

	public int updatePhoneNumber(Insurant insurant) {
		return sqlSession.update(UpdatePhoneNumber, insurant);
	}

	public int updateAge(Insurant insurant) {
		return sqlSession.update(UpdateAge, insurant);
	}

	public int updateAccidentHistory(Insurant insurant) {
		return sqlSession.update(UpdateAccidentHistory, insurant);
	}

	public int updatePostedPriceOfStructure(Insurant insurant) {
		return sqlSession.update(UpdatePostedPriceOfStructure, insurant);
	}

	public int updateUsageOfStructure(Insurant insurant) {
		InsurantDB insurantDB = new InsurantDB(insurant);
		return sqlSession.update(UpdateUsageOfStructure, insurantDB);
	}

	public int updateGender(Insurant insurant) {
		InsurantDB insurantDB = new InsurantDB(insurant);
		insurantDB.setEnum();
		return sqlSession.update(UpdateGender, insurantDB);
	}

	public int updateJob(Insurant insurant) {
		InsurantDB insurantDB = new InsurantDB(insurant);
		insurantDB.setEnum();
		return sqlSession.update(UpdateJob, insurantDB);
	}

	public int updateTypeOfCar(Insurant insurant) {
		InsurantDB insurantDB = new InsurantDB(insurant);
		insurantDB.setEnum();
		return sqlSession.update(UpdateTypeOfCar, insurantDB);
	}

	public int updateRankOfCar(Insurant insurant) {
		InsurantDB insurantDB = new InsurantDB(insurant);
		insurantDB.setEnum();
		return sqlSession.update(UpdateRankOfCar, insurantDB);
	}

	public int updateRiskOfTripCountry(Insurant insurant) {
		InsurantDB insurantDB = new InsurantDB(insurant);
		insurantDB.setEnum();
		return sqlSession.update(UpdateRiskOfTripCountry, insurantDB);
	}

	public int updateForRecontract(Insurant insurant) {
		InsurantDB insurantDB = new InsurantDB(insurant);
		insurantDB.setEnum();
		return sqlSession.update(UpdateForRecontract, insurantDB);
	}

	public int updateFamilyMedicalRelationship(Insurant insurant) {
		InsurantDB insurantDB = new InsurantDB(insurant);
		insurantDB.setEnum();
		return sqlSession.update(UpdateFamilyMedicalRelationship, insurantDB);
	}

	public int updateFamilyMedicalDisease(Insurant insurant) {
		InsurantDB insurantDB = new InsurantDB(insurant);
		insurantDB.setEnum();
		return sqlSession.update(UpdateFamilyMedicalDisease, insurantDB);
	}

	public int delete(String insurantId) {
		return sqlSession.delete(Delete, insurantId);
		
	}
}