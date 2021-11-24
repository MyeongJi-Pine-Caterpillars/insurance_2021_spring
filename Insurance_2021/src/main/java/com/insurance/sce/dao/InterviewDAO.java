package com.insurance.sce.dao;

import java.util.List;

import com.insurance.sce.model.interview.Interview;

public interface InterviewDAO {
	public int insert(Interview interView);
	
	public List<Interview> selectAll();
	public Interview select(String interviewId);
	
	public int updateConfirmedStatus(Interview interView);
	public int updateDate(Interview interView);
	public int updateContent(Interview interView);
	public int updateSalespersonId(Interview interView);
	
	public int delete(String interviewId);
	
}
