package com.insurance.sce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.insurance.sce.dao.InsuranceDAO;
import com.insurance.sce.model.insurance.CancerInsurance;
import com.insurance.sce.model.insurance.Insurance;

@Repository
public class InsuranceService {

	@Autowired
	InsuranceDAO insuranceDAO;
	
	public List<CancerInsurance> selectAll() {
		List<CancerInsurance> insuranceList = insuranceDAO.selectAllCancerInsurance();
//		for(CancerInsurance insurance : insuranceList) {
//			insurance = insuranceDAO.selectCancerInsurance(insurance.getInsuranceId());
//		}
		return insuranceList;
	}
}
