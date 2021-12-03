package com.insurance.sce.service;

import java.util.ArrayList;
import java.util.List;

import com.insurance.sce.model.contract.Accident;

public interface AccidentService {
	public List<Accident> selectAllAccident();
}
