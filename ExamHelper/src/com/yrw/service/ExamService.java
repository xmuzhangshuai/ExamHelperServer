package com.yrw.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.yrw.domains.Examination;
import com.yrw.idao.IExamQuestionDao;
import com.yrw.idao.IExamSectionDao;
import com.yrw.idao.IExaminationDao;

public class ExamService {

	private IExaminationDao iExaminationDao;
	private IExamQuestionDao iExamQuestionDao;
	private IExamSectionDao iExamSectionDao;
	public void setiExaminationDao(IExaminationDao iExaminationDao) {
		this.iExaminationDao = iExaminationDao;
	}
	public void setiExamQuestionDao(IExamQuestionDao iExamQuestionDao) {
		this.iExamQuestionDao = iExamQuestionDao;
	}
	public void setiExamSectionDao(IExamSectionDao iExamSectionDao) {
		this.iExamSectionDao = iExamSectionDao;
	}
	
	/**显示某个科目下的所有大题
	 * @param subjectId
	 * @return
	 */
	public List<Examination> listExaminations(String pageNowString,int subjectId){
		int pageNow = 1;
		int pageCount = iExaminationDao.getPageCountBySubject(subjectId);
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
		List examsList = iExaminationDao.getExamBySubject(subjectId, pageNow);

		List collection = new ArrayList();
		collection.add(pageMap);
		collection.add(examsList);
		return collection;
	}
}
