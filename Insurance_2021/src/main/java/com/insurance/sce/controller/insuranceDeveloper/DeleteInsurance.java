package com.insurance.sce.controller.insuranceDeveloper;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.insurance.sce.model.insurance.GuaranteePlan;
import com.insurance.sce.model.insurance.Insurance;
import com.insurance.sce.service.InsuranceConfirmerService;
import com.insurance.sce.service.InsuranceService;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/")
public class DeleteInsurance {
	@Autowired
	InsuranceConfirmerService insuranceConfirmerService;
	@Autowired
	InsuranceService insuranceService;
	
	@RequestMapping(value="deleteInsurance", method=RequestMethod.GET)
	public String responseDeleteInsurance(Locale locale, Model model, HttpServletRequest request) {
		model.addAttribute("insuranceList", insuranceService.selectAllInsurance());
		return "insuranceDeveloper/deleteInsurance";
	}
	@RequestMapping(value="deleteInsurance/delete", method=RequestMethod.GET)
	public String responseConfirmInsurance(Locale locale, Model model, HttpServletRequest request) {
		String insuranceId = (String)request.getParameter("confirmInsuranceId");
		insuranceConfirmerService.confirmInsurance(insuranceId);
		return "redirect:/confirmerView";
	}
	
	@RequestMapping(value="deleteInsurance/doSelect")
	@ResponseBody
	Insurance doSelect(String insuranceId) {
		return insuranceService.selectInsurance(insuranceId);
	}
	@RequestMapping(value="deleteInsurance/doSelectGuaranteePlan")
	@ResponseBody
	List<GuaranteePlan> doSelectGuaranteePlan(String insuranceId) {
		return insuranceService.selectGuaranteePlan(insuranceId);
	}
	
	@RequestMapping(value="deleteInsurance/doLogout")
	public String doLogout(HttpServletRequest request) {
		return "redirect:/loginEmployee";
	}
}
/*  */
