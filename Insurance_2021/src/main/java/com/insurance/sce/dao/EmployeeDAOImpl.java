package com.insurance.sce.dao;

import java.util.ArrayList;
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
	public int insert(Employee employee) {
		EmployeeDB employeeDB = new EmployeeDB(employee);
		return sqlSession.insert(Insert, employeeDB);
	}

	// Select
	public List<Employee> selectAll() {
		List<EmployeeDB> employeeDBList = sqlSession.selectList(SelectAll);
		ArrayList<Employee> employeeList = new ArrayList<Employee>();
		for(EmployeeDB employee : employeeDBList) {
			employee.setEnum();
			employeeList.add(employee);
		}
		return employeeList;
	}

	public List<Employee> selectAllSlaesPerson() {
		List<EmployeeDB> employeeDBList = sqlSession.selectList(SelectAllSlaesPerson);
		ArrayList<Employee> employeeList = new ArrayList<Employee>();
		for(EmployeeDB employee : employeeDBList) {
			employee.setEnum();
			employeeList.add(employee);
		}
		return employeeList;
	}
	public Employee select(String employeeId) {
		EmployeeDB employeeDB = sqlSession.selectOne(Select, employeeId);
		employeeDB.setEnum();
		return (Employee) employeeDB;
	}
	public Employee selectByIdPw(Employee employee) {
		EmployeeDB employeeDB = sqlSession.selectOne(SelectByIdPw, employee);
		employeeDB.setEnum();
		return (Employee) employeeDB;
	}
	public Employee selectSlaesPerson(String employeeId) {
		EmployeeDB employeeDB = sqlSession.selectOne(SelectSlaesPerson, employeeId);
		employeeDB.setEnum();
		return (Employee) employeeDB;
	}

	// Update
	public int updateSaleHistory(String employeeId) {return sqlSession.update(UpdateSaleHistory, employeeId);}

	// Delete
	public int delete(String employeeId) {return sqlSession.delete(Delete, employeeId);}

}