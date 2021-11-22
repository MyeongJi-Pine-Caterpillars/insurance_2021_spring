package com.insurance.sce.controller.insuranceDeveloper;

import java.awt.Label;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.insurance.sce.model.customer.Customer;

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
		System.out.println("asd");
		return "insuranceDeveloper/developInsurance";
	}
}