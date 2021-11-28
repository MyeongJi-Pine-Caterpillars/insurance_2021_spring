package com.insurance.sce.dao;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.insurance.sce.global.Constants.eInsuranceType;
import com.insurance.sce.model.insurance.*;

@Repository
public class InsuranceDAOImpl extends DBConnector implements InsuranceDAO{
	@Inject
	private SqlSession sqlSession;

	private static final String Insert = "insuranceMapper.insert";
	private static final String InsertActualCostInsurance = "insuranceMapper.insertActualCostInsurance";
	private static final String InsertCancerInsurance = "insuranceMapper.insertCancerInsurance";
	private static final String InsertDentalInsurance = "insuranceMapper.insertDentalInsurance";
	private static final String InsertDriverInsurance = "insuranceMapper.insertDriverInsurance";
	private static final String InsertFireInsurance = "insuranceMapper.insertFireInsurance";
	private static final String InsertTripInsurance = "insuranceMapper.insertTripInsurance";
	private static final String SelectAll = "insuranceMapper.selectAll";
	private static final String SelectAllActualCostInsurance = "insuranceMapper.selectAllActualCostInsurance";
	private static final String SelectAllCancerInsurance = "insuranceMapper.selectAllCancerInsurance";
	private static final String SelectAllDentalInsurance = "insuranceMapper.selectAllDentalInsurance";
	private static final String SelectAllDriverInsurance = "insuranceMapper.selectAllDriverInsurance";
	private static final String SelectAllFireInsurance = "insuranceMapper.selectAllFireInsurance";
	private static final String SelectAllTripInsurance = "insuranceMapper.selectAllTripInsurance";
	private static final String SelectForConfirm = "insuranceMapper.selectForConfirm";
	private static final String SelectSimpleData = "insuranceMapper.selectSimpleData";
	private static final String SelectInsuranceId = "insuranceMapper.selectInsuranceId";
	private static final String Select = "insuranceMapper.select";
	private static final String SelectActualCostInsurance = "insuranceMapper.selectActualCostInsurance";
	private static final String SelectCancerInsurance = "insuranceMapper.selectCancerInsurance";
	private static final String SelectDentalInsurance = "insuranceMapper.selectDentalInsurance";
	private static final String SelectDriverInsurance = "insuranceMapper.selectDriverInsurance";
	private static final String SelectFireInsurance = "insuranceMapper.selectFireInsurance";
	private static final String SelectTripInsurance = "insuranceMapper.selectTripInsurance";
	private static final String UpdateConfirmedStatus = "insuranceMapper.updateConfirmedStatus";
	private static final String UpdateBasicFee = "insuranceMapper.updateBasicFee";
	private static final String UpdateSpeCialContractFee = "insuranceMapper.updateSpeCialContractFee";
	private static final String UpdateDel = "insuranceMapper.updateDel";
	private static final String Delete = "insuranceMapper.delete";

	// Insert
	public int insert(Insurance insurance) {return sqlSession.insert(Insert, insurance);}
	public int insertActualCostInsurance(Insurance insurance) {return sqlSession.insert(InsertActualCostInsurance, insurance);}
	public int insertCancerInsurance(Insurance insurance) {return sqlSession.insert(InsertCancerInsurance, insurance);}
	public int insertDentalInsurance(Insurance insurance) {return sqlSession.insert(InsertDentalInsurance, insurance);}
	public int insertDriverInsurance(Insurance insurance) {return sqlSession.insert(InsertDriverInsurance, insurance);}
	public int insertFireInsurance(Insurance insurance) {return sqlSession.insert(InsertFireInsurance, insurance);}
	public int insertTripInsurance(Insurance insurance) {return sqlSession.insert(InsertTripInsurance, insurance);}

	// Select
	public List<Insurance> selectAll() {return sqlSession.selectList(SelectAll);}
	public List<ActualCostInsurance> selectAllActualCostInsurance() {return sqlSession.selectList(SelectAllActualCostInsurance);}
	public List<CancerInsurance> selectAllCancerInsurance() {return sqlSession.selectList(SelectAllCancerInsurance);}
	public List<DentalInsurance> selectAllDentalInsurance() {return sqlSession.selectList(SelectAllDentalInsurance);}
	public List<DriverInsurance> selectAllDriverInsurance() {return sqlSession.selectList(SelectAllDriverInsurance);}
	public List<FireInsurance> selectAllFireInsurance() {return sqlSession.selectList(SelectAllFireInsurance);}
	public List<TripInsurance> selectAllTripInsurance() {return sqlSession.selectList(SelectAllTripInsurance);}
	public List<Insurance> selectForConfirm() {return sqlSession.selectList(SelectForConfirm);}
	public List<Insurance> selectSimpleData() {return sqlSession.selectList(SelectSimpleData);}
	public List<String> selectInsuranceId() {return sqlSession.selectList(SelectInsuranceId);}
	public Insurance select(String insuranceId) {return sqlSession.selectOne(Select, insuranceId);}
	public Insurance selectActualCostInsurance(String insuranceId) {return sqlSession.selectOne(SelectActualCostInsurance, insuranceId);}
	public Insurance selectCancerInsurance(String insuranceId) {return sqlSession.selectOne(SelectCancerInsurance, insuranceId);}
	public Insurance selectDentalInsurance(String insuranceId) {return sqlSession.selectOne(SelectDentalInsurance, insuranceId);}
	public Insurance selectDriverInsurance(String insuranceId) {return sqlSession.selectOne(SelectDriverInsurance, insuranceId);}
	public Insurance selectFireInsurance(String insuranceId) {return sqlSession.selectOne(SelectFireInsurance, insuranceId);}
	public Insurance selectTripInsurance(String insuranceId) {return sqlSession.selectOne(SelectTripInsurance, insuranceId);}

	// Update
	public int updateConfirmedStatus(Insurance insurance) {return sqlSession.update(UpdateConfirmedStatus, insurance);}
	public int updateBasicFee(Insurance insurance) {return sqlSession.update(UpdateBasicFee, insurance);}
	public int updateSpeCialContractFee(Insurance insurance) {return sqlSession.update(UpdateSpeCialContractFee, insurance);}
	public int updateDel(Insurance insurance) {return sqlSession.update(UpdateDel, insurance);}
	
	// Delete
	public int delete(String insuranceId) {return sqlSession.delete(Delete, insuranceId);}
}