package com.insurance.sce.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import com.insurance.sce.model.interview.Interview;

@Component
public class InterviewDAOImpl extends DBConnector implements InterviewDAO{
	@Inject
	private SqlSession sqlSession;

	private static final String Insert = "interviewMapper.insert";
	private static final String SelectAll = "interviewMapper.selectAll";
	private static final String Select = "interviewMapper.select";
	private static final String UpdateConfirmedStatus = "interviewMapper.updateConfirmedStatus";
	private static final String UpdateDate = "interviewMapper.updateDate";
	private static final String UpdateContent = "interviewMapper.updateContent";
	private static final String UpdateSalespersonId = "interviewMapper.updateSalespersonId";
	private static final String Delete = "interviewMapper.delete";
	
	// Insert
	public int insert(Interview interView) {return sqlSession.insert(Insert, interView);}

	// Select
	public List<Interview> selectAll() {return sqlSession.selectList(SelectAll);}
	public Interview select(String interviewId) {return sqlSession.selectOne(Select);}

	// Update
	public int updateConfirmedStatus(Interview interView) {return sqlSession.update(UpdateConfirmedStatus, interView);}
	public int updateDate(Interview interView) {return sqlSession.update(UpdateDate, interView);}
	public int updateContent(Interview interView) {return sqlSession.update(UpdateContent, interView);}
	public int updateSalespersonId(Interview interView) {return sqlSession.update(UpdateSalespersonId, interView);}

	// Delete
	public int delete(String interviewId) {return sqlSession.delete(Delete);}

}
