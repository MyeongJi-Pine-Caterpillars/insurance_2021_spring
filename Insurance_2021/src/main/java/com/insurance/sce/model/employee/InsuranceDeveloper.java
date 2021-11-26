package com.insurance.sce.model.employee;

import com.insurance.sce.dao.InsuranceDAO;
import com.insurance.sce.global.Constants.eInsuranceType;
import com.insurance.sce.model.insurance.*;

public class InsuranceDeveloper extends Employee {
	private InsuranceDAO insuranceDAO;
	
	public InsuranceDeveloper(InsuranceDAO insuranceDAO){
		this.insuranceDAO = insuranceDAO;
	}

	
	public boolean postManageInsurance(Insurance insurance, boolean del){
		return insuranceDAO.updateDel(insurance.getInsuranceId(), del);
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
		return this.insuranceDAO.insert(insurance);
	}
}