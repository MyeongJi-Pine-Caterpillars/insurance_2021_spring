package com.insurance.sce.dao;

import java.util.List;

import com.insurance.sce.model.insurance.GuaranteePlan;

public interface GuaranteePlanDAO {
	public int insert(GuaranteePlan guaranteePlan);
	public List<GuaranteePlan> selectByInsuranceId(String insuranceId);
}
