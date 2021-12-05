package com.insurance.sce.model.employee;

import com.insurance.sce.dao.contract.ContractDAO;
import com.insurance.sce.model.contract.Contract;

public class ContractManager extends Employee {
	private ContractDAO contractDAO;

	public ContractManager(ContractDAO contractDAO){
		this.contractDAO = contractDAO;
	}

	public void manageUnpaidContract(Contract contract){
//		this.contractDAO.updateEffectiveness(contract.getContractId(), false);
	}
}