package com.insurance.sce.controller.customer;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

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
import com.insurance.sce.model.customer.Insurant;
import com.insurance.sce.service.contract.ContractService;
import com.insurance.sce.service.contract.ContractServiceImpl;

@Controller
@RequestMapping(value = "/")
public class SignUpInsurantTripController {
	
	private static final Logger logger = LoggerFactory.getLogger(SelectTripInsuranceController.class);
	String insuranceId = "";
	String special = "";
	@Autowired
	ContractService contractService;
	
	@RequestMapping(value="signUpInsurantTrip", method=RequestMethod.GET)
	public String response(Locale locale, Model model, HttpServletRequest request, String insuranceId, String special) {
		HttpSession session = request.getSession(true);
		Customer customer = (Customer) session.getAttribute("loginCustomer");
		
		this.insuranceId = insuranceId;
		this.special = special;
		
		model.addAttribute("insuranceId", insuranceId);
		model.addAttribute("customerName", customer.getName() );
		return "customer/signUpInsurantTrip";
	}
	
	@RequestMapping(value="doRegisterTripInsurance", method=RequestMethod.GET)
	public String doSignUp(Locale locale, Model model, HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		
		// 세션으로부터 고객과 피보험자의 정보를 불러옴
		Customer customer = (Customer) session.getAttribute("loginCustomer");
		Insurant insurant = (Insurant) session.getAttribute("insurantBasic");
		
		Map<String, Object> map = new HashMap<>();
		map.put("special", special);
		map.put("insuranceId", insuranceId);
		map.put("customerId", customer.getCustomerId());
		map.put("rateOfCountryRiskRadio", (String) request.getParameter("rateOfCountryRiskRadio"));
		contractService.signUpTripInsurance(map, insurant);
		
		return "redirect:/tripInsurance";
	}

	@RequestMapping(value="signUpInsurantTrip/doLogout")
	public String doLogout(HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		session.removeAttribute("loginCustomer");
		return "redirect:/login";
	}
}
