package com.insurance.sce.model.insurance;

import com.insurance.sce.global.Constants.eGender;
import com.insurance.sce.model.customer.Insurant;

public class TripInsurance extends Insurance {
	// Attributes
	private double[] rateOfCountryRisk = {1.0, 1.3, 1.5, 2.5}; // index[0: 占쎈툧占쎌읈 / 1: 1占쎈뼊�⑨옙 / 1: 2占쎈뼊�⑨옙 / 2: 3占쎈뼊�⑨옙] 

	// Constructor
	public TripInsurance(){

	}
	
	// getters & setters
	public double[] getRateOfCountryRank() {return rateOfCountryRisk;}
	public void setRateOfCountryRank(double[] rateOfCountryRank) {this.rateOfCountryRisk = rateOfCountryRank;}
	

	public double getRateOfCountryRisk0() {return rateOfCountryRisk[0];}
	public double getRateOfCountryRisk1() {return rateOfCountryRisk[1];}
	public double getRateOfCountryRisk2() {return rateOfCountryRisk[2];}
	public double getRateOfCountryRisk3() {return rateOfCountryRisk[3];}

	public void setRateOfCountryRisk0(double x) {this.rateOfCountryRisk[0] = x;}
	public void setRateOfCountryRisk1(double x) {this.rateOfCountryRisk[1] = x;}
	public void setRateOfCountryRisk2(double x) {this.rateOfCountryRisk[2] = x;}
	public void setRateOfCountryRisk3(double x) {this.rateOfCountryRisk[3] = x;}

	// Methods
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
		if (insurant.getEGender() == eGender.male) {
			fee *= this.getRateOfGender()[0];
		} else if (insurant.getEGender() == eGender.female) {
			fee *= this.getRateOfGender()[1];
		}

		// �뤃占썲첎占� 占쎌맄占쎈퓮占쎈즲占쎈퓠 占쎈뎡�몴占� 占쎌뒄占쎌몛 �④쑴沅�
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