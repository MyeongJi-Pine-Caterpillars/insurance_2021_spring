package com.insurance.sce.model.customer;

import java.util.Scanner;

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
	private eUsageOfStructure eUsageOfStructure;
	private eGender eGender;
	private eJob eJob;
	private eTypeOfCar eTypeOfCar;
	private eRankOfCar eRankOfCar;
	private eRiskOfTripCountry eRiskOfTripCountry;
	private eFamilyMedicalDisease eFamilyMedicalDisease;
	private eFamilyMedicalRelationship eFamilyMedicalRelationship;

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

	public eGender getEGender() {return eGender;}
	public void setEGender(eGender gender) {this.eGender = gender;}

	public eUsageOfStructure getEUsageOfStructure() {return eUsageOfStructure;}
	public void setEUsageOfStructure(eUsageOfStructure usageOfStructure) {this.eUsageOfStructure = usageOfStructure;}

	public eJob getEJob() {return eJob;}
	public void setEJob(eJob job) {this.eJob = job;}

	public eTypeOfCar getETypeOfCar() {return eTypeOfCar;}
	public void setETypeOfCar(eTypeOfCar typeOfCar) {this.eTypeOfCar = typeOfCar;}

	public eRankOfCar getERankOfCar() {return eRankOfCar;}
	public void setERankOfCar(eRankOfCar rankOfCar) {this.eRankOfCar = rankOfCar;}
	
	public eRiskOfTripCountry getERiskOfTripCountry() {return eRiskOfTripCountry;}
	public void setERiskOfTripCountry(eRiskOfTripCountry riskOfTripCountry) {this.eRiskOfTripCountry = riskOfTripCountry;}

	public eFamilyMedicalDisease getEFamilyMedicalDisease() {return eFamilyMedicalDisease;}
	public void setEFamilyMedicalDisease(eFamilyMedicalDisease familyMedicalDisease) {this.eFamilyMedicalDisease = familyMedicalDisease;}

	public eFamilyMedicalRelationship getEFamilyMedicalRelationship() {return eFamilyMedicalRelationship;}
	public void setEFamilyMedicalRelationship(eFamilyMedicalRelationship familyMedicalRelationship) {this.eFamilyMedicalRelationship = familyMedicalRelationship;}

}
