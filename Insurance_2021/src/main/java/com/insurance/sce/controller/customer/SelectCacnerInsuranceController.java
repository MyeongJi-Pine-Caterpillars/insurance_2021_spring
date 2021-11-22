package com.insurance.sce.controller.customer;

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
import org.springframework.web.servlet.ModelAndView;

import com.insurance.sce.dao.AccidentDAO;
import com.insurance.sce.dao.AccidentDAOImpl;
import com.insurance.sce.model.customer.Customer;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/")
public class SelectCacnerInsuranceController {
	
	private static final Logger logger = LoggerFactory.getLogger(SelectCacnerInsuranceController.class);
	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	@RequestMapping(value="cancerInsurance", method=RequestMethod.GET)
	public String response(Locale locale, Model model, HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		
		//임시방편
		Customer tmp = new Customer();
		tmp.setName("홍영석");
		session.setAttribute("loginCustomer", tmp);
		
		Customer customer = (Customer)session.getAttribute("loginCustomer");
		

		model.addAttribute("customerName", customer.getName() );
		return "customer/selectCancerInsurance";
	}
}
