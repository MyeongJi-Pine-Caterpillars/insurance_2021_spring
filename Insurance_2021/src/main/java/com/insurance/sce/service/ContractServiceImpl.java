package com.insurance.sce.service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.sce.dao.ContractDAO;
import com.insurance.sce.dao.ContractDAOImpl;
import com.insurance.sce.model.contract.Contract;

@Service
public class ContractServiceImpl implements ContractService{
	
	@Autowired
	ContractDAO contractDAO;

	public List<Contract> selectNotEffectiveContract() {
		List<Contract> list = contractDAO.selectAll();
		ArrayList<Contract> resultList = new ArrayList<Contract>();
		for(Contract contract : list) {
			if(contract.isEffectiveness() == false) {
				resultList.add(contract);
			}
		}
		return resultList;
	}
	
	
}
