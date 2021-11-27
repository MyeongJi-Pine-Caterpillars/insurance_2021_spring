package com.insurance.sce.dao;

import com.insurance.sce.model.customer.Insurant;
import com.insurance.sce.global.Constants.eUsageOfStructure;
import com.insurance.sce.global.Constants.eGender;
import com.insurance.sce.global.Constants.eJob;
import com.insurance.sce.global.Constants.eTypeOfCar;
import com.insurance.sce.global.Constants.eRankOfCar;
import com.insurance.sce.global.Constants.eRiskOfTripCountry;
import com.insurance.sce.global.Constants.eFamilyMedicalRelationship;
import com.insurance.sce.global.Constants.eFamilyMedicalDisease;

public class InsurantDB extends Insurant {
	
	private int usageOfStructure;
	private int gender;
	private int job;
	private int typeOfCar;
	private int rankOfCar;
	private int riskOfTripCountry;
	private int familyMedicalDisease;
	private int familyMedicalRelationship;
	
	public InsurantDB() {
		
	}
	
	public InsurantDB(Insurant insurant) {
		this.setInsurantId(insurant.getInsurantId());
		this.setCustomerId(insurant.getCustomerId());
		this.setName(insurant.getName());
		this.setAddress(insurant.getAddress());
		this.setPhoneNumber(insurant.getPhoneNumber());
		this.setAge(insurant.getAge());
		this.setAccidentHistory(insurant.getAccidentHistory());
		this.setPostedPriceOfStructure(insurant.getPostedPriceOfStructure());
		this.usageOfStructure = insurant.getEUsageOfStructure().getNum();
		this.gender = insurant.getEGender().getNum();
		this.typeOfCar = insurant.getETypeOfCar().getNum();
		this.rankOfCar = insurant.getERankOfCar().getNum();
		this.job = insurant.getEJob().getNum();
		this.riskOfTripCountry = insurant.getERiskOfTripCountry().getNum();
		this.familyMedicalDisease = insurant.getEFamilyMedicalDisease().getNum();
		this.familyMedicalRelationship = insurant.getEFamilyMedicalRelationship().getNum();
	}
	
	public void setEnum() {
		this.setEUsageOfStructure(eUsageOfStructure.values()[usageOfStructure]);
		this.setEJob(eJob.values()[usageOfStructure]);
		this.setEGender(eGender.values()[gender]);
		this.setETypeOfCar(eTypeOfCar.values()[typeOfCar]);
		this.setERankOfCar(eRankOfCar.values()[rankOfCar]);
		this.setERiskOfTripCountry(eRiskOfTripCountry.values()[riskOfTripCountry]);
		this.setEFamilyMedicalDisease(eFamilyMedicalDisease.values()[familyMedicalDisease]);
		this.setEFamilyMedicalRelationship(eFamilyMedicalRelationship.values()[familyMedicalRelationship]);
	}

	public int getUsageOfStructure() {
		return usageOfStructure;
	}

	public void setUsageOfStructure(int usageOfStructure) {
		this.usageOfStructure = usageOfStructure;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public int getJob() {
		return job;
	}

	public void setJob(int job) {
		this.job = job;
	}

	public int getTypeOfCar() {
		return typeOfCar;
	}

	public void setTypeOfCar(int typeOfCar) {
		this.typeOfCar = typeOfCar;
	}

	public int getRankOfCar() {
		return rankOfCar;
	}

	public void setRankOfCar(int rankOfRank) {
		this.rankOfCar = rankOfRank;
	}

	public int getRiskOfTripCountry() {
		return riskOfTripCountry;
	}

	public void setRiskOfTripCountry(int riskOfTripCountry) {
		this.riskOfTripCountry = riskOfTripCountry;
	}

	public int getFamilyMedicalDisease() {
		return familyMedicalDisease;
	}

	public void setFamilyMedicalDisease(int familyMedicalDisease) {
		this.familyMedicalDisease = familyMedicalDisease;
	}

	public int getFamilyMedicalRelationship() {
		return familyMedicalRelationship;
	}

	public void setFamilyMedicalRelationship(int familyMedicalRelationship) {
		this.familyMedicalRelationship = familyMedicalRelationship;
	}

}
