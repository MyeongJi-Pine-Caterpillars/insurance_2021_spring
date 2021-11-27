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
import com.insurance.sce.global.Constants.eRankOfCar;
import com.insurance.sce.global.Constants.eTypeOfCar;
import com.insurance.sce.global.Constants.eUsageOfStructure;
import com.insurance.sce.model.insurance.Insurance;
import com.insurance.sce.service.InsuranceDeveloperService;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/")
public class RateFireInsurance {
	private Insurance insurance;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	@RequestMapping(value="rateFireInsurance", method=RequestMethod.GET)
	public String responseRateFireInsurance(Locale locale, Model model, HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		this.insurance = (Insurance) session.getAttribute("detailedInsurance");
		int i = 1;
		for(int k = 1; k < eUsageOfStructure.values().length; k++) {
			model.addAttribute("usageStructureRateName"+i, eUsageOfStructure.values()[k].getName());
			i++;
		}
		i = 1;
		for(String e: Constants.postedPrice) {
			model.addAttribute("postedPriceRateName"+i, e);
			i++;
		}
		return "insuranceDeveloper/rateFireInsurance";
	}
	@RequestMapping(value="goToGuaranteeFireInsurance", method=RequestMethod.GET)
	public String responseGoToGuaranteeFireInsurance(Locale locale, Model model, HttpServletRequest request) throws Exception{
		String[] postedPrice = {"lDotFiveRate", "mDotFivelFiveRate", "mFivelTenRate", "mTenlTwentyRate", "mTwentyRate"};
		String[] usageOfStructure = {"houseRate", "studyRate", "factoryRate", "warehouseRate", "officeRate", "publicFacilityRate"};
		double[] postedPriceRate = new double[postedPrice.length];
		double[] usageOfStructureRate = new double[usageOfStructure.length];
		for(int i = 0; i < postedPrice.length; i++) {
			postedPriceRate[i] = Double.parseDouble(request.getParameter(postedPrice[i]));
		}
		for(int i = 0; i < usageOfStructure.length; i++) {
			usageOfStructureRate[i] = Double.parseDouble(request.getParameter(usageOfStructure[i]));
		}
		
		InsuranceDeveloperService idService = new InsuranceDeveloperService();
		this.insurance = idService.setFireRate(insurance, postedPriceRate, usageOfStructureRate);
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
