package com.insurance.sce.dao;

import java.util.List;

import com.insurance.sce.model.customer.Customer;

public interface CustomerDAO {
	public int insertCustomer(Customer customer);
	
	public List<Customer> selectCustomerList();
	public Customer selectCustomer(String customerId);
	
	public int updateAddress(Customer customer);
	public int updatePhoneNumber(Customer customer);
	
	public int deleteCustomer(String customerId);
}
