package com.insurance.sce.model.employee;

import com.insurance.sce.global.Constants.eEmployeeRole;

public class Employee {
	// Attributes
	private String employeeId;
	private String password;
	private String name;
	private String phoneNumber;
	private eEmployeeRole role;
	private int saleHistory;
	
	// Constructor
	public Employee() {
	}	
	
	// getters & setters
	public String getEmployeeId() {return employeeId;}
	public void setEmployeeId(String employeeId) {this.employeeId = employeeId;}

	public String getName() {return name;}
	public void setName(String name) {this.name = name;}

	public String getPhoneNumber() {return phoneNumber;}
	public void setPhoneNumber(String phoneNumber) {this.phoneNumber = phoneNumber;}

	public String getPassword() {return password;}
	public void setPassword(String password) {this.password = password;}

	public eEmployeeRole getRole() {return role;}
	public void setRole(int role) {this.role = eEmployeeRole.get(role);}
	
	public int getSaleHistory() {return saleHistory;}
	public void setSaleHistory(int saleHistory) {this.saleHistory = saleHistory;}
}
