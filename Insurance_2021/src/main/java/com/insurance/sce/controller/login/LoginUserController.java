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
@RequestMapping(value="/")
public class LoginUserController {
	@Autowired
	CustomerService customerService;
	
	@RequestMapping(value="loginUser", method=RequestMethod.GET)
	public String userLogin() {
		return "login/loginUser";
	}
	@RequestMapping(value="loginUser/doLogin", method=RequestMethod.GET)
	public String loginCheck(String id, String password, HttpServletRequest request) {
		// 서비스를 통해 로그인
		Customer customer = customerService.loginCustomer(id, password);
		
		if(customer != null) {
			// 세션에 저장
			HttpSession session = request.getSession(true);
			session.setAttribute("loginCustomer", customer);
			return "redirect:/cancerInsurance";
		}else return "login/loginUser";
	}
}
