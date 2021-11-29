package com.insurance.sce.service;

import com.insurance.sce.model.insurance.Insurance;

public interface InsuranceDeveloperService {
	public Insurance designInsurance(String insuranceType);
	public Insurance setGender(Insurance insurance, String[] insuranceGender);
	public Insurance detailInsurance(Insurance insurance, String name, int basicFee, int specialFee, int warrantyPeriod, double[] age, double[] gender, double[] job);
	public Insurance setCancerRate(Insurance insurance, double[] familyMedical, double[] familyRelationship);
	public Insurance setDriverRate(Insurance insurance, double[] typeOfCar, double[] rankOfCar, double[] accidentHistoryRate);
	public Insurance setDentalRate(Insurance insurance, int annualCount);
	public Insurance setFireRate(Insurance insurance, double[] postedPrice, double[] usageOfStructure);
	public Insurance setTripRate(Insurance insurance, double[] riskOfTripCountry);
	public Insurance setActualCostRate(Insurance insurance, double selfBurden);
	public void finishInsurance(Insurance insurance, String[] selected, String[] special, int[] compensation);
	public void finishInsurance(Insurance insurance, String[] selected, String[] special, int[] compensation, double[] selfBurden);
	public void insertInsurance(Insurance insurance);
}