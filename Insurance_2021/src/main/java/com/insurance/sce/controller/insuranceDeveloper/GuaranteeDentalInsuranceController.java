package com.insurance.sce.controller.insuranceDeveloper;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.insurance.sce.global.Constants;
import com.insurance.sce.model.employee.Employee;
import com.insurance.sce.model.insurance.Insurance;
import com.insurance.sce.service.employee.InsuranceDeveloperService;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/")
public class GuaranteeDentalInsuranceController {
	@Autowired
	InsuranceDeveloperService idService;
	private Insurance insurance;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	@RequestMapping(value="guaranteeDentalInsurance", method=RequestMethod.GET)
	public String responseGuaranteeDentalInsurance(Locale locale, Model model, HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		Employee uw = (Employee)session.getAttribute("loginEmployee");
		model.addAttribute("employeeName", uw.getName());
		this.insurance = (Insurance) session.getAttribute("ratedInsurance");
		int i = 1;
		for(String e: Constants.dentalGuarantee) {
			model.addAttribute("dentalGuarantee"+i, e);
			i++;
		}
		return "insuranceDeveloper/guaranteeDentalInsurance";
	}
	@RequestMapping(value="checkDentalInsurance", method=RequestMethod.GET)
	public String responseCheck(Locale locale, Model model, HttpServletRequest request) throws Exception{
		String[] selectedGuarantee = request.getParameterValues("guaranteeCheckbox");
		String[] selectedSpecial = request.getParameterValues("specialCheckbox");
		if(selectedSpecial == null) selectedSpecial = new String[0];
		String[] tmpCompensation = request.getParameterValues("compensation");
		int[] compensation = new int[selectedGuarantee.length];
		int i = 0;
		for(String comp: tmpCompensation) {
			if(!comp.equals("")) {
				compensation[i++] = Integer.parseInt(comp);
			}
		}
		idService.finishInsurance(insurance, selectedGuarantee, selectedSpecial, compensation);
		return "redirect:/developInsurance";
	}
	@RequestMapping(value="guaranteeDentalInsurance/doLogout")
	public String doLogout(HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		session.removeAttribute("loginEmployee");
		return "redirect:/login";
	}
}
