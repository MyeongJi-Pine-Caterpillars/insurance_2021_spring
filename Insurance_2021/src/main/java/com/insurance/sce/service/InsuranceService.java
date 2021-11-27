package com.insurance.sce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.insurance.sce.dao.GuaranteePlanDAO;
import com.insurance.sce.dao.InsuranceDAO;
import com.insurance.sce.model.insurance.*;

@Repository
public class InsuranceService {

	@Autowired
	InsuranceDAO insuranceDAO;
	@Autowired
	GuaranteePlanDAO guaranteePlanDAO;
	
	public List<CancerInsurance> selectAllCancerInsurance() {
		return insuranceDAO.selectAllCancerInsurance();
	}

	public List<DentalInsurance> selectAllDentalInsurance() {
		return insuranceDAO.selectAllDentalInsurance();
	}

	public List<DriverInsurance> selectAllDriverInsurance() {
		return insuranceDAO.selectAllDriverInsurance();
	}
	
	public List<ActualCostInsurance> selectAllActualCostInsurance() {
		return insuranceDAO.selectAllActualCostInsurance();
	}
	
	public List<TripInsurance> selectAllTripInsurance() {
		return insuranceDAO.selectAllTripInsurance();
	}
	
	public List<FireInsurance> selectAllFireInsurance() {
		return insuranceDAO.selectAllFireInsurance();
	}
	
	public CancerInsurance selectCancerInsurance(String insuranceId) {
		return (CancerInsurance) insuranceDAO.selectCancerInsurance(insuranceId);
	}

	public DentalInsurance selectDentalInsurance(String insuranceId) {
		return (DentalInsurance) insuranceDAO.selectDentalInsurance(insuranceId);
	}

	public DriverInsurance selectDriverInsurance(String insuranceId) {
		return (DriverInsurance) insuranceDAO.selectDriverInsurance(insuranceId);
	}
	
	public ActualCostInsurance selectActualCostInsurance(String insuranceId) {
		return (ActualCostInsurance) insuranceDAO.selectActualCostInsurance(insuranceId);
	}
	
	public TripInsurance selectTripInsurance(String insuranceId) {
		return (TripInsurance) insuranceDAO.selectTripInsurance(insuranceId);
	}
	
	public FireInsurance selectFireInsurance(String insuranceId) {
		return (FireInsurance) insuranceDAO.selectFireInsurance(insuranceId);
	}
	
	public List<GuaranteePlan> selectGuaranteePlan(String insuranceId) {
		return guaranteePlanDAO.selectByInsuranceId(insuranceId);
	}

}
