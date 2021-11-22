package com.insurance.sce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.insurance.sce.dao.CustomerDAO;
import com.insurance.sce.dao.CustomerDAOImpl;
import com.insurance.sce.dao.DBConnector;
import com.insurance.sce.model.customer.Customer;

@Controller
public class LoginUser {
	@RequestMapping(value="/UserLogin", method=RequestMethod.GET)
	public String userLogin(String id, String password) {
		DBConnector dbConnector = new DBConnector();
		CustomerDAO customerDAO = new CustomerDAOImpl();
		dbConnector.startDB();
		dbConnector.connect();
		Customer customer = customerDAO.selectCustomer(id);
		if(customer != null) {
			if(customer.getPassword().matches(password)) {
				//Success
				return "SelectUserType";
			}
		} 
		//Fail
		return "home";
	}
}
