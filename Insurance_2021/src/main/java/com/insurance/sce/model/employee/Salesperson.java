package com.insurance.sce.model.employee;

import com.insurance.sce.dao.InterviewDAO;
import com.insurance.sce.model.interview.Interview;

public class Salesperson extends Employee{
	
	private InterviewDAO interviewDAO;
	
	public Salesperson(InterviewDAO interviewDAO){
		this.interviewDAO = interviewDAO;
	}

	public void writeReport(Interview interview,String input){
		this.interviewDAO.updateContent(interview.getInterviewId(), input);
		this.interviewDAO.updateConfirmedStatus(interview.getInterviewId(), true);
	}

}