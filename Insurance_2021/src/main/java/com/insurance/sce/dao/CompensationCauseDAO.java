package com.insurance.sce.dao;

public interface CompensationCauseDAO {
	public int insert(String accidentId, String cause);
	public String select(String accidentId);
}