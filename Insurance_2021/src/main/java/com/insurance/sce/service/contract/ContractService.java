package com.insurance.sce.service.contract;

import java.util.List;
import java.util.Map;

import com.insurance.sce.model.contract.Contract;
import com.insurance.sce.model.customer.Insurant;

public interface ContractService {
	public List<Contract> selectNotEffectiveContract();
	public List<Contract> selectAllContract();
	public List<Map<String, Object>> selectContractInsurance(String customerId);
	public void signUpCancerInsurance(Map<String, Object> map, Insurant insurant);
	public void signUpDentalInsurance(Map<String, Object> map, Insurant insurant);
	public void signUpDriverInsurance(Map<String, Object> map, Insurant insurant);
	public void signUpTripInsurance(Map<String, Object> map, Insurant insurant);
	public void signUpFireInsurance(Map<String, Object> map, Insurant insurant);
	public Map<String, Object> getInsurantFromContract(List<Map<String, Object>> mapList, String contractId);
}
