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
		String hql = "from Section where subject.id="+subjectId;	

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

	/**
	 * 设置判断题中的section为空
	 * 
	 * @param trueorfalses
	 */
	public void setTrueoffalse(Set<Trueorfalse> trueorfalses) {
		Iterator iterator = trueorfalses.iterator();
		Trueorfalse trueorfalse = null;
		while (iterator.hasNext()) {
			trueorfalse = (Trueorfalse) iterator.next();
			trueorfalse.setSection(null);
			this.update(trueorfalse);
		}

	}

	/**
	 * 把单项选择中的section对象置空
	 * 
	 * @param singlechoices
	 */
	public void setSinglechoice(Set<Singlechoice> singlechoices) {
		Iterator<Singlechoice> iterator = singlechoices.iterator();
		Singlechoice singlechoice = null;
		while (iterator.hasNext()) {
			singlechoice = (Singlechoice) iterator.next();
			singlechoice.setSection(null);
			this.update(singlechoice);
		}

	}

	/**
	 * 把多项选择中的section置空
	 * 
	 * @param multichoices
	 */
	public void setMultichoice(Set<Multichoice> multichoices) {
		// TODO Auto-generated method stub
		Iterator<Multichoice> iterator = multichoices.iterator();
		Multichoice multichoice = null;
		while (iterator.hasNext()) {
			multichoice = (Multichoice) iterator.next();
			multichoice.setSection(null);
			this.update(multichoice);
		}

	}

	/**
	 * 把materialAnalysis中的section置空
	 * 
	 * @param materialanalysises
	 */
	public void setMaterialanalysises(Set<Materialanalysis> materialanalysises) {
		Iterator<Materialanalysis> iterator = materialanalysises.iterator();
		Materialanalysis materialanalysis = null;
		while (iterator.hasNext()) {
			materialanalysis = (Materialanalysis) iterator.next();
			materialanalysis.setSection(null);
			this.update(materialanalysis);
		}

	}

	/**
	 * 把collection对象的中的section属性置空
	 * 
	 * @param set
	 */
	public void setCollection(Set<Collection> collections) {

		Iterator<Collection> iterator = collections.iterator();
		Collection collection = null;
		while (iterator.hasNext()) {
			collection = (Collection) iterator.next();
			collection.setSection(null);
			this.update(collection);
		}
	}

	/**
	 * 把ErrorQuestion对象的中的section属性置空
	 * 
	 * @param errorquestions
	 */
	public void setErrorQuestions(Set<Errorquestions> errorquestions) {

		Iterator<Errorquestions> iterator = errorquestions.iterator();
		Errorquestions errorQuestion = null;
		while (iterator.hasNext()) {
			errorQuestion = (Errorquestions) iterator.next();
			errorQuestion.setSection(null);
			this.update(errorQuestion);
		}
	}

	/**
	 * 把Group对象中的section属性置空
	 * 
	 * @param groups
	 */
	public void setGroups(Set<Group> groups) {
		Iterator<Group> iterator = groups.iterator();
		Group group = null;
		while (iterator.hasNext()) {
			group = (Group) iterator.next();
			group.setSection(null);
			this.update(group);
		}
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

}
