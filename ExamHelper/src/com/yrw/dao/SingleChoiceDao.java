package com.yrw.dao;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.yrw.domains.Section;
import com.yrw.domains.Singlechoice;
import com.yrw.idao.ISingleChoiceDao;

public class SingleChoiceDao extends BasicDao implements ISingleChoiceDao {

	@Override
	public void addSingleChoice(Singlechoice singlechoice) {
		// TODO Auto-generated method stub
		this.add(singlechoice);
	}

	@Override
	public void delSingleChoice(Object object) {
		// TODO Auto-generated method stub
		Singlechoice singlechoice = (Singlechoice)object;
		if (singlechoice != null) {
			Section section = singlechoice.getSection();
			Set<Singlechoice> singlechoices = section.getSinglechoices();
			Iterator<Singlechoice> iterator = singlechoices.iterator();
			while (iterator.hasNext())
				if (iterator.next().getId() == singlechoice.getId()) {
					iterator.remove();
					break;
				}
		}
	}

	@Override
	public List getSingleChoiceBySection(int pageNow, int sectionId) {
		// TODO Auto-generated method stub
		String hql = "from Singlechoice as s where s.section.id=" + sectionId+" order by s.id desc";
		List list = this.executeQueryByPage(hql, null, pageNow);
		return list;
	}

	@Override
	public int getPageCountBySection(int sectionId) {
		// TODO Auto-generated method stub
		String hql = "select count(s) from Singlechoice as s where s.section.id="
				+ sectionId;
		return this.queryPageCount(hql, null);
	}

	@Override
	public List getSingleChoiceBySubject(int pageNow, int subjectId) {
		// TODO Auto-generated method stub
		String hql = "select s from Singlechoice s where s.section.id in (select section.id from Section  section where section.subjectId="
				+ subjectId + ")";
		List list = this.executeQueryByPage(hql, null, pageNow);
		return list;
	}

	@Override
	public int getPageCountBySubject(int subjectId) {
		String hql = "select count(s) from Singlechoice where s.section.id in (select section.id from Section  section where section.subjectId="
				+ subjectId + ")";
		return this.queryPageCount(hql, null);
	}

	@Override
	public int getPageCountByName(String singleChoiceName) {
		// TODO Auto-generated method stub
		String hql = "select count(s) from Singlechoice as s where s.questionStem like '%"
				+ singleChoiceName + "%'";
		return this.queryPageCount(hql, null);
	}

	@Override
	public List getSingleChoiceByName(String singleChoiceName, int pageNow) {
		// TODO Auto-generated method stub
		String hql = "from Singlechoice as s where s.questionStem like '%"
				+ singleChoiceName + "%'";
		return this.executeQueryByPage(hql, null, pageNow);
	}

	@Override
	public Singlechoice showSinglechoice(int singleChoiceId) {
		// TODO Auto-generated method stub
		return (Singlechoice) this.findById(Singlechoice.class, singleChoiceId);
	}

	@Override
	public void updateSinglechoice(Singlechoice singlechoice) {
		// TODO Auto-generated method stub
		this.update(singlechoice);
	}

}
