package com.insurance.sce.service.employee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import com.insurance.sce.dao.contract.ContractDAO;
import com.insurance.sce.dao.customer.InsurantDAO;
import com.insurance.sce.dao.insurance.InsuranceDAO;
import com.insurance.sce.global.Constants.eInsuranceType;
import com.insurance.sce.model.contract.Contract;
import com.insurance.sce.model.customer.Insurant;
import com.insurance.sce.model.insurance.DriverInsurance;
import com.insurance.sce.model.insurance.Insurance;

@Service
public class UnderWriterServiceImpl implements UnderWriterService{
	
	@Autowired
	ContractDAO contractDAO;
	@Autowired
	InsurantDAO insurantDAO;
	@Autowired
	InsuranceDAO insuranceDAO;
	

	public Insurance getInsurace(String insuranceId) {
		return insuranceDAO.selectCancerInsurance(insuranceId);
	}

	public Insurant getInsurant(String insurantId) {
		return insurantDAO.select(insurantId);
	}
	
	@Override
	public List<Map<String, Object>> getAllData() {
		return contractDAO.getAllData();
	}

	@Override
	public Contract getContract(String contractId) {
		return contractDAO.select(contractId);
	}

	@Override
	public void approveContract(String contractId) {
		Contract contract = new Contract();
		contract.setContractId(contractId);
		contract.setEffectiveness(true);
		contractDAO.updateEffectiveness(contract);
	}

	@Override
	public void denyContract(String contractId) {
		contractDAO.delete(contractId);
	}

	@Override
	public String selectInsuranceType(eInsuranceType eType) {
		String jsp = "ContractDetail";
		switch(eType) {
		case driverInsurance :
			jsp = eType.driverInsurance.getName() + jsp;
			break;
		case dentalInsurance : 
			jsp = eType.dentalInsurance.getName() + jsp;
			break;
		case actualCostInsurance : 
			jsp = eType.actualCostInsurance.getName() + jsp;
			break;
		case fireInsurance : 
			jsp = eType.fireInsurance.getName() + jsp;
			break;
		case cancerInsurance : 
			jsp = eType.cancerInsurance.getName() + jsp;
			break;
		case tripInsurance : 
			jsp = eType.tripInsurance.getName() + jsp;
			break;
		}
		return jsp;
	}

	@Override
	public void calculateFee(Contract contract, Insurance insurance, Insurant insurant) {
		int fee = insurance.calculateFee(insurant);
		contract.setFee(fee);
		this.contractDAO.updateFee(contract);
	}
}
