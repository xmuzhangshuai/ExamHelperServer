package com.yrw.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.yrw.config.DefaultValue;
import com.yrw.domains.Examination;
import com.yrw.domains.Examquestion;
import com.yrw.domains.Examsection;
import com.yrw.domains.Materialanalysis;
import com.yrw.domains.Multichoice;
import com.yrw.domains.Section;
import com.yrw.domains.Singlechoice;
import com.yrw.domains.Trueorfalse;
import com.yrw.idao.IExamQuestionDao;
import com.yrw.idao.IExamSectionDao;
import com.yrw.idao.IExaminationDao;
import com.yrw.idao.IMaterialAnalysisDao;
import com.yrw.idao.IMultiChoiceDao;
import com.yrw.idao.IQuestionTypeDao;
import com.yrw.idao.IQuestionsOfMaterial;
import com.yrw.idao.ISingleChoiceDao;
import com.yrw.idao.ITrueOrFalseDao;

public class ExamService {

	private IExaminationDao iExaminationDao;
	private IExamQuestionDao iExamQuestionDao;
	private IExamSectionDao iExamSectionDao;

	private ISingleChoiceDao iSingleChoiceDao;
	private IMultiChoiceDao iMultiChoiceDao;
	private ITrueOrFalseDao iTrueOrFalseDao;
	private IMaterialAnalysisDao iMaterialAnalysisDao;
	private IQuestionsOfMaterial iQuestionsOfMaterial;

	public void setiQuestionsOfMaterial(
			IQuestionsOfMaterial iQuestionsOfMaterial) {
		this.iQuestionsOfMaterial = iQuestionsOfMaterial;
	}

	public void setiSingleChoiceDao(ISingleChoiceDao iSingleChoiceDao) {
		this.iSingleChoiceDao = iSingleChoiceDao;
	}

	public void setiMultiChoiceDao(IMultiChoiceDao iMultiChoiceDao) {
		this.iMultiChoiceDao = iMultiChoiceDao;
	}

	public void setiTrueOrFalseDao(ITrueOrFalseDao iTrueOrFalseDao) {
		this.iTrueOrFalseDao = iTrueOrFalseDao;
	}

	public void setiMaterialAnalysisDao(
			IMaterialAnalysisDao iMaterialAnalysisDao) {
		this.iMaterialAnalysisDao = iMaterialAnalysisDao;
	}

	public void setiExaminationDao(IExaminationDao iExaminationDao) {
		this.iExaminationDao = iExaminationDao;
	}

	public void setiExamQuestionDao(IExamQuestionDao iExamQuestionDao) {
		this.iExamQuestionDao = iExamQuestionDao;
	}

	public void setiExamSectionDao(IExamSectionDao iExamSectionDao) {
		this.iExamSectionDao = iExamSectionDao;
	}

