package com.insurance.sce.dao;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.insurance.sce.model.customer.Insurant;
import com.insurance.sce.model.customer.InsurantDB;

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

	public ArrayList<Insurant> selectInsurantList() {
		ArrayList<Insurant> insurantList = new ArrayList<Insurant>();
		List<InsurantDB> insurantDBList = sqlSession.selectList(SelectInsurantList);
		for(InsurantDB db : insurantDBList) {
			db.setEnum();
			insurantList.add((Insurant)db);
		}
		return insurantList;
	}
	public Insurant selectInsurant(String insurantId) {
		InsurantDB insurantDB = sqlSession.selectOne(SelectInsurant, insurantId);
		
		insurantDB.setEnum();
		return (Insurant)insurantDB;
	}
	public Insurant selectByCustomerId(String customerId) {return sqlSession.selectOne(SelectByCustomerId, customerId);}
	public String selectCustomerId(String insurantId) {return sqlSession.selectOne(SelectCustomerId, insurantId);}
	
	public int updateName(Insurant insurant) {return sqlSession.update(UpdateName, insurant);}
	public int updateAddress(Insurant insurant) {return sqlSession.update(UpdateAddress, insurant);}
	public int updatePhoneNumber(Insurant insurant) {return sqlSession.update(UpdatePhoneNumber, insurant);}
	public int updateAge(Insurant insurant) {return sqlSession.update(UpdateAge, insurant);}
	public int updateAccidentHistory(Insurant insurant) {return sqlSession.update(UpdateAccidentHistory, insurant);}
	public int updatePostedPriceOfStructure(Insurant insurant) {return sqlSession.update(UpdatePostedPriceOfStructure, insurant);}
	public int updateUsageOfStructure(InsurantDB insurant) {return sqlSession.update(UpdateUsageOfStructure, insurant);}
	public int updateGender(InsurantDB insurant) {return sqlSession.update(UpdateGender, insurant);}
	public int updateJob(InsurantDB insurant) {return sqlSession.update(UpdateJob, insurant);}
	public int updateTypeOfCar(InsurantDB insurant) {return sqlSession.update(UpdateTypeOfCar, insurant);}
	public int updateRankOfCar(InsurantDB insurant) {return sqlSession.update(UpdateRankOfCar, insurant);}
	public int updateRiskOfTripCountry(InsurantDB insurant) {return sqlSession.update(UpdateRiskOfTripCountry, insurant);}
	public int updateForRecontract(InsurantDB insurant) {return sqlSession.update(UpdateForRecontract, insurant);}
	public int updateFamilyMedicalRelationship(InsurantDB insurant) {return sqlSession.update(UpdateFamilyMedicalRelationship, insurant);}
	public int updateFamilyMedicalDisease(InsurantDB insurant) {return sqlSession.update(UpdateFamilyMedicalDisease, insurant);}

	public int delete(String insurantId) {return sqlSession.delete(Delete, insurantId);}
}