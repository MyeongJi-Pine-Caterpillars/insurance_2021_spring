package com.insurance.sce.service.insurance;

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
	public CancerInsurance selectCancerInsurance(List<CancerInsurance> insruanceList, String insuranceId);
	public DentalInsurance selectDentalInsurance(List<DentalInsurance> insruanceList, String insuranceId);
	public DriverInsurance selectDriverInsurance(List<DriverInsurance> insruanceList, String insuranceId);
	public ActualCostInsurance selectActualCostInsurance(List<ActualCostInsurance> insruanceList, String insuranceId);
	public TripInsurance selectTripInsurance(List<TripInsurance> insruanceList, String insuranceId);
	public FireInsurance selectFireInsurance(List<FireInsurance> insruanceList, String insuranceId);
	public List<GuaranteePlan> selectGuaranteePlan(String insuranceId);
	public Insurance selectInsurance(String insuranceId);
}
