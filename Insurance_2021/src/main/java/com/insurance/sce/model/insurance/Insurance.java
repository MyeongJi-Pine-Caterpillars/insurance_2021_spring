package com.insurance.sce.model.insurance;

import java.util.ArrayList;

import com.insurance.sce.dao.GuaranteePlanDAO;
import com.insurance.sce.dao.GuaranteePlanDAOImpl;
import com.insurance.sce.global.Constants.*;
import com.insurance.sce.model.customer.Insurant;

public abstract class Insurance {

	// Attributes
	private String insuranceId;
	private String name;
	private eInsuranceType type;
	private eGender gender;
	private int basicFee;
	private double[] rateOfAge = {1.1, 1.0, 1.0, 1.1, 1.2, 1.3, 1.4}; // index[0 : 占쎌겫占쎌�占쎈툡/ 1 : 10占쏙옙/ 2 : 20占쏙옙/ 3 : 30占쏙옙/ 4 : 40占쏙옙/ 5 : 50占쏙옙/ 6 : 占쎈걗占쎈�덌㎘占�]
	private double[] rateOfGender = {1.0, 1.1}; // index[0 : 占쎄텚占쎄쉐/ 1 : 占쎈연占쎄쉐]
	private double[] rateOfJob = {1.0, 1.2, 1.3, 1.0, 1.0, 1.2, 1.1}; // index[0 : 占쎄텢�눧�똻彛�/ 1 : 占쎌뒲占쎈꽊占쎈씜/ 2 : 占쎌겱占쎌삢筌욑옙/ 3 : 占쎈린占쎄문/ 4 : �뤃癒�沅�(占쎈땾)筌욑옙/ 5 : �뤃怨쀬뵥/ 6 : 疫꿸퀬占�]
	private int specialContractFee;
	private int warrantyPeriod;
	private boolean confirmedStatus = false;
	private boolean specialContract;
	private boolean del;
	private boolean clone;
	
	
	// Component
	private GuaranteePlanDAO guaranteePlanDAO;
	
	// Composition Class
	private ArrayList<GuaranteePlan> guaranteePlanList;

	// Constructor
	public Insurance() {
		this.guaranteePlanList = new ArrayList<GuaranteePlan>();
	}
	
	// getters & setters
	public int getBasicFee() {return basicFee;}
	public void setBasicFee(int basicFee) {this.basicFee = basicFee;}

	public boolean isConfirmedStatus() {return confirmedStatus;}
	public void setConfirmedStatus(boolean confirmedStatus) {this.confirmedStatus = confirmedStatus;}

	public String getInsuranceId() {return insuranceId;}
	public void setInsuranceId(String insuranceId) {this.insuranceId = insuranceId;}

	public String getName() {return name;}
	public void setName(String name) {this.name = name;}

	public eInsuranceType getType() {return type;}
	public void setType(int type) {this.type = eInsuranceType.get(type);}
	
	public eGender getGender() {return gender;}
	public void setGender(int gender) {this.gender = eGender.get(gender);}
	
	public double[] getRateOfAge() {return rateOfAge;}
	public void setRateOfAge(double[] rateOfAge) {this.rateOfAge = rateOfAge;}

	public double[] getRateOfGender() {return rateOfGender;}
	public void setRateOfGender(double[] rateOfGender) {this.rateOfGender = rateOfGender;}

	public double[] getRateOfJob() {return rateOfJob;}
	public void setRateOfJob(double[] rateOfJob) {this.rateOfJob = rateOfJob;}
	
	public int getSpecialContractFee() {return specialContractFee;}
	public void setSpecialContractFee(int specialContractFee) {this.specialContractFee = specialContractFee;}

	public int getWarrantyPeriod() {return warrantyPeriod;}
	public void setWarrantyPeriod(int warrantyPeriod) {this.warrantyPeriod = warrantyPeriod;}

	public boolean isSpecialContract() {return specialContract;}
	public void setSpecialContract(boolean specialContract) {this.specialContract = specialContract;}
	
	public boolean isClone() {return clone;}
	public void setClone(boolean clone) {this.clone = clone;}
	
	public ArrayList<GuaranteePlan> getGuaranteePlanList() {return guaranteePlanList;}
	public void setGuaranteePlanList(ArrayList<GuaranteePlan> guaranteePlanList) {this.guaranteePlanList = guaranteePlanList;}
	
	public GuaranteePlanDAO getGuaranteePlanDAO() {return guaranteePlanDAO;}
	public void setGuaranteePlanDAO(GuaranteePlanDAO guaranteePlanDAO) {this.guaranteePlanDAO = guaranteePlanDAO;}
	
	public boolean isDel() {return del;}
	public void setDel(boolean del) {this.del = del;}

	// Public Methods
	abstract public int calculateFee(Insurant Insurnat);
	abstract public Insurance newInstance();
	
	public void birngGuaranteePlan() {
		//this.guaranteePlanList = this.guaranteePlanDAO.selectById(this.insuranceId);
	}
	
	public void addGuaranteePlan(String content, int compensation, boolean special, double rate) {
		GuaranteePlan guaranteePlan = new GuaranteePlan();
		guaranteePlan.setInsuranceId(this.insuranceId);
		guaranteePlan.setCompensation(compensation);
		guaranteePlan.setSpecial(special);
		guaranteePlan.setContent(content);
		guaranteePlan.setRate(rate);
	}
}