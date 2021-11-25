package com.insurance.sce.controller.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/")
public class SelectUserTypeController {
	@RequestMapping(value="next", method=RequestMethod.GET)
	public String response() {
		return "login/selectUserType";
	}
}
