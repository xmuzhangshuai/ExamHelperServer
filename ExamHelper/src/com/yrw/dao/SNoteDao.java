package com.yrw.dao;

import java.util.List;

import com.yrw.domains.Snote;
import com.yrw.idao.ISnoteDao;

public class SNoteDao extends BasicDao implements ISnoteDao {

	@Override
	public void addSNote(Snote snote) {
		// TODO Auto-generated method stub
		this.add(snote);
	}

	@Override
	public void deleteSNote(Snote snote) {
		// TODO Auto-generated method stub
		this.deletById(Snote.class, snote.getId());
	}

	@Override
	public Snote getSnote(int questionTypeId, int questionId) {
		// TODO Auto-generated method stub
		String hql = "from Snote as s where s.questiontype.id=" + questionId
				+ " and s.questionId=" + questionId
				+ " order by s.noteNum desc";
		return (Snote) this.uniqueQuery(hql, null);
	}

	@Override
	public List<Snote> getSnotesBySectionId(int sectionId, int pageNow) {
		// TODO Auto-generated method stub
		String hql="from Snote as s where s.";
		return null;
	}

	@Override
	public int getPageCountBySectionId(int sectionId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Snote> getSnotesByQuestionTypeId(int questionTypeId, int pageNow) {
		// TODO Auto-generated method stub
		String hql = "from Snote as s where s.questiontype.id="
				+ questionTypeId + " order by s.noteNum desc";
		return this.executeQuery(hql, null);
	}

	@Override
	public int getPageCountByQuestionTypeId(int questionTypeId) {
		// TODO Auto-generated method stub
		String hql = "select count(s) from Snote as s where s.questiontype.id="
				+ questionTypeId + " order by s.noteNum desc";
		
		return this.queryPageCount(hql, null);
	}

	@Override
	public List<Snote> getSnotes(int pageNow) {
		// TODO Auto-generated method stub
		String hql="from Snote as s order by s.noteNum desc";
		return this.executeQuery(hql, null);
	}

	@Override
	public int getPageCount() {
		// TODO Auto-generated method stub
		String hql="select count(s) from Snote as s";
		return queryPageCount(hql, null);
	}

}
