package com.insurance.sce.dao;

import org.springframework.stereotype.Repository;

public interface CompensationCauseDAO {
	public int insert(String accidentId, String cause);
	public String select(String accidentId);
}