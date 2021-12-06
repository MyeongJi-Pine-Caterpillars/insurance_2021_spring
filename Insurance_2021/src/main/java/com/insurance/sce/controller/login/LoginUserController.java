package com.insurance.sce.controller.login;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.insurance.sce.model.customer.Customer;
import com.insurance.sce.service.customer.CustomerService;
import com.insurance.sce.service.employee.EmployeeService;

@Controller
@RequestMapping(value="/")
public class LoginUserController {
	@Autowired
	CustomerService customerService;
	@Autowired
	EmployeeService employeeService;
	
	@RequestMapping(value="login", method=RequestMethod.GET)
	public String userLogin() {
		return "login/login";
	}
	@RequestMapping(value="doLogin", method=RequestMethod.GET)
	public String loginCheck(String id, String password, HttpServletRequest request) {
		// 서비스를 통해 로그인
		Customer customer = customerService.loginCustomer(id, password);
		
		if(customer != null) {
			// 세션에 저장
			HttpSession session = request.getSession(true);
			session.setAttribute("loginCustomer", customer);
			return "redirect:/cancerInsurance";
		}else return "login/login";
	}
	
	@RequestMapping(value="doLoginEmployee", method=RequestMethod.GET)
	public String loginEmployeeCheck(String id, String password, HttpServletRequest request) {
		// 서비스를 통해 로그인
		Map<String, Object> map = employeeService.loginEmployee(id, password);
		
		if(map == null) {
			return "login/login";
		}
		if(map.get("employee") != null) {
			// 세션에 저장
			HttpSession session = request.getSession(true);
			session.setAttribute("loginEmployee", map.get("employee"));
			return (String) map.get("employeeRole");
		}else return "login/login";
	}
}
