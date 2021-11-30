package com.insurance.sce.service;

import java.util.List;

import com.insurance.sce.model.contract.Contract;

public interface ContractService {
	public List<Contract> selectNotEffectiveContract();
}
