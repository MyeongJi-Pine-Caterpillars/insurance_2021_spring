
package com.insurance.sce.controller.insuranceDeveloper;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.insurance.sce.service.insurance.InsuranceService;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/")
public class PostManageInsuranceController {
	@Autowired
	InsuranceService insuranceService;
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	@RequestMapping(value="postManageInsurance", method=RequestMethod.GET)
	public String responsePostManageInsurance(Locale locale, Model model, HttpServletRequest request) {
		model.addAttribute("insuranceList", insuranceService.selectAllInsurance());
		return "insuranceDeveloper/postManageInsurance";
	}
}
