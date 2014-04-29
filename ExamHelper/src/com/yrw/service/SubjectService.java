package com.yrw.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.yrw.domains.Subject;
import com.yrw.idao.ISubjectDao;

public class SubjectService {
	private ISubjectDao iSubjectDao;

	public void setiSubjectDao(ISubjectDao iSubjectDao) {
		this.iSubjectDao = iSubjectDao;
	}

	/**
	 * 获得subject的列表，其中subjectId用于获得section对应的subject
	 * 
	 * @param subjectId
	 * @return
	 */
	public List getSubjectList(int subjectId) {

		Subject subject = null;
		List<Subject> subjectList = iSubjectDao.getSubject();
		int i = 0;
		for (; i < subjectList.size(); i++) {

			if (subjectList.get(i).getId() == subjectId) {
				subject = subjectList.get(i);
				break;
			}
		}
		
		subjectList.set(i, subjectList.get(0));
		subjectList.set(0, subject);
		return subjectList;

	}

	/**
	 * 罗列科目
	 * 
	 * @param pageNowString
	 * @return
	 */
	public List listSubject(String pageNowString) {
		int pageNow = 1;
		int pageCount = iSubjectDao.getPageCount();
		if (pageNowString != null) {
			pageNow = Integer.parseInt(pageNowString);
			if (pageNow < 1)
				pageNow = 1;
			else if (pageNow > pageCount)
				pageNow = pageCount;

		}
		List subjectList = iSubjectDao.getSubject(pageNow);

		Map<String, Integer> map = new HashMap();

		map.put("pageCount", pageCount);
		map.put("pageNow", pageNow);

		List collection = new ArrayList();
		collection.add(map);
		collection.add(subjectList);

		return collection;
	}

	public void deleteSubject(int id) {
		iSubjectDao.delSubject(id);
	}

	public void delSubjectByList(String params) {
		iSubjectDao.delSubjects(params);
	}
	
	/**得到所有subject
	 * @return
	 */
	public List<Subject> getSubjects(){
	
		return iSubjectDao.getSubject();
	}

	public boolean addSubject(Subject subject) {
		Subject existSubject=iSubjectDao.getSubjectByName(subject.getSubName());
		if(existSubject==null)
		{
			iSubjectDao.addSubject(subject);
			return true;
		}
		else 
			return false;
	}

	/**通过subject的名字得到对应Id
	 * @param subjectName
	 * @return
	 */
	public int getSubjectIdBySubjectName(String subjectName){
		return iSubjectDao.getSubjectIdByName(subjectName);
	}
	
	/**通过subjectName得到subject对象
	 * @param subjectName
	 * @return
	 */
	public Subject getSubjectByName(String subjectName){
		return iSubjectDao.getSubjectByName(subjectName);
	}
	/**根据Id得到subject	 * 
	 * @param subjectId
	 * @return
	 */
	public Subject getSubjectById(int subjectId) {
		return iSubjectDao.getQuniqueSubject(subjectId);
	}

	public void updateSubject(Subject subject) {
		iSubjectDao.modifySubject(subject);
	}

	public List searchSubjectByKeyWord(String keyword, String pageNowString) {
		int pageCount = iSubjectDao.getPageCountLikeName(keyword);
		int pageNow = 1;
		if (pageNowString != null) {
			pageNow = Integer.parseInt(pageNowString);
			if (pageNow < 1)
				pageNow = 1;
			else if (pageNow > pageCount)
				pageNow = pageCount;
		}
		List subjectList = iSubjectDao.getSubjectLikeName(keyword, pageNow);
		System.out.println(subjectList.size());
		Map<String, Integer> map = new HashMap();
		map.put("pageNow", pageNow);
		map.put("pageCount", pageCount);

		List collection = new ArrayList();
		collection.add(map);
		collection.add(subjectList);

		return collection;

	}
}
