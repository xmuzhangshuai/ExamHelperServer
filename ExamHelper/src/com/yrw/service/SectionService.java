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
	 * 通过章节名称获得章节对象
	 * 
	 * @param sectionName
	 * @return
	 */
	public Section getSectionBySectionName(String sectionName) {
		return iSectionDao.getSectoinByName(sectionName);
	}

	/**
	 * 通过科目id以及章节名称获得章节
	 * 
	 * @param subjectId
	 * @param sectionId
	 * @return
	 */
	public List<Section> listSectionBySubIdAndSecId(int subjectId, int sectionId) {
		List<Section> sectionList = iSectionDao
				.getSectionBySubjectId(subjectId);
		Section section = null;
		int i = 0;
		for (; i < sectionList.size(); i++) {
			if (sectionList.get(i).getId() == sectionId) {
				section = sectionList.get(i);
				break;
			}
		}
		if (i == sectionList.size()) {
		System.out.println("SectionService sectionList为空");
			return null;
		} else {
			sectionList.set(i, sectionList.get(0));
			sectionList.set(0, section);
			return sectionList;
		}

	}
	/**
	 * @param subjectId
	 * @return
	 */
	public List<Section> listSection(int subjectId){
		return iSectionDao.getSectionBySubjectId(subjectId);
	}

	/**
	 * 显示某个科目下的章节
	 * 
	 * @param pageNowString
	 * @param subjectId
	 * @return
	 */
	public List listSection(String pageNowString, int subjectId) {
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
		List sectionList = iSectionDao.getSectionBySubject(pageNow, subjectId);

		List collection = new ArrayList();
		collection.add(pageMap);
		collection.add(sectionList);
		return collection;
	}

	/**
	 * 显示某个章节的具体信息
	 * 
	 * @param sectionId
	 * @return
	 */
	public Section showSection(int sectionId) {
		Section section = iSectionDao.getSectionById(sectionId);
		return section;
	}

	/**
	 * 更新section
	 * 
	 * @param sectionNewName
	 * @param newSubject
	 * @param sectionId
	 */
	public void updateSection(String sectionNewName, String newSubject,
			int sectionId) {

		Section section = iSectionDao.getSectionById(sectionId);
		section.setSectionName(sectionNewName);

		int subjectId = iSubjectDao.getSubjectIdByName(newSubject);
		section.setSubjectId(subjectId);

		iSectionDao.updateSection(section);
	}

	/**
	 * 增加section
	 * 
	 * @param sectionName
	 * @param subjectName
	 * @return boon
	 */
	public boolean addSection(String sectionName, String subjectName) {
		int subjectId = iSubjectDao.getSubjectIdByName(subjectName);
		Section existSection = iSectionDao.getSectionByNameAndSubId(
				sectionName, subjectId);
		if (existSection == null) {
			Section section = new Section();
			section.setSectionName(sectionName);
			section.setSubjectId(subjectId);

			iSectionDao.add(section);
			return true;
		} else
			return false;
	}

	public void deleteSection(int sectionId) {
		Section existSection = (Section) iSectionDao.findById(Section.class,
				sectionId);
		if (existSection != null) {
			System.out.println("SectionService:deleteSection" + "存在");
			iSectionDao.delSection(existSection);
		}
	}
}
