package com.insurance.sce.service.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.sce.dao.customer.CustomerDAO;
import com.insurance.sce.model.customer.Customer;

@Service
public class ContractManagerServiceImpl implements ContractManageService{
	@Autowired
	CustomerDAO customerDAO;
	
	public Customer loginCustomer(String id, String pw) {
		
		Customer customer = customerDAO.select(id);
		
		if(customer == null) return null;
		
		
		if(customer.getPassword().equals(pw)) return customer;
		else return null;
	}

}
