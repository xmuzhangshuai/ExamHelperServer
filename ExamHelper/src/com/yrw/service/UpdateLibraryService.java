package com.yrw.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.jsonobjects.JExamQuestion;
import com.jsonobjects.JExamSection;
import com.jsonobjects.JExamination;
import com.jsonobjects.JMaterialAnalysis;
import com.jsonobjects.JMultiChoice;
import com.jsonobjects.JQuestionsOfMaterial;
import com.jsonobjects.JSection;
import com.jsonobjects.JSingleChoice;
import com.yrw.domains.Examination;
import com.yrw.domains.Examquestion;
import com.yrw.domains.Examsection;
import com.yrw.domains.Materialanalysis;
import com.yrw.domains.Multichoice;
import com.yrw.domains.Questionsofmaterial;
import com.yrw.domains.Questiontype;
import com.yrw.domains.Section;
import com.yrw.domains.Singlechoice;
import com.yrw.domains.Subject;
import com.yrw.idao.IQuestionTypeDao;

public class UpdateLibraryService {

	private QuestionService questionService;
	private SubjectService subjectService;
	private IQuestionTypeDao iQuestionTypeDao;
	private SectionService sectionService;
	private ExamService examService;

	public void setQuestionService(QuestionService questionService) {
		this.questionService = questionService;
	}

	public void setSubjectService(SubjectService subjectService) {
		this.subjectService = subjectService;
	}

	public void setiQuestionTypeDao(IQuestionTypeDao iQuestionTypeDao) {
		this.iQuestionTypeDao = iQuestionTypeDao;
	}

	public void setSectionService(SectionService sectionService) {
		this.sectionService = sectionService;
	}

	public void setExamService(ExamService examService) {
		this.examService = examService;
	}

