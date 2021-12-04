package com.insurance.sce.dao;

import com.insurance.sce.global.Constants.eGender;
import com.insurance.sce.global.Constants.eInsuranceType;

public class Data {
	private String contractId;
	private String insurantId;
	private String insuranceId;
	private boolean special;
	
	private String name;
	private eInsuranceType type;
	private int basicFee;
	
	private int age; //
	private eGender gender; //
	
	public Data() {
		
	}
	
	// getters & setters
	public int getAge() {return age;}
	public void setAge(int age) {this.age = age;}
		
	
		public int getBasicFee() {return basicFee;}
		public void setBasicFee(int basicFee) {this.basicFee = basicFee;}
		public String getInsuranceId() {return insuranceId;}
		public void setInsuranceId(String insuranceId) {this.insuranceId = insuranceId;}

		public String getName() {return name;}
		public void setName(String name) {this.name = name;}

		public int getType() {return type.getNum();}
		public void setType(int type) {this.type = eInsuranceType.get(type);}

		public eInsuranceType getEType() {return type;}
		public void setEType(eInsuranceType type) {this.type = type;}
		
		public int getGender() {return gender.getNum();}
		public void setGender(int gender) {this.gender = eGender.get(gender);}

		public eGender getEGender() {return gender;}
		public void setEGender(eGender gender) {this.gender = gender;}
		
	
		
		// Getters&Setters
		public String getContractId() {return contractId;}
		public void setContractId(String contractId) {this.contractId = contractId;}
		
		public String getInsurantId() {return insurantId;}
		public void setInsurantId(String insurantId) {this.insurantId = insurantId;}


		public boolean isSpecial() {return special;}
		public void setSpecial(boolean special) {this.special = special;}

			
}
