package com.insurance.sce.controller.insuranceDeveloper;

import java.util.HashMap;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/")
public class DevelopInsurance {
	
	private static final Logger logger = LoggerFactory.getLogger(DevelopInsurance.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	@RequestMapping(value="developInsurance", method=RequestMethod.GET)
	public String response4(Locale locale, Model model, HttpServletRequest request) {

		return "insuranceDeveloper/developInsurance";
	}
	
	@RequestMapping(value="clickNextBtn", method=RequestMethod.GET)
	public String response5(@RequestParam(value="genderCheckbox") HashMap<String, Object> commandMap) {
		String[] checkedGenders = null;
		String checkGender = commandMap.get("arrayParam").toString();
		checkedGenders = checkGender.split(",");
//		, @RequestParam(value="insuranceRadio", defaultValue="insuranceRadio4", required=false) String k
//		System.out.println(k);
		for(String a: checkedGenders) {
			System.out.println(a);
		}
		
		return "insuranceDeveloper/developInsurance";
	}
}
