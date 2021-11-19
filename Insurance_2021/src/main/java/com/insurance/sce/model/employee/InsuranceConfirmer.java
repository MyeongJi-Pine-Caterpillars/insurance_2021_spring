package com.insurance.sce.model.employee;

import com.insurance.sce.dao.InsuranceDAO;
import com.insurance.sce.model.insurance.Insurance;

public class InsuranceConfirmer extends Employee {
	private InsuranceDAO insuranceDAO;

	public InsuranceConfirmer(InsuranceDAO insuranceDAO){
		this.insuranceDAO = insuranceDAO;
	}

	public void confirmInsurance(Insurance insurance){
		this.insuranceDAO.updateConfirmedStatus(insurance.getInsuranceId(), true);
	}

}