package com.insurance.sce.controller.customer;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
public class MyPageController {
	
	private static final Logger logger = LoggerFactory.getLogger(SelectActualInsuranceController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	@RequestMapping(value="myPage", method=RequestMethod.GET)
	public String response4(Locale locale, Model model, HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		
		Customer customer = (Customer) session.getAttribute("loginCustomer");

		model.addAttribute("customerName", customer.getName() );
		return "customer/myPage";
	}
	@RequestMapping(value="myPage/doLogout")
	public String doLogout(HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		session.removeAttribute("loginCustomer");
		return "redirect:/loginUser";
	}
}
