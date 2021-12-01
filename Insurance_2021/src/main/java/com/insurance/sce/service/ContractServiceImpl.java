package com.insurance.sce.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.sce.dao.ContractDAO;
import com.insurance.sce.dao.InsurantDAO;
import com.insurance.sce.model.contract.Contract;
import com.insurance.sce.model.customer.Insurant;
import com.insurance.sce.global.Constants.eFamilyMedicalDisease;
import com.insurance.sce.global.Constants.eFamilyMedicalRelationship;;

@Service
public class ContractServiceImpl implements ContractService{
	
	@Autowired
	ContractDAO contractDAO;
	@Autowired
	InsurantDAO insurantDAO;

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

	public void signUpCancerInsurance(Map<String, Object> map, Insurant insurant) {
		Contract contract = new Contract();
		if(map.get("isCancerRadio").equals("No")) {
			insurant.setEFamilyMedicalDisease(eFamilyMedicalDisease.none);
			insurant.setEFamilyMedicalRelationship(eFamilyMedicalRelationship.none);
		}else {
			if(map.get("familyMedicalDisease").equals("thyroid")) 
				{insurant.setEFamilyMedicalDisease(eFamilyMedicalDisease.thyroid);}
			else if(map.get("familyMedicalDisease").equals("testicular")) 
				{insurant.setEFamilyMedicalDisease(eFamilyMedicalDisease.testicular);}
			else if(map.get("familyMedicalDisease").equals("ovarian")) 
				{insurant.setEFamilyMedicalDisease(eFamilyMedicalDisease.ovarian);}
			else if(map.get("familyMedicalDisease").equals("esophageal"))
				{insurant.setEFamilyMedicalDisease(eFamilyMedicalDisease.esophageal);}
			else if(map.get("familyMedicalDisease").equals("lung")) 
				{insurant.setEFamilyMedicalDisease(eFamilyMedicalDisease.lung);}
			
			if(map.get("familyMedicalRelationship").equals("one")) 
				{insurant.setEFamilyMedicalRelationship(eFamilyMedicalRelationship.one);}
			else if(map.get("familyMedicalRelationship").equals("two")) 
				{insurant.setEFamilyMedicalRelationship(eFamilyMedicalRelationship.two);}
			else if(map.get("familyMedicalRelationship").equals("three")) 
				{insurant.setEFamilyMedicalRelationship(eFamilyMedicalRelationship.three);}
			else if(map.get("familyMedicalRelationship").equals("four")) 
				{insurant.setEFamilyMedicalRelationship(eFamilyMedicalRelationship.four);}
		}
		
		if(map.get("special").equals("Yes")) contract.setSpecial(true);
		else contract.setSpecial(false);
		
		insurant.setUsageOfStructure(0);
		insurant.setTypeOfCar(0);
		insurant.setRankOfCar(0);
		insurant.setRiskOfTripCountry(0);
		
		ArrayList<String> ids = (ArrayList<String>) contractDAO.selectAllContractId();
		int maxId = 0;
		for(String id: ids) maxId = Math.max(maxId, Integer.parseInt(id));
		contract.setContractId(Integer.toString(maxId+1));
		
		contract.setInsuranceId((String)map.get("insuranceId"));
		contract.setInsurantId(insurant.getInsurantId());
		contract.setEffectiveness(false);
		
		insurantDAO.insertInsurant(insurant);
		contractDAO.insert(contract);
	}
	
	
}
