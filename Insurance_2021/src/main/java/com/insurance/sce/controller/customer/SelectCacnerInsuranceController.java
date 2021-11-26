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
import com.insurance.sce.model.insurance.Insurance;
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
//	InsuranceDAO insuranceDAO;
//	GuaranteePlanDAO guaranteePlanDAO;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	@RequestMapping(value="cancerInsurance", method=RequestMethod.GET)
	public String response(Locale locale, Model model, HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		
		Customer customer = (Customer)session.getAttribute("loginCustomer");
		

		model.addAttribute("customerName", customer.getName() );
		return "customer/selectCancerInsurance";
	}
	
	@RequestMapping(value="selectCancerInsurance/doSelectAll")
	@ResponseBody
	List<CancerInsurance> doSelectAll() {
		return insuranceService.selectAll();
	}
	
	@RequestMapping(value="selectCancerInsurance/doLogout")
	public String doLogout(HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		session.removeAttribute("loginCustomer");
		return "redirect:/loginUser";
	}
}
