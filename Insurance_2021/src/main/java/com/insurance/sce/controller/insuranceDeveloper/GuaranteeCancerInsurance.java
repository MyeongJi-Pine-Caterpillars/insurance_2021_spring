package com.insurance.sce.controller.insuranceDeveloper;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.insurance.sce.global.Constants;
import com.insurance.sce.model.insurance.Insurance;
import com.insurance.sce.service.InsuranceDeveloperService;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/")
public class GuaranteeCancerInsurance {
	@Autowired
	InsuranceDeveloperService idService;
	private Insurance insurance;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	@RequestMapping(value="guaranteeCancerInsurance", method=RequestMethod.GET)
	public String responseGuaranteeCancerInsurance(Locale locale, Model model, HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		this.insurance = (Insurance) session.getAttribute("ratedInsurance");
		int i = 1;
		for(String e: Constants.cancerGuarantee) {
			model.addAttribute("cancerGuarantee"+i, e);
			i++;
		}
		return "insuranceDeveloper/guaranteeCancerInsurance";
	}
	@RequestMapping(value="checkCancerInsurance", method=RequestMethod.GET)
	public String responseCheck(Locale locale, Model model, HttpServletRequest request) throws Exception{
		String[] selectedGuarantee = request.getParameterValues("guaranteeCheckbox");
		String[] selectedSpecial = request.getParameterValues("specialCheckbox");
		if(selectedSpecial == null) selectedSpecial = new String[0];
		String[] tmpCompensation = request.getParameterValues("compensation");
		int[] compensation = new int[selectedGuarantee.length];
		int i = 0;
		for(String comp: tmpCompensation) {
			if(!comp.equals("")) {
				compensation[i++] = Integer.parseInt(comp);
			}
		}
		this.insurance = idService.setGuarantee(insurance, selectedGuarantee, selectedSpecial, compensation);
		idService.finishInsurance(this.insurance);
		return "redirect:/developInsurance";
	}

}
