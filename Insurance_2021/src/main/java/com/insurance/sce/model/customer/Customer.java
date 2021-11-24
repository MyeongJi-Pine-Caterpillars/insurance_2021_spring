package com.insurance.sce.model.customer;

import java.util.ArrayList;

import com.insurance.sce.dao.ContractDAO;
import com.insurance.sce.dao.InsurantDAO;
import com.insurance.sce.dao.InsurantDAOImpl;
import com.insurance.sce.dao.InterviewDAO;
import com.insurance.sce.global.Constants;
import com.insurance.sce.model.interview.Interview;

public class Customer {
	// Attributes
	private String name;
	private String address;
	private String phoneNumber;
	private String customerId;
	private String password;
	
	// Composition Class
	private ArrayList<Insurant> insurantList;
	
	private InsurantDAO insurantDAO;

	// Constructor
	public Customer(){
		this.insurantList = new ArrayList<Insurant>();
		this.insurantDAO = new InsurantDAOImpl();
	}
	
	// getters & setters
	public String getAddress() {return address;}
	public void setAddress(String address) {this.address = address;}

	public String getCustomerId() {return customerId;}
	public void setCustomerId(String customerId) {this.customerId = customerId;}

	public String getName() {return name;}
	public void setName(String name) {this.name = name;}

	public String getPhoneNumber() {return phoneNumber;}
	public void setPhoneNumber(String phoneNumber) {this.phoneNumber = phoneNumber;}
	
	public ArrayList<Insurant> getInsurantList() {return insurantList;}
	public void setInsurantList(ArrayList<Insurant> insurantList) {this.insurantList = insurantList;}
	
	public String getPassword() {return password;}
	public void setPassword(String password) {this.password = password;}

	// Methods
	public void requestInterview(InterviewDAO interviewDAO, Interview interview){
		interviewDAO.insert(interview);
	}

	public void createInsurant(Insurant insurant) {
		this.insurantDAO.insertInsurant(insurant);
	}
	
	public void reviveContract(String contractId, ContractDAO contractDAO) {
//		contractDAO.updateUnpaidPeriod(contractId, 0);
//		for (int month = 0; month < Constants.thisMonth-1; month++) {
//			contractDAO.updatePayHistory(contractId, month);
//		}
	}
	
}