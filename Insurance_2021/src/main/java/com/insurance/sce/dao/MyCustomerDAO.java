package com.insurance.sce.dao;

import com.insurance.sce.model.customer.Customer;

public interface MyCustomerDAO {
	public Customer selectCustomer(String customerId);
}
