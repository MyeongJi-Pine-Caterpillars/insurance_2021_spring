package com.insurance.sce.controller.insuranceDeveloper;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.insurance.sce.model.employee.Employee;
import com.insurance.sce.model.insurance.Insurance;
import com.insurance.sce.service.employee.InsuranceDeveloperService;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/")
public class DevelopInsuranceController {
	@Autowired
	InsuranceDeveloperService idService;
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	@RequestMapping(value="developInsurance", method=RequestMethod.GET)
	public String responseDevelopInsurance(Locale locale, Model model, HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		Employee uw = (Employee)session.getAttribute("loginEmployee");
		model.addAttribute("employeeName", uw.getName());
		return "insuranceDeveloper/developInsurance";
	}

	@RequestMapping(value="goToDetailInsurance", method=RequestMethod.GET)
	public String responseGoToDetailInsurance(Locale locale, Model model, HttpServletRequest request) {
		String insuranceType = (String) request.getParameter("insuranceRadio");
		String[] insuranceGender = request.getParameterValues("genderCheckbox");
		Insurance insurance = idService.designInsurance(insuranceType);
		insurance = idService.setGender(insurance, insuranceGender);
		HttpSession session = request.getSession(true);
		session.setAttribute("designedInsurance", insurance);
		session.setAttribute("insuranceType", insuranceType);
		return "redirect:/detailInsurance";
	}
	@RequestMapping(value="developInsurance/doLogout")
	public String doLogout(HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		session.removeAttribute("loginEmployee");
		return "redirect:/login";
	}
}
