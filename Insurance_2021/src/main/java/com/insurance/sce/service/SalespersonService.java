package com.insurance.sce.service;

import java.util.List;

import com.insurance.sce.model.insurance.Insurance;

public interface SalespersonService {
	public List<Insurance> selectInsuranceList(int insuranceType);
}
