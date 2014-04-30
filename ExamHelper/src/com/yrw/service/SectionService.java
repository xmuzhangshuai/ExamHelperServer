package com.yrw.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.yrw.domains.Section;
import com.yrw.domains.Subject;
import com.yrw.idao.ISectionDao;
import com.yrw.idao.ISubjectDao;

public class SectionService {

	private ISectionDao iSectionDao;
	private ISubjectDao iSubjectDao;

	public void setiSubjectDao(ISubjectDao iSubjectDao) {
		this.iSubjectDao = iSubjectDao;
	}

	public void setiSectionDao(ISectionDao iSectionDao) {
		this.iSectionDao = iSectionDao;
	}

	/**
	 * ͨ���½����ƻ���½ڶ���
	 * 
	 * @param sectionName
	 * @return
	 */
	public Section getSectionBySectionName(String sectionName) {
		return iSectionDao.getSectoinByName(sectionName);
	}

	/**
	 * ͨ����Ŀid�Լ��½����ƻ���½�
	 * 
	 * @param subjectId
	 * @param sectionId
	 * @return
	 */
	public List<Section> listSectionBySubIdAndSecId(int subjectId) {
		List<Section> sectionList = iSectionDao.getSectionListBySubject(subjectId);
		return sectionList;
	}
	
	/**
	 * @return
	 */
	public List<Section> listSectionBySubject(int subjectId){
	 return	iSectionDao.getSectionListBySubject(subjectId);
	}

	/**��ҳ��ʾ�����½�
	 * @param pageNow
	 * @return
	 */
	public List listSection(String pageNowString) {
		int pageNow = 1;
		int pageCount = iSectionDao.getPageCount();
		if (pageNowString != null) {
			pageNow = Integer.parseInt(pageNowString);
			if (pageNow < 1)
				pageNow = 1;
			else if (pageNow > pageCount)
				pageNow = pageCount;

		}
		Map<String, Integer> pageMap = new HashMap<String, Integer>();
		pageMap.put("pageNow", pageNow);
		pageMap.put("pageCount", pageCount);
		List<Section> sectionList = iSectionDao.getSectionList(pageNow);

		List collection = new ArrayList();
		collection.add(pageMap);
		collection.add(sectionList);
		return collection;
	}

	/**
	 * ��ҳ��ʾĳ����Ŀ�µ��½�
	 * 
	 * @param pageNowString
	 * @param subjectId
	 * @return
	 */
	public List listSectionBySubject(String pageNowString, int subjectId) {
		int pageNow = 1;
		int pageCount = iSectionDao.getPageCountBySubject(subjectId);
		if (pageNowString != null) {
			pageNow = Integer.parseInt(pageNowString);
			if (pageNow < 1)
				pageNow = 1;
			else if (pageNow > pageCount)
				pageNow = pageCount;

		}

		Map<String, Integer> pageMap = new HashMap<String, Integer>();
		pageMap.put("pageNow", pageNow);
		pageMap.put("pageCount", pageCount);
		List<Section> sectionList = iSectionDao.getSectionListBySubject(pageNow, subjectId);

		List collection = new ArrayList();
		collection.add(pageMap);
		collection.add(sectionList);
		return collection;
	}

	/**
	 * ��ʾĳ���½ڵľ�����Ϣ
	 * 
	 * @param sectionId
	 * @return
	 */
	public Section showSection(int sectionId) {
		Section section = iSectionDao.getSectionById(sectionId);
		return section;
	}

	/**
	 * ����section
	 * 
	 * @param sectionNewName
	 * @param newSubject
	 * @param sectionId
	 */
	public void updateSection(String sectionNewName, String newSubject, int sectionId) {

		Section section = iSectionDao.getSectionById(sectionId);
		section.setSectionName(sectionNewName);

		Subject subject = null;
		subject = iSubjectDao.getSubjectByName(newSubject);
		if (subject != null) {
			section.setSubject(subject);
		}

		iSectionDao.updateSection(section);
	}

	/**
	 * ����section
	 * 
	 * @param sectionName
	 * @param subjectName
	 * @return boon
	 */
	public boolean addSection(String sectionName, String subjectName) {
		int subjectId = iSubjectDao.getSubjectIdByName(subjectName);
		Section existSection = iSectionDao.getSectionByNameAndSubId(sectionName, subjectId);
		if (existSection == null) {
			Section section = new Section();
			section.setSectionName(sectionName);
			Subject subject = null;
			subject = iSubjectDao.getSubjectByName(subjectName);
			if (subject != null) {
				section.setSubject(subject);
			}

			iSectionDao.add(section);
			return true;
		} else
			return false;
	}

	public void deleteSection(int sectionId) {
		Section existSection = (Section) iSectionDao.findById(Section.class, sectionId);
		if (existSection != null) {
			System.out.println("SectionService:deleteSection" + "����");
			iSectionDao.delSection(existSection);
		}
	}
}