	/**
	 * 显示某个科目下的所有大题
	 * 
	 * @param subjectId
	 * @return
	 */
	public List<Examination> listExaminations(String pageNowString,
			int subjectId) {
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

	/**
	 * 通过试卷Id得到examination对象
	 * 
	 * @param examinationId
	 * @return
	 */
	public Examination getExamination(int examinationId) {
		return (Examination) iExaminationDao.showExam(examinationId);
	}

	public Examsection getExamsection(int examSectionId) {
		return (Examsection) iExamSectionDao.showExamsection(examSectionId);
	}

	/**
	 * 通过试卷章节返回该章节下的所有题目集合
	 * 
	 * @param examsection
	 * @return
	 */
	public Object getQuestions(Examsection examsection) {
		List<Examquestion> examquestions = new ArrayList<Examquestion>(
				examsection.getExamquestions());
		if (examsection.getQuestiontype().getTypeName()
				.equals(DefaultValue.SINGLE_CHOICE)) {
			List<Singlechoice> singlechoiceList = new ArrayList<Singlechoice>();
			Singlechoice singlechoice = null;

			for (int i = 0; i < examquestions.size(); i++) {
				int singleChoiceId = examquestions.get(i).getQuestionId();
				singlechoice = iSingleChoiceDao
						.showSinglechoice(singleChoiceId);
				if (singlechoice != null) {

					singlechoiceList.add(singlechoice);
				}
			}
			return singlechoiceList;
		} else if (examsection.getQuestiontype().getTypeName()
				.equals(DefaultValue.MULTI_CHOICE)) {
			List<Multichoice> multichoiceList = new ArrayList<Multichoice>();
			Multichoice multichoice = null;

			for (int i = 0; i < examquestions.size(); i++) {
				int multiChoiceId = examquestions.get(i).getQuestionId();
				multichoice = iMultiChoiceDao.showMultichoice(multiChoiceId);
				if (multichoice != null) {
					multichoiceList.add(multichoice);
				}
			}
			return multichoiceList;
		} else if (examsection.getQuestiontype().getTypeName()
				.equals(DefaultValue.TRUE_OR_FALSE)) {
			List<Trueorfalse> trueorfalseList = new ArrayList<Trueorfalse>();
			Trueorfalse trueorfalse = null;

			for (int i = 0; i < examquestions.size(); i++) {
				int trueOrFalseId = examquestions.get(i).getQuestionId();
				trueorfalse = iTrueOrFalseDao.showTrueorfalse(trueOrFalseId);
				if (trueorfalse != null) {

					trueorfalseList.add(trueorfalse);
				}
			}
			return trueorfalseList;
		} else if (examsection.getQuestiontype().getTypeName()
				.equals(DefaultValue.MATERIAL_ANALYSIS)) {
			List<Materialanalysis> materialanalysisList = new ArrayList<Materialanalysis>();
			Materialanalysis materialanalysis = null;

			for (int i = 0; i < examquestions.size(); i++) {
				int materialAnalysisId = examquestions.get(i).getQuestionId();
				materialanalysis = iMaterialAnalysisDao
						.showMaterialAnalysis(materialAnalysisId);
				if (materialanalysis != null) {
					materialanalysisList.add(materialanalysis);
				}

			}
			return materialanalysisList;
		}
		return null;
	}

	/**
	 * 上移singleChoice在试卷中的位置
	 * 
	 * @param singleChoiceId
	 */
	public void moveSingleChoice(int singleChoiceId, String type, int examId) {
		// 获得examSection对象
		Examination examination = iExaminationDao.showExam(examId);
		Examsection examsection = null;
		Examquestion examquestion = null;
		Examquestion repalcedExamquestion=null;
		Iterator<Examsection> Iterator = examination.getExamsections()
				.iterator();
		while (Iterator.hasNext()) {
			examsection = Iterator.next();
			if (examsection.getQuestiontype().getTypeName()
					.equals(DefaultValue.SINGLE_CHOICE)) {
				List<Examquestion> examquestions = new ArrayList<Examquestion>(
						examsection.getExamquestions());
				for (int i = 0; i < examquestions.size(); i++) {
					if (examquestions.get(i).getQuestionId() == singleChoiceId) {
						if (type.equals("decrease")) {
							examquestion = examquestions.get(i);
							repalcedExamquestion=examquestions.get(i-1);
							System.out.println("moveSingleChoice "
									+ examquestion.getQuestionId());
							repalcedExamquestion.setQuestionNumber(
									examquestion.getQuestionNumber());
							examquestion.setQuestionNumber(examquestion
									.getQuestionNumber() - 1);
						} else {
							examquestion = examquestions.get(i);
							repalcedExamquestion=examquestions.get(i+1);
							repalcedExamquestion.setQuestionNumber(
									examquestion.getQuestionNumber());
							examquestion.setQuestionNumber(examquestion
									.getQuestionNumber() + 1);
						}
						iExamQuestionDao.update(examquestion);
						iExamQuestionDao.update(repalcedExamquestion);
					}
				}
			}
		}
	}
}
