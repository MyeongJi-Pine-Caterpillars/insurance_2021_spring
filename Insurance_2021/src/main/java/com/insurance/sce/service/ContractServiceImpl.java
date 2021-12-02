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
import com.insurance.sce.global.Constants.eFamilyMedicalRelationship;
import com.insurance.sce.global.Constants.eRankOfCar;
import com.insurance.sce.global.Constants.eRiskOfTripCountry;
import com.insurance.sce.global.Constants.eTypeOfCar;
import com.insurance.sce.global.Constants.eUsageOfStructure;;

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

		insurant = fillNullEnum(insurant);
		
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
	
	public void signUpDentalInsurance(Map<String, Object> map, Insurant insurant) {
		Contract contract = new Contract();
		
		if(map.get("special").equals("Yes")) contract.setSpecial(true);
		else contract.setSpecial(false);
		
		insurant = fillNullEnum(insurant);
		
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
	
	public void signUpDriverInsurance(Map<String, Object> map, Insurant insurant) {
		Contract contract = new Contract();
		if (map.get("accidentHistoryRadio").equals("Zero")) insurant.setAccidentHistory(0);
		else if (map.get("accidentHistoryRadio").equals("One")) insurant.setAccidentHistory(1);
		else if (map.get("accidentHistoryRadio").equals("TwoThree")) insurant.setAccidentHistory(2);
		else if (map.get("accidentHistoryRadio").equals("FourFive")) insurant.setAccidentHistory(4);
		else if (map.get("accidentHistoryRadio").equals("SixSeven")) insurant.setAccidentHistory(6);
		else if (map.get("accidentHistoryRadio").equals("Eight")) insurant.setAccidentHistory(8);
		
		if (map.get("typeOfCarRadio").equals("Bus")) insurant.setETypeOfCar(eTypeOfCar.bus);
		else if (map.get("typeOfCarRadio").equals("Van")) insurant.setETypeOfCar(eTypeOfCar.van);
		else if (map.get("typeOfCarRadio").equals("SUV")) insurant.setETypeOfCar(eTypeOfCar.suv);
		else if (map.get("typeOfCarRadio").equals("Foreign")) insurant.setETypeOfCar(eTypeOfCar.foreign);
		else if (map.get("typeOfCarRadio").equals("Etc")) insurant.setETypeOfCar(eTypeOfCar.etc);
		
		if (map.get("rankOfCarRadio").equals("Luxury")) insurant.setERankOfCar(eRankOfCar.luxury);
		else if (map.get("rankOfCarRadio").equals("High")) insurant.setERankOfCar(eRankOfCar.high);
		else if (map.get("rankOfCarRadio").equals("Middle")) insurant.setERankOfCar(eRankOfCar.middle);
		else if (map.get("rankOfCarRadio").equals("Low")) insurant.setERankOfCar(eRankOfCar.low);
		
		if(map.get("special").equals("Yes")) contract.setSpecial(true);
		else contract.setSpecial(false);

		insurant = fillNullEnum(insurant);
		
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

	public void signUpTripInsurance(Map<String, Object> map, Insurant insurant) {
		Contract contract = new Contract();
		
		if (map.get("rateOfCountryRiskRadio").equals("Zero")) insurant.setERiskOfTripCountry(eRiskOfTripCountry.safe);
		else if (map.get("rateOfCountryRiskRadio").equals("One")) insurant.setERiskOfTripCountry(eRiskOfTripCountry.first);
		else if (map.get("rateOfCountryRiskRadio").equals("Two")) insurant.setERiskOfTripCountry(eRiskOfTripCountry.second);
		else if (map.get("rateOfCountryRiskRadio").equals("Three")) insurant.setERiskOfTripCountry(eRiskOfTripCountry.third);
		
		if(map.get("special").equals("Yes")) contract.setSpecial(true);
		else contract.setSpecial(false);

		insurant = fillNullEnum(insurant);
		
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
	
	public void signUpFireInsurance(Map<String, Object> map, Insurant insurant) {
		Contract contract = new Contract();
		
		if (map.get("usageOfStructure").equals("house")) insurant.setEUsageOfStructure(eUsageOfStructure.house);
		else if (map.get("usageOfStructure").equals("study")) insurant.setEUsageOfStructure(eUsageOfStructure.study);
		else if (map.get("usageOfStructure").equals("factory")) insurant.setEUsageOfStructure(eUsageOfStructure.factory);
		else if (map.get("usageOfStructure").equals("warehouse")) insurant.setEUsageOfStructure(eUsageOfStructure.warehouse);
		else if (map.get("usageOfStructure").equals("office")) insurant.setEUsageOfStructure(eUsageOfStructure.office);
		else if (map.get("usageOfStructure").equals("publicFacility")) insurant.setEUsageOfStructure(eUsageOfStructure.publicFacility);
		insurant.setPostedPriceOfStructure((Integer)map.get("postedPrice"));
		
		if(map.get("special").equals("Yes")) contract.setSpecial(true);
		else contract.setSpecial(false);

		insurant = fillNullEnum(insurant);
		
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
	
	private Insurant fillNullEnum(Insurant insurant) {
		if(insurant.getEFamilyMedicalDisease() == null) insurant.setFamilyMedicalDisease(0);
		if(insurant.getEFamilyMedicalRelationship() == null) insurant.setFamilyMedicalRelationship(0);
		if(insurant.getEUsageOfStructure() == null) insurant.setUsageOfStructure(0);
		if(insurant.getETypeOfCar() == null) insurant.setTypeOfCar(0);
		if(insurant.getERankOfCar() == null) insurant.setRankOfCar(0);
		if(insurant.getERiskOfTripCountry() == null) insurant.setRiskOfTripCountry(0);
		return insurant;
	}



	
}
