package com.insurance.sce.controller.customer;

import java.util.List;
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
import org.springframework.web.bind.annotation.ResponseBody;

import com.insurance.sce.model.customer.Customer;
import com.insurance.sce.model.customer.Insurant;
import com.insurance.sce.model.insurance.CancerInsurance;
import com.insurance.sce.model.insurance.GuaranteePlan;
import com.insurance.sce.service.contract.ContractService;
import com.insurance.sce.service.insurance.InsuranceService;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/")
public class RegisterAccidentController {
	
	private static final Logger logger = LoggerFactory.getLogger(MyPageController.class);
	List<GuaranteePlan> guaranteePlanList;
	
	@Autowired
	InsuranceService insuranceService;
	
	
	@RequestMapping(value="registerAccident", method=RequestMethod.GET)
	public String response4(Locale locale, Model model, HttpServletRequest request, String contractId, String insuranceId, String type) {
		HttpSession session = request.getSession(true);
		
		Customer customer = (Customer) session.getAttribute("loginCustomer");
		
		guaranteePlanList =  insuranceService.selectGuaranteePlan(insuranceId);
		System.out.println(type);
		
		model.addAttribute("guaranteePlanList", guaranteePlanList );
		model.addAttribute("type", type );
		model.addAttribute("customerName", customer.getName() );
		return "customer/registerAccident";
	}
	
	
	@RequestMapping(value="registerAccident/doLogout")
	public String doLogout(HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		session.removeAttribute("loginCustomer");
		return "redirect:/login";
	}
}
