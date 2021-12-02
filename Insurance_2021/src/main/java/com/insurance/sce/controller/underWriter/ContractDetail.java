package com.insurance.sce.controller.underWriter;

import java.util.Locale;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.insurance.sce.model.contract.Contract;
import com.insurance.sce.model.customer.Insurant;
import com.insurance.sce.model.employee.Employee;
import com.insurance.sce.model.insurance.CancerInsurance;
import com.insurance.sce.model.insurance.Insurance;
import com.insurance.sce.service.UnderWriterService;

@Controller
@RequestMapping(value = "/")
public class ContractDetail {
	
	@Autowired
	UnderWriterService underWriterService;
	
	@RequestMapping(value="contractDetail", method=RequestMethod.GET)
	public String cancerResponse(Locale locale, Model model, HttpServletRequest request, String contractId) {
		HttpSession session = request.getSession(true);
		Contract contract = (Contract)underWriterService.getContract(contractId);
		model.addAttribute("seletedContract", contract);
		Insurance insurance = underWriterService.getInsurace(contract.getInsuranceId());
		Insurant insurant = (Insurant)underWriterService.getInsurant(contract.getInsurantId());
		model.addAttribute("seletedInsurant", insurant);
		underWriterService.calculateFee(contract, insurance, insurant);
		return "underWriter/"+underWriterService.selectInsuranceType(insurance.getEType());
	}
}
