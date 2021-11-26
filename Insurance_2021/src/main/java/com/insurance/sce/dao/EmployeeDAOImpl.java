package com.insurance.sce.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.insurance.sce.model.employee.Employee;

@Repository
public class EmployeeDAOImpl extends DBConnector implements EmployeeDAO{
	@Inject
	private SqlSession sqlSession;
	
	private static final String Insert = "employeeMapper.insert";
	private static final String SelectAll = "employeeMapper.selectAll";
	private static final String SelectAllSlaesPerson = "employeeMapper.selectAllSlaesPerson";
	private static final String Select = "employeeMapper.select";
	private static final String SelectByIdPw = "employeeMapper.selectByIdPw";
	private static final String SelectSlaesPerson = "employeeMapper.selectSlaesPerson";
	private static final String UpdateSaleHistory = "employeeMapper.updateSaleHistory";
	private static final String Delete = "employeeMapper.delete";
	
	// Insert
	public int insert(Employee employee) {return sqlSession.insert(Insert, employee);}

	// Select
	public List<Employee> selectAll() {return sqlSession.selectList(SelectAll);}
	public List<Employee> selectAllSlaesPerson() {return sqlSession.selectList(SelectAllSlaesPerson);}
	public Employee select(String employeeId) {return (Employee)sqlSession.selectOne(Select, employeeId);}
	public Employee selectByIdPw(Employee employee) {return (Employee)sqlSession.selectOne(SelectByIdPw, employee);}
	public Employee selectSlaesPerson(String employeeId) {return (Employee)sqlSession.selectOne(SelectSlaesPerson, employeeId);}

	// Update
	public int updateSaleHistory(String employeeId) {return sqlSession.update(UpdateSaleHistory, employeeId);}

	// Delete
	public int delete(String employeeId) {return sqlSession.delete(Delete, employeeId);}

}
