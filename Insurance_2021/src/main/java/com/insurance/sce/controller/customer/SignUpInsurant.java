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
import com.insurance.sce.service.InsuranceServiceImpl;
import com.insurance.sce.service.InsurantServiceImpl;

@Controller
@RequestMapping(value = "/")
public class SignUpInsurant {
	
	private static final Logger logger = LoggerFactory.getLogger(SelectTripInsuranceController.class);
	
	@Autowired
	InsuranceServiceImpl insuranceService;
	@Autowired
	InsurantServiceImpl insurantService;
	
	String insuranceId = "";
	String insuranceType = "";
	
	@RequestMapping(value="signUpInsurant", method=RequestMethod.GET)
	public String response5(Locale locale, Model model, HttpServletRequest request, String insuranceId, String insuranceType) {
		HttpSession session = request.getSession(true);
		Customer customer = (Customer) session.getAttribute("loginCustomer");
		
		this.insuranceId = insuranceId;
		this.insuranceType = insuranceType;
		
		model.addAttribute("insuranceId", insuranceId);
		return "customer/signUpInsurant";
	}
	
	@RequestMapping(value="signUpInsurantType", method=RequestMethod.GET)
	public String response(Locale locale, Model model, HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		Customer customer = (Customer) session.getAttribute("loginCustomer");

		// insurant의 입력값을 view로부터 받아옴
		Map<String, Object> map = new HashMap<>();
		map.put("customerId", customer.getCustomerId());
		map.put("insurantName", request.getParameter("insurantName"));
		map.put("insurantAge", Integer.parseInt(request.getParameter("insurantAge")));
		map.put("insurantAddress", request.getParameter("insurantAddress"));
		map.put("insurantPhoneNumber1", request.getParameter("insurantPhoneNumber1"));
		map.put("insurantPhoneNumber2", request.getParameter("insurantPhoneNumber2"));
		map.put("insurantPhoneNumber3", request.getParameter("insurantPhoneNumber3"));
		map.put("jobRadio", (String) request.getParameter("jobRadio"));
		
		// 받아온 정보를 insurant 객체에 주입 후 세션 전송
		Insurant insurant = insurantService.setInsurantBasic(map);
		session.setAttribute("insurantBasic", insurant);
		
		// 보험 종류에 따라 화면을 띄움
		model.addAttribute("insuranceId", insuranceId);
		return "redirect:/signUpInsurant" + insuranceType;
	}
}
