package com.yrw.dao;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.yrw.domains.Collection;
import com.yrw.domains.Errorquestions;
import com.yrw.domains.Group;
import com.yrw.domains.Materialanalysis;
import com.yrw.domains.Multichoice;
import com.yrw.domains.Section;
import com.yrw.domains.Singlechoice;
import com.yrw.domains.Trueorfalse;
import com.yrw.idao.ISectionDao;

public class SectionDao extends BasicDao implements ISectionDao {

	@Override
	public List<Section> getSectionListBySubject(int pageNow, int subjectId) {
		// TODO Auto-generated method stub
		String hql = "from Section as s where s.subject.id="+subjectId+"order by s.id desc";	

		return  this.executeQueryByPage(hql, null, pageNow);
	}

	@Override
	public int getPageCountBySubject(int subjectId) {
		// TODO Auto-generated method stub
		String hql = "select count(*) from Section where subject.id="
				+ subjectId;
		return this.queryPageCount(hql, null);
	}

	@Override
	public void delSection(Section section) {
		// TODO Auto-generated method stub

		this.deletById(Section.class, section.getId());
	}

	@Override
	public void addSection(Section section) {
		// TODO Auto-generated method stub
		this.add(section);
	}

	@Override
	public Section getSectionById(int sectionId) {
		// TODO Auto-generated method stub
		return (Section) this.findById(Section.class, sectionId);
	}

	@Override
	public void updateSection(Section section) {
		// TODO Auto-generated method stub
		this.update(section);
	}

	@Override
	public Section getSectionByNameAndSubId(String sectionName, int subjectId) {
		// TODO Auto-generated method stub
		String hql = "from Section as s  where s.sectionName='" + sectionName
				+ "' and s.subject.id=" + subjectId;
		System.out.println(hql);
		return (Section) this.uniqueQuery(hql, null);
	}

	@Override
	public Section getSectoinByName(String sectionName) {
		// TODO Auto-generated method stub
		String hql = "from Section as s where s.sectionName='" + sectionName
				+ "'";
		return (Section) this.uniqueQuery(hql, null);
	}

	@Override
	public List<Section> getSectionList(int pageNow) {
		// TODO Auto-generated method stub
		String hql="from Section";
		return this.executeQueryByPage(hql, null, pageNow);
	}

	@Override
	public int getPageCount() {
		// TODO Auto-generated method stub
		String hql="select count(*) from Section";
		return this.queryPageCount(hql,null);
	}

	@Override
	public List<Section> getSectionListBySubject(int subjectId) {
		// TODO Auto-generated method stub
		String hql = "from Section where subject.id="+subjectId;	
		return  this.executeQuery(hql, null);
	}

	@Override
	public void delSections(String params) {
		// TODO Auto-generated method stub
		String hql = "delete from Section where id in (" + params + ")";
		this.deletAll(hql);
	}

}
