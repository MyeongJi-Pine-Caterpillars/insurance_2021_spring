package com.insurance.sce.controller.customer;

import java.util.List;
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
import org.springframework.web.bind.annotation.ResponseBody;

import com.insurance.sce.model.customer.Customer;
import com.insurance.sce.model.insurance.CancerInsurance;
import com.insurance.sce.model.insurance.GuaranteePlan;
import com.insurance.sce.service.InsuranceService;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/")
public class SelectCacnerInsuranceController {
	
	private static final Logger logger = LoggerFactory.getLogger(SelectCacnerInsuranceController.class);
	
	@Autowired
	InsuranceService insuranceService;
	
	@RequestMapping(value="cancerInsurance", method=RequestMethod.GET)
	public String response(Locale locale, Model model, HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		
		Customer customer = (Customer)session.getAttribute("loginCustomer");
		
		model.addAttribute("insuranceList", insuranceService.selectAllCancerInsurance());
		model.addAttribute("customerName", customer.getName() );
		return "customer/selectCancerInsurance";
	}
	
	@RequestMapping(value="selectCancerInsurance/doSelect")
	@ResponseBody
	CancerInsurance doSelect(String insuranceId) {
		return insuranceService.selectCancerInsurance(insuranceId);
	}
	@RequestMapping(value="selectCancerInsurance/doSelectGuaranteePlan")
	@ResponseBody
	List<GuaranteePlan> doSelectGuaranteePlan(String insuranceId) {
		System.out.println(insuranceId);
		return insuranceService.selectGuaranteePlan(insuranceId);
	}
	
	@RequestMapping(value="selectCancerInsurance/doLogout")
	public String doLogout(HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		session.removeAttribute("loginCustomer");
		return "redirect:/loginUser";
	}
}
