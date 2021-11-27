package com.insurance.sce.model.insurance;

import com.insurance.sce.global.Constants.eGender;
import com.insurance.sce.model.customer.Insurant;

public class TripInsurance extends Insurance {
	// Attributes
	private double[] rateOfCountryRisk = {1.0, 1.3, 1.5, 2.5}; // index[0: �븞�쟾 / 1: 1�떒怨� / 1: 2�떒怨� / 2: 3�떒怨�] 

	// Constructor
	public TripInsurance(){

	}
	
	// getters & setters
	public double[] getRateOfCountryRank() {return rateOfCountryRisk;}
	public void setRateOfCountryRank(double[] rateOfCountryRank) {this.rateOfCountryRisk = rateOfCountryRank;}

	// Methods
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
		} else if (insurant.getEGender() == eGender.female) {
			fee *= this.getRateOfGender()[1];
		}

		// 援�媛� �쐞�뿕�룄�뿉 �뵲瑜� �슂�쑉 怨꾩궛
		switch(insurant.getERiskOfTripCountry()) {
		case safe:
			fee *= this.getRateOfCountryRank()[0];
			break;
		case first:
			fee *= this.getRateOfCountryRank()[1];
			break;
		case second:
			fee *= this.getRateOfCountryRank()[2];
			break;
		case third:
			fee *= this.getRateOfCountryRank()[3];
			break;
		default:
			break;
		}
		
		return (int) fee;
	}

	public Insurance newInstance() {
		return new TripInsurance();
	}

}