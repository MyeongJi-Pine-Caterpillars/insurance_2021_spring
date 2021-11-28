package com.insurance.sce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.insurance.sce.dao.InsuranceDAO;
import com.insurance.sce.model.insurance.Insurance;

@Repository
public class InsuranceConfirmerService {
	@Autowired
	InsuranceDAO insuranceDAO;

	public Insurance selectInsurance(String insuranceId) {
		Insurance insurance = insuranceDAO.select(insuranceId);
		switch(insurance.getEType()) {
		case driverInsurance:
			insurance = insuranceDAO.selectDriverInsurance(insuranceId);
			break;
		case dentalInsurance:
			insurance = insuranceDAO.selectDentalInsurance(insuranceId);
			break;
		case actualCostInsurance:
			insurance = insuranceDAO.selectActualCostInsurance(insuranceId);
			break;
		case fireInsurance:
			insurance = insuranceDAO.selectFireInsurance(insuranceId);
			break;
		case cancerInsurance:
			insurance = insuranceDAO.selectCancerInsurance(insuranceId);
			break;
		case tripInsurance:
			insurance = insuranceDAO.selectTripInsurance(insuranceId);
			break;
		}
		return insurance;
	}
	
	
}