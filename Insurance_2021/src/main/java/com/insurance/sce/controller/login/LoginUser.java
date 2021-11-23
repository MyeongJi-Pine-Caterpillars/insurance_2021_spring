package com.insurance.sce.controller.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.insurance.sce.dao.CustomerDAO;
import com.insurance.sce.dao.CustomerDAOImpl;
import com.insurance.sce.dao.DBConnector;
import com.insurance.sce.model.customer.Customer;

@Controller
public class LoginUser {
	@RequestMapping(value="/userLogin", method=RequestMethod.GET)
	public String userLogin(String id, String password) {
		DBConnector dbConnector = new DBConnector();
		CustomerDAO customerDAO = new CustomerDAOImpl();
		dbConnector.startDB();	
		dbConnector.connect();
		Customer customer = customerDAO.selectCustomer(id);
		if(customer != null) {
			if(customer.getPassword().matches(password)) {
				return "customer/selectCancerInsurance";
			}
		}
		return "customer/selectCancerInsurance";
	}
	@RequestMapping(value="/loginCheck", method=RequestMethod.GET)
	public String loginCheck(String id, String password, HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		DBConnector dbConnector = new DBConnector();
		CustomerDAO customerDAO = new CustomerDAOImpl();
		dbConnector.startDB();	
		dbConnector.connect();
		Customer customer = customerDAO.selectCustomer(id);
		session.setAttribute("loginCustomer", customer);
		if(customer != null) {
			if(customer.getPassword().matches(password)) {
				return "customer/selectCancerInsurance";
			}
		}
		return "login/selectUserType";
	}
}
