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
import com.insurance.sce.model.insurance.ActualCostInsurance;
import com.insurance.sce.model.insurance.GuaranteePlan;
import com.insurance.sce.service.InsuranceService;

@Controller
@RequestMapping(value = "/")
public class SelectActualCostInsuranceController {
	
	private static final Logger logger = LoggerFactory.getLogger(SelectActualCostInsuranceController.class);
	
	@Autowired
	InsuranceService insuranceService;
	
	@RequestMapping(value="actualCostInsurance", method=RequestMethod.GET)
	public String response5(Locale locale, Model model, HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		
		Customer customer = (Customer)session.getAttribute("loginCustomer");

		model.addAttribute("insuranceList", insuranceService.selectAllActualCostInsurance());
		model.addAttribute("clientName", customer.getName() );
		return "customer/selectActualCostInsurance";
	}

	@RequestMapping(value="selectActualCostInsurance/doSelect")
	@ResponseBody
	ActualCostInsurance doSelect(String insuranceId) {
		return insuranceService.selectActualCostInsurance(insuranceId);
	}
	@RequestMapping(value="selectActualCostInsurance/doSelectGuaranteePlan")
	@ResponseBody
	List<GuaranteePlan> doSelectGuaranteePlan(String insuranceId) {
		System.out.println(insuranceId);
		return insuranceService.selectGuaranteePlan(insuranceId);
	}

	@RequestMapping(value="selectActualCostInsurance/doLogout")
	public String doLogout(HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		session.removeAttribute("loginCustomer");
		return "redirect:/loginUser";
	}
}
