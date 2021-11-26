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

import com.insurance.sce.global.Constants.eFamilyMedicalDisease;
import com.insurance.sce.global.Constants.eFamilyMedicalRelationship;
import com.insurance.sce.model.insurance.Insurance;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/")
public class RateCancerInsurance {
	private static final Logger logger = LoggerFactory.getLogger(DetailInsurance.class);
	private Insurance insurance;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	@RequestMapping(value="RateCancerInsurance", method=RequestMethod.GET)
	public String response4(Locale locale, Model model, HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		this.insurance = (Insurance) session.getAttribute("detailedInsurance");
		for(eFamilyMedicalDisease e: eFamilyMedicalDisease.values()) {
			model.addAttribute(e.getName(), e.getName());
		}
		for(eFamilyMedicalRelationship e: eFamilyMedicalRelationship.values()) {
			model.addAttribute(e.getName(), e.getName());
		}
		return "insuranceDeveloper/rateCancerInsurance";
	}

}
