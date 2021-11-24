package com.insurance.sce.controller.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.insurance.sce.dao.CustomerDAO;
import com.insurance.sce.dao.CustomerDAOImpl;
import com.insurance.sce.dao.DBConnector;
import com.insurance.sce.model.customer.Customer;
import com.insurance.sce.service.CustomerService;

@Controller
public class LoginUser {
	@Autowired
	CustomerService customerService;
	
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
		
		// 서비스를 통해 로그인
		Customer customer = customerService.loginCustomer(id, password);
		
		if(customer != null) {
			// 세션에 저장
			HttpSession session = request.getSession(true);
			session.setAttribute("loginCustomer", customer);
			return "customer/selectCancerInsurance";
		}else return "login/selectUserType";
	}
}
