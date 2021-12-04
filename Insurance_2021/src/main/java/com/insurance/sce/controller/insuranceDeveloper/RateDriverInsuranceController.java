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
import com.insurance.sce.global.Constants.eRankOfCar;
import com.insurance.sce.global.Constants.eTypeOfCar;
import com.insurance.sce.model.insurance.Insurance;
import com.insurance.sce.service.InsuranceDeveloperService;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/")
public class RateDriverInsuranceController {
	@Autowired
	InsuranceDeveloperService idService;
	private Insurance insurance;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	@RequestMapping(value="rateDriverInsurance", method=RequestMethod.GET)
	public String responseRateDriverInsurance(Locale locale, Model model, HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		this.insurance = (Insurance) session.getAttribute("detailedInsurance");
		int i = 1;
		for(int k = 1; k < eTypeOfCar.values().length; k++) {
			model.addAttribute("typeOfCarRateName"+i, eTypeOfCar.values()[k].getName());
			i++;
		}
		i = 1;
		for(int k = 1; k < eRankOfCar.values().length; k++) {
			model.addAttribute("rankOfCarRateName"+i, eRankOfCar.values()[k].getName());
			i++;
		}
		i = 1;
		for(String e: Constants.accidentHistory) {
			model.addAttribute("accidentHistoryRateName"+i, e);
			i++;
		}
		return "insuranceDeveloper/rateDriverInsurance";
	}
	@RequestMapping(value="goToGuaranteeDriverInsurance", method=RequestMethod.GET)
	public String responseGoTOGuaranteeDriverInsurance(Locale locale, Model model, HttpServletRequest request) throws Exception{
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
		
		this.insurance = idService.setDriverRate(this.insurance, typeOfCarRate, rankOfCarRate, accidentHistoryRate);
		HttpSession session = request.getSession(true);
		session.setAttribute("ratedInsurance", this.insurance);
		return "redirect:/guaranteeDriverInsurance";
	}

}
