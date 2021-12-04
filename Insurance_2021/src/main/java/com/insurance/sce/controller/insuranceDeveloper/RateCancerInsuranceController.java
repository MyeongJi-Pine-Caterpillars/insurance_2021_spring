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

import com.insurance.sce.global.Constants.eFamilyMedicalDisease;
import com.insurance.sce.global.Constants.eFamilyMedicalRelationship;
import com.insurance.sce.global.Constants.eTypeOfCar;
import com.insurance.sce.model.insurance.Insurance;
import com.insurance.sce.service.InsuranceDeveloperService;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/")
public class RateCancerInsuranceController {
	@Autowired
	InsuranceDeveloperService idService;
	private Insurance insurance;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	@RequestMapping(value="rateCancerInsurance", method=RequestMethod.GET)
	public String responseRateCancerInsurance(Locale locale, Model model, HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		this.insurance = (Insurance) session.getAttribute("detailedInsurance");
		int i = 1;
		for(int k = 1; k < eFamilyMedicalDisease.values().length; k++) {
			model.addAttribute("familyDiseaseRateName"+i, eFamilyMedicalDisease.values()[k].getName());
			i++;
		}
		i = 1;
		for(int k = 1; k < eFamilyMedicalRelationship.values().length; k++) {
			model.addAttribute("familyRelationRateName"+i, eFamilyMedicalRelationship.values()[k].getName());
			i++;
		}
		return "insuranceDeveloper/rateCancerInsurance";
	}
	@RequestMapping(value="goToGuaranteeCancerInsurance", method=RequestMethod.GET)
	public String responseGoToGuaranteeCancerInsurance(Locale locale, Model model, HttpServletRequest request) throws Exception{
		String[] familyMeical = {"thyroidRate", "testicularRate", "ovarianRate", "esophagealRate", "lungRate"};
		String[] familyRelationship = {"oneRelRate", "twoRelRate", "threeRelRate", "fourRelRate"};
		double[] familyMeicalRate = new double[familyMeical.length];
		double[] familyRelationshipRate = new double[familyRelationship.length];
		for(int i = 0; i < familyMeical.length; i++) {
			familyMeicalRate[i] = Double.parseDouble(request.getParameter(familyMeical[i]));
		}
		for(int i = 0; i < familyRelationship.length; i++) {
			familyRelationshipRate[i] = Double.parseDouble(request.getParameter(familyRelationship[i]));
		}
		
		this.insurance = idService.setCancerRate(this.insurance, familyMeicalRate, familyRelationshipRate);
		HttpSession session = request.getSession(true);
		session.setAttribute("ratedInsurance", this.insurance);
		return "redirect:/guaranteeCancerInsurance";
	}

}
