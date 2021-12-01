package com.insurance.sce.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.insurance.sce.dao.InsurantDAO;
import com.insurance.sce.dao.InsurantDAOImpl;
import com.insurance.sce.global.Constants.eJob;
import com.insurance.sce.model.customer.Insurant;
import com.insurance.sce.global.Constants.eJob;;

@Service
public class InsurantServiceImpl implements InsurantService{
	@Autowired
	InsurantDAO insurantDAO = new InsurantDAOImpl();
	
	public Insurant selectInsurant(String insurantID) {
		return insurantDAO.selectInsurant(insurantID);
	}

	public Insurant setInsurantBasic(Map<String, Object> map) {
		String phoneNumber = (String) map.get("insurantPhoneNumber1") + "-" + (String) map.get("insurantPhoneNumber2")
				+ "-" + (String) map.get("insurantPhoneNumber3");
		String job = (String) map.get("jobRadio");
		
		Insurant insurant = new Insurant();
		insurant.setCustomerId((String)map.get("customerId"));
		insurant.setName((String)map.get("insurantName"));
		insurant.setAge((Integer)map.get("insurantAge"));
		insurant.setAddress((String)map.get("insurantAddress"));
		insurant.setPhoneNumber(phoneNumber);
		
		if(job.equals("Officer")) insurant.setEJob(eJob.officeWorker);
		else if(job.equals("Driver")) insurant.setEJob(eJob.driver);
		else if(job.equals("factoryWorker")) insurant.setEJob(eJob.factoryWorker);
		else if(job.equals("Student")) insurant.setEJob(eJob.student);
		else if(job.equals("Teacher")) insurant.setEJob(eJob.teacher);
		else if(job.equals("Soldier")) insurant.setEJob(eJob.soldier);
		else if(job.equals("Etc")) insurant.setEJob(eJob.etc);
		
		return insurant;
	}
}
