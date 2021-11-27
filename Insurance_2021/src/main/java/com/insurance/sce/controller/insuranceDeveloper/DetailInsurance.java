package com.insurance.sce.controller.insuranceDeveloper;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	private Insurance insurance;
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	@RequestMapping(value="detailInsurance", method=RequestMethod.GET)
	public String responseDetailInsurance(Locale locale, Model model, HttpServletRequest request) throws Exception{
		HttpSession session = request.getSession(true);
		Insurance insurance = (Insurance) session.getAttribute("designedInsurance");
		this.insurance = insurance;
		int i = 1;
		for(eAge e: eAge.values()) {
			model.addAttribute("ageRateName"+i, e.getName());
			i++;
		}
		i = 1;
		for(eGender e: eGender.values()) {
			model.addAttribute("genderRateName"+i, e.getName());
			i++;
		}
		i = 1;
		for(int k = 1; k < eJob.values().length; k++) {
			model.addAttribute("jobRateName"+i, eJob.values()[k].getName());
			i++;
		}
		return "insuranceDeveloper/detailInsurance";
	}
	@RequestMapping(value="goToSpecializeRate", method=RequestMethod.GET)
	public String responseGoToSpecializeRate(Locale locale, Model model, HttpServletRequest request) throws Exception{
		String name = request.getParameter("insuranceName");
		int basicFee = Integer.parseInt(request.getParameter("insuranceFee"));
		int specialFee = Integer.parseInt(request.getParameter("insuranceSpecialFee"));
		int warrantyPeriod = Integer.parseInt(request.getParameter("insuranceWarrantyPeriod"));
		String[] age = {"kidsRate", "teensRate", "twentiesRate", "thirtiesRate", "fourtiesRate", "fiftiesRate", "oldersRate"};
		String[] gender = {"maleRate", "femaleRate"};
		String[] job = {"officeRate", "driverRate", "factoryRate", "studentRate", "teacherRate", "soldierRate", "etcRate"};
		double[] ageRate = new double[age.length];
		double[] genderRate = new double[gender.length];
		double[] jobRate = new double[job.length];
		for(int i = 0; i < age.length; i++) {
			ageRate[i] = Double.parseDouble(request.getParameter(age[i]));
		}
		for(int i = 0; i < gender.length; i++) {
			genderRate[i] = Double.parseDouble(request.getParameter(gender[i]));
		}
		for(int i = 0; i < job.length; i++) {
			jobRate[i] = Double.parseDouble(request.getParameter(job[i]));
		}
		
		InsuranceDeveloperService idService = new InsuranceDeveloperService();
		this.insurance = idService.detailInsurance(insurance, name, basicFee, specialFee, warrantyPeriod, ageRate, genderRate, jobRate);
		HttpSession session = request.getSession(true);
		session.setAttribute("detailedInsurance", this.insurance);
		String nextViewUrl = "";
		switch(this.insurance.getEType()) {
		case driverInsurance:
			nextViewUrl = "redirect:/rateDriverInsurance";
			break;
		case fireInsurance:
			nextViewUrl = "redirect:/rateFireInsurance";
			break;
		case cancerInsurance:
			nextViewUrl = "redirect:/rateCancerInsurance";
			break;
		case actualCostInsurance:
			nextViewUrl = "redirect:/rateActualCostInsurance";
			break;
		case tripInsurance:
			nextViewUrl = "redirect:/rateTripInsurance";
			break;
		case dentalInsurance:
			nextViewUrl = "redirect:/rateDentalInsurance";
			break;
		default:
			nextViewUrl = "redirect:/developInsurance";
			break; 
		}
		return nextViewUrl;
	}
}
