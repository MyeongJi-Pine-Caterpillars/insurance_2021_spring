package com.insurance.sce.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import com.insurance.sce.dao.ContractDAO;
import com.insurance.sce.dao.InsuranceDAO;
import com.insurance.sce.dao.InsurantDAO;
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
	
	public List<Contract> selectNotEffectiveContract() {
		List<Contract> list = contractDAO.selectAll();
		ArrayList<Contract> resultList = new ArrayList<Contract>();
		for(Contract contract : list) {
			if(contract.isEffectiveness() == false) {
				resultList.add(contract);
			}
		}
		return resultList;
	}

	public Insurance getInsurace(String insuranceId) {
		return insuranceDAO.selectCancerInsurance(insuranceId);
	}

	public Insurant getInsurant(String insurantId) {
		return insurantDAO.select(insurantId);
	}
	
	public ArrayList<String[]> getContractList() {
		ArrayList<String[]> dataList = new ArrayList<String[]>();
		for(Contract contract : selectNotEffectiveContract()) {
			String[] list = new String[7];
			Insurance insurance = this.getInsurace(contract.getInsuranceId());
			Insurant insurant = this.getInsurant(contract.getInsurantId());
			list[0] = insurance.getName();
			list[1] = insurance.getEType().name();
			list[2] = String.valueOf(insurant.getAge());
			list[3] = insurant.getEGender().getName();
			list[4] = String.valueOf(contract.getFee());
			list[5] = String.valueOf(contract.isSpecial());
			list[6] = contract.getContractId();
			dataList.add(list);
		}
		return dataList;
	}

	@Override
	public Contract getContract(String contractID) {
		return contractDAO.select(contractID);
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
}
