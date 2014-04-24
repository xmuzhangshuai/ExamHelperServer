package com.yrw.dao;

import java.util.List;

import com.yrw.domains.Errorquestions;
import com.yrw.domains.Serrorquestions;
import com.yrw.idao.IErrorQuestionDao;
import com.yrw.idao.ISerrorQuestionDao;

public class SErrorQuestionDao extends BasicDao implements ISerrorQuestionDao {

	@Override
	public void addSerrorQuestion(Serrorquestions serrorquestions) {
		// TODO Auto-generated method stub
		this.add(serrorquestions);
	}

	@Override
	public void deleteSerrorQuestion(Serrorquestions serrorquestions) {
		// TODO Auto-generated method stub
		this.deletById(Serrorquestions.class, serrorquestions.getId());
	}

	@Override
	public Serrorquestions getSerrorquestions(int questionTypeId, int questionId) {
		// TODO Auto-generated method stub
		String hql = "from Serrorquestions as s where s.questiontype.id="
				+ questionTypeId + " and s.questionId=" + questionId;
		return (Serrorquestions) this.uniqueQuery(hql, null);
	}

	@Override
	public List<Serrorquestions> getSerrorquestions() {
		// TODO Auto-generated method stub
		String hql = "from Serrorquestions as s order by s.errorNum desc";
		return this.executeQuery(hql, null);
	}

	@Override
	public int getPageCount(int pageNow) {
		// TODO Auto-generated method stub
		String hql = "select count(s) from Serrorquestions";
		return this.queryPageCount(hql, null);
	}

	@Override
	public List<Serrorquestions> getSerrorquestionsBySectionId(int sectionId,
			int pageNow) {
		// TODO Auto-generated method stub
		String hql = "from Serrorquestions as s where s.section.id="
				+ sectionId + " order by s.errorNum desc";
		return this.executeQueryByPage(hql, null, pageNow);
	}

	@Override
	public int getPageCountBySectionId(int sectionId) {
		// TODO Auto-generated method stub
		String hql = "select count(s) from Serrorquestions as s where s.section.id="
				+ sectionId;
		return this.queryPageCount(hql, null);
	}

	@Override
	public List<Serrorquestions> getSerrorquestionsByQuestionTypeId(
			int questionTypeId, int pageNow) {
		// TODO Auto-generated method stub
		String hql = "from Serrorquestions as s where s.questiontype.id="
				+ questionTypeId + " order by s.errorNum desc";
		return this.executeQueryByPage(hql, null, pageNow);
	}

	@Override
	public int getPageCountByQuestionTypeId(int questionTypeId) {
		// TODO Auto-generated method stub
		String hql = "select count(s) from Serrorquestions as s where s.questiontype.id="
				+ questionTypeId ;
		return this.queryPageCount(hql, null);
	}

}
