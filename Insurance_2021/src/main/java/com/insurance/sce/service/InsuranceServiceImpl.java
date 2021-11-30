package com.insurance.sce.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.sce.dao.GuaranteePlanDAO;
import com.insurance.sce.dao.InsuranceDAO;
import com.insurance.sce.model.insurance.ActualCostInsurance;
import com.insurance.sce.model.insurance.CancerInsurance;
import com.insurance.sce.model.insurance.DentalInsurance;
import com.insurance.sce.model.insurance.DriverInsurance;
import com.insurance.sce.model.insurance.FireInsurance;
import com.insurance.sce.model.insurance.GuaranteePlan;
import com.insurance.sce.model.insurance.Insurance;
import com.insurance.sce.model.insurance.TripInsurance;

@Service
public class InsuranceServiceImpl implements InsuranceService{

	@Autowired
	InsuranceDAO insuranceDAO;
	@Autowired
	GuaranteePlanDAO guaranteePlanDAO;
	
	public List<Insurance> selectAllInsurance(){
		ArrayList<Insurance> insuranceList = new ArrayList<Insurance>();
		insuranceList.addAll(this.selectAllCancerInsurance());
		insuranceList.addAll(this.selectAllDentalInsurance());
		insuranceList.addAll(this.selectAllDriverInsurance());
		insuranceList.addAll(this.selectAllActualCostInsurance());
		insuranceList.addAll(this.selectAllTripInsurance());
		insuranceList.addAll(this.selectAllFireInsurance());
		return insuranceList;
	}
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
