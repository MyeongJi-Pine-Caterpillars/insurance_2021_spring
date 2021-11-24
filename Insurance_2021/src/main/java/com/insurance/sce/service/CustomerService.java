package com.insurance.sce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.insurance.sce.dao.CustomerDAO;
import com.insurance.sce.model.customer.Customer;

@Repository
public class CustomerService {
	@Autowired
	CustomerDAO customerDAO;
	
	public Customer loginCustomer(String id, String pw) {
		// 해당 Id를 가진 Customer 불러오기
		Customer customer = customerDAO.select(id);
		
		// Id PW 대조
		if(customer.getPassword().equals(pw)) return customer;
		else return null;
	}

}
