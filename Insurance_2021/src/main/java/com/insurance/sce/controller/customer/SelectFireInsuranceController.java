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
import com.insurance.sce.model.insurance.FireInsurance;
import com.insurance.sce.model.insurance.GuaranteePlan;
import com.insurance.sce.service.insurance.InsuranceService;
import com.insurance.sce.service.insurance.InsuranceServiceImpl;

@Controller
@RequestMapping(value = "/")
public class SelectFireInsuranceController {
	
	private static final Logger logger = LoggerFactory.getLogger(SelectFireInsuranceController.class);
	private List<FireInsurance> insuranceList;
	
	@Autowired
	InsuranceService insuranceService;
	
	@RequestMapping(value="fireInsurance", method=RequestMethod.GET)
	public String response5(Locale locale, Model model, HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		
		Customer customer = (Customer)session.getAttribute("loginCustomer");

		insuranceList = insuranceService.selectAllFireInsurance();
		model.addAttribute("insuranceList", insuranceList);
		model.addAttribute("customerName", customer.getName() );
		return "customer/selectFireInsurance";
	}

	@RequestMapping(value="selectFireInsurance/doSelect")
	@ResponseBody
	FireInsurance doSelect(String insuranceId) {
		return insuranceService.selectFireInsurance(insuranceList, insuranceId);
	}
	@RequestMapping(value="selectFireInsurance/doSelectGuaranteePlan")
	@ResponseBody
	List<GuaranteePlan> doSelectGuaranteePlan(String insuranceId) {
		System.out.println(insuranceId);
		return insuranceService.selectGuaranteePlan(insuranceId);
	}

	@RequestMapping(value="selectFireInsurance/doLogout")
	public String doLogout(HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		session.removeAttribute("loginCustomer");
		return "redirect:/login";
	}
}
