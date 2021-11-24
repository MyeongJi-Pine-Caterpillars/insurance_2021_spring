package com.insurance.sce.dao;

import java.util.List;
import com.insurance.sce.model.customer.Insurant;

public interface InsurantDAO {
	public int insertInsurant(Insurant insurant);
	
	public List<Insurant> selectInsurantList();
	public Insurant selectInsurant(String InsurantId);
	public Insurant selectByCustomerId(String customerId);
	public String selectCustomerId(String insurantId);
	
	public int updateName(Insurant insurant);
	public int updateAddress(Insurant insurant);
	public int updatePhoneNumber(Insurant insurant);
	public int updateAge(Insurant insurant);
	public int updateAccidentHistory(Insurant insurant);
	public int updatePostedPriceOfStructure(Insurant insurant);
	public int updateUsageOfStructure(Insurant insurant);
	public int updateGender(Insurant insurant);
	public int updateJob(Insurant insurant);
	public int updateTypeOfCar(Insurant insurant);
	public int updateRankOfCar(Insurant insurant);
	public int updateRiskOfTripCountry(Insurant insurant);
	public int updateForRecontract(Insurant insurant);
	public int updateFamilyMedicalRelationship(Insurant insurant);
	public int updateFamilyMedicalDisease(Insurant insurant);
	
	public int delete(String insurantId);
}
