package com.insurance.sce.dao;

import com.insurance.sce.global.Constants.eEmployeeRole;
import com.insurance.sce.model.employee.Employee;

public class EmployeeDB extends Employee {
	
	int role;
	
	public EmployeeDB() {
		
	}
	
	public EmployeeDB(Employee employee) {
		this.setEmployeeId(employee.getEmployeeId());
		this.setPassword(employee.getPassword());
		this.setName(employee.getName());
		this.setPhoneNumber(employee.getPhoneNumber());
		this.role = employee.getEmployeeRole().getNum();
		this.setSaleHistory(employee.getSaleHistory());
	}
	
	public void setEnum() {
		this.setEmployeeRole(eEmployeeRole.values()[role - 1]);
	}
}
