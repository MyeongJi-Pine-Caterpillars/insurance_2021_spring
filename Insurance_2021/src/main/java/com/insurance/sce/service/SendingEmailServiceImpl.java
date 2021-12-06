package com.insurance.sce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.sce.dao.ContractDAO;
import com.insurance.sce.dao.CustomerDAO;
import com.insurance.sce.model.customer.Customer;

@Service
public class SendingEmailServiceImpl implements ContractManageService{
	@Autowired
	CustomerDAO customerDAO;
	ContractDAO contractDAO;
	
	public Customer loginCustomer(String id, String pw) {
		
		Customer customer = customerDAO.select(id);
		
		if(customer == null) return null;
		
		
		if(customer.getPassword().equals(pw)) return customer;
		else return null;
	}

}
