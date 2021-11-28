package com.insurance.sce.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.insurance.sce.model.customer.Customer;

public interface CustomerDAO {
	public int insert(Customer customer);
	
	public List<Customer> selectAll();
	public Customer select(String customerId);
	
	public int updateAddress(Customer customer);
	public int updatePhoneNumber(Customer customer);
	
	public int delete(String customerId);
}
