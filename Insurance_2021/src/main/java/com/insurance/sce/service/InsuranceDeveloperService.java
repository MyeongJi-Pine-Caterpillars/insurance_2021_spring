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
	public Insurance detailInsurance(Insurance insurance, String name, int basicFee, int specialFee, int warrantyPeriod, double[] age, double[] gender, double[] job) {
		insurance.setName(name);
		insurance.setBasicFee(basicFee);
		insurance.setSpecialContractFee(specialFee);
		insurance.setWarrantyPeriod(warrantyPeriod);
		insurance.setRateOfAge(age);
		insurance.setRateOfGender(gender);
		insurance.setRateOfJob(job);
		return insurance;
	}
	public Insurance setCancerRate(Insurance insurance, double[] familyMedical, double[] familyRelationship) {
		((CancerInsurance)insurance).setRateOfFamilyMedicalDisease(familyMedical);
		((CancerInsurance)insurance).setRateOfFamilyMedicalRelationship(familyRelationship);
		return insurance;
	}
	public Insurance setDriverRate(Insurance insurance, double[] typeOfCar, double[] rankOfCar, double[] accidentHistoryRate) {
		((DriverInsurance)insurance).setRateOfCarType(typeOfCar);
		((DriverInsurance)insurance).setRateOfCarRank(rankOfCar);
		((DriverInsurance)insurance).setRateOfAccidentHistory(accidentHistoryRate);
		return insurance;
	}
	public Insurance setDentalRate(Insurance insurance, int annualCount) {
		((DentalInsurance)insurance).setAnnualLimitCount(annualCount);
		return insurance;
	}
	public Insurance setFireRate(Insurance insurance, double[] postedPrice, double[] usageOfStructure) {
		((FireInsurance)insurance).setRateOfPostedPrice(postedPrice);
		((FireInsurance)insurance).setRateOfStructureUsage(usageOfStructure);
		return insurance;
	}
}