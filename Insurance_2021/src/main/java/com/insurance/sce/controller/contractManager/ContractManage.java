package com.insurance.sce.controller.contractManager;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.insurance.sce.model.customer.Customer;
import com.insurance.sce.service.contract.ContractService;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/")

public class ContractManage {
	@Autowired ContractService contractService;
//	private static final Logger logger = LoggerFactory.getLogger(ContractManage.class);
	
	
	@RequestMapping(value="contractManage", method=RequestMethod.GET)
	public String response4(Locale locale, Model model, HttpServletRequest request) {
		model.addAttribute("contractList", contractService.selectAllContract());
		return "contractManager/contractManage";
	}
	@RequestMapping(value="contractManage/doLogout")
	public String doLogout(HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		session.removeAttribute("loginCustomer");
		return "redirect:/loginUser";
	}
}
