package com.insurance.sce.model.employee;

import com.insurance.sce.dao.insurance.InsuranceDAO;
import com.insurance.sce.model.insurance.Insurance;

public class InsuranceConfirmer extends Employee {

	public InsuranceConfirmer(InsuranceDAO insuranceDAO){
	}

	public void confirmInsurance(Insurance insurance){
//		this.insuranceDAO.updateConfirmedStatus(insurance.getInsuranceId(), true);
	}

}