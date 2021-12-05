package com.insurance.sce.dao;

import java.util.List;

import com.insurance.sce.model.insurance.ActualCostInsurance;
import com.insurance.sce.model.insurance.CancerInsurance;
import com.insurance.sce.model.insurance.DentalInsurance;
import com.insurance.sce.model.insurance.DriverInsurance;
import com.insurance.sce.model.insurance.FireInsurance;
import com.insurance.sce.model.insurance.Insurance;
import com.insurance.sce.model.insurance.TripInsurance;

public interface InsuranceDAO {
	
	public int insert(Insurance insurance);
	
	public List<Insurance> selectAll();
	public List<ActualCostInsurance> selectAllActualCostInsurance();
	public List<CancerInsurance> selectAllCancerInsurance();
	public List<DentalInsurance> selectAllDentalInsurance();
	public List<DriverInsurance> selectAllDriverInsurance();
	public List<FireInsurance> selectAllFireInsurance();
	public List<TripInsurance> selectAllTripInsurance();
	public List<Insurance> selectForConfirm();
	public List<Insurance> selectSimpleData();
	public List<String> selectInsuranceId();
	public Integer selectInsuranceType(String insuranceId);
	public Insurance select(String insuranceId);
	public Insurance selectActualCostInsurance(String insuranceId);
	public Insurance selectCancerInsurance(String insuranceId);
	public Insurance selectDentalInsurance(String insuranceId);
	public Insurance selectDriverInsurance(String insuranceId);
	public Insurance selectFireInsurance(String insuranceId);
	public Insurance selectTripInsurance(String insuranceId);
	public double selectSelfBurdenRate(String insuranceId);
	
	public int updateConfirmedStatus(String insuranceId);
	public int updateBasicFee(Insurance insurance);
	public int updateSpeCialContractFee(Insurance insurance);
	public int updateDel(String insuranceId);
	public int updateRestore(String insuranceId);
	
	
	public int delete(String insuranceId);

}
