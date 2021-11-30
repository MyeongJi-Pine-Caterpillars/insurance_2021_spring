package com.insurance.sce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.insurance.sce.dao.InsurantDAO;
import com.insurance.sce.dao.InsurantDAOImpl;
import com.insurance.sce.model.customer.Insurant;

@Service
public class InsurantServiceImpl implements InsurantService{
	@Autowired
	InsurantDAO insurantDAO = new InsurantDAOImpl();
	
	public Insurant selectInsurant(String insurantID) {
		return insurantDAO.selectInsurant(insurantID);
	}
}
