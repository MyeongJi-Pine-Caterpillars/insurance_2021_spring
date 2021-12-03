package com.insurance.sce.service;

import java.util.List;

import com.insurance.sce.model.insurance.*;

public interface InsuranceService {
	public List<Insurance> selectAllInsurance();
	public List<CancerInsurance> selectAllCancerInsurance();
	public List<DentalInsurance> selectAllDentalInsurance();
	public List<DriverInsurance> selectAllDriverInsurance();
	public List<ActualCostInsurance> selectAllActualCostInsurance();
	public List<TripInsurance> selectAllTripInsurance();
	public List<FireInsurance> selectAllFireInsurance();
	public CancerInsurance selectCancerInsurance(String insuranceId);
	public DentalInsurance selectDentalInsurance(String insuranceId);
	public DriverInsurance selectDriverInsurance(String insuranceId);
	public ActualCostInsurance selectActualCostInsurance(String insuranceId);
	public TripInsurance selectTripInsurance(String insuranceId);
	public FireInsurance selectFireInsurance(String insuranceId);
	public List<GuaranteePlan> selectGuaranteePlan(String insuranceId);
	public Insurance selectInsurance(String insuranceId);
}
