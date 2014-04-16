package com.yrw.dao;

import java.util.List;

import com.yrw.domains.Multichoice;
import com.yrw.idao.IMultiChoiceDao;

public class MultiChoiceDao extends BasicDao implements IMultiChoiceDao {

	@Override
	public List getMultiChoiceBySubject(int pageNow, int subjectId) {
		// TODO Auto-generated method stub
		String hql = "select m from Multichoice m where m.section.id in (select section.id from Section  section where section.subjectId="
				+ subjectId+")";
		List list = this.executeQueryByPage(hql, null, pageNow);
		return list;
	}

	@Override
	public int getPageCountBySubject(int subjectId) {
		// TODO Auto-generated method stub
		String hql = "select count(m) from Multichoice m where m.section.id in (select section.id from Section  section where section.subjectId="
				+ subjectId+")";
		return this.queryPageCount(hql, null);
	}
	@Override
	public List getMultiChoiceBySection(int pageNow, int sectionId) {
		// TODO Auto-generated method stub
		String hql = "from Multichoice as m where m.section.id="
				+ sectionId;
		List list = this.executeQueryByPage(hql, null, pageNow);
		return list;
	}

	@Override
	public int getPageCountBySection(int sectionId) {
		// TODO Auto-generated method stub
		String hql = "select count(*) from Multichoice as m where m.section.id="
				+ sectionId;
		return this.queryPageCount(hql, null);
	}

	@Override
	public List getMultiChoiceByStem(String questionStem, int pageNow) {
		// TODO Auto-generated method stub
		String hql="from Multichoice where questionStem like '%"+questionStem+"%'";
		return this.executeQueryByPage(hql, null, pageNow);
	}

	@Override
	public int getPageCountByStem(String questionStem) {
		// TODO Auto-generated method stub
		String hql="select count(*) from Multichoice where questionStem like '%"+questionStem+"%'";
		return this.queryPageCount(hql, null);
	}

	@Override
	public void delMultiChoice(int multichoiceId) {
		// TODO Auto-generated method stub
		this.deletById(Multichoice.class, multichoiceId);
	}

	@Override
	public void addMultiChoice(Multichoice multichoice) {
		// TODO Auto-generated method stub
		this.add(multichoice);
	}

	@Override
	public Multichoice showMultichoice(int multiChoiceId) {
		// TODO Auto-generated method stub
		return (Multichoice)this.findById(Multichoice.class, multiChoiceId);
	}

	@Override
	public void updateMultiChoice(Multichoice multichoice) {
		// TODO Auto-generated method stub
		this.update(multichoice);
	}

	

	
	

}
