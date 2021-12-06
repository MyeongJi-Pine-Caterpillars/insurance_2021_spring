package com.insurance.sce.controller.insuranceDeveloper;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.insurance.sce.global.Constants.eRiskOfTripCountry;
import com.insurance.sce.model.employee.Employee;
import com.insurance.sce.model.insurance.Insurance;
import com.insurance.sce.service.employee.InsuranceDeveloperService;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/")
public class RateTripInsuranceController {
	@Autowired
	InsuranceDeveloperService idService;
	private Insurance insurance;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	@RequestMapping(value="rateTripInsurance", method=RequestMethod.GET)
	public String responseRateTripInsurance(Locale locale, Model model, HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		Employee uw = (Employee)session.getAttribute("loginEmployee");
		model.addAttribute("employeeName", uw.getName());
		this.insurance = (Insurance) session.getAttribute("detailedInsurance");
		int i = 1;
		for(int k = 1; k < eRiskOfTripCountry.values().length; k++) {
			model.addAttribute("riskRateName"+i, eRiskOfTripCountry.values()[k].getName());
			i++;
		}
		return "insuranceDeveloper/rateTripInsurance";
	}
	@RequestMapping(value="goToGuaranteeTripInsurance", method=RequestMethod.GET)
	public String responseGoToGuaranteeTripInsurance(Locale locale, Model model, HttpServletRequest request) throws Exception{
		String[] riskOfTripCountry = {"safeRate", "firstRate", "secondRate", "thirdRate"};
		double[] riskOfTripCountryRate = new double[riskOfTripCountry.length];
		for(int i = 0; i < riskOfTripCountry.length; i++) {
			riskOfTripCountryRate[i] = Double.parseDouble(request.getParameter(riskOfTripCountry[i]));
		}
		
		this.insurance = idService.setTripRate(insurance, riskOfTripCountryRate);
		HttpSession session = request.getSession(true);
		session.setAttribute("ratedInsurance", this.insurance);
		return "redirect:/guaranteeTripInsurance";
	}
	@RequestMapping(value="rateTripInsurance/doLogout")
	public String doLogout(HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		session.removeAttribute("loginEmployee");
		return "redirect:/login";
	}
}
