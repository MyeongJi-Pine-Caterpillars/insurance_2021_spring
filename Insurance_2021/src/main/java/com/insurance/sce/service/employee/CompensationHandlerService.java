package com.insurance.sce.service.employee;

import java.util.ArrayList;
import java.util.HashMap;

import com.insurance.sce.model.contract.Accident;

public interface CompensationHandlerService {
	public void compensate(HashMap<String, Object> map);
	public ArrayList<Accident> selectAccidentByInsurant(ArrayList<Accident> acList, String contractId);
}
