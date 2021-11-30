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
import com.insurance.sce.service.ContractService;
import com.insurance.sce.service.ContractServiceImpl;
import com.insurance.sce.service.InsuranceService;
import com.insurance.sce.service.InsuranceServiceImpl;
import com.insurance.sce.service.InsurantService;
import com.insurance.sce.service.InsurantServiceImpl;
import com.insurance.sce.service.UnderWriterService;
import com.insurance.sce.service.UnderWriterServiceImpl;

@Controller
@RequestMapping(value = "/")
public class UnderWriterView {
	
	@Autowired
	UnderWriterService underWriterService;
	
	@RequestMapping(value="underWriterView", method=RequestMethod.GET)
	public String underWriterView(Locale locale, Model model, HttpServletRequest request, String contractId) {
		
		HttpSession session = request.getSession(true);
		Employee uw = (Employee)session.getAttribute("loginEmployee");
		model.addAttribute("employeeName", uw.getName());
		
		model.addAttribute("dataList", underWriterService.getContractList());
		
		return "underWriter/underWriterView";
	}
}
