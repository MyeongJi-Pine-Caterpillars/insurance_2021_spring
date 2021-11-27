package com.insurance.sce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.insurance.sce.dao.GuaranteePlanDAO;
import com.insurance.sce.dao.InsuranceDAO;
import com.insurance.sce.global.Constants.eGender;
import com.insurance.sce.global.Constants.eInsuranceType;
import com.insurance.sce.model.insurance.ActualCostInsurance;
import com.insurance.sce.model.insurance.CancerInsurance;
import com.insurance.sce.model.insurance.DentalInsurance;
import com.insurance.sce.model.insurance.DriverInsurance;
import com.insurance.sce.model.insurance.FireInsurance;
import com.insurance.sce.model.insurance.GuaranteePlan;
import com.insurance.sce.model.insurance.Insurance;
import com.insurance.sce.model.insurance.TripInsurance;

@Repository
public class InsuranceDeveloperService {
	@Autowired
	private InsuranceDAO insuranceDAO;
	@Autowired
	private GuaranteePlanDAO guaranteePlanDAO;
	
	public Insurance designInsurance(String insuranceType) {
		Insurance insurance = null;
		switch(insuranceType) {
		case "Driver":
			insurance = new DriverInsurance();
			insurance.setEType(eInsuranceType.driverInsurance);
			break;
		case "Dental":
			insurance = new DentalInsurance();
			insurance.setEType(eInsuranceType.dentalInsurance);
			break;
		case "ActualCost":
			insurance = new ActualCostInsurance();
			insurance.setEType(eInsuranceType.actualCostInsurance);
			break;
		case "Fire":
			insurance = new FireInsurance();
			insurance.setEType(eInsuranceType.fireInsurance);
			break;
		case "Cancer":
			insurance = new CancerInsurance();
			insurance.setEType(eInsuranceType.cancerInsurance);
			break;
		case "Trip":
			insurance = new TripInsurance();
			insurance.setEType(eInsuranceType.tripInsurance);
			break;
		}
		return insurance;
	}
	public Insurance setGender(Insurance insurance, String[] insuranceGender) {
		if(insuranceGender.length == 2) {
			insurance.setEGender(eGender.both);
		} else {
			if(insuranceGender[0].equals("man")) insurance.setEGender(eGender.male);
			else insurance.setEGender(eGender.female);
		}
		return insurance;
	}
	public Insurance detailInsurance(Insurance insurance, String name, int basicFee, int specialFee, int warrantyPeriod, double[] age, double[] gender, double[] job) {
		insurance.setName(name);
		insurance.setBasicFee(basicFee);
		if(specialFee != 0) {
			insurance.setSpecialContract(true);
			insurance.setSpecialContractFee(specialFee);
		}
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
	public Insurance setTripRate(Insurance insurance, double[] riskOfTripCountry) {
		((TripInsurance)insurance).setRateOfCountryRank(riskOfTripCountry);
		return insurance;
	}
	public Insurance setActualCostRate(Insurance insurance, double selfBurden) {
		((ActualCostInsurance)insurance).setSelfBurdenRate(selfBurden);
		return insurance;
	}
	public Insurance setCancerGuarantee(Insurance insurance, String[] selected, String[] special, int[] compensation) {
		for(int i = 0; i < selected.length; i++) {
			String content = selected[i];
			boolean isSpecial = false;
			for(int j = 0; j < special.length; j++) {
				if(content.equals(special[j])) isSpecial = true;
			}
			if(isSpecial) insurance.addGuaranteePlan(content, compensation[i], true, 1);
			else insurance.addGuaranteePlan(content, compensation[i], false, 1);
		}
		return insurance;
	}
	public void finishInsurance(Insurance insurance) {
		insuranceDAO.insert(insurance);
		for(GuaranteePlan guaranteePlan: insurance.getGuaranteePlanList()) {
			guaranteePlanDAO.insert(guaranteePlan);
		}
	}
}