package com.insurance.sce.model.customer;

import com.insurance.sce.global.Constants.*;

public class Insurant {
	// Attributes
	private String insurantId;
	private String customerId;
	private String name;
	private String address;
	private String phoneNumber;
	private int age;
	private int accidentHistory;
	private long postedPriceOfStructure;
	private eUsageOfStructure usageOfStructure;
	private eGender gender;
	private eJob job;
	private eTypeOfCar typeOfCar;
	private eRankOfCar rankOfCar;
	private eRiskOfTripCountry riskOfTripCountry;
	private eFamilyMedicalDisease familyMedicalDisease;
	private eFamilyMedicalRelationship familyMedicalRelationship;

	// Constructor
	public Insurant(){
		
	}

	// getters & setters	
	public String getCustomerId() {return customerId;}
	public void setCustomerId(String customerId) {this.customerId = customerId;}
	
	public int getAccidentHistory() {return accidentHistory;}
	public void setAccidentHistory(int accidentHistory) {this.accidentHistory = accidentHistory;}

	public String getAddress() {return address;}
	public void setAddress(String address) {this.address = address;}

	public int getAge() {return age;}
	public void setAge(int age) {this.age = age;}

	public String getInsurantId() {return insurantId;}
	public void setInsurantId(String insurantId) {this.insurantId = insurantId;}

	public String getName() {return name;}
	public void setName(String name) {this.name = name;}

	public String getPhoneNumber() {return phoneNumber;}
	public void setPhoneNumber(String phoneNumber) {this.phoneNumber = phoneNumber;}

	public long getPostedPriceOfStructure() {return postedPriceOfStructure;}
	public void setPostedPriceOfStructure(long postedPriceOfStructure) {this.postedPriceOfStructure = postedPriceOfStructure;}

	public int getGender() {return gender.getNum();}
	public void setGender(int gender) {this.gender = eGender.get(gender);}

	public int getUsageOfStructure() {return usageOfStructure.getNum();}
	public void setUsageOfStructure(int usageOfStructure) {this.usageOfStructure = eUsageOfStructure.get(usageOfStructure);}

	public int getJob() {return job.getNum();}
	public void setJob(int job) {this.job = eJob.get(job);}

	public int getTypeOfCar() {return typeOfCar.getNum();}
	public void setTypeOfCar(int typeOfCar) {this.typeOfCar = eTypeOfCar.get(typeOfCar);}

	public int getRankOfCar() {return rankOfCar.getNum();}
	public void setRankOfCar(int rankOfCar) {this.rankOfCar = eRankOfCar.get(rankOfCar);}
	
	public int getRiskOfTripCountry() {return riskOfTripCountry.getNum();}
	public void setRiskOfTripCountry(int riskOfTripCountry) {this.riskOfTripCountry = eRiskOfTripCountry.get(riskOfTripCountry);}

	public int getFamilyMedicalDisease() {return familyMedicalDisease.getNum();}
	public void setFamilyMedicalDisease(int familyMedicalDisease) {this.familyMedicalDisease = eFamilyMedicalDisease.get(familyMedicalDisease);}

	public int getFamilyMedicalRelationship() {return familyMedicalRelationship.getNum();}
	public void setFamilyMedicalRelationship(int familyMedicalRelationship) {this.familyMedicalRelationship = eFamilyMedicalRelationship.get(familyMedicalRelationship);}

}
