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
		return insuranceDAO.selectAll();
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
	
	public CancerInsurance selectCancerInsurance(List<CancerInsurance> insuranceList, String insuranceId) {
		if (insuranceList != null) {
			for (CancerInsurance insurance : insuranceList) {
				if (insurance.getInsuranceId().equals(insuranceId))
					return insurance;
			}
		}
		return (CancerInsurance) insuranceDAO.selectCancerInsurance(insuranceId);
	}

	public DentalInsurance selectDentalInsurance(List<DentalInsurance> insuranceList, String insuranceId) {
		if (insuranceList != null) {
			for (DentalInsurance insurance : insuranceList) {
				if (insurance.getInsuranceId().equals(insuranceId))
					return insurance;
			}
		}
		return (DentalInsurance) insuranceDAO.selectDentalInsurance(insuranceId);
	}

	public DriverInsurance selectDriverInsurance(List<DriverInsurance> insuranceList, String insuranceId) {
		if (insuranceList != null) {
			for (DriverInsurance insurance : insuranceList) {
				if (insurance.getInsuranceId().equals(insuranceId))
					return insurance;
			}
		}
		return (DriverInsurance) insuranceDAO.selectDriverInsurance(insuranceId);
	}

	public ActualCostInsurance selectActualCostInsurance(List<ActualCostInsurance> insuranceList, String insuranceId) {
		if (insuranceList != null) {
			for (ActualCostInsurance insurance : insuranceList) {
				if (insurance.getInsuranceId().equals(insuranceId))
					return insurance;
			}
		}
		return (ActualCostInsurance) insuranceDAO.selectActualCostInsurance(insuranceId);
	}

	public TripInsurance selectTripInsurance(List<TripInsurance> insuranceList, String insuranceId) {
		if (insuranceList != null) {
			for (TripInsurance insurance : insuranceList) {
				if (insurance.getInsuranceId().equals(insuranceId))
					return insurance;
			}
		}
		return (TripInsurance) insuranceDAO.selectTripInsurance(insuranceId);
	}

	public FireInsurance selectFireInsurance(List<FireInsurance> insuranceList, String insuranceId) {
		if (insuranceList != null) {
			for (FireInsurance insurance : insuranceList) {
				if (insurance.getInsuranceId().equals(insuranceId))
					return insurance;
			}
		}
		return (FireInsurance) insuranceDAO.selectFireInsurance(insuranceId);
	}
	
	public List<GuaranteePlan> selectGuaranteePlan(String insuranceId) {
		return guaranteePlanDAO.selectByInsuranceId(insuranceId);
	}
	public Insurance selectInsurance(String insuranceId) {
		int type = insuranceDAO.selectInsuranceType(insuranceId);
		Insurance insurance = null;
		switch(type) {
		case 1:
			insurance = insuranceDAO.selectDriverInsurance(insuranceId);
			break;
		case 2:
			insurance = insuranceDAO.selectDentalInsurance(insuranceId);
			break;
		case 3:
			insurance = insuranceDAO.selectActualCostInsurance(insuranceId);
			break;
		case 4:
			insurance = insuranceDAO.selectFireInsurance(insuranceId);
			break;
		case 5:
			insurance = insuranceDAO.selectCancerInsurance(insuranceId);
			break;
		case 6:
			insurance = insuranceDAO.selectTripInsurance(insuranceId);
			break;
		}
		return insurance;
	}
}
