package com.insurance.sce.controller.salesperson;

import java.util.List;
import java.util.Locale;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.insurance.sce.model.employee.Employee;
import com.insurance.sce.model.insurance.Insurance;
import com.insurance.sce.service.SalespersonService;

@Controller
@RequestMapping(value = "/")
public class SalespersonController {
	@Autowired
	SalespersonService salepersonService;
	
	@RequestMapping(value="salesperson", method=RequestMethod.GET)
	public String salespersonView(Locale locale, Model model, HttpServletRequest request, String contractId) {
		HttpSession session = request.getSession(true);
		Employee uw = (Employee)session.getAttribute("loginEmployee");
		model.addAttribute("employeeName", uw.getName());
		return "salesperson/salesperson";
	}
	
	@RequestMapping(value="insuranceTable", method=RequestMethod.GET)
	public String insuranceTable(Locale locale, Model model, HttpServletRequest request, int insuranceType) {
		HttpSession session = request.getSession(true);
		Employee uw = (Employee)session.getAttribute("loginEmployee");
		model.addAttribute("employeeName", uw.getName());
		List<Insurance> list = salepersonService.selectInsuranceList(insuranceType);
		model.addAttribute("insuranceList", list);
		return "salesperson/insuranceTable";
	}
	
	@RequestMapping(value="insuranceDetail", method=RequestMethod.GET)
	public String insuranceDetail(Locale locale, Model model, HttpServletRequest request, String insuranceId) {
		HttpSession session = request.getSession(true);
		Employee uw = (Employee)session.getAttribute("loginEmployee");
		model.addAttribute("employeeName", uw.getName());
		
		return "login/loginEmployee";
	}
}
