package com.insurance.sce.service.employee;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.sce.dao.insurance.InsuranceDAO;
import com.insurance.sce.model.insurance.Insurance;

@Service
public class SalespersonServiceImpl implements SalespersonService{
	
	@Autowired
	InsuranceDAO insuranceDAO;
	
	public List<Insurance> selectInsuranceList(int insuranceType) {
		List<Insurance> list = insuranceDAO.selectAll();
		ArrayList<Insurance> resultList = new ArrayList<Insurance>();
		for(Insurance insurance : list) {
			if(insurance.getType() == insuranceType) {
				resultList.add(insurance);
			}
		}
		return resultList;
	}
}
