package com.insurance.sce.service;

import java.util.ArrayList;
import java.util.HashMap;

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
public class InsuranceDeveloperServiceImpl implements InsuranceDeveloperService{
	@Autowired
	InsuranceDAO insuranceDAO;
	@Autowired
	GuaranteePlanDAO guaranteePlanDAO;
	
	public Insurance designInsurance(String insuranceType) {
		Insurance insurance = null;
		switch(insuranceType) {
		case "Driver":
			insurance = new DriverInsurance();
			insurance.setType(eInsuranceType.driverInsurance.getNum());
			break;
		case "Dental":
			insurance = new DentalInsurance();
			insurance.setType(eInsuranceType.dentalInsurance.getNum());
			break;
		case "ActualCost":
			insurance = new ActualCostInsurance();
			insurance.setType(eInsuranceType.actualCostInsurance.getNum());
			break;
		case "Fire":
			insurance = new FireInsurance();
			insurance.setType(eInsuranceType.fireInsurance.getNum());
			break;
		case "Cancer":
			insurance = new CancerInsurance();
			insurance.setType(eInsuranceType.cancerInsurance.getNum());
			break;
		case "Trip":
			insurance = new TripInsurance();
			insurance.setType(eInsuranceType.tripInsurance.getNum());
			break;
		}
		ArrayList<String> ids = (ArrayList<String>) insuranceDAO.selectInsuranceId();
		int maxId = 0;
		for(String id: ids) maxId = Math.max(maxId, Integer.parseInt(id));
		insurance.setInsuranceId(Integer.toString(maxId+1));
		return insurance;
	}
	public Insurance setGender(Insurance insurance, String[] insuranceGender) {
		if(insuranceGender.length == 2) {
			insurance.setGender(eGender.both.getNum());
		} else {
			if(insuranceGender[0].equals("man")) insurance.setGender(eGender.male.getNum());
			else insurance.setGender(eGender.female.getNum());
		}
		return insurance;
	}
	public Insurance detailInsurance(Insurance insurance, HashMap<String, Object> map) {
		insurance.setName((String)map.get("name"));
		insurance.setBasicFee((int)map.get("basicFee"));
		if((int)map.get("specialFee") != 0) {
			insurance.setSpecialContract(true);
			insurance.setSpecialContractFee((int)map.get("specialFee"));
		}
		insurance.setWarrantyPeriod((int)map.get("warrantyPeriod"));
		insurance.setRateOfAge((double[])map.get("ageRate"));
		insurance.setRateOfGender((double[])map.get("genderRate"));
		insurance.setRateOfJob((double[])map.get("jobRate"));
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
	public void finishInsurance(Insurance insurance, String[] selected, String[] special, int[] compensation) {
		this.insertInsurance(insurance);
		for(int i = 0; i < selected.length; i++) {
			String content = selected[i];
			boolean isSpecial = false;
			for(int j = 0; j < special.length; j++) {
				if(content.equals(special[j])) isSpecial = true;
			}
			GuaranteePlan guaranteePlan = new GuaranteePlan();
			guaranteePlan.setInsuranceId(insurance.getInsuranceId());
			guaranteePlan.setCompensation(compensation[i]);
			if(isSpecial) guaranteePlan.setSpecial(true);
			else guaranteePlan.setSpecial(false);
			guaranteePlan.setContent(content);
			guaranteePlan.setRate(0);
			guaranteePlanDAO.insert(guaranteePlan);
		}
	}
	public void finishInsurance(Insurance insurance, String[] selected, String[] special, int[] compensation, double[] selfBurden) {
		this.insertInsurance(insurance);;
		for(int i = 0; i < selected.length; i++) {
			String content = selected[i];
			boolean isSpecial = false;
			for(int j = 0; j < special.length; j++) {
				if(content.equals(special[j])) isSpecial = true;
			}
			GuaranteePlan guaranteePlan = new GuaranteePlan();
			guaranteePlan.setInsuranceId(insurance.getInsuranceId());
			guaranteePlan.setCompensation(compensation[i]);
			if(isSpecial) guaranteePlan.setSpecial(true);
			else guaranteePlan.setSpecial(false);
			guaranteePlan.setContent(content);
			guaranteePlan.setRate(selfBurden[i]);
			guaranteePlanDAO.insert(guaranteePlan);
		}
	}
	public void insertInsurance(Insurance insurance) {
		insuranceDAO.insert(insurance);
	}
	public int deleteInsurance(String insuranceId) {
		return insuranceDAO.updateDel(insuranceId);
	}
	public int restoreInsurance(String insuranceId) {
		return insuranceDAO.updateRestore(insuranceId);
	}
}