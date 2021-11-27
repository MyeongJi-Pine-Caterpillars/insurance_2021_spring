package com.insurance.sce.model.insurance;

import com.insurance.sce.global.Constants.eGender;
import com.insurance.sce.model.customer.Insurant;

public class CancerInsurance extends Insurance {
	// Attributes
	private double[] rateOfFamilyMedicalDisease = {1.6, 1.5, 1.4, 1.3, 1.2}; // index[0: thyroid/ 1: testicular/ 2: ovarian/ 3: esophageal/ 4: lung]
	private double[] rateOfFamilyMedicalRelationship = {1.4, 1.3, 1.2, 1.1}; // index[0: 1珥�/ 1: 2珥�/ 2: 3珥�/ 3: 4珥�]
		
	// Constructor
	public CancerInsurance() {
		
	}
	
	// getters & setters
	public double[] getRateOfFamilyMedicalDisease() {return rateOfFamilyMedicalDisease;}
	public void setRateOfFamilyMedicalDisease(double[] rateOfFamilyMedicalDisease) {this.rateOfFamilyMedicalDisease = rateOfFamilyMedicalDisease;}

	public double[] getRateOfFamilyMedicalRelationship() {return rateOfFamilyMedicalRelationship;}
	public void setRateOfFamilyMedicalRelationship(double[] rateOfFamilyMedicalRelationship) {this.rateOfFamilyMedicalRelationship = rateOfFamilyMedicalRelationship;}

	// public Methods
	public int calculateFee(Insurant insurant){
		double fee = this.getBasicFee();

		// �굹�씠�뿉 �뵲瑜� �슂�쑉 怨꾩궛
		if (insurant.getAge() >= 10 && insurant.getAge() < 20) {
			fee *= this.getRateOfAge()[0];
		} else if (insurant.getAge() >= 20 && insurant.getAge() < 30) {
			fee *= this.getRateOfAge()[1];
		} else if (insurant.getAge() >= 30 && insurant.getAge() < 40) {
			fee *= this.getRateOfAge()[2];
		} else if (insurant.getAge() >= 40 && insurant.getAge() < 50) {
			fee *= this.getRateOfAge()[3];
		} else if (insurant.getAge() >= 50 && insurant.getAge() < 60) {
			fee *= this.getRateOfAge()[4];
		} else if (insurant.getAge() >= 60 && insurant.getAge() < 70) {
			fee *= this.getRateOfAge()[5];
		} else {
			fee *= this.getRateOfAge()[6];
		}
		
		// �꽦蹂꾩뿉 �뵲瑜� �슂�쑉 怨꾩궛
		if (insurant.getEGender() == eGender.male) {
			fee *= this.getRateOfGender()[0];
		} else if (insurant.getEGender() == eGender.female){
			fee *= this.getRateOfGender()[1];
		}
		
		// 吏곸뾽�뿉 �뵲瑜� �슂�쑉 怨꾩궛
		switch (insurant.getEJob()) {
		case officeWorker:
			fee *= this.getRateOfJob()[0];
			break;
		case driver:
			fee *= this.getRateOfJob()[1];
			break;
		case factoryWorker:
			fee *= this.getRateOfJob()[2];
			break;
		case student:
			fee *= this.getRateOfJob()[3];
			break;
		case teacher:
			fee *= this.getRateOfJob()[4];
			break;
		case soldier:
			fee *= this.getRateOfJob()[5];
			break;
		case etc:
			fee *= this.getRateOfJob()[6];
			break;
		default:
			break;
		}
		
		// 媛�議깅퀝�젰�뿉 �뵲瑜� �슂�쑉 怨꾩궛
		switch (insurant.getEFamilyMedicalRelationship()) {
		case one:
			fee *= rateOfFamilyMedicalRelationship[0];
			break;
		case two:
			fee *= rateOfFamilyMedicalRelationship[1];
			break;
		case three:
			fee *= rateOfFamilyMedicalRelationship[2];
			break;
		case four:
			fee *= rateOfFamilyMedicalRelationship[3];
			break;
		default:
			break;
		}
		
		switch (insurant.getEFamilyMedicalDisease()) {
		case thyroid:
			fee *= rateOfFamilyMedicalDisease[0];
			break;
		case esophageal:
			fee *= rateOfFamilyMedicalDisease[1];
			break;
		case lung:
			fee *= rateOfFamilyMedicalDisease[2];
			break;
		case ovarian:
			fee *= rateOfFamilyMedicalDisease[3];
			break;
		case testicular:
			fee *= rateOfFamilyMedicalDisease[4];
			break;
		default:
			break;
		}
		
		return (int)fee;
	}
	
	public Insurance newInstance() {
		return new CancerInsurance();
	}

}