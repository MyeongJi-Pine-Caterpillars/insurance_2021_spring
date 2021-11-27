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
import com.insurance.sce.model.insurance.Insurance;
import com.insurance.sce.service.InsuranceDeveloperService;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/")
public class RateDriverInsurance {
	private Insurance insurance;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	@RequestMapping(value="rateDriverInsurance", method=RequestMethod.GET)
	public String responseRateDriverInsurance(Locale locale, Model model, HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		this.insurance = (Insurance) session.getAttribute("detailedInsurance");
		for(eTypeOfCar e: eTypeOfCar.values()) {
			model.addAttribute(e.getName(), e.getName());
		}
		for(eRankOfCar e: eRankOfCar.values()) {
			model.addAttribute(e.getName(), e.getName());
		}
		for(String e: Constants.accidentHistory) {
			model.addAttribute(e, e);
		}
		return "insuranceDeveloper/rateDriverInsurance";
	}
	@RequestMapping(value="guaranteeDriverInsurance", method=RequestMethod.GET)
	public String responseGuaranteeDriverInsurance(Locale locale, Model model, HttpServletRequest request) throws Exception{
		String[] typeOfCar = {"busRate", "vanRate", "suvRate", "foreignRate", "etcRate"};
		String[] rankOfCar = {"luxuryRate", "highRate", "middleRate", "lowRate"};
		String[] accidentHistory = {"zeroCountRate", "oneCountRate", "twoThreeCountRate", "fourFiveCountRate", "sixSevenCountRate", "eightCountRate"};
		double[] typeOfCarRate = new double[typeOfCar.length];
		double[] rankOfCarRate = new double[rankOfCar.length];
		double[] accidentHistoryRate = new double[accidentHistory.length];
		for(int i = 0; i < typeOfCar.length; i++) {
			typeOfCarRate[i] = Double.parseDouble(request.getParameter(typeOfCar[i]));
		}
		for(int i = 0; i < rankOfCar.length; i++) {
			rankOfCarRate[i] = Double.parseDouble(request.getParameter(rankOfCar[i]));
		}
		for(int i = 0; i < accidentHistory.length; i++) {
			accidentHistoryRate[i] = Double.parseDouble(request.getParameter(accidentHistory[i]));
		}
		
		InsuranceDeveloperService idService = new InsuranceDeveloperService();
		this.insurance = idService.setDriverRate(this.insurance, typeOfCarRate, rankOfCarRate, accidentHistoryRate);
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
