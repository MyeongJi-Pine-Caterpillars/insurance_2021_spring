package com.insurance.sce.controller.insuranceConfirmer;

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
public class ConfirmerView {
	@Autowired
	InsuranceConfirmerService insuranceConfirmerService;
	@Autowired
	InsuranceService insuranceService;
	
	@RequestMapping(value="confirmerView", method=RequestMethod.GET)
	public String responseConfirmerView(Locale locale, Model model, HttpServletRequest request) {
		model.addAttribute("insuranceList", insuranceService.selectAllCancerInsurance());
		return "insuranceConfirmer/confirmerView";
	}
	@RequestMapping(value="confirmerView/confirmInsurance", method=RequestMethod.GET)
	public String responseConfirmInsurance(Locale locale, Model model, HttpServletRequest request) {
		model.addAttribute("insuranceList", insuranceService.selectAllCancerInsurance());
		return "redirect:/insuranceConfirmer/confirmerView";
	}
	
	@RequestMapping(value="confirmerView/doSelect")
	@ResponseBody
	Insurance doSelect(String insuranceId) {
		return insuranceConfirmerService.selectInsurance(insuranceId);
	}
	@RequestMapping(value="confirmerView/doSelectGuaranteePlan")
	@ResponseBody
	List<GuaranteePlan> doSelectGuaranteePlan(String insuranceId) {
		return insuranceService.selectGuaranteePlan(insuranceId);
	}
	
	@RequestMapping(value="confirmerView/doLogout")
	public String doLogout(HttpServletRequest request) {
		return "redirect:/loginEmployee";
	}
}
/*  */
