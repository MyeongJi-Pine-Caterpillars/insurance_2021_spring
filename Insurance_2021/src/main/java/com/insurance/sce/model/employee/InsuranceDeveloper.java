package com.insurance.sce.model.employee;

import com.insurance.sce.dao.InsuranceDAO;
import com.insurance.sce.global.Constants.eInsuranceType;
import com.insurance.sce.model.insurance.*;

public class InsuranceDeveloper extends Employee {
	
	public InsuranceDeveloper(InsuranceDAO insuranceDAO){
	}

	public Insurance designInsurance(Insurance insurance, int type){
		switch (type) {
		case 1:
			insurance = new DriverInsurance();
			insurance.setType(eInsuranceType.driverInsurance);
			break;
		case 2:
			insurance = new DentalInsurance();
			insurance.setType(eInsuranceType.dentalInsurance);
			break;
		case 3:
			insurance = new ActualCostInsurance();
			insurance.setType(eInsuranceType.actualCostInsurance);
			break;
		case 4:
			insurance = new FireInsurance();
			insurance.setType(eInsuranceType.fireInsurance);
			break;
		case 5:
			insurance = new CancerInsurance();
			insurance.setType(eInsuranceType.cancerInsurance);
			break;
		case 6:
			insurance = new TripInsurance();
			insurance.setType(eInsuranceType.tripInsurance);
			break;
		}
		return insurance;
		
	}

	public boolean postManageInsurance(Insurance insurance, boolean del){
//		return insuranceDAO.updateDel(insurance.getInsuranceId(), del);
		return false;
	}

	public void readSurveyResult(){

	}

	public Insurance setDetailOfInsurance(Insurance insurance, String type, double[] rate){
		switch(type) {
		case "age":
			insurance.setRateOfAge(rate);
			break;
		case "gender":
			insurance.setRateOfGender(rate);
			break;
		case "job":
			insurance.setRateOfJob(rate);
			break;
		}
		return insurance;
	}
	
	public boolean finishInsurance(Insurance insurance) {
//		return this.insuranceDAO.insert(insurance);
		return false;
	}
}