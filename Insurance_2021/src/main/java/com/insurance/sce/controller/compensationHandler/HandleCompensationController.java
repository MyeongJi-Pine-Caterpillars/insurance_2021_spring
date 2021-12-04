package com.insurance.sce.controller.compensationHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.insurance.sce.model.contract.Accident;
import com.insurance.sce.model.contract.Contract;
import com.insurance.sce.model.customer.Insurant;
import com.insurance.sce.service.AccidentService;
import com.insurance.sce.service.CompensationHandlerService;
import com.insurance.sce.service.ContractService;
import com.insurance.sce.service.InsurantService;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/")
public class HandleCompensationController {
	@Autowired
	AccidentService accidentService;
	@Autowired
	ContractService contractService;
	@Autowired
	InsurantService insurantService;
	@Autowired 
	CompensationHandlerService compensationHandlerService;
	ArrayList<Contract> contractList;
	ArrayList<Accident> accidentList;
	@RequestMapping(value="handleCompensation", method=RequestMethod.GET)
	public String responseHandleCompensation(Locale locale, Model model, HttpServletRequest request) {
		this.contractList = (ArrayList<Contract>) contractService.selectAllContract();
		this.accidentList = (ArrayList<Accident>) accidentService.selectAllAccident();
		model.addAttribute("accidentList", this.accidentList);
		model.addAttribute("contractList", this.contractList);
		return "compensationHandler/handleCompensation";
	}
	@RequestMapping(value="handleCompensation/compensate", method=RequestMethod.GET)
	public String responseConfirmInsurance(Locale locale, Model model, HttpServletRequest request) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("fee", Integer.parseInt(request.getParameter("fee")));
		map.put("compensation", Integer.parseInt(request.getParameter("compensation")));
		map.put("compensationCause", (String)request.getParameter("compensationCause"));
		map.put("contractId", (String)request.getParameter("contractId"));
		map.put("accidentId", (String)request.getParameter("accidentId"));
		compensationHandlerService.compensate(map);
		return "redirect:/handleCompensation";
	}
	
	@RequestMapping(value="handleCompensation/doSelect")
	@ResponseBody
	Insurant doSelect(String contractId) {
		String insurantId = "";
		for(Contract contract: this.contractList) {
			if(contract.getContractId().equals(contractId)) insurantId = contract.getInsurantId();
		}
		return insurantService.selectInsurant(insurantId);
	}
	@RequestMapping(value="handleCompensation/doSelectCompensationCause")
	@ResponseBody
	ArrayList<Accident> doSelectCompensationCause(String contractId) {
		return compensationHandlerService.selectAccidentByInsurant(this.accidentList, contractId);
	}
}
/*  */
