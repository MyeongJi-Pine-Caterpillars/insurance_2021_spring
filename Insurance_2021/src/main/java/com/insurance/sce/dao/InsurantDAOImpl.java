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
	
	private static final String SelectAll = "insurantMapper.selectAll";
	private static final String SelectInsurantIds = "insurantMapper.selectInsurantIds";
	private static final String Select = "insurantMapper.select";
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
	
	public int insertInsurant(Insurant insurant) {return sqlSession.insert(Insert, insurant);}

	public List<Insurant> selectAll() {return sqlSession.selectList(SelectAll);}
	public List<String> selectInsurantIds() {return sqlSession.selectList(SelectInsurantIds);}
	public Insurant select(String InsurantId) {return sqlSession.selectOne(Select, InsurantId);}
	public Insurant selectByCustomerId(String customerId) {return sqlSession.selectOne(SelectByCustomerId, customerId);}
	public String selectCustomerId(String insurantId) {return sqlSession.selectOne(SelectCustomerId, insurantId);}

	public int updateName(Insurant insurant) {return sqlSession.update(UpdateName, insurant);}
	public int updateAddress(Insurant insurant) {return sqlSession.update(UpdateAddress, insurant);}
	public int updatePhoneNumber(Insurant insurant) {return sqlSession.update(UpdatePhoneNumber, insurant);}
	public int updateAge(Insurant insurant) {return sqlSession.update(UpdateAge, insurant);}
	public int updateAccidentHistory(Insurant insurant) {return sqlSession.update(UpdateAccidentHistory, insurant);}
	public int updatePostedPriceOfStructure(Insurant insurant) {return sqlSession.update(UpdatePostedPriceOfStructure, insurant);}
	public int updateUsageOfStructure(Insurant insurant) {return sqlSession.update(UpdateUsageOfStructure, insurant);}
	public int updateGender(Insurant insurant) {return sqlSession.update(UpdateGender, insurant);}
	public int updateJob(Insurant insurant) {return sqlSession.update(UpdateJob, insurant);}
	public int updateTypeOfCar(Insurant insurant) {return sqlSession.update(UpdateTypeOfCar, insurant);}
	public int updateRankOfCar(Insurant insurant) {return sqlSession.update(UpdateRankOfCar, insurant);}
	public int updateRiskOfTripCountry(Insurant insurant) {return sqlSession.update(UpdateRiskOfTripCountry, insurant);}
	public int updateForRecontract(Insurant insurant) {return sqlSession.update(UpdateForRecontract, insurant);}
	public int updateFamilyMedicalRelationship(Insurant insurant) {return sqlSession.update(UpdateFamilyMedicalRelationship, insurant);}
	public int updateFamilyMedicalDisease(Insurant insurant) {return sqlSession.update(UpdateFamilyMedicalDisease, insurant);}

	public int delete(String insurantId) {
		return sqlSession.delete(Delete, insurantId);
		
	}

	
}