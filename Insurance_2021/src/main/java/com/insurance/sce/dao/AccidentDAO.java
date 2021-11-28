package com.insurance.sce.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.insurance.sce.model.contract.*;

public interface AccidentDAO {
	public int insert(Accident accident);
	
	public List<Accident> selectAll();
	public List<Accident> selectListByContractId(String contractId);
	public Accident selectByAccidentId(String accidentId);
	
	public int updateCompensation(Accident accident);
	public int updateHandlingStatus(Accident accident);
	
	public int delete(String accidentId);
}
