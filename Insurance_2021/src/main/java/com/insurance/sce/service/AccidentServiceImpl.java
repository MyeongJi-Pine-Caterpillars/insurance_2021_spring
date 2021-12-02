package com.insurance.sce.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.sce.dao.AccidentDAO;
import com.insurance.sce.model.contract.Accident;

@Service
public class AccidentServiceImpl implements AccidentService{
	@Autowired
	AccidentDAO accidentDAO;
	@Override
	public List<Accident> selectAllAccident() {
		return accidentDAO.selectAll();
	}
}
