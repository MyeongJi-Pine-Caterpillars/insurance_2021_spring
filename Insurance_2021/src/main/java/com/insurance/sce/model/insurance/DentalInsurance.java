package com.insurance.sce.model.insurance;

import com.insurance.sce.global.Constants.eGender;
import com.insurance.sce.model.customer.Insurant;

public class DentalInsurance extends Insurance {

	// Attributes
	private int annualLimitCount;

	// Constructor
	public DentalInsurance(){

	}

	// getters & setters
	public int getAnnualLimitCount() {return annualLimitCount;}
	public void setAnnualLimitCount(int annualLimitCount) {	this.annualLimitCount = annualLimitCount;}
	

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
		if (insurant.getGender() == eGender.male) {
			fee *= this.getRateOfGender()[0];
		} else if (insurant.getGender() == eGender.female) {
			fee *= this.getRateOfGender()[1];
		}
		return (int) fee;
	}

	public Insurance newInstance() {
		return new DentalInsurance();
	}

}