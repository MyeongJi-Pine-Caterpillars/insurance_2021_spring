package com.insurance.sce.dao.contract;

import java.util.List;

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
