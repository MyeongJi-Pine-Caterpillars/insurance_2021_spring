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
import org.springframework.web.servlet.ModelAndView;

import com.insurance.sce.model.customer.Customer;
import com.insurance.sce.model.insurance.DriverInsurance;
import com.insurance.sce.model.insurance.GuaranteePlan;
import com.insurance.sce.service.insurance.InsuranceService;
import com.insurance.sce.service.insurance.InsuranceServiceImpl;

@Controller
@RequestMapping(value = "/")
public class SelectDriverInsuranceController {
	
	private static final Logger logger = LoggerFactory.getLogger(SelectDriverInsuranceController.class);
	private List<DriverInsurance> insuranceList;
	
	@Autowired
	InsuranceService insuranceService;
	
	@RequestMapping(value="driverInsurance", method=RequestMethod.GET)
	public String response5(Locale locale, Model model, HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		
		Customer customer = (Customer)session.getAttribute("loginCustomer");

		insuranceList = insuranceService.selectAllDriverInsurance();
		model.addAttribute("insuranceList", insuranceList);
		model.addAttribute("customerName", customer.getName() );
		return "customer/selectDriverInsurance";
	}

	@RequestMapping(value="selectDriverInsurance/doSelect")
	@ResponseBody
	DriverInsurance doSelect(String insuranceId) {
		return insuranceService.selectDriverInsurance(insuranceList, insuranceId);
	}
	@RequestMapping(value="selectDriverInsurance/doSelectGuaranteePlan")
	@ResponseBody
	List<GuaranteePlan> doSelectGuaranteePlan(String insuranceId) {
		System.out.println(insuranceId);
		return insuranceService.selectGuaranteePlan(insuranceId);
	}

	@RequestMapping(value="selectDriverInsurance/doLogout")
	public String doLogout(HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		session.removeAttribute("loginCustomer");
		return "redirect:/login";
	}
}
