package com.insurance.sce.service;

import java.util.Map;

import com.insurance.sce.model.customer.Insurant;

public interface InsurantService {
	public Insurant selectInsurant(String insurantID);
	public Insurant setInsurantBasic(Map<String, Object> map);
}
