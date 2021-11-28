package com.insurance.sce.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.insurance.sce.model.customer.Customer;

@Component
public class CustomerDAOImpl implements CustomerDAO{

	@Inject
	private SqlSession sqlSession;
	
	private static final String Insert = "customerMapper.insert";
	private static final String SelectAll= "customerMapper.selectAll";
	private static final String Select = "customerMapper.select";
	private static final String UpdateAddress= "customerMapper.updateAddress";
	private static final String UpdatePhoneNumber= "customerMapper.updatePhoneNumber";
	private static final String Delete= "customerMapper.delete";

	// Insert
	@Override
	public int insert(Customer customer) {return sqlSession.insert(Insert, customer);}

	// Select
	@Override
	public List<Customer> selectAll() {return sqlSession.selectList(SelectAll);}
	@Override
	public Customer select(String customerId) {return (Customer)sqlSession.selectOne(Select, customerId);}

	// Update
	@Override
	public int updateAddress(Customer customer) {return sqlSession.update(UpdateAddress, customer);}
	@Override
	public int updatePhoneNumber(Customer customer) {return sqlSession.update(UpdatePhoneNumber, customer);}

	// Delete
	@Override
	public int delete(String customerId) {return sqlSession.delete(Delete, customerId);}

}