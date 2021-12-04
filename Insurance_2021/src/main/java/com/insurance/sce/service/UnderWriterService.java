package com.insurance.sce.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.insurance.sce.dao.Data;
import com.insurance.sce.global.Constants.eInsuranceType;
import com.insurance.sce.model.contract.Contract;
import com.insurance.sce.model.customer.Insurant;
import com.insurance.sce.model.insurance.CancerInsurance;
import com.insurance.sce.model.insurance.Insurance;

public interface UnderWriterService {
	public Insurance getInsurace(String insuranceId);
	public Insurant getInsurant(String insurantId);
	public List<Data> getAllData();
	public Contract getContract(String contractID);
	public void approveContract(String contractId);
	public void denyContract(String contractId);
	public String selectInsuranceType(eInsuranceType eType);
	public void calculateFee(Contract contract, Insurance insurance, Insurant insurant);
}
