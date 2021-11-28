package com.insurance.sce.model.insurance;

import com.insurance.sce.global.Constants.eGender;
import com.insurance.sce.model.customer.Insurant;

public class CancerInsurance extends Insurance {
	// Attributes
	private double[] rateOfFamilyMedicalDisease = {1.6, 1.5, 1.4, 1.3, 1.2}; // index[0: thyroid/ 1: testicular/ 2: ovarian/ 3: esophageal/ 4: lung]
	private double[] rateOfFamilyMedicalRelationship = {1.4, 1.3, 1.2, 1.1}; // index[0: 1�룯占�/ 1: 2�룯占�/ 2: 3�룯占�/ 3: 4�룯占�]
		
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

		// 占쎄돌占쎌뵠占쎈퓠 占쎈뎡�몴占� 占쎌뒄占쎌몛 �④쑴沅�
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
		
		// 占쎄쉐癰귢쑴肉� 占쎈뎡�몴占� 占쎌뒄占쎌몛 �④쑴沅�
		if (insurant.getGender() == eGender.male) {
			fee *= this.getRateOfGender()[0];
		} else if (insurant.getGender() == eGender.female){
			fee *= this.getRateOfGender()[1];
		}
		
		// 筌욊낯毓쏙옙肉� 占쎈뎡�몴占� 占쎌뒄占쎌몛 �④쑴沅�
		switch (insurant.getJob()) {
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
		
		// 揶쏉옙鈺곌퉭�앾옙�젾占쎈퓠 占쎈뎡�몴占� 占쎌뒄占쎌몛 �④쑴沅�
		switch (insurant.getFamilyMedicalRelationship()) {
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
		
		switch (insurant.getFamilyMedicalDisease()) {
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