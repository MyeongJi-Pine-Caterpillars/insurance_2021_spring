package com.insurance.sce.controller.customer;

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
import com.insurance.sce.model.insurance.Insurance;
import com.insurance.sce.service.InsuranceService;
import com.insurance.sce.service.InsuranceServiceImpl;

@Controller
@RequestMapping(value = "/")
public class SignUpInsurantCancer {
	
	private static final Logger logger = LoggerFactory.getLogger(SelectTripInsuranceController.class);
	String insuranceId = "";
	int insuranceType = 0;
	@Autowired
	InsuranceServiceImpl insuranceService;
	
	@RequestMapping(value="signUpInsurantCancer", method=RequestMethod.GET)
	public String response(Locale locale, Model model, HttpServletRequest request, String insuranceId, String insuranceType) {
		HttpSession session = request.getSession(true);
		Customer customer = (Customer) session.getAttribute("loginCustomer");
		
		this.insuranceId = insuranceId;
		this.insuranceType = Integer.parseInt(insuranceType);
		
		model.addAttribute("insuranceId", insuranceId);
		return "customer/signUpInsurant";
	}
}
