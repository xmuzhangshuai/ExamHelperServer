package com.yrw.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.engine.spi.Mapping;

import com.yrw.config.DefaultValue;
import com.yrw.dao.QuestionOfMaterialDao;
import com.yrw.domains.Materialanalysis;
import com.yrw.domains.Multichoice;
import com.yrw.domains.Questionsofmaterial;
import com.yrw.domains.Questiontype;
import com.yrw.domains.Section;
import com.yrw.domains.Singlechoice;
import com.yrw.domains.Subject;
import com.yrw.domains.Trueorfalse;
import com.yrw.idao.IMaterialAnalysisDao;
import com.yrw.idao.IMultiChoiceDao;
import com.yrw.idao.IQuestionTypeDao;
import com.yrw.idao.IQuestionsOfMaterial;
import com.yrw.idao.ISectionDao;
import com.yrw.idao.ISingleChoiceDao;
import com.yrw.idao.ISubjectDao;
import com.yrw.idao.ITrueOrFalseDao;
import com.yrw.web.forms.MaterialAnalysisForm;

/**
 * @author Administrator
 *
 */
/**
 * @author Administrator
 * 
 */
public class QuestionService {
	private IQuestionTypeDao iQuestionTypeDao;
	private ISingleChoiceDao iSingleChoiceDao;
	private IMultiChoiceDao iMultiChoiceDao;
	private ITrueOrFalseDao iTrueOrFalseDao;
	private IMaterialAnalysisDao iMaterialAnalysisDao;
	private IQuestionsOfMaterial iQuestionsOfMaterial;
	private ISectionDao iSectionDao;
	private ISubjectDao iSubjectDao;

	public void setiSubjectDao(ISubjectDao iSubjectDao) {
		this.iSubjectDao = iSubjectDao;
	}

	public void setiSectionDao(ISectionDao iSectionDao) {
		this.iSectionDao = iSectionDao;
	}

