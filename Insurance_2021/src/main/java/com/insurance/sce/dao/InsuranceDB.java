package com.insurance.sce.dao;

import com.insurance.sce.global.Constants.eInsuranceType;
import com.insurance.sce.global.Constants.eGender;
import com.insurance.sce.model.insurance.Insurance;

public class InsuranceDB{
	
	int TYPE;
	int gender;
	private String insuranceId;
	private String NAME;
	private eInsuranceType eType;
	private eGender eGender;
	private int basicFee;
	private double rateOfAge0 = 1.1;
	private double rateOfAge1 = 1.0;
	private double rateOfAge2 = 1.0;
	private double rateOfAge3 = 1.1;
	private double rateOfAge4 = 1.2;
	private double rateOfAge5 = 1.3;
	private double rateOfAge6 = 1.4;
	private double rateOfGender0 = 1.0;
	private double rateOfGender1 = 1.1;
	private double rateOfJob0 = 1.0;
	private double rateOfJob1 = 1.2;
	private double rateOfJob2 = 1.3;
	private double rateOfJob3 = 1.0;
	private double rateOfJob4 = 1.0;
	private double rateOfJob5 = 1.2;
	private double rateOfJob6 = 1.1;
	private double[] rateOfAge = {1.1, 1.0, 1.0, 1.1, 1.2, 1.3, 1.4}; // index[0 : �쁺�쑀�븘/ 1 : 10��/ 2 : 20��/ 3 : 30��/ 4 : 40��/ 5 : 50��/ 6 : �끂�뀈痢�]
	private double[] rateOfGender = {1.0, 1.1}; // index[0 : �궓�꽦/ 1 : �뿬�꽦]
	private double[] rateOfJob = {1.0, 1.2, 1.3, 1.0, 1.0, 1.2, 1.1}; // index[0 : �궗臾댁쭅/ 1 : �슫�넚�뾽/ 2 : �쁽�옣吏�/ 3 : �븰�깮/ 4 : 援먯궗(�닔)吏�/ 5 : 援곗씤/ 6 : 湲고�]
	private int specialContractFee;
	private int warrantyPeriod;
	private boolean confirmedStatus = false;
	private boolean specialContract;
	private boolean del;
	private boolean clone;
	
	public InsuranceDB() {
		
	}
	
	
	public double getRateOfAge0() {
		return rateOfAge0;
	}


	public void setRateOfAge0(double rateOfAge0) {
		this.rateOfAge0 = rateOfAge0;
	}


	public double getRateOfAge1() {
		return rateOfAge1;
	}


	public void setRateOfAge1(double rateOfAge1) {
		this.rateOfAge1 = rateOfAge1;
	}


	public double getRateOfAge2() {
		return rateOfAge2;
	}


	public void setRateOfAge2(double rateOfAge2) {
		this.rateOfAge2 = rateOfAge2;
	}


	public double getRateOfAge3() {
		return rateOfAge3;
	}


	public void setRateOfAge3(double rateOfAge3) {
		this.rateOfAge3 = rateOfAge3;
	}


	public double getRateOfAge4() {
		return rateOfAge4;
	}


	public void setRateOfAge4(double rateOfAge4) {
		this.rateOfAge4 = rateOfAge4;
	}


	public double getRateOfAge5() {
		return rateOfAge5;
	}


	public void setRateOfAge5(double rateOfAge5) {
		this.rateOfAge5 = rateOfAge5;
	}


	public double getRateOfAge6() {
		return rateOfAge6;
	}


	public void setRateOfAge6(double rateOfAge6) {
		this.rateOfAge6 = rateOfAge6;
	}


	public double getRateOfGender0() {
		return rateOfGender0;
	}


	public void setRateOfGender0(double rateOfGender0) {
		this.rateOfGender0 = rateOfGender0;
	}


	public double getRateOfGender1() {
		return rateOfGender1;
	}


	public void setRateOfGender1(double rateOfGender1) {
		this.rateOfGender1 = rateOfGender1;
	}


	public double getRateOfJob0() {
		return rateOfJob0;
	}


	public void setRateOfJob0(double rateOfJob0) {
		this.rateOfJob0 = rateOfJob0;
	}


	public double getRateOfJob1() {
		return rateOfJob1;
	}


	public void setRateOfJob1(double rateOfJob1) {
		this.rateOfJob1 = rateOfJob1;
	}


	public double getRateOfJob2() {
		return rateOfJob2;
	}


	public void setRateOfJob2(double rateOfJob2) {
		this.rateOfJob2 = rateOfJob2;
	}


	public double getRateOfJob3() {
		return rateOfJob3;
	}


	public void setRateOfJob3(double rateOfJob3) {
		this.rateOfJob3 = rateOfJob3;
	}


	public double getRateOfJob4() {
		return rateOfJob4;
	}


	public void setRateOfJob4(double rateOfJob4) {
		this.rateOfJob4 = rateOfJob4;
	}


