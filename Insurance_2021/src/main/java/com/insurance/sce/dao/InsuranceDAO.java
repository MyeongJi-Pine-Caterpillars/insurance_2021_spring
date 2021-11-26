package com.insurance.sce.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.insurance.sce.model.insurance.*;

@Repository
public interface InsuranceDAO {
	
	public int insert(Insurance insurance);
	public int insertActualCostInsurance(Insurance insurance);
	public int insertCancerInsurance(Insurance insurance);
	public int insertDentalInsurance(Insurance insurance);
	public int insertDriverInsurance(Insurance insurance);
	public int insertFireInsurance(Insurance insurance);
	public int insertTripInsurance(Insurance insurance);
	
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
	public Insurance select(String insuranceId);
	public Insurance selectActualCostInsurance(String insuranceId);
	public Insurance selectCancerInsurance(String insuranceId);
	public Insurance selectDentalInsurance(String insuranceId);
	public Insurance selectDriverInsurance(String insuranceId);
	public Insurance selectFireInsurance(String insuranceId);
	public Insurance selectTripInsurance(String insuranceId);
	
	public int updateConfirmedStatus(Insurance insurance);
	public int updateBasicFee(Insurance insurance);
	public int updateSpeCialContractFee(Insurance insurance);
	public int updateDel(Insurance insurance);
	
	
	public int delete(String insuranceId);
}
