package com.yrw.dao;

import java.util.List;

import com.yrw.domains.Examination;
import com.yrw.idao.IExaminationDao;

public class ExaminationDao extends BasicDao implements IExaminationDao {

	@Override
	public List<Examination> getExam(int pageNow) {
		// TODO Auto-generated method stub
		String hql="from Examination";
		return this.executeQueryByPage(hql, null, pageNow);
	}

	@Override
	public int getPageCount() {
		// TODO Auto-generated method stub
	String hql="select count(*) from Examination";
	return this.queryPageCount(hql, null);
	}

	@Override
	public List getExamByName(String examName, int pageNow) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getPageCountByName(String examName) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List getExamBySubject(int subjectId, int pageNow) {
		// TODO Auto-generated method stub
		String hql = "from Examination as e where e.subject.id=" + subjectId;
		return this.executeQueryByPage(hql, null, pageNow);
	}

	@Override
	public int getPageCountBySubject(int subjectId) {
		// TODO Auto-generated method stub
		String hql = "select count(e) from Examination as e where e.subject.id="
				+ subjectId;
		return this.queryPageCount(hql, null);
	}

	@Override
	public Examination showExam(int examId) {
		// TODO Auto-generated method stub
		return (Examination) this.findById(Examination.class, examId);
	}

	@Override
	public void addExam(Examination examination) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delExam(Examination examination) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delExam(List<Examination> examinations) {
		// TODO Auto-generated method stub

	}

	@Override
	public void modifyExam(Examination examination) {
		// TODO Auto-generated method stub

	}

}
