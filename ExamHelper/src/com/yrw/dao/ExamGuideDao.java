package com.yrw.dao;

import java.util.List;

import com.yrw.domains.Examguide;
import com.yrw.domains.Examguidetype;
import com.yrw.idao.IExamGuideDao;

public class ExamGuideDao extends BasicDao implements IExamGuideDao{

	@Override
	public List<Examguide> getExamguidesByExamguideTypeId(int examGuideTypeId ) {
		// TODO Auto-generated method stub
		String hql="from Examguide as e where e.examguidetype.id="+examGuideTypeId+" order by e.time desc";
		return this.executeQuery(hql, null);
	}

	@Override
	public List<Examguidetype> getExamguidetypesBySubjectId(int subjectId) {
		// TODO Auto-generated method stub
		String hql="from Examguidetype as e where e.subject.id="+subjectId;
		return this.executeQuery(hql, null);
	}

	@Override
	public Examguide getExamguideById(int examGuideId) {
		// TODO Auto-generated method stub
	return	(Examguide) this.findById(Examguide.class, examGuideId);
	}

	@Override
	public Examguidetype getExamguidetypeById(int examGuideTypeId) {
		// TODO Auto-generated method stub
		return (Examguidetype) this.findById(Examguidetype.class, examGuideTypeId);
	}

	@Override
	public void addExamguide(Examguide examguide) {
		// TODO Auto-generated method stub
		this.add(examguide);
	}

	@Override
	public void addExamguidetype(Examguidetype examguidetype) {
		// TODO Auto-generated method stub
		this.addExamguidetype(examguidetype);
	}

	@Override
	public void editExamguide(Examguide examguide) {
		// TODO Auto-generated method stub
		this.update(examguide);
	}

	@Override
	public void editExamguideType(Examguidetype examguidetype) {
		// TODO Auto-generated method stub
		this.update(examguidetype);
	}

	@Override
	public void deletExamguide(int  examguideId) {
		// TODO Auto-generated method stub
		this.deletById(Examguide.class, examguideId);
	}

	@Override
	public void deletExamguideType(int examguidetypeId) {
		// TODO Auto-generated method stub
		this.deletById(Examguidetype.class, examguidetypeId);
	}

	@Override
	public int getPageCount() {
		// TODO Auto-generated method stub
		String hql = "select count(*) from Examguide";
		return this.queryPageCount(hql, null);
	}

	@Override
	public List<Examguide> getExamguideListByPage(int pageNow) {
		// TODO Auto-generated method stub
		String hql = "from Examguide order by time desc";
		return this.executeQueryByPage(hql, null, pageNow);
	}

}
