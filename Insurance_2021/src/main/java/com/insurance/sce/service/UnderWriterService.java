package com.insurance.sce.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.insurance.sce.model.contract.Contract;
import com.insurance.sce.model.customer.Insurant;
import com.insurance.sce.model.insurance.CancerInsurance;
import com.insurance.sce.model.insurance.Insurance;

public interface UnderWriterService {
	public List<Contract> selectNotEffectiveContract();
	public Insurance getInsurace(String insuranceId);
	public Insurant getInsurant(String insurantId);
	public ArrayList<String[]> getContractList();
	public Contract getContract(String contractID);
}
