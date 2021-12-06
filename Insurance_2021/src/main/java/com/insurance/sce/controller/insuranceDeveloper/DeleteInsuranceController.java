package com.insurance.sce.controller.insuranceDeveloper;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.insurance.sce.model.employee.Employee;
import com.insurance.sce.model.insurance.GuaranteePlan;
import com.insurance.sce.model.insurance.Insurance;
import com.insurance.sce.service.employee.InsuranceDeveloperService;
import com.insurance.sce.service.insurance.InsuranceService;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/")
public class DeleteInsuranceController {
	@Autowired
	InsuranceDeveloperService insuranceDeveloperService;
	@Autowired
	InsuranceService insuranceService;
	
	@RequestMapping(value="deleteInsurance", method=RequestMethod.GET)
	public String responseDeleteInsurance(Locale locale, Model model, HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		Employee uw = (Employee)session.getAttribute("loginEmployee");
		model.addAttribute("employeeName", uw.getName());
		model.addAttribute("insuranceList", insuranceService.selectAllInsurance());
		return "insuranceDeveloper/deleteInsurance";
	}
	@RequestMapping(value="deleteInsurance/delete", method=RequestMethod.GET)
	public String responseDelete(Locale locale, Model model, HttpServletRequest request) {
		String insuranceId = (String)request.getParameter("deleteInsuranceId");
		insuranceDeveloperService.deleteInsurance(insuranceId);
		return "redirect:/deleteInsurance";
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
		HttpSession session = request.getSession(true);
		session.removeAttribute("loginEmployee");
		return "redirect:/login";
	}
}
/*  */
