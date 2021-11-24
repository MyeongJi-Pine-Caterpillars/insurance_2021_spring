package com.insurance.sce.dao;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.insurance.sce.model.customer.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO{

	@Inject
	private SqlSession sqlSession;
	
	private static final String InsertCustomer = "customerMapper.insertCustomer";
	private static final String SelectCustomer = "customerMapper.selectCustomer";
	private static final String SelectCustomerList = "customerMapper.selectCustomerList";
	private static final String UpdateAddress= "customerMapper.updateAddress";
	private static final String UpdatePhoneNumber= "customerMapper.updatePhoneNumber";
	private static final String DeletePhoneNumber= "customerMapper.deleteCustomer";

	@Override
	public int insertCustomer(Customer customer) {
		return sqlSession.insert(InsertCustomer, customer);
	}
	
	@Override
	public List<Customer> selectCustomerList() {
		return sqlSession.selectList(SelectCustomerList);
	}

	@Override
	public Customer selectCustomer(String customerId) {
		return (Customer)sqlSession.selectOne(SelectCustomer, customerId);
	}

	@Override
	public int updateAddress(Customer customer) {
		return sqlSession.update(UpdateAddress, customer);
	}

	@Override
	public int updatePhoneNumber(Customer customer) {
		return sqlSession.update(UpdatePhoneNumber, customer);
	}

	@Override
	public int deleteCustomer(String customerId) {
		return sqlSession.delete(DeletePhoneNumber, customerId);
	}

}