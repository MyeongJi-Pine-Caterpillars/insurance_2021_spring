package com.insurance.sce.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.insurance.sce.model.insurance.GuaranteePlan;

@Repository
public interface GuaranteePlanDAO {
	public int insert(GuaranteePlan guaranteePlan);
	public List<GuaranteePlan> selectByInsuranceId(String insuranceId);
}