	/**
	 * ������
	 * 
	 * @return
	 */
	public boolean checkUpdate(List<Map<String, Object>> data) {
		int subjectId = Integer.parseInt((String) data.get(0).get("subjectId"));
		// �����Ŀ�б仯
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

		// ���������һ��
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

	/**
	 * �����û���ѡ��Ŀ����Ŀ�����б�
	 * 
	 * @return
	 */
	public List<JSection> getJSections(int subjectId) {
		Subject subject = subjectService.getSubjectById(subjectId);
		List<Section> sections = sectionService.listSectionBySubject(subjectId);
		List<JSection> jSectionList = new ArrayList<JSection>();
		if (sections != null) {
			for (Section section : sections) {
				JSection jSection = JSection.LocalToNet(section);
				jSectionList.add(jSection);
			}
		}
		return jSectionList;
	}

	/**
	 * ��ȡ��Ŀ�µ�ѡ��
	 * 
	 * @param subjectId
	 * @return
	 */
	public List<JSingleChoice> getJSingleChoices(int subjectId) {
		Subject subject = subjectService.getSubjectById(subjectId);
		List<JSingleChoice> jSingleChoiceList = new ArrayList<JSingleChoice>();
		List<Singlechoice> singlechoices = new ArrayList<Singlechoice>();
		List<Section> sections = sectionService.listSectionBySubject(subjectId);
		if (sections != null) {
			for (Section section : sections) {
				singlechoices.addAll(section.getSinglechoices());
			}
		}

		if (singlechoices != null) {
			for (Singlechoice singlechoice : singlechoices) {
				jSingleChoiceList.add(JSingleChoice.LocalToNet(singlechoice));
			}
		}
		return jSingleChoiceList;
	}

	/**
	 * ��ȡ��Ŀ�µ�ѡ��
	 * 
	 * @param subjectId
	 * @return
	 */
	public List<JMultiChoice> getJMultiChoices(int subjectId) {
		List<JMultiChoice> jMultiChoiceList = new ArrayList<JMultiChoice>();
		List<Multichoice> multichoices = new ArrayList<Multichoice>();
		List<Section> sections = sectionService.listSectionBySubject(subjectId);
		if (sections != null) {
			for (Section section : sections) {
				multichoices.addAll(section.getMultichoices());
			}
		}

		if (multichoices != null) {
			for (Multichoice multichoice : multichoices) {
				jMultiChoiceList.add(JMultiChoice.LocalToNet(multichoice));
			}
		}
		return jMultiChoiceList;
	}

	/**
	 * ��ȡ��Ŀ�²�����
	 * 
	 * @param subjectId
	 * @return
	 */
	public List<JMaterialAnalysis> getJMaterias(int subjectId) {
		List<JMaterialAnalysis> jMaterialAnalysiList = new ArrayList<JMaterialAnalysis>();
		List<Materialanalysis> materialanalysis = new ArrayList<Materialanalysis>();
		List<Section> sections = sectionService.listSectionBySubject(subjectId);
		if (sections != null) {
			for (Section section : sections) {
				materialanalysis.addAll(section.getMaterialanalysises());
			}
		}

		if (materialanalysis != null) {
			for (Materialanalysis materialanaly : materialanalysis) {
				jMaterialAnalysiList.add(JMaterialAnalysis.LocalToNet(materialanaly));
			}
		}
		return jMaterialAnalysiList;
	}

	/**
	 * ��ȡ��Ŀ�²�����
	 * 
	 * @param subjectId
	 * @return
	 */
	public List<JQuestionsOfMaterial> getJQuestionsOfMaterial(int subjectId) {
		List<JQuestionsOfMaterial> jQuestionsOfMaterials = new ArrayList<JQuestionsOfMaterial>();
		List<Materialanalysis> materialanalysis = new ArrayList<Materialanalysis>();
		List<Section> sections = sectionService.listSectionBySubject(subjectId);
		if (sections != null) {
			for (Section section : sections) {
				materialanalysis.addAll(section.getMaterialanalysises());
			}
		}

		if (materialanalysis != null) {
			for (Materialanalysis mater : materialanalysis) {
				List<Questionsofmaterial> questionsList = new ArrayList<Questionsofmaterial>(
						mater.getQuestionsofmaterials());
				for (Questionsofmaterial questionsofmaterial : questionsList) {
					jQuestionsOfMaterials.add(JQuestionsOfMaterial.LocalToNet(questionsofmaterial));
				}
			}

		}

		return jQuestionsOfMaterials;
	}

	/**
	 * �Ծ��б�
	 * 
	 * @param subjectId
	 * @return
	 */
	public List<JExamination> getJExaminationList(int subjectId) {
		List<JExamination> jExaminationList = new ArrayList<JExamination>();
		List<Examination> examinationList = examService.getExaminationListBySubjectId(subjectId);
		if (examinationList != null) {
			for (Examination examination : examinationList) {
				JExamination jExamination = JExamination.LocalToNet(examination);
				jExaminationList.add(jExamination);
			}
		}

		return jExaminationList;
	}

	/**
	 * �Ծ�����б�
	 * 
	 * @param subjectId
	 * @return
	 */
	public List<JExamSection> getJExamSectionList(int subjectId) {
		List<Examination> examinationList = examService.getExaminationListBySubjectId(subjectId);
		List<JExamSection> jExamSectionList = new ArrayList<JExamSection>();
		List<Examsection> examsectionList = new ArrayList<Examsection>();
		if (examinationList != null) {
			for (Examination examination : examinationList) {
				examsectionList.addAll(examination.getExamsections());
			}
		}
		if (examsectionList != null) {
			for (Examsection examsection : examsectionList) {
				JExamSection jExamSection = JExamSection.LocalToNet(examsection);
				jExamSectionList.add(jExamSection);
			}
		}

		return jExamSectionList;
	}

	/**
	 * �Ծ���Ŀ�б�
	 * 
	 * @param subjectId
	 * @return
	 */
	public List<JExamQuestion> getJExamQuestionList(int subjectId) {
		List<Examination> examinationList = examService.getExaminationListBySubjectId(subjectId);
		List<JExamQuestion> jExamQuestionList = new ArrayList<JExamQuestion>();
		List<Examquestion> examQuestionList = new ArrayList<Examquestion>();
		List<Examsection> examsectionList = new ArrayList<Examsection>();
		if (examinationList != null) {
			for (Examination examination : examinationList) {
				examsectionList.addAll(examination.getExamsections());
			}
		}

		if (examsectionList != null) {
			for (Examsection examsection : examsectionList) {
				examQuestionList.addAll(examsection.getExamquestions());
			}
		}
		if (examQuestionList != null) {
			for (Examquestion examQuestion : examQuestionList) {
				JExamQuestion jExamQuestion = JExamQuestion.LocalToNet(examQuestion);
				jExamQuestionList.add(jExamQuestion);
			}
		}

		return jExamQuestionList;
	}
}