	public void setiQuestionTypeDao(IQuestionTypeDao iQuestionTypeDao) {
		this.iQuestionTypeDao = iQuestionTypeDao;
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

	public void setiQuestionsOfMaterial(
			IQuestionsOfMaterial iQuestionsOfMaterial) {
		this.iQuestionsOfMaterial = iQuestionsOfMaterial;
	}

	// /**
	// * 根据每个科目的题型显示
	// *
	// * @param request
	// * @param typeName
	// * @param pageNow
	// * @param subjectId
	// * @return
	// */
	// public List listQuestionByType(String typeName, String pageNowString,
	// int subjectId) {
	//
	// String path = null;
	// Map<String, Integer> pageMap = new HashMap<String, Integer>();
	// List collection = new ArrayList();
	// if (typeName.equals(DefaultValue.SINGLE_CHOICE)) {
	// int pageCount = iSingleChoiceDao.getPageCountBySubject(subjectId);
	// int pageNow = 1;
	// if (pageNowString != null) {
	// pageNow = Integer.parseInt(pageNowString);
	// if (pageNow < 1)
	// pageNow = 1;
	// else if (pageNow > pageCount)
	// pageNow = pageCount;
	//
	// }
	//
	// pageMap.put("pageCount", pageCount);
	// pageMap.put("pageNow", pageNow);
	//
	// List singleCohiceList = iSingleChoiceDao.getSingleChoiceBySubject(
	// pageNow, subjectId);
	//
	// collection.add(pageCount);
	// collection.add(singleCohiceList);
	// collection.add("showSingleChoice");
	//
	// } else if (typeName.equals(DefaultValue.MULTI_CHOICE)) {
	// int pageCount = iMultiChoiceDao.getPageCountBySubject(subjectId);
	// int pageNow = 1;
	// if (pageNowString != null) {
	// pageNow = Integer.parseInt(pageNowString);
	// if (pageNow < 1)
	// pageNow = 1;
	// else if (pageNow > pageCount)
	// pageNow = pageCount;
	//
	// }
	//
	// pageMap.put("pageCount", pageCount);
	// pageMap.put("pageNow", pageNow);
	//
	// List multiCohiceList = iMultiChoiceDao.getMultiChoiceBySubject(
	// pageNow, subjectId);
	//
	// collection.add(pageCount);
	// collection.add(multiCohiceList);
	// collection.add("showMultiChoice");
	//
	// } else if (typeName.equals(DefaultValue.TRUE_OR_FALSE)) {
	// int pageCount = iTrueOrFalseDao.getPageCountBySubject(subjectId);
	// int pageNow = 1;
	// if (pageNowString != null) {
	// pageNow = Integer.parseInt(pageNowString);
	// if (pageNow < 1)
	// pageNow = 1;
	// else if (pageNow > pageCount)
	// pageNow = pageCount;
	//
	// }
	//
	// pageMap.put("pageCount", pageCount);
	// pageMap.put("pageNow", pageNow);
	//
	// List trueOrFalseList = iTrueOrFalseDao.getTrueOrFalseBySubject(
	// pageNow, subjectId);
	//
	// collection.add(pageCount);
	// collection.add(trueOrFalseList);
	// collection.add("showTrueOrFalse");
	//
	// } else if (typeName.equals(DefaultValue.MATERIAL_ANALYSIS)) {
	// int pageCount = iMaterialAnalysisDao
	// .getPageCountBySubject(subjectId);
	// int pageNow = 1;
	// if (pageNowString != null) {
	// pageNow = Integer.parseInt(pageNowString);
	// if (pageNow < 1)
	// pageNow = 1;
	// else if (pageNow > pageCount)
	// pageNow = pageCount;
	//
	// }
	//
	// pageMap.put("pageCount", pageCount);
	// pageMap.put("pageNow", pageNow);
	//
	// List materialAnalysisList = iMaterialAnalysisDao
	// .getMaterialAnalysisBySubject(pageNow, subjectId);
	//
	// collection.add(pageCount);
	// collection.add(materialAnalysisList);
	// collection.add("showMaterialAnalysis");
	// }
	// return collection;
	// }

	/**
	 * 根据科目下的章节显示题目列表
	 * 
	 * @param sectionId
	 * @return
	 */
	public List listQuestionBySection(int sectionId, String pageNowString,
			String typeName) {
		Map<String, Integer> pageMap = new HashMap<String, Integer>();
		List collection = new ArrayList();
		if (typeName.equals(DefaultValue.SINGLE_CHOICE)) {
			int pageCount = iSingleChoiceDao.getPageCountBySection(sectionId);
			int pageNow = 1;
			if (pageNowString != null) {
				pageNow = Integer.parseInt(pageNowString);
				if (pageNow < 1)
					pageNow = 1;
				else if (pageNow > pageCount)
					pageNow = pageCount;

			}

			pageMap.put("pageCount", pageCount);
			pageMap.put("pageNow", pageNow);

			List<Singlechoice> singleCohiceList = iSingleChoiceDao
					.getSingleChoiceBySection(pageNow, sectionId);

			collection.add(pageMap);
			collection.add(singleCohiceList);
			collection.add("showSingleChoiceList");

		} else if (typeName.equals(DefaultValue.MULTI_CHOICE)) {
			int pageCount = iMultiChoiceDao.getPageCountBySection(sectionId);
			int pageNow = 1;
			if (pageNowString != null) {
				pageNow = Integer.parseInt(pageNowString);
				if (pageNow < 1)
					pageNow = 1;
				else if (pageNow > pageCount)
					pageNow = pageCount;

			}

			pageMap.put("pageCount", pageCount);
			pageMap.put("pageNow", pageNow);

			List multiCohiceList = iMultiChoiceDao.getMultiChoiceBySection(
					pageNow, sectionId);

			collection.add(pageMap);
			collection.add(multiCohiceList);
			collection.add("showMultiChoiceList");

		} else if (typeName.equals(DefaultValue.TRUE_OR_FALSE)) {
			int pageCount = iTrueOrFalseDao.getPageCountBySection(sectionId);
			int pageNow = 1;
			if (pageNowString != null) {
				pageNow = Integer.parseInt(pageNowString);
				if (pageNow < 1)
					pageNow = 1;
				else if (pageNow > pageCount)
					pageNow = pageCount;

			}

			pageMap.put("pageCount", pageCount);
			pageMap.put("pageNow", pageNow);

			List trueOrFalseList = iTrueOrFalseDao.getTrueOrFalseBySection(
					pageNow, sectionId);

			collection.add(pageMap);
			collection.add(trueOrFalseList);
			collection.add("showTrueOrFalseList");

		} else if (typeName.equals(DefaultValue.MATERIAL_ANALYSIS)) {
			int pageCount = iMaterialAnalysisDao
					.getPageCountBySection(sectionId);
			int pageNow = 1;
			if (pageNowString != null) {
				pageNow = Integer.parseInt(pageNowString);
				if (pageNow < 1)
					pageNow = 1;
				else if (pageNow > pageCount)
					pageNow = pageCount;

			}

			pageMap.put("pageCount", pageCount);
			pageMap.put("pageNow", pageNow);

			List materialAnalysisList = iMaterialAnalysisDao
					.getMaterialAnalysisBySection(pageNow, sectionId);

			collection.add(pageMap);
			collection.add(materialAnalysisList);
			collection.add("showMaterialAnalysisList");

		}
		return collection;
	}

	/**
	 * 得到某个题对象
	 * 
	 * @param id
	 * @param typeName
	 * @return
	 */
	public Object getQuestion(int id, String typeName) {
		if (typeName.equals(DefaultValue.SINGLE_CHOICE)) {
			return iSingleChoiceDao.showSinglechoice(id);
		}

		else if (typeName.equals(DefaultValue.MULTI_CHOICE)) {
			return iMultiChoiceDao.showMultichoice(id);

		} else if (typeName.equals(DefaultValue.TRUE_OR_FALSE)) {
			return iTrueOrFalseDao.showTrueorfalse(id);

		} else if (typeName.equals(DefaultValue.MATERIAL_ANALYSIS)) {
			return iMaterialAnalysisDao.showMaterialAnalysis(id);
		} else if (typeName.equals(DefaultValue.QUESTION_OF_MATERIAL)) {
			return iQuestionsOfMaterial.showQuestionOfMaterial(id);
		}
		return null;
	}

	/**
	 * 删除某个题
	 * 
	 * @param request
	 * @param typeName
	 * @param id
	 */
	public void deleteQuestion(String typeName, Object object) {
		if (typeName.equals(DefaultValue.SINGLE_CHOICE))
			iSingleChoiceDao.delSingleChoice(object);

		else if (typeName.equals(DefaultValue.MULTI_CHOICE))
			iMultiChoiceDao.delMultiChoice(object);

		else if (typeName.equals(DefaultValue.TRUE_OR_FALSE))
			iTrueOrFalseDao.delTrueOrFalse(object);
		else if (typeName.equals(DefaultValue.MATERIAL_ANALYSIS))
			iMaterialAnalysisDao.delMaterialAnalysis(object);
		else if (typeName.equals(DefaultValue.QUESTION_OF_MATERIAL))
			iQuestionsOfMaterial.delQuestionOfMaterial(object);

	}

	/**
	 * 显示问题类型列表，单选题、多选题
	 * 
	 * @param typeName
	 * @return
	 */
	public List<Questiontype> showQuestiontypes(String typeName) {
		List<Questiontype> questiontypes = iQuestionTypeDao.getQuestionTypes();
		Questiontype questiontype = null;
		int i = 0;
		for (; i < questiontypes.size(); i++) {
			if (questiontypes.get(i).getTypeName().equals(typeName)) {
				questiontype = questiontypes.get(i);
				break;
			}
		}

		questiontypes.set(i, questiontypes.get(0));
		questiontypes.set(0, questiontype);
		return questiontypes;
	}

	// /**
	// * 显示题型
	// *
	// * @param pageNowString
	// * @return
	// */
	// public List listType(String pageNowString) {
	// int pageNow = 1;
	// int pageCount = iQuestionTypeDao.getPageCount();
	// if (pageNowString != null) {
	// pageNow = Integer.parseInt(pageNowString);
	// if (pageNow < 1)
	// pageNow = 1;
	// else if (pageNow > pageCount)
	// pageNow = pageCount;
	// }
	// List list = iQuestionTypeDao.getQuestionType(pageNow);
	// return list;
	// }

	/**
	 * 添加单选题
	 * 
	 * @param sectionId
	 * @param singlechoice
	 */
	public void addSingleChoice(Singlechoice singlechoice) {
		iSingleChoiceDao.addSingleChoice(singlechoice);

	}

	/**
	 * 添加多选题
	 * 
	 * @param multichoice
	 */
	public void addMultiChoice(Multichoice multichoice) {
		iMultiChoiceDao.add(multichoice);
	}

	/**
	 * 增加判断题
	 * 
	 * @param sectionId
	 * @param trueorfalse
	 */
	public void addTrueOrFalse(Trueorfalse trueorfalse) {
		iTrueOrFalseDao.add(trueorfalse);
	}

	/**
	 * 增加材料分析题,返回该题的Id号
	 * 
	 * @param sectionId
	 * @param materialanalysis
	 * @param questionofMaterial
	 */
	public int addMaterialAnalysis(Materialanalysis materialanalysis) {

		iMaterialAnalysisDao.add(materialanalysis);
		int materialAnalysisId = iMaterialAnalysisDao
				.getMaterialAnalysisIdByMaterial(materialanalysis.getMaterial());
		return materialAnalysisId;
	}

	/**
	 * 增加材料分析题的小题
	 * 
	 * @param materialAnalysisId
	 * @param questionsofmaterial
	 */
	public void addQuestionofMaterial(int materialAnalysisId,
			Questionsofmaterial questionsofmaterial) {

		Materialanalysis materialanalysis = iMaterialAnalysisDao
				.showMaterialAnalysis(materialAnalysisId);
		Set<Questionsofmaterial> questionsofmaterialSet = materialanalysis
				.getQuestionsofmaterials();

		questionsofmaterial.setMaterialanalysis(materialanalysis);
		questionsofmaterialSet.add(questionsofmaterial);

		iMaterialAnalysisDao.update(materialanalysis);
		iQuestionsOfMaterial.add(questionsofmaterial);

	}

	/**
	 * 修改单选题
	 * 
	 * @param singlechoice
	 */
	public void updateSingleChoice(Singlechoice singlechoice) {
		iSingleChoiceDao.updateSinglechoice(singlechoice);
	}

	/**
	 * 修改多选题
	 * 
	 * @param multichoice
	 */
	public void updateMultiChoice(Multichoice multichoice) {
		iMultiChoiceDao.update(multichoice);
	}

	/**
	 * 修改判断题
	 * 
	 * @param trueorfalse
	 */
	public void updateTrueOrFalse(Trueorfalse trueorfalse) {
		iTrueOrFalseDao.updateTrueOrFalse(trueorfalse);
	}

	/**
	 * 修改材料题
	 * 
	 * @param materialanalysis
	 */
	public void updateMaterialAnalysis(Materialanalysis materialanalysis) {
		iMaterialAnalysisDao.updateMaterialAnalysis(materialanalysis);
	}

	public void updateQuestionofMaterial(Questionsofmaterial questionsofmaterial) {
		iQuestionsOfMaterial.updateQuestionOfMaterial(questionsofmaterial);
	}

	/**
	 * 得到某道材料分析题已有最大小题编号
	 * 
	 * @param materialId
	 * @return
	 */
	public int getMaxQuestionNumByMaterialId(int materialAnalysisId) {
		return iQuestionsOfMaterial
				.getMaxQuestionNumByMaterialId(materialAnalysisId);
	}

	/**
	 * 修改小题的编号
	 * 
	 * @param questionNumber
	 * @param materialanalysis
	 */
	public void updateQuestionNumber(int questionNumber,
			Materialanalysis materialanalysis) {

		List<Questionsofmaterial> questionsofmaterials = new ArrayList<Questionsofmaterial>(
				materialanalysis.getQuestionsofmaterials());

		for (int i = 0; i < questionsofmaterials.size(); i++) {

			if (questionsofmaterials.get(i).getQuestionNumber() > questionNumber)
				questionsofmaterials.get(i).setQuestionNumber(
						questionsofmaterials.get(i).getQuestionNumber() - 1);
		}
		Set<Questionsofmaterial> set = new HashSet<Questionsofmaterial>();
		for (Iterator it = questionsofmaterials.iterator(); it.hasNext();) {
			set.add((Questionsofmaterial) it.next());
		}
		materialanalysis.setQuestionsofmaterials(set);
		iMaterialAnalysisDao.updateMaterialAnalysis(materialanalysis);
	}

	/**
	 * 减小题目编号
	 * 
	 * @param questionNumber
	 * @param materialanalysis
	 */
	public void decreaseQuestionNumber(Questionsofmaterial questionsofmaterial) {
		if (questionsofmaterial.getQuestionNumber() != 1) {
			Materialanalysis materialanalysis = questionsofmaterial
					.getMaterialanalysis();
			List<Questionsofmaterial> questionsofmaterials = new ArrayList<Questionsofmaterial>(
					materialanalysis.getQuestionsofmaterials());
			for (int i = 0; i < questionsofmaterials.size(); i++) {
				if (questionsofmaterials.get(i).getQuestionNumber() + 1 == questionsofmaterial
						.getQuestionNumber()) {
					questionsofmaterials.get(i).setQuestionNumber(questionsofmaterial.getQuestionNumber());
					questionsofmaterial.setQuestionNumber(questionsofmaterial.getQuestionNumber()-1);
					questionsofmaterials.set(
							questionsofmaterials.indexOf(questionsofmaterial),
							questionsofmaterials.get(i));
					questionsofmaterials.set(i, questionsofmaterial);
					break;
				}
			}
		}
	}

	/**
	 * 增大题目编号
	 * 
	 * @param questionNumber
	 * @param materialanalysis
	 */
	public void increaseQuestionNumber(Questionsofmaterial questionsofmaterial) {
		System.out.println(getMaxQuestionNumByMaterialId(questionsofmaterial
				.getMaterialanalysis().getId()));
		System.out.println(questionsofmaterial.getQuestionNumber());
		if (questionsofmaterial.getQuestionNumber() < getMaxQuestionNumByMaterialId(questionsofmaterial
				.getMaterialanalysis().getId())) {
			Materialanalysis materialanalysis = questionsofmaterial
					.getMaterialanalysis();
			List<Questionsofmaterial> questionsofmaterials = new ArrayList<Questionsofmaterial>(
					materialanalysis.getQuestionsofmaterials());
			for (int i = 0; i < questionsofmaterials.size(); i++) {
				if (questionsofmaterials.get(i).getQuestionNumber() - 1 == questionsofmaterial
						.getQuestionNumber()) {
				
					questionsofmaterials.get(i).setQuestionNumber(questionsofmaterial.getQuestionNumber());
					questionsofmaterial.setQuestionNumber(questionsofmaterial.getQuestionNumber()+1);
					questionsofmaterials.set(
							questionsofmaterials.indexOf(questionsofmaterial),
							questionsofmaterials.get(i));
					questionsofmaterials.set(i, questionsofmaterial);
					break;
				}
			}
		}
	}
}
