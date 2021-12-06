package com.insurance.sce.controller.underWriter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.insurance.sce.controller.customer.SelectCacnerInsuranceController;
import com.insurance.sce.model.contract.Contract;
import com.insurance.sce.model.customer.Insurant;
import com.insurance.sce.model.employee.Employee;
import com.insurance.sce.model.employee.UnderWriter;
import com.insurance.sce.model.insurance.Insurance;
import com.insurance.sce.service.contract.ContractService;
import com.insurance.sce.service.contract.ContractServiceImpl;
import com.insurance.sce.service.customer.InsurantService;
import com.insurance.sce.service.customer.InsurantServiceImpl;
import com.insurance.sce.service.employee.UnderWriterService;
import com.insurance.sce.service.employee.UnderWriterServiceImpl;
import com.insurance.sce.service.insurance.InsuranceService;
import com.insurance.sce.service.insurance.InsuranceServiceImpl;

@Controller
@RequestMapping(value = "/")
public class UnderWriterController {
	
	@Autowired
	UnderWriterService underWriterService;
	
	@RequestMapping(value="underWriter", method=RequestMethod.GET)
	public String underWriterView(Locale locale, Model model, HttpServletRequest request, String contractId) {
		HttpSession session = request.getSession(true);
		Employee uw = (Employee)session.getAttribute("loginEmployee");
		model.addAttribute("employeeName", uw.getName());
		model.addAttribute("mapList", underWriterService.getAllData());
		return "underWriter/underWriter";
	}
	
	@RequestMapping(value="doApprove", method=RequestMethod.GET)
	public String doApprove(Locale locale, Model model, HttpServletRequest request, String contractId) {
		HttpSession session = request.getSession(true);
		underWriterService.approveContract(contractId);
		model.addAttribute("mapList", underWriterService.getAllData());
		return "underWriter/underWriter";
	}
	
	@RequestMapping(value="doDeny", method=RequestMethod.GET)
	public String doDeny(Locale locale, Model model, HttpServletRequest request, String contractId) {
		underWriterService.denyContract(contractId);
		model.addAttribute("mapList", underWriterService.getAllData());
		return "underWriter/underWriterView";
	}
	@RequestMapping(value="doLogout")
	public String doLogout(HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		session.removeAttribute("loginEmployee");
		return "redirect:/login";
	}
}
