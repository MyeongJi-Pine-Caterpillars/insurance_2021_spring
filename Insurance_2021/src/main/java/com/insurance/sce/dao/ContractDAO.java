package com.insurance.sce.dao;

import java.util.List;

import com.insurance.sce.model.contract.Contract;

public interface ContractDAO {
	public int insert(Contract contract);
	
	public List<Contract> selectAll();
	public List<String> selectAllContractId();
	public List<Contract> selectAllIds();
	public List<Contract> selectListByInsurant(String insurantId);
	public Contract select(String contractId);
	public Contract selectUnpaidAndFee(String contractId);
	
	public int updateFee(Contract contract);
	public int updateEffectiveness(Contract contract);
	public int updateLifespan(Contract contract);
	public int updateUnpaidPeriod(Contract contract);
	public int updateSpecial(Contract contract);

	public int delete(String contractId);
}
