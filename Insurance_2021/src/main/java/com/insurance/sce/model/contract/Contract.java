package com.insurance.sce.model.contract;

import java.util.ArrayList;

import com.insurance.sce.dao.contract.AccidentDAO;
import com.insurance.sce.dao.contract.AccidentDAOImpl;
import com.insurance.sce.dao.contract.ContractDAO;
import com.insurance.sce.model.customer.Insurant;
import com.insurance.sce.model.insurance.Insurance;


public class Contract {
	// Attributes
	private String contractId;
	private String insurantId;
	private String insuranceId;
	private boolean effectiveness;
	private boolean special;
	private int lifespan;
	private int fee;
	private int paidFee;
	private int unpaidPeriod;
	private boolean[] payHistory = new boolean[12];
	private ArrayList<Accident> accidentList;

	// Constructor
	public Contract(){
	}
	
	// Getters&Setters
	public String getContractId() {return contractId;}
	public void setContractId(String contractId) {this.contractId = contractId;}
	
	public String getInsurantId() {return insurantId;}
	public void setInsurantId(String insurantId) {this.insurantId = insurantId;}

	public String getInsuranceId() {return insuranceId;}
	public void setInsuranceId(String insuranceId) {this.insuranceId = insuranceId;}

	public boolean isEffectiveness() {return effectiveness;}
	public void setEffectiveness(boolean effectiveness) {this.effectiveness = effectiveness;}
	
	public boolean isSpecial() {return special;}
	public void setSpecial(boolean special) {this.special = special;}

	public int getFee() {return fee;}
	public void setFee(int fee) {this.fee = fee;}

	public int getLifespan() {return lifespan;}
	public void setLifespan(int lifespan) {this.lifespan = lifespan;}

	public int getPaidFee() {return paidFee;}
	public void setPaidFee(int paidFee) {this.paidFee = paidFee;}

	public int getUnpaidPeriod() {return unpaidPeriod;}
	public void setUnpaidPeriod(int unpaidPeriod) {this.unpaidPeriod = unpaidPeriod;}
		
	public ArrayList<Accident> getAccidentList() {return accidentList;}
	public void setAccidentList(ArrayList<Accident> accidentList) {this.accidentList = accidentList;}

	public boolean[] getPayHistory() {return payHistory;}
	public void setPayHistory(boolean[] payHistory) {this.payHistory = payHistory;}
	
	// public Method
	public void joinInsurance(Insurance insurance, Insurant insurant){
		this.insuranceId = insurance.getInsuranceId();
		this.insurantId = insurant.getInsurantId();
	}

	public void addAccident(String accidentId, String content, int damageCost, boolean handlingStatus) {
		Accident accident = new Accident();
		accident.setContractId(this.contractId);
		accident.setAccidentId(accidentId);
		accident.setContent(content);
		accident.setDamageCost(damageCost);
		accident.setHandlingStatus(handlingStatus);
	}
}