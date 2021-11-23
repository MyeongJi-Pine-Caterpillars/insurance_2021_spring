package com.insurance.sce.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.insurance.sce.model.customer.Customer;

@Repository
public class MyCustomerDAOImpl implements MyCustomerDAO{

	@Inject
	private SqlSession sqlSession;
	
	private static final String SelectCustomer = "customerMapper.selectCustomer";
	
	@Override
	public Customer selectCustomer(String customerId) {
		return (Customer)sqlSession.selectOne(SelectCustomer, customerId);
	}

}
