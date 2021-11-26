package com.insurance.sce.controller.login;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.insurance.sce.service.EmployeeService;

@Controller
@RequestMapping(value="/")
public class LoginEmployee {
	@Autowired
	EmployeeService employeeService;
	
	@RequestMapping(value="loginEmployee", method=RequestMethod.GET)
	public String userLogin() {
		return "login/loginEmployee";
	}
	@RequestMapping(value="loginEmployee/doLogin", method=RequestMethod.GET)
	public String loginCheck(String id, String password, HttpServletRequest request) {
		// 서비스를 통해 로그인
		Map<String, Object> map = employeeService.loginEmployee(id, password);
		
		if(map.get("employee") != null) {
			// 세션에 저장
			HttpSession session = request.getSession(true);
			session.setAttribute("loginCustomer", map.get("employee"));
			return (String) map.get("employeeRole");
		}else return "login/loginEmployee";
	}
}
