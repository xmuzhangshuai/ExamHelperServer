package com.yrw.service;

import java.util.ArrayList;
import java.util.List;

import com.jsonobjects.JExamGuide;
import com.jsonobjects.JExamGuideType;
import com.yrw.domains.Examguide;
import com.yrw.domains.Examguidetype;
import com.yrw.idao.IExamGuideDao;

public class ExamGuideService {

	private IExamGuideDao iExamGuideDao;

	public void setiExamGuideDao(IExamGuideDao iExamGuideDao) {
		this.iExamGuideDao = iExamGuideDao;
	}

	public ExamGuideService() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 根据科目ID返回考试指南列表
	 * 
	 * @param subjectID
	 * @return
	 */
	public List<JExamGuideType> getExamGuideTypeListBySubjectId(int subjectID) {
		List<Examguidetype> examguidetypes = iExamGuideDao.getExamguidetypesBySubjectId(subjectID);
		List<JExamGuideType> jExamGuideTypes = new ArrayList<JExamGuideType>();
		if (examguidetypes != null) {
			for (Examguidetype examguidetype : examguidetypes) {
				jExamGuideTypes.add(JExamGuideType.LocalToNet(examguidetype));
			}
		}
		return jExamGuideTypes;
	}

	/**
	 * 根据考试指南类型ID返回文章列表
	 * 
	 * @param examGuideTypeId
	 * @return
	 */
	public List<JExamGuide> getExamGuideListByTypeId(int examGuideTypeId) {
		List<Examguide> examguides = iExamGuideDao.getExamguidesByExamguideTypeId(examGuideTypeId);
		List<JExamGuide> jExamGuides = new ArrayList<JExamGuide>();
		if (examguides != null) {
			for (Examguide examguide : examguides) {
				jExamGuides.add(JExamGuide.LocalToNet(examguide));
			}
		}

		return jExamGuides;
	}
}
