package com.insurance.sce.service;

import org.springframework.stereotype.Repository;

import com.insurance.sce.global.Constants.eGender;
import com.insurance.sce.global.Constants.eInsuranceType;
import com.insurance.sce.model.insurance.ActualCostInsurance;
import com.insurance.sce.model.insurance.CancerInsurance;
import com.insurance.sce.model.insurance.DentalInsurance;
import com.insurance.sce.model.insurance.DriverInsurance;
import com.insurance.sce.model.insurance.FireInsurance;
import com.insurance.sce.model.insurance.Insurance;
import com.insurance.sce.model.insurance.TripInsurance;

@Repository
public class InsuranceDeveloperService {
	
	public Insurance designInsurance(String insuranceType) {
		Insurance insurance = null;
		switch(insuranceType) {
		case "Driver":
			insurance = new DriverInsurance();
			insurance.setType(eInsuranceType.driverInsurance);
			break;
		case "Dental":
			insurance = new DentalInsurance();
			insurance.setType(eInsuranceType.dentalInsurance);
			break;
		case "ActualCost":
			insurance = new ActualCostInsurance();
			insurance.setType(eInsuranceType.actualCostInsurance);
			break;
		case "Fire":
			insurance = new FireInsurance();
			insurance.setType(eInsuranceType.fireInsurance);
			break;
		case "Cancer":
			insurance = new CancerInsurance();
			insurance.setType(eInsuranceType.cancerInsurance);
			break;
		case "Trip":
			insurance = new TripInsurance();
			insurance.setType(eInsuranceType.tripInsurance);
			break;
		}
		return insurance;
	}
	public Insurance setGender(Insurance insurance, String[] insuranceGender) {
		if(insuranceGender.length == 2) {
			insurance.setGender(eGender.both);
		} else {
			if(insuranceGender[0].equals("man")) insurance.setGender(eGender.male);
			else insurance.setGender(eGender.female);
		}
		return insurance;
	}

}