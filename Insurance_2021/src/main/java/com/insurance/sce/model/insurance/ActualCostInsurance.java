package com.insurance.sce.model.insurance;

import com.insurance.sce.global.Constants.eGender;
import com.insurance.sce.model.customer.Insurant;

public class ActualCostInsurance extends Insurance {

	// Attributes
	private double selfBurdenRate;

	// Constructor
	public ActualCostInsurance(){

	}

	// getters & setters
	public double getSelfBurdenRate() {return selfBurdenRate;}
	public void setSelfBurdenRate(double selfBurdenRate) {this.selfBurdenRate = selfBurdenRate;}

	// Methods
	public int calculateFee(Insurant insurant){
		double fee = this.getBasicFee();
		
		// 占쎄돌占쎌뵠占쎈퓠 占쎈뎡�몴占� 占쎌뒄占쎌몛 �④쑴沅�
		if (insurant.getAge() >= 10 && insurant.getAge() < 20) {
			fee *= this.getRateOfAge()[0];
		} else if (insurant.getAge() >= 20 && insurant.getAge() < 30) {
			fee = this.getBasicFee()*this.getRateOfAge()[1];
		} else if (insurant.getAge() >= 30 && insurant.getAge() < 40) {
			fee = this.getBasicFee()*this.getRateOfAge()[2];
		} else if (insurant.getAge() >= 40 && insurant.getAge() < 50) {
			fee = this.getBasicFee()*this.getRateOfAge()[3];
		} else if (insurant.getAge() >= 50 && insurant.getAge() < 60) {
			fee = this.getBasicFee()*this.getRateOfAge()[4];
		} else if (insurant.getAge() >= 60 && insurant.getAge() < 70) {
			fee = this.getBasicFee()*this.getRateOfAge()[5];
		} else {
			fee = this.getBasicFee()*this.getRateOfAge()[6];
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
		
		return (int)fee;
	}
	
	public Insurance newInstance() {
		return new ActualCostInsurance();
	}
}