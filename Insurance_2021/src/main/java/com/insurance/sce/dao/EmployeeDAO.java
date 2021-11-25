package com.insurance.sce.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.insurance.sce.model.employee.Employee;

@Repository
public interface EmployeeDAO {
	public int insert(Employee employee);
	
	public List<Employee> selectAll();
	public List<Employee> selectAllSlaesPerson();
	public Employee select(String employeeId);
	public Employee selectByIdPw(Employee employee);
	public Employee selectSlaesPerson(String employeeId);
	
	public int updateSaleHistory(String employeeId);
	
	public int delete(String employeeId);
}
