package com.insurance.sce.service;

import java.util.List;

import com.insurance.sce.model.contract.Contract;

public interface SendingEmailService {
	public List<Contract> selectNotEffectiveContract();
	public List<Contract> selectAllContract();
}
