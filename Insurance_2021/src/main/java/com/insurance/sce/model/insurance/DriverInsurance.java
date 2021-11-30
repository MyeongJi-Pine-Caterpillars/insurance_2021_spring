package com.insurance.sce.model.insurance;

import com.insurance.sce.global.Constants.eGender;
import com.insurance.sce.model.customer.Insurant;

public class DriverInsurance extends Insurance {

	// Attributes
	private double[] rateOfAccidentHistory = {1.0, 1.2, 1.3, 1.4, 1.5, 1.6};
	private double[] rateOfCarType = {2, 1.7, 1.6, 1.5, 1.0};
	private double[] rateOfCarRank = {2, 1.8, 1.2, 1.0};

	// Constructor
	public DriverInsurance(){

	}
	
	// Getters & Setters
	public double[] getRateOfAccidentHistory() {return rateOfAccidentHistory;}
	public void setRateOfAccidentHistory(double[] rateOfAccidentHistory) {this.rateOfAccidentHistory = rateOfAccidentHistory;}
	
	
	public double[] getRateOfCarType() {return rateOfCarType;}
	public void setRateOfCarType(double[] rateOfCarType) {this.rateOfCarType = rateOfCarType;}

	public double[] getRateOfCarRank() {return rateOfCarRank;}	
	public void setRateOfCarRank(double[] rateOfCarRank) {this.rateOfCarRank = rateOfCarRank;}
	

	public double getRateOfAccidentHistory0() {return rateOfAccidentHistory[0];}
	public double getRateOfAccidentHistory1() {return rateOfAccidentHistory[1];}
	public double getRateOfAccidentHistory2() {return rateOfAccidentHistory[2];}
	public double getRateOfAccidentHistory3() {return rateOfAccidentHistory[3];}
	public double getRateOfAccidentHistory4() {return rateOfAccidentHistory[4];}
	public double getRateOfAccidentHistory5() {return rateOfAccidentHistory[5];}
	public double getRateOfCarType0() {return rateOfCarType[0];}
	public double getRateOfCarType1() {return rateOfCarType[1];}
	public double getRateOfCarType2() {return rateOfCarType[2];}
	public double getRateOfCarType3() {return rateOfCarType[3];}
	public double getRateOfCarType4() {return rateOfCarType[4];}
	public double getRateOfCarRank0() {return rateOfCarRank[0];}
	public double getRateOfCarRank1() {return rateOfCarRank[1];}
	public double getRateOfCarRank2() {return rateOfCarRank[2];}
	public double getRateOfCarRank3() {return rateOfCarRank[3];}

	public void setRateOfAccidentHistory0(double x) {this.rateOfAccidentHistory[0] = x;}
	public void setRateOfAccidentHistory1(double x) {this.rateOfAccidentHistory[1] = x;}
	public void setRateOfAccidentHistory2(double x) {this.rateOfAccidentHistory[2] = x;}
	public void setRateOfAccidentHistory3(double x) {this.rateOfAccidentHistory[3] = x;}
	public void setRateOfAccidentHistory4(double x) {this.rateOfAccidentHistory[4] = x;}
	public void setRateOfAccidentHistory5(double x) {this.rateOfAccidentHistory[5] = x;}
	public void setRateOfCarType0(double x) {this.rateOfCarType[0] = x;}
	public void setRateOfCarType1(double x) {this.rateOfCarType[1] = x;}
	public void setRateOfCarType2(double x) {this.rateOfCarType[2] = x;}
	public void setRateOfCarType3(double x) {this.rateOfCarType[3] = x;}
	public void setRateOfCarType4(double x) {this.rateOfCarType[4] = x;}
	public void setRateOfCarRank0(double x) {this.rateOfCarRank[0] = x;}
	public void setRateOfCarRank1(double x) {this.rateOfCarRank[1] = x;}
	public void setRateOfCarRank2(double x) {this.rateOfCarRank[2] = x;}
	public void setRateOfCarRank3(double x) {this.rateOfCarRank[3] = x;}
	
	// Methods
	public int calculateFee(Insurant insurant){
		double fee = this.getBasicFee();
		
		// �뜝�럡�룎�뜝�럩逾졾뜝�럥�뱺 �뜝�럥�렊占쎈ご�뜝占� �뜝�럩�뭵�뜝�럩紐� 占썩몿�뫒亦낉옙
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
				
		// �뜝�럡�뎽�솻洹��뫒�굢占� �뜝�럥�렊占쎈ご�뜝占� �뜝�럩�뭵�뜝�럩紐� 占썩몿�뫒亦낉옙
		if (insurant.getEGender() == eGender.male) {
			fee *= this.getRateOfGender()[0];
		} else if (insurant.getEGender() == eGender.female){
			fee *= this.getRateOfGender()[1];
		}
		
		//�뜝�럩�겱�뜝�럥吏쀧춯�댙�삕 �뜝�럥苡사뼨��留⑵굢占� �뜝�럥�렊占쎈ご�뜝占� �뜝�럩�뭵�뜝�럩紐� 占썩몿�뫒亦낉옙
		switch(insurant.getETypeOfCar()) {
		case bus :
			fee *= this.rateOfCarType[0];
			break;
		case van :
			fee *= this.rateOfCarType[1];
			break;
		case suv :
			fee *= this.rateOfCarType[2];
			break;
		case foreign :
			fee *= this.rateOfCarType[3];
			break;
		case etc :
			fee *= this.rateOfCarType[4];
			break;
		}
		
		int count = insurant.getAccidentHistory();
		if(count == 0) {
			fee *= this.rateOfAccidentHistory[0];
		} else if(count < 2) {
			fee *= this.rateOfAccidentHistory[1];
		} else if(count < 4) {
			fee *= this.rateOfAccidentHistory[2];
		} else if(count < 6) {
			fee *= this.rateOfAccidentHistory[3];
		} else if(count < 8) {
			fee *= this.rateOfAccidentHistory[4];
		} else {
			fee *= this.rateOfAccidentHistory[5];
		}

		switch (insurant.getERankOfCar()) {
		case luxury:
			fee *= this.rateOfCarRank[0];
			break;
		case high:
			fee *= this.rateOfCarRank[1];
			break;
		case middle:
			fee *= this.rateOfCarRank[2];
			break;
		case low:
			fee *= this.rateOfCarRank[3];
			break;
		}
		
		return (int)fee;
	}

	public Insurance newInstance() {
		return new DriverInsurance();
	}

}