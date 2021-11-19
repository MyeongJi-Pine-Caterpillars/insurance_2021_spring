package com.insurance.sce.model.employee;

import com.insurance.sce.dao.ContractDAO;
import com.insurance.sce.model.contract.Contract;

public class UnderWriter extends Employee{

	private ContractDAO contractDAO;

	public UnderWriter(ContractDAO contractDAO){
		this.contractDAO = contractDAO;
	}

	public void approveContract(Contract contract) {
		contractDAO.updateEffectiveness(contract.getContractId(), true);
		contractDAO.updateUnpaidPeriod(contract.getContractId(), 1);
	}
	
	public void refuseContract(Contract contract) {
		this.contractDAO.delete(contract.getContractId());
	}
}