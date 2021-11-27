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
	public int insert(Insurance insurance) {
		InsuranceDB insuranceDB = new InsuranceDB(insurance);
		int insuranceResult = sqlSession.insert(Insert, insuranceDB);
		switch(insurance.getEType()) {
		case cancerInsurance:
			return this.insertCancerInsurance(insurance);
		case dentalInsurance:
			return this.insertDentalInsurance(insurance);
		case actualCostInsurance:
			return this.insertActualCostInsurance(insurance);
		case fireInsurance:
			return this.insertFireInsurance(insurance);
		case driverInsurance:
			return this.insertDriverInsurance(insurance);
		case tripInsurance:
			return this.insertTripInsurance(insurance);
		default:
			return insuranceResult;
		}
	}
	public int insertActualCostInsurance(Insurance insurance) {
		InsuranceDB insuranceDB = new InsuranceDB(insurance);
		return sqlSession.insert(InsertActualCostInsurance, insuranceDB);
	}
	public int insertCancerInsurance(Insurance insurance) {
		InsuranceDB insuranceDB = new InsuranceDB(insurance);
		return sqlSession.insert(InsertCancerInsurance, insuranceDB);
	}
	public int insertDentalInsurance(Insurance insurance) {
		InsuranceDB insuranceDB = new InsuranceDB(insurance);
		return sqlSession.insert(InsertDentalInsurance, insuranceDB);
	}
	public int insertDriverInsurance(Insurance insurance) {
		InsuranceDB insuranceDB = new InsuranceDB(insurance);
		return sqlSession.insert(InsertDriverInsurance, insuranceDB);
	}
	public int insertFireInsurance(Insurance insurance) {
		InsuranceDB insuranceDB = new InsuranceDB(insurance);
		return sqlSession.insert(InsertFireInsurance, insuranceDB);
	}
	public int insertTripInsurance(Insurance insurance) {
		InsuranceDB insuranceDB = new InsuranceDB(insurance);
		return sqlSession.insert(InsertTripInsurance, insuranceDB);
	}

	// Select
	public List<Insurance> selectAll() {
		ArrayList<Insurance> insuranceList = new ArrayList<Insurance>();
		List<InsuranceDB> insuranceDB = sqlSession.selectList(SelectAll);
		for(InsuranceDB insurance : insuranceDB) {
			insurance.setEnum();
			insuranceList.add(insurance.getInsurance());
		}
		return insuranceList;
	}
	public List<ActualCostInsurance> selectAllActualCostInsurance() {
		ArrayList<ActualCostInsurance> insuranceList = new ArrayList<ActualCostInsurance>();
		List<InsuranceDB> insuranceDBList = sqlSession.selectList(SelectAllActualCostInsurance);
		for(InsuranceDB insuranceDB : insuranceDBList) {
			insuranceDB.setEnum();
			Insurance insurance = insuranceDB.getInsurance();
			insuranceList.add((ActualCostInsurance) insurance);
		}
		return insuranceList;
	}
	public List<CancerInsurance> selectAllCancerInsurance() {
		ArrayList<CancerInsurance> insuranceList = new ArrayList<CancerInsurance>();
		List<InsuranceDB> insuranceDBList = sqlSession.selectList(SelectAllCancerInsurance);
		for(InsuranceDB insuranceDB : insuranceDBList) {
			insuranceDB.setEnum();
			Insurance insurance = insuranceDB.getInsurance();
			insuranceList.add((CancerInsurance) insurance);
		}
		return insuranceList;
	}
	public List<DentalInsurance> selectAllDentalInsurance() {
		ArrayList<DentalInsurance> insuranceList = new ArrayList<DentalInsurance>();
		List<InsuranceDB> insuranceDBList = sqlSession.selectList(SelectAllDentalInsurance);
		for(InsuranceDB insuranceDB : insuranceDBList) {
			insuranceDB.setEnum();
			Insurance insurance = insuranceDB.getInsurance();
			insuranceList.add((DentalInsurance) insurance);
		}
		return insuranceList;
	}

	public List<DriverInsurance> selectAllDriverInsurance() {
		ArrayList<DriverInsurance> insuranceList = new ArrayList<DriverInsurance>();
		List<InsuranceDB> insuranceDBList = sqlSession.selectList(SelectAllDriverInsurance);
		for(InsuranceDB insuranceDB : insuranceDBList) {
			insuranceDB.setEnum();
			Insurance insurance = insuranceDB.getInsurance();
			insuranceList.add((DriverInsurance) insurance);
		}
		return insuranceList;
	}

	public List<FireInsurance> selectAllFireInsurance() {
		ArrayList<FireInsurance> insuranceList = new ArrayList<FireInsurance>();
		List<InsuranceDB> insuranceDBList = sqlSession.selectList(SelectAllFireInsurance);
		for(InsuranceDB insuranceDB : insuranceDBList) {
			insuranceDB.setEnum();
			Insurance insurance = insuranceDB.getInsurance();
			insuranceList.add((FireInsurance) insurance);
		}
		return insuranceList;
	}

	public List<TripInsurance> selectAllTripInsurance() {
		ArrayList<TripInsurance> insuranceList = new ArrayList<TripInsurance>();
		List<InsuranceDB> insuranceDBList = sqlSession.selectList(SelectAllTripInsurance);
		for(InsuranceDB insuranceDB : insuranceDBList) {
			insuranceDB.setEnum();
			Insurance insurance = insuranceDB.getInsurance();
			insuranceList.add((TripInsurance) insurance);
		}
		return insuranceList;
	}

	public List<Insurance> selectForConfirm() {
		ArrayList<Insurance> insuranceList = new ArrayList<Insurance>();
		List<InsuranceDB> insuranceDB = sqlSession.selectList(SelectForConfirm);
		for(InsuranceDB insurance : insuranceDB) {
			insurance.setEnum();
			insuranceList.add(insurance.getInsurance());
		}
		return insuranceList;
	}

	public List<Insurance> selectSimpleData() {
		ArrayList<Insurance> insuranceList = new ArrayList<Insurance>();
		List<InsuranceDB> insuranceDB = sqlSession.selectList(SelectSimpleData);
		for(InsuranceDB insurance : insuranceDB) {
			insurance.setEnum();
			insuranceList.add(insurance.getInsurance());
		}
		return insuranceList;
	}

	public List<String> selectInsuranceId() {
		return sqlSession.selectList(SelectInsuranceId);
	}

	public Insurance select(String insuranceId) {
		InsuranceDB insuranceDB = sqlSession.selectOne(Select, insuranceId);
		insuranceDB.setEnum();
		return insuranceDB.getInsurance();
	}

	public Insurance selectActualCostInsurance(String insuranceId) {
		InsuranceDB insuranceDB = sqlSession.selectOne(SelectActualCostInsurance, insuranceId);
		insuranceDB.setEnum();
		return insuranceDB.getInsurance();
	}

	public Insurance selectCancerInsurance(String insuranceId) {
		InsuranceDB insuranceDB = sqlSession.selectOne(SelectCancerInsurance, insuranceId);
		insuranceDB.setEnum();
		return insuranceDB.getInsurance();
	}

	public Insurance selectDentalInsurance(String insuranceId) {
		InsuranceDB insuranceDB = sqlSession.selectOne(SelectDentalInsurance, insuranceId);
		insuranceDB.setEnum();
		return insuranceDB.getInsurance();
	}

	public Insurance selectDriverInsurance(String insuranceId) {
		InsuranceDB insuranceDB = sqlSession.selectOne(SelectDriverInsurance, insuranceId);
		insuranceDB.setEnum();
		return insuranceDB.getInsurance();
	}

	public Insurance selectFireInsurance(String insuranceId) {
		InsuranceDB insuranceDB = sqlSession.selectOne(SelectFireInsurance, insuranceId);
		insuranceDB.setEnum();
		return insuranceDB.getInsurance();
	}

	public Insurance selectTripInsurance(String insuranceId) {
		InsuranceDB insuranceDB = sqlSession.selectOne(SelectTripInsurance, insuranceId);
		insuranceDB.setEnum();
		return insuranceDB.getInsurance();
	}

	// Update
	public int updateConfirmedStatus(Insurance insurance) {return sqlSession.update(UpdateConfirmedStatus, insurance);}
	public int updateBasicFee(Insurance insurance) {return sqlSession.update(UpdateBasicFee, insurance);}
	public int updateSpeCialContractFee(Insurance insurance) {return sqlSession.update(UpdateSpeCialContractFee, insurance);}
	public int updateDel(Insurance insurance) {return sqlSession.update(UpdateDel, insurance);}
	
	// Delete
	public int delete(String insuranceId) {return sqlSession.delete(Delete, insuranceId);}
}