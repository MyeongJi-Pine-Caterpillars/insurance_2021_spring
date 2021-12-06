package com.insurance.sce.controller.insuranceDeveloper;

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

import com.insurance.sce.global.Constants;
import com.insurance.sce.global.Constants.eRiskOfTripCountry;
import com.insurance.sce.model.employee.Employee;
import com.insurance.sce.model.insurance.Insurance;
import com.insurance.sce.service.employee.InsuranceDeveloperService;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/")
public class RateActualCostInsuranceController {
	@Autowired
	InsuranceDeveloperService idService;
	private Insurance insurance;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	@RequestMapping(value="rateActualCostInsurance", method=RequestMethod.GET)
	public String responseRateActualCostInsurance(Locale locale, Model model, HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		Employee uw = (Employee)session.getAttribute("loginEmployee");
		model.addAttribute("employeeName", uw.getName());
		this.insurance = (Insurance) session.getAttribute("detailedInsurance");
		return "insuranceDeveloper/rateActualCostInsurance";
	}
	@RequestMapping(value="goToGuaranteeActualCostInsurance", method=RequestMethod.GET)
	public String responseGoToGuaranteeActualCostInsurance(Locale locale, Model model, HttpServletRequest request) throws Exception{
		double selfBurdenRate = Double.parseDouble(request.getParameter("selfBurdenRate"));
		this.insurance = idService.setActualCostRate(insurance, selfBurdenRate);
		idService.insertInsurance(this.insurance);
		return "redirect:/developInsurance";
	}
	@RequestMapping(value="rateActualCostInsurance/doLogout")
	public String doLogout(HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		session.removeAttribute("loginEmployee");
		return "redirect:/login";
	}
}
