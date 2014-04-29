package com.yrw.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.yrw.domains.Questiontype;
import com.yrw.domains.Section;
import com.yrw.domains.Subject;
import com.yrw.idao.IQuestionTypeDao;

public class UpdateLibraryService {

	private QuestionService questionService;
	private SubjectService subjectService;
	private IQuestionTypeDao iQuestionTypeDao;

	public void setQuestionService(QuestionService questionService) {
		this.questionService = questionService;
	}

	public void setSubjectService(SubjectService subjectService) {
		this.subjectService = subjectService;
	}

	public void setiQuestionTypeDao(IQuestionTypeDao iQuestionTypeDao) {
		this.iQuestionTypeDao = iQuestionTypeDao;
	}

	/**
	 * 检查更新
	 * 
	 * @return
	 */
	public boolean checkUpdate(List<Map<String, Object>> data) {
		int subjectId = Integer.parseInt((String) data.get(0).get("subjectId"));
		// 如果科目有变化
		if (subjectService.getSubjectById(subjectId) == null) {
			return true;
		}
		Subject subject = subjectService.getSubjectById(subjectId);
		List<Section> sections = new ArrayList<Section>(subject.getSections());
		int count = 0;
		for (Section section : sections) {
			count = count + section.getSinglechoices().size() + section.getMultichoices().size()
					+ section.getMaterialanalysises().size();
		}

		// 如果个数不一致
		if (count != data.size()) {
			return true;
		}

		for (Map<String, Object> map : data) {
			int questionTypeId = Integer.parseInt((String) map.get("questionTypeId"));
			int questionId = Integer.parseInt((String) map.get("questionId"));
			Questiontype questiontype = iQuestionTypeDao.getQuestiontypeById(questionTypeId);
			if (questiontype != null) {
				Object object = questionService.getQuestion(questionId, questiontype.getTypeName());
				if (object == null)
					return true;
			} else {
				return true;
			}
		}
		return false;

	}
}
