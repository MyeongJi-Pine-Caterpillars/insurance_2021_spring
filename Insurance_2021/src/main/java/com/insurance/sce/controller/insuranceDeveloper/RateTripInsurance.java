package com.insurance.sce.controller.insuranceDeveloper;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.insurance.sce.global.Constants;
import com.insurance.sce.global.Constants.eRiskOfTripCountry;
import com.insurance.sce.model.insurance.Insurance;
import com.insurance.sce.service.InsuranceDeveloperService;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/")
public class RateTripInsurance {
	private Insurance insurance;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	@RequestMapping(value="rateTripInsurance", method=RequestMethod.GET)
	public String responseRateTripInsurance(Locale locale, Model model, HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		this.insurance = (Insurance) session.getAttribute("detailedInsurance");
		for(eRiskOfTripCountry e: eRiskOfTripCountry.values()) {
			model.addAttribute(e.getName(), e.getName());
		}
		return "insuranceDeveloper/rateTripInsurance";
	}
	@RequestMapping(value="guaranteeTripInsurance", method=RequestMethod.GET)
	public String responseGuaranteeTripInsurance(Locale locale, Model model, HttpServletRequest request) throws Exception{
		String[] riskOfTripCountry = {"safeRate", "firstRate", "secondRate", "thirdRate"};
		double[] riskOfTripCountryRate = new double[riskOfTripCountry.length];
		for(int i = 0; i < riskOfTripCountry.length; i++) {
			riskOfTripCountryRate[i] = Double.parseDouble(request.getParameter(riskOfTripCountry[i]));
		}
		
		InsuranceDeveloperService idService = new InsuranceDeveloperService();
		this.insurance = idService.setTripRate(insurance, riskOfTripCountryRate);
		HttpSession session = request.getSession(true);
		session.setAttribute("ratedInsurance", this.insurance);
		String nextViewUrl = "";
		switch(this.insurance.getEType()) {
		case driverInsurance:
			nextViewUrl = "redirect:/guaranteeDriverInsurance";
			break;
		case fireInsurance:
			nextViewUrl = "redirect:/guaranteeFireInsurance";
			break;
		case cancerInsurance:
			nextViewUrl = "redirect:/guaranteeCancerInsurance";
			break;
		case actualCostInsurance:
			nextViewUrl = "redirect:/guaranteeActualCostInsurance";
			break;
		case tripInsurance:
			nextViewUrl = "redirect:/guaranteeTripInsurance";
			break;
		case dentalInsurance:
			nextViewUrl = "redirect:/guaranteeDentalInsurance";
			break;
		default:
			nextViewUrl = "redirect:/developInsurance";
			break; 
		}
		return nextViewUrl;
	}

}
