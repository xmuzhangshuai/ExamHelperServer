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
	public List getSectionBySubject(int pageNow, int subjectId) {
		// TODO Auto-generated method stub
		String hql = "from Section where subject.id=?";
		String parameter[] = { subjectId + "" };

		List list = this.executeQueryByPage(hql, parameter, pageNow);

		return list;
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
		setCollection(section.getCollections());
		setErrorQuestions(section.getErrorquestionses());
		setGroups(section.getGroups());
		setMaterialanalysises(section.getMaterialanalysises());
		setMultichoice(section.getMultichoices());
		setSinglechoice(section.getSinglechoices());
		setTrueoffalse(section.getTrueorfalses());
		
		this.deletById(Section.class, section.getId());
	}

	/**
	 * �����ж����е�sectionΪ��
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
	 * �ѵ���ѡ���е�section�����ÿ�
	 * 
	 * @param singlechoices
	 */
	public void setSinglechoice(Set<Singlechoice> singlechoices) {
		Iterator iterator = singlechoices.iterator();
		Singlechoice singlechoice = null;
		while (iterator.hasNext()) {
			singlechoice = (Singlechoice) iterator.next();
			singlechoice.setSection(null);
			this.update(singlechoice);
		}

	}

	/**
	 * �Ѷ���ѡ���е�section�ÿ�
	 * 
	 * @param multichoices
	 */
	public void setMultichoice(Set<Multichoice> multichoices) {
		// TODO Auto-generated method stub
		Iterator iterator = multichoices.iterator();
		Multichoice multichoice = null;
		while (iterator.hasNext()) {
			multichoice = (Multichoice) iterator.next();
			multichoice.setSection(null);
			this.update(multichoice);
		}

	}

	/**
	 * ��materialAnalysis�е�section�ÿ�
	 * 
	 * @param materialanalysises
	 */
	public void setMaterialanalysises(Set<Materialanalysis> materialanalysises) {
		Iterator iterator = materialanalysises.iterator();
		Materialanalysis materialanalysis = null;
		while (iterator.hasNext()) {
			materialanalysis = (Materialanalysis) iterator.next();
			materialanalysis.setSection(null);
			this.update(materialanalysis);
		}

	}

	/**
	 * ��collection������е�section�����ÿ�
	 * 
	 * @param set
	 */
	public void setCollection(Set<Collection> collections) {

		Iterator iterator = collections.iterator();
		Collection collection = null;
		while (iterator.hasNext()) {
			collection = (Collection) iterator.next();
			collection.setSection(null);
			this.update(collection);
		}
	}

	/**
	 * ��ErrorQuestion������е�section�����ÿ�
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
	 * ��Group�����е�section�����ÿ�
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
	public List getSectionBySubjectId(int subjectId) {
		// TODO Auto-generated method stub
		String hql="from Section as s where s.subject.id="+subjectId;
		return this.executeQuery(hql, null);
		 
	}

	@Override
	public Section getSectoinByName(String sectionName) {
		// TODO Auto-generated method stub
		String hql="from Section as s where s.sectionName='"+sectionName+"'";
		return (Section)this.uniqueQuery(hql, null);
	}

}
