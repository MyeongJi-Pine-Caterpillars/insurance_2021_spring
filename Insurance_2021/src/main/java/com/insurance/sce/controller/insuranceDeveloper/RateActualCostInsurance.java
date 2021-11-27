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
public class RateActualCostInsurance {
	private Insurance insurance;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	@RequestMapping(value="rateActualCostInsurance", method=RequestMethod.GET)
	public String responseRateActualCostInsurance(Locale locale, Model model, HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		this.insurance = (Insurance) session.getAttribute("detailedInsurance");
		return "insuranceDeveloper/rateActualCostInsurance";
	}
	@RequestMapping(value="goToGuaranteeActualCostInsurance", method=RequestMethod.GET)
	public String responseGoToGuaranteeActualCostInsurance(Locale locale, Model model, HttpServletRequest request) throws Exception{
		double selfBurdenRate = Double.parseDouble(request.getParameter("selfBurdenRate"));
		
		InsuranceDeveloperService idService = new InsuranceDeveloperService();
		this.insurance = idService.setActualCostRate(insurance, selfBurdenRate);
		HttpSession session = request.getSession(true);
		session.setAttribute("ratedInsurance", this.insurance);
		String nextViewUrl = "";
		switch(this.insurance.getType()) {
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
