package com.insurance.sce.dao;

import com.insurance.sce.global.Constants.eInsuranceType;
import com.insurance.sce.global.Constants.eGender;
import com.insurance.sce.model.insurance.Insurance;

public class InsuranceDB{
	
	int type;
	int gender;
	private String insuranceId;
	private String name;
	private eInsuranceType eType;
	private eGender eGender;
	private int basicFee;
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

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
		this.setName(insurance.getName());
		this.type = insurance.getEType().getNum();
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
		this.eType = (eInsuranceType.values()[type]);
		this.eGender = (com.insurance.sce.global.Constants.eGender.values()[gender - 1]);
	}

	public Insurance getInsurance() {
		Insurance insurance = eType.getSelectedInsurance().newInstance();
		insurance.setInsuranceId(getInsuranceId());
		insurance.setName(getName());
		this.eType = (eInsuranceType.values()[type]);
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
