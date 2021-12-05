package com.insurance.sce.dao.contract;

public interface CompensationCauseDAO {
	public int insert(String accidentId, String cause);
	public String select(String accidentId);
}