	public double getRateOfJob5() {
		return rateOfJob5;
	}


	public void setRateOfJob5(double rateOfJob5) {
		this.rateOfJob5 = rateOfJob5;
	}


	public double getRateOfJob6() {
		return rateOfJob6;
	}


	public void setRateOfJob6(double rateOfJob6) {
		this.rateOfJob6 = rateOfJob6;
	}


	public int getTYPE() {
		return TYPE;
	}


	public void setTYPE(int tYPE) {
		TYPE = tYPE;
	}


	public int getGender() {
		return gender;
	}


	public void setGender(int gender) {
		this.gender = gender;
	}


	public String getInsuranceId() {
		return insuranceId;
	}


	public void setInsuranceId(String insuranceId) {
		this.insuranceId = insuranceId;
	}


	public String getNAME() {
		return NAME;
	}


	public void setNAME(String nAME) {
		NAME = nAME;
	}


	public eInsuranceType geteType() {
		return eType;
	}


	public void seteType(eInsuranceType eType) {
		this.eType = eType;
	}


	public eGender geteGender() {
		return eGender;
	}


	public void seteGender(eGender eGender) {
		this.eGender = eGender;
	}


	public int getBasicFee() {
		return basicFee;
	}


	public void setBasicFee(int basicFee) {
		this.basicFee = basicFee;
	}


	public double[] getRateOfAge() {
		return rateOfAge;
	}


	public void setRateOfAge(double[] rateOfAge) {
		this.rateOfAge = rateOfAge;
	}


	public double[] getRateOfGender() {
		return rateOfGender;
	}


	public void setRateOfGender(double[] rateOfGender) {
		this.rateOfGender = rateOfGender;
	}


	public double[] getRateOfJob() {
		return rateOfJob;
	}


	public void setRateOfJob(double[] rateOfJob) {
		this.rateOfJob = rateOfJob;
	}


	public int getSpecialContractFee() {
		return specialContractFee;
	}


	public void setSpecialContractFee(int specialContractFee) {
		this.specialContractFee = specialContractFee;
	}


	public int getWarrantyPeriod() {
		return warrantyPeriod;
	}


	public void setWarrantyPeriod(int warrantyPeriod) {
		this.warrantyPeriod = warrantyPeriod;
	}


	public boolean isConfirmedStatus() {
		return confirmedStatus;
	}


	public void setConfirmedStatus(boolean confirmedStatus) {
		this.confirmedStatus = confirmedStatus;
	}


	public boolean isSpecialContract() {
		return specialContract;
	}


	public void setSpecialContract(boolean specialContract) {
		this.specialContract = specialContract;
	}


	public boolean isDel() {
		return del;
	}


	public void setDel(boolean del) {
		this.del = del;
	}


	public boolean isClone() {
		return clone;
	}


	public void setClone(boolean clone) {
		this.clone = clone;
	}


	public InsuranceDB(Insurance insurance) {
		this.setInsuranceId(insurance.getInsuranceId());
		this.setNAME(insurance.getName());
		this.TYPE = insurance.getEType().getNum();
		this.gender = insurance.getEGender().getNum();
		this.setBasicFee(insurance.getBasicFee());
		this.setRateOfAge(insurance.getRateOfAge());
		this.setRateOfGender(insurance.getRateOfGender());
		this.setRateOfJob(insurance.getRateOfJob());
		this.setSpecialContractFee(insurance.getSpecialContractFee());
		this.setWarrantyPeriod(insurance.getWarrantyPeriod());
		this.setConfirmedStatus(insurance.isConfirmedStatus());
		this.setSpecialContract(insurance.isSpecialContract());
		this.setDel(insurance.isDel());
		this.setClone(insurance.isClone());
	}
	
	
	public void setEnum() {
		this.eType = (eInsuranceType.values()[TYPE - 1]);
		this.eGender = (com.insurance.sce.global.Constants.eGender.values()[gender - 1]);
	}

	public Insurance getInsurance() {
		Insurance insurance = eType.getSelectedInsurance().newInstance();
		insurance.setInsuranceId(getInsuranceId());
		insurance.setName(getNAME());
		this.eType = (eInsuranceType.values()[TYPE]);
		this.eGender = (com.insurance.sce.global.Constants.eGender.values()[gender - 1]);
		insurance.setBasicFee(getBasicFee());
		insurance.setRateOfAge(getRateOfAge());
		insurance.setRateOfGender(getRateOfGender());
		insurance.setRateOfJob(getRateOfJob());
		insurance.setSpecialContractFee(getSpecialContractFee());
		insurance.setWarrantyPeriod(getWarrantyPeriod());
		insurance.setConfirmedStatus(isConfirmedStatus());
		insurance.setSpecialContract(isSpecialContract());
		insurance.setDel(isDel());
		insurance.setClone(isClone());
		return insurance;
	}
}
