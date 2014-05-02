package com.yrw.dao;

import java.util.List;

import com.yrw.domains.Examquestion;
import com.yrw.idao.IExamQuestionDao;

public class ExamQuestionDao extends BasicDao implements IExamQuestionDao {

	@Override
	public List getExamQuestionBySection(int examSectionId, int pageNow) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getPageCountBySection(int examSectionId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void addExamQuestion(Examquestion examquestion) {
		// TODO Auto-generated method stub
		this.add(examquestion);
	}

	@Override
	public void delExamQuestion(Examquestion examquestion) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delExamQuestions(List<Examquestion> examquestions) {
		// TODO Auto-generated method stub

	}

	@Override
	public void modifyExamQuestion(Examquestion examquestion) {
		// TODO Auto-generated method stub

	}

	@Override
	public int getMaxQuestionNumberByExamSection(int examSectionId) {
		// TODO Auto-generated method stub
		String hql = "select max(e.questionNumber) from Examquestion as e where e.examsection.id="
				+ examSectionId;
		return (Integer) this.uniqueQuery(hql, null);
	}

}
