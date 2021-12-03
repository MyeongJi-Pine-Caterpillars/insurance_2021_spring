package com.insurance.sce.controller.insuranceDeveloper;

import java.util.HashMap;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.insurance.sce.global.Constants.eAge;
import com.insurance.sce.global.Constants.eGender;
import com.insurance.sce.global.Constants.eJob;
import com.insurance.sce.model.insurance.Insurance;
import com.insurance.sce.service.InsuranceDeveloperService;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/")
public class DetailInsurance {
	@Autowired
	InsuranceDeveloperService idService;
	private Insurance insurance;
	private String nextUrl;
	
	@RequestMapping(value="detailInsurance", method=RequestMethod.GET)
	public String responseDetailInsurance(Locale locale, Model model, HttpServletRequest request) throws Exception{
		HttpSession session = request.getSession(true);
		this.insurance = (Insurance) session.getAttribute("designedInsurance");
		this.nextUrl = (String)session.getAttribute("insuranceType");
		int i = 1;
		for(eAge e: eAge.values()) model.addAttribute("ageRateName"+i++, e.getName());
		i = 1;
		for(eGender e: eGender.values()) model.addAttribute("genderRateName"+i++, e.getName());
		i = 1;
		for(int k = 1; k < eJob.values().length; k++) model.addAttribute("jobRateName"+i++, eJob.values()[k].getName());
		return "insuranceDeveloper/detailInsurance";
	}
	@RequestMapping(value="goToSpecializeRate", method=RequestMethod.GET)
	public String responseGoToSpecializeRate(Locale locale, Model model, HttpServletRequest request) throws Exception{
		String[] age = {"kidsRate", "teensRate", "twentiesRate", "thirtiesRate", "fourtiesRate", "fiftiesRate", "oldersRate"};
		String[] gender = {"maleRate", "femaleRate"};
		String[] job = {"officeRate", "driverRate", "factoryRate", "studentRate", "teacherRate", "soldierRate", "etcRate"};
		double[] ageRate = new double[age.length];
		double[] genderRate = new double[gender.length];
		double[] jobRate = new double[job.length];
		for(int i = 0; i < age.length; i++) ageRate[i] = Double.parseDouble(request.getParameter(age[i]));
		for(int i = 0; i < gender.length; i++) genderRate[i] = Double.parseDouble(request.getParameter(gender[i]));
		for(int i = 0; i < job.length; i++) jobRate[i] = Double.parseDouble(request.getParameter(job[i]));
		HashMap<String, Object> map = new HashMap<>();
		map.put("name", request.getParameter("insuranceName"));
		map.put("basicFee", Integer.parseInt(request.getParameter("insuranceFee")));
		map.put("specialFee", Integer.parseInt(request.getParameter("insuranceSpecialFee")));
		map.put("warrantyPeriod", Integer.parseInt(request.getParameter("insuranceWarrantyPeriod")));
		map.put("ageRate", ageRate);
		map.put("genderRate", genderRate);
		map.put("jobRate", jobRate);
		
		this.insurance = idService.detailInsurance(insurance, map);
		HttpSession session = request.getSession(true);
		session.setAttribute("detailedInsurance", this.insurance);
		return "redirect:/rate"+this.nextUrl+"Insurance";
	}
}
