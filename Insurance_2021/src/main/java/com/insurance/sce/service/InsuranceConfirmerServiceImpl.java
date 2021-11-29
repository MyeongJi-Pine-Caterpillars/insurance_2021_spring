package com.insurance.sce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.insurance.sce.dao.InsuranceDAO;
import com.insurance.sce.model.insurance.Insurance;

@Repository
public class InsuranceConfirmerServiceImpl implements InsuranceConfirmerService{
	@Autowired
	InsuranceDAO insuranceDAO;

	public Insurance selectInsurance(String insuranceId) {
		int type = insuranceDAO.selectInsuranceType(insuranceId);
		Insurance insurance = null;
		switch(type) {
		case 1:
			insurance = insuranceDAO.selectDriverInsurance(insuranceId);
			break;
		case 2:
			insurance = insuranceDAO.selectDentalInsurance(insuranceId);
			break;
		case 3:
			insurance = insuranceDAO.selectActualCostInsurance(insuranceId);
			break;
		case 4:
			insurance = insuranceDAO.selectFireInsurance(insuranceId);
			break;
		case 5:
			insurance = insuranceDAO.selectCancerInsurance(insuranceId);
			break;
		case 6:
			insurance = insuranceDAO.selectTripInsurance(insuranceId);
			break;
		}
		return insurance;
	}
	public int confirmInsurance(String insuranceId) {
		return insuranceDAO.updateConfirmedStatus(insuranceId);
	}
	
}