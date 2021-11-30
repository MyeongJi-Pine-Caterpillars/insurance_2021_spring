package com.insurance.sce.controller.insuranceDeveloper;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.insurance.sce.model.insurance.Insurance;
import com.insurance.sce.service.InsuranceDeveloperService;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/")
public class RateDentalInsurance {
	@Autowired
	InsuranceDeveloperService idService;
	private Insurance insurance;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	@RequestMapping(value="rateDentalInsurance", method=RequestMethod.GET)
	public String responseRateDentalInsurance(Locale locale, Model model, HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		this.insurance = (Insurance) session.getAttribute("detailedInsurance");
		return "insuranceDeveloper/rateDentalInsurance";
	}
	@RequestMapping(value="goToGuaranteeDentalInsurance", method=RequestMethod.GET)
	public String responseGoToGuaranteeDentalInsurance(Locale locale, Model model, HttpServletRequest request) throws Exception{
		int annualCount = Integer.parseInt(request.getParameter("annualCount"));
		this.insurance = idService.setDentalRate(insurance, annualCount);
		HttpSession session = request.getSession(true);
		session.setAttribute("ratedInsurance", this.insurance);
		return"redirect:/guaranteeDentalInsurance";
	}

}
