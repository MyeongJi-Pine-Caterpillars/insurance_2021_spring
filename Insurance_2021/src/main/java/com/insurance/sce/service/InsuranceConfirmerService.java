package com.insurance.sce.service;

import com.insurance.sce.model.insurance.Insurance;

public interface InsuranceConfirmerService {
	public Insurance selectInsurance(String insuranceId);
	public int confirmInsurance(String insuranceId);
}