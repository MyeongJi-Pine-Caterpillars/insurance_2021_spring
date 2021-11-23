package com.insurance.sce.controller.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SelectUserTypeController {
	@RequestMapping(value="/loginUser", method=RequestMethod.GET)
	public String loginUser() {
		return "login/loginUser";
	}
	@RequestMapping(value="/loginEmployee", method=RequestMethod.GET)
	public String loginEmployee() {
		return "login/loginEmployee";
	}
}
