package com.insurance.sce.service.employee;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.sce.dao.contract.AccidentDAO;
import com.insurance.sce.dao.contract.CompensationCauseDAO;
import com.insurance.sce.dao.contract.ContractDAO;
import com.insurance.sce.model.contract.Accident;
import com.insurance.sce.model.contract.Contract;;

@Service
public class CompensationHandlerServiceImpl implements CompensationHandlerService{
	@Autowired
	ContractDAO contractDAO;
	@Autowired
	AccidentDAO accidentDAO;
	@Autowired
	CompensationCauseDAO compensationCauseDAO;
	@Override
	public void compensate(HashMap<String, Object> map) {
		Contract contract = new Contract();
		contract.setContractId((String)map.get("contractId"));
		contract.setFee((int)map.get("fee"));
		Accident accident = new Accident();
		accident.setAccidentId((String)map.get("accidentId"));
		accident.setCompensation((int)map.get("compensation"));
		accident.setHandlingStatus(true);
		accidentDAO.updateCompensation(accident);
		accidentDAO.updateHandlingStatus(accident);
		contractDAO.updateFee(contract);
		compensationCauseDAO.insert((String)map.get("accidentId"), (String)map.get("compensationCause"));
	}
	@Override
	public ArrayList<Accident> selectAccidentByInsurant(ArrayList<Accident> acList, String contractId) {
		ArrayList<Accident> returnList = new ArrayList<>();
		for(Accident ac: acList) {
			if(ac.getContractId().equals(contractId) && ac.isHandlingStatus() == true) returnList.add(ac);
		}
		return returnList;
	}
	
}
