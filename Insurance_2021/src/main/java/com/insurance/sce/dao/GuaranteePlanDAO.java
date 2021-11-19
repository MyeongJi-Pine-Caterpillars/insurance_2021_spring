package com.insurance.sce.dao;

import java.util.ArrayList;

import com.insurance.sce.model.insurance.GuaranteePlan;

public interface GuaranteePlanDAO {
	public boolean insert(GuaranteePlan guaranteePlan);
	public ArrayList<GuaranteePlan> selectById(String insuranceId);
}
