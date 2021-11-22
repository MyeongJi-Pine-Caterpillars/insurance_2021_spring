package com.insurance.sce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.insurance.sce.dao.DBConnector;
import com.insurance.sce.dao.EmployeeDAO;
import com.insurance.sce.dao.EmployeeDAOImpl;
import com.insurance.sce.model.employee.Employee;

@Controller
public class LoginEmployee {
	@RequestMapping(value="/EmployeeLogin", method=RequestMethod.GET)
	public String employeeLogin(String id, String password) {
		DBConnector dbConnector = new DBConnector();
		EmployeeDAO employeeDAO = new EmployeeDAOImpl();
		dbConnector.startDB();
		dbConnector.connect();
		Employee employee = employeeDAO.selectEmployee(id);
		if(employee != null) {
			if(employee.getPassword().matches(password)) {
				//Success
				return "SelectUserType";
			}
		} 
		//Fail
		return "home";
	}
}
