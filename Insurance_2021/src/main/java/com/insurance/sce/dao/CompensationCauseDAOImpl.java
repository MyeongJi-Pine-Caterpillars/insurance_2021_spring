package com.insurance.sce.dao;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
public class CompensationCauseDAOImpl implements CompensationCauseDAO{
	@Inject
	private SqlSession sqlSession;

	private static final String Insert = "compensationCauseMapper.insert";
	private static final String Select = "compensationCauseMapper.select";
	
	// Insert
	public int insert(String accidentId, String cause) {
		Map<String, String> map = new HashMap<>();
		map.put("accidentId", accidentId);
		map.put("cause", cause);
		return sqlSession.insert(Insert, map);
	}

	// Select
	public String select(String accidentId) {return sqlSession.selectOne(Select, accidentId);}
}

