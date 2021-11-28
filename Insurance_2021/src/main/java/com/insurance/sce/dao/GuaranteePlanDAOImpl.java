package com.insurance.sce.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.insurance.sce.model.insurance.GuaranteePlan;

@Component
public class GuaranteePlanDAOImpl extends DBConnector implements GuaranteePlanDAO{
	@Inject
	private SqlSession sqlSession;
	
	private static final String Insert = "guaranteePlanMapper.insert";
	private static final String SelectByInsuranceId = "guaranteePlanMapper.selectByInsuranceId";
	
	// Insert
	public int insert(GuaranteePlan guaranteePlan) {return sqlSession.insert(Insert, guaranteePlan);}

	// Select
	public List<GuaranteePlan> selectByInsuranceId(String insuranceId) {return sqlSession.selectList(SelectByInsuranceId, insuranceId);}
	
}
