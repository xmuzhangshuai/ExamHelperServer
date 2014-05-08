package com.yrw.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.yrw.config.DefaultValue;
import com.yrw.domains.Examination;
import com.yrw.domains.Examquestion;
import com.yrw.domains.Examsection;
import com.yrw.domains.Materialanalysis;
import com.yrw.domains.Multichoice;
import com.yrw.domains.Singlechoice;
import com.yrw.domains.Trueorfalse;
import com.yrw.idao.IExamQuestionDao;
import com.yrw.idao.IExamSectionDao;
import com.yrw.idao.IExaminationDao;
import com.yrw.idao.IMaterialAnalysisDao;
import com.yrw.idao.IMultiChoiceDao;
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
	 * 根据科目Id返回试卷列表
	 * 
	 * @param subjectId
	 * @return
	 */
	public List<Examination> getExaminationListBySubjectId(int subjectId) {
		return iExaminationDao.getExamBySubject(subjectId);
	}

	public List<Examination> listExaminations(String pageNowString) {
		int pageNow = 1;
		int pageCount = iExaminationDao.getPageCount();
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
		List<Examination> examsList = iExaminationDao.getExam(pageNow);

		List collection = new ArrayList();
		collection.add(pageMap);
		collection.add(examsList);
		return collection;
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
		Examquestion targetExamquestion = null;
		Iterator<Examsection> examSectionIterator = examination
				.getExamsections().iterator();
		while (examSectionIterator.hasNext()) {
			examsection = examSectionIterator.next();
			if (examsection.getQuestiontype().getTypeName()
					.equals(DefaultValue.SINGLE_CHOICE)) {
				List<Examquestion> examquestionList = new ArrayList<Examquestion>(
						examsection.getExamquestions());
				for (int j = 0; j < examquestionList.size(); j++) {

					examquestion = examquestionList.get(j);
					if (examquestion.getQuestionId() == singleChoiceId) {
						if (type.equals("decrease")) {

							targetExamquestion = examquestionList.get(j - 1);

							targetExamquestion.setQuestionNumber(examquestion
									.getQuestionNumber());
							examquestion.setQuestionNumber(examquestion
									.getQuestionNumber() - 1);
							examquestionList.set(j, examquestion);
							examquestionList.set(j - 1, targetExamquestion);

						}

						else {

							targetExamquestion = examquestionList.get(j + 1);
							targetExamquestion.setQuestionNumber(examquestion
									.getQuestionNumber());
							examquestion.setQuestionNumber(examquestion
									.getQuestionNumber() + 1);

							examquestionList.set(j, examquestion);
							examquestionList.set(j + 1, targetExamquestion);
						}

						Set<Examquestion> examquestionSet = new HashSet<Examquestion>(
								examquestionList);
						examsection.setExamquestions(examquestionSet);
						iExamSectionDao.update(examsection);
						break;
					}

				}
			}
		}

		// while (examSectionIterator.hasNext()) {
		// examsection = examSectionIterator.next();
		// if (examsection.getQuestiontype().getTypeName()
		// .equals(DefaultValue.SINGLE_CHOICE)) {
		// List<Examquestion> examquestions = new ArrayList<Examquestion>(
		// examsection.getExamquestions());
		// for (int i = 0; i < examquestions.size(); i++) {
		// if (examquestions.get(i).getQuestionId() == singleChoiceId) {
		// if (type.equals("decrease")) {
		// examquestion = examquestions.get(i);
		// repalcedExamquestion = examquestions.get(i - 1);
		//
		// repalcedExamquestion.setQuestionNumber(examquestion
		// .getQuestionNumber());
		// examquestion.setQuestionNumber(examquestion
		// .getQuestionNumber() - 1);
		// examquestions.set(i, examquestion);
		// examquestions.set(i - 1, repalcedExamquestion);
		//
		// } else {
		// examquestion = examquestions.get(i);
		// repalcedExamquestion = examquestions.get(i + 1);
		// System.out.println("increase moveSingleChoice "
		// + examquestion.getQuestionNumber() + "  "
		// + repalcedExamquestion.getQuestionNumber());
		//
		// repalcedExamquestion.setQuestionNumber(examquestion
		// .getQuestionNumber());
		// examquestion.setQuestionNumber(examquestion
		// .getQuestionNumber() + 1);
		//
		// examquestions.set(i, examquestion);
		// examquestions.set(i + 1, repalcedExamquestion);
		//
		// }
		// iExamQuestionDao.update(examquestion);
		// iExamQuestionDao.update(repalcedExamquestion);
		// iExamSectionDao.update(examsection);
		// iExaminationDao.update(examination);
		// }
		// }
		// }
		// }
	}

	/**
	 * 从试卷中剔除某个题目
	 * 
	 * @param examId
	 * @param singleChoiceId
	 */
	public void removeExamQuestion(int questionId, int examSectionId,
			Examsection examsection) {
		Set<Examquestion> examquestions = examsection.getExamquestions();
		List<Examquestion> examquestionList = new ArrayList<Examquestion>(
				examquestions);
		// int targetExamQuestionId = 0;
		boolean flag = true;
		for (int i = 0; i < examquestionList.size(); i++) {
			if (flag) {
				if (questionId == examquestionList.get(i).getQuestionId()) {
					examquestionList.remove(i);
					iExamQuestionDao.deletById(Examquestion.class,
							examquestionList.get(i).getId());
					flag = false;

				}
			} else
				iExamQuestionDao.updateQuestionNumber(examquestionList.get(i)
						.getId(),
						examquestionList.get(i).getQuestionNumber() - 1);
		}

		examquestions = new HashSet<Examquestion>(examquestionList);
		examsection.setExamquestions(examquestions);

		// 修改后续章节的examquestionNumber
		Examquestion exq = null;
		List<Examsection> nextExamsections = iExamSectionDao
				.getExamsectionsByExamIdAndExamSectionId(examsection
						.getExamination().getId(), examSectionId);
		if (nextExamsections != null) {

			for (int i = 0; i < nextExamsections.size(); i++) {
				Iterator<Examquestion> iterator = nextExamsections.get(i)
						.getExamquestions().iterator();
				while (iterator.hasNext()) {
					exq = (Examquestion) iterator.next();
					iExamQuestionDao.updateQuestionNumber(exq.getId(),
							exq.getQuestionNumber() - 1);
				}
				iExamSectionDao.update(nextExamsections.get(i));
			}

			// 修改examsection中的题目数量
			examsection.setQuestionNum(examsection.getQuestionNum() - 1);
			iExamSectionDao.update(examsection);
		}
	}

	public void addExamQuestion(int questionId, int examSectionId,
			Examsection examsection) {
		Set<Examquestion> examquestions = examsection.getExamquestions();
		List<Examquestion> examquestionList = new ArrayList<Examquestion>(
				examquestions);
		boolean exist = false;
		for (int i = 0; i < examquestionList.size(); i++) {
			if (questionId == examquestionList.get(i).getQuestionId()) {
				exist = true;
				break;
			}
		}
		if (!exist) {
			// 建立examQuestion
			Examquestion examquestion = new Examquestion();
			examquestion.setExamsection(examsection);
			examquestion.setQuestionId(questionId);
			int questionNumber = iExamQuestionDao
					.getMaxQuestionNumberByExamSection(examSectionId);
			System.out.println("MaxQuestionNumber  "+questionNumber);
			if (questionNumber != 0) {
				examquestion.setQuestionNumber(questionNumber + 1);
			} else
				examquestion.setQuestionNumber(1);
			int examQuestionId = iExamQuestionDao
					.addQuestionNumberWithReturn(examquestion);
			examquestion.setId(examQuestionId);
			// 添加入examSection中的examQuestion集合
			examquestions.add(examquestion);
			examsection.setExamquestions(examquestions);
			// 修改后续章节的examquestionNumber
			List<Examsection> nextExamsections = iExamSectionDao
					.getExamsectionsByExamIdAndExamSectionId(examsection
							.getExamination().getId(), examSectionId);
			if (nextExamsections != null) {
				Examquestion exq = null;
				for (int i = 0; i < nextExamsections.size(); i++) {
					Iterator<Examquestion> iterator = nextExamsections.get(i)
							.getExamquestions().iterator();
					while (iterator.hasNext()) {
						exq = (Examquestion) iterator.next();
						System.out.println("quesiontNumber "+exq.getQuestionNumber());
						iExamQuestionDao.updateQuestionNumber(exq.getId(),
								exq.getQuestionNumber() + 1);
						exq.setQuestionNumber(exq.getQuestionNumber()+1);
					}
					iExamSectionDao.update(nextExamsections.get(i));
				}
			}

			// 修改examsection中的题目数量
			if (examsection.getQuestionNum() != null)
				examsection.setQuestionNum(examsection.getQuestionNum() + 1);
			else
				examsection.setQuestionNum(1);

			iExamSectionDao.update(examsection);
		}
	}

	/**
	 * 添加新的试题信息，并返回examination对象
	 * 
	 * @param examinationForm
	 */
	public Examination addExaminationInfor(Examination examination) {
		int examinationId = (Integer) iExaminationDao.addReturnId(examination);
		examination = iExaminationDao.showExam(examinationId);
		return examination;
	}

	/**
	 * 添加examS
	 * 
	 * @param examsection
	 */
	public void addExamSection(Examsection examsection) {
		iExamSectionDao.add(examsection);
	}

	/**
	 * 删除试卷
	 * 
	 * @param examination
	 */
	public void deleteExamination(int examinationId) {
		iExaminationDao.deletById(Examination.class, examinationId);
	}

	public void deleteExamSection(int examSectionId) {
		iExamSectionDao.deletById(Examsection.class, examSectionId);
	}
}
