package com.yrw.dao;

import java.util.List;

import com.yrw.domains.Examsection;
import com.yrw.idao.IExamSectionDao;

public class ExamSectionDao extends BasicDao implements IExamSectionDao {

	@Override
	public List getExamBySection(int examId, int pageNow) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List getPageCount(int examId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addExamSection(Examsection examSection) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delExamSection(Examsection examsection) {
		// TODO Auto-generated method stub

	}

	@Override
	public void modifyExamSection(Examsection examsection) {
		// TODO Auto-generated method stub

	}

	@Override
	public Examsection showExamsection(int examSectioId) {
		// TODO Auto-generated method stub
		return (Examsection) this.findById(Examsection.class, examSectioId);
	}

	@Override
	public List<Examsection> getExamsectionsByExamIdAndExamSectionId(
			int examId, int examSectionId) {
		// TODO Auto-generated method stub
		String hql = "select e from Examsection as e  where e.examination.id="
				+ examId + " and e.id>" + examSectionId;
		return this.executeQuery(hql, null);
	}

}
