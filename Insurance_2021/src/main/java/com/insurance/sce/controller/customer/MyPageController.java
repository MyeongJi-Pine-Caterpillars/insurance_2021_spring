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
public class MyPageController {
	
	private static final Logger logger = LoggerFactory.getLogger(MyPageController.class);
	List<Map<String, Object>> mapList;
	
	@Autowired
	ContractService contractService;
	@Autowired
	InsuranceService insuranceService;
	
	
	@RequestMapping(value="myPage", method=RequestMethod.GET)
	public String response4(Locale locale, Model model, HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		
		Customer customer = (Customer) session.getAttribute("loginCustomer");

		mapList = contractService.selectContractInsurance(customer.getCustomerId());
		model.addAttribute("mapList", mapList);
		model.addAttribute("customerName", customer.getName() );
		return "customer/myPage";
	}
	
	@RequestMapping(value="myPage/doSelectGuaranteePlan")
	@ResponseBody
	List<GuaranteePlan> doSelectGuaranteePlan(String insuranceId) {
		return insuranceService.selectGuaranteePlan(insuranceId);
	}
	
	@RequestMapping(value="myPage/doSelectInsurant")
	@ResponseBody
	Map<String, Object> doSelectInsurant(String contractId) {
		return contractService.getInsurantFromContract(mapList, contractId);
	}
	
	@RequestMapping(value="myPage/doSelectRate")
	@ResponseBody
	double doSelectRate(String insuranceId) {
		System.out.println(insuranceService.getSelfBurdenRate(insuranceId));
		return insuranceService.getSelfBurdenRate(insuranceId);
	}
	
	
	@RequestMapping(value="myPage/doLogout")
	public String doLogout(HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		session.removeAttribute("loginCustomer");
		return "redirect:/loginUser";
	}
}
