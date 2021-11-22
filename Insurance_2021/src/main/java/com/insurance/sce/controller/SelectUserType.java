package com.insurance.sce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SelectUserType {
	@RequestMapping(value="/LoginUser", method=RequestMethod.GET)
	public String loginUser() {
		return "LoginUser";
	}
	@RequestMapping(value="/LoginEmployee", method=RequestMethod.GET)
	public String loginEmployee() {
		return "LoginEmployee";
	}
}
