package com.insurance.sce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.insurance.sce.dao.InsuranceDAO;
import com.insurance.sce.model.insurance.Insurance;

@Repository
public class InsuranceConfirmerServiceImpl implements InsuranceConfirmerService{
	@Autowired
	InsuranceDAO insuranceDAO;

	
	public int confirmInsurance(String insuranceId) {
		return insuranceDAO.updateConfirmedStatus(insuranceId);
	}
	
}