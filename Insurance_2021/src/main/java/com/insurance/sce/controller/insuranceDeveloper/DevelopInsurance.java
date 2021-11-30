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
public class DevelopInsurance {
	@Autowired
	InsuranceDeveloperService idService;
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	@RequestMapping(value="developInsurance", method=RequestMethod.GET)
	public String responseDevelopInsurance(Locale locale, Model model, HttpServletRequest request) {

		return "insuranceDeveloper/developInsurance";
	}
	
//	@RequestMapping(value="clickNextBtn", method=RequestMethod.GET)
//	public String response5(@RequestParam(value="genderCheckbox") HashMap<String, Object> commandMap) {
//		String[] checkedGenders = null;
//		String checkGender = commandMap.get("arrayParam").toString();
//		checkedGenders = checkGender.split(",");
//		, @RequestParam(value="insuranceRadio", defaultValue="insuranceRadio4", required=false) String k
//		System.out.println(k);
//		for(String a: checkedGenders) {
//			System.out.println(a);
//		}
//		
//		return "insuranceDeveloper/developInsurance";
//	}
	@RequestMapping(value="goToDetailInsurance", method=RequestMethod.GET)
	public String responseGoToDetailInsurance(Locale locale, Model model, HttpServletRequest request) {
		String insuranceType = (String) request.getParameter("insuranceRadio");
		String[] insuranceGender = request.getParameterValues("genderCheckbox");
		if(insuranceGender == null) {
			System.out.println("Please check the Gender");
			return "redirect:/insuranceDeveloper/developInsurance";
		} else {
			Insurance insurance = idService.designInsurance(insuranceType);
			insurance = idService.setGender(insurance, insuranceGender);
			HttpSession session = request.getSession(true);
			session.setAttribute("designedInsurance", insurance);
			return "redirect:/detailInsurance";
		}
		
	}
}
