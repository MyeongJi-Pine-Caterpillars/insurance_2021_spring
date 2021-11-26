package com.insurance.sce.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.insurance.sce.model.customer.Insurant;
import com.insurance.sce.model.customer.InsurantDB;

@Repository
public interface InsurantDAO {
	public int insertInsurant(Insurant insurant);
	
	public ArrayList<Insurant> selectInsurantList();
	public Insurant selectInsurant(String InsurantId);
	public Insurant selectByCustomerId(String customerId);
	public String selectCustomerId(String insurantId);
	
	public int updateName(Insurant insurant);
	public int updateAddress(Insurant insurant);
	public int updatePhoneNumber(Insurant insurant);
	public int updateAge(Insurant insurant);
	public int updateAccidentHistory(Insurant insurant);
	public int updatePostedPriceOfStructure(Insurant insurant);
	public int updateUsageOfStructure(InsurantDB insurant);
	public int updateGender(InsurantDB insurant);
	public int updateJob(InsurantDB insurant);
	public int updateTypeOfCar(InsurantDB insurant);
	public int updateRankOfCar(InsurantDB insurant);
	public int updateRiskOfTripCountry(InsurantDB insurant);
	public int updateForRecontract(InsurantDB insurant);
	public int updateFamilyMedicalRelationship(InsurantDB insurant);
	public int updateFamilyMedicalDisease(InsurantDB insurant);
	
	public int delete(String insurantId);
}
