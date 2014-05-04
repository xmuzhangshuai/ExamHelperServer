/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.yrw.web.actions;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder.In;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.yrw.config.DefaultValue;
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
import com.yrw.domains.Trueorfalse;
import com.yrw.service.ExamService;
import com.yrw.service.QuestionService;
import com.yrw.service.SectionService;
import com.yrw.service.SubjectService;
import com.yrw.web.forms.ExaminationForm;

/**
 * MyEclipse Struts Creation date: 04-21-2014
 * 
 * XDoclet definition:
 * 
 * @struts.action parameter="flag" validate="true"
 */
public class ExaminationAction extends DispatchAction {

	private ExamService examService;
	private SubjectService subjectService;
	private SectionService sectionService;
	private QuestionService questionService;

	public void setQuestionService(QuestionService questionService) {
		this.questionService = questionService;
	}

	public void setSectionService(SectionService sectionService) {
		this.sectionService = sectionService;
	}

	public void setSubjectService(SubjectService subjectService) {
		this.subjectService = subjectService;
	}

	public void setExamService(ExamService examService) {
		this.examService = examService;
	}

	/**
	 * 显示所有试卷
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
	public ActionForward showAllExamList(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		String pageNowString = request.getParameter("pageNow");
		List collection = examService.listExaminations(pageNowString);

		Map<String, Integer> pageMap = (Map<String, Integer>) collection.get(0);
		request.setAttribute("pageNow", pageMap.get("pageNow"));
		request.setAttribute("pageCount", pageMap.get("pageCount"));

		List<Examination> exmaList = (List<Examination>) collection.get(1);
		request.setAttribute("examinations", exmaList);
		request.getSession().removeAttribute("subjectId");
		return mapping.findForward("showExamList");
	}

	/**
	 * 罗列某个科目下的所有试卷
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
	public ActionForward showExamListBySubject(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		int subjectId = Integer.parseInt(request.getParameter("subjectId"));

		String pageNowString = request.getParameter("pageNow");
		List collection = examService
				.listExaminations(pageNowString, subjectId);

		Map<String, Integer> pageMap = (Map<String, Integer>) collection.get(0);
		request.setAttribute("pageNow", pageMap.get("pageNow"));
		request.setAttribute("pageCount", pageMap.get("pageCount"));

		List<Examination> exmaList = (List<Examination>) collection.get(1);
		request.setAttribute("examinations", exmaList);
		request.getSession().setAttribute("subjectId", subjectId);
		return mapping.findForward("showExamList");

	}

	/**
	 * 显示试卷信息及内容
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
	public ActionForward showExamination(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		// 得到examination对象
		int examinationId=0;
		if ((request.getParameter("examinationId") != null))
			if(request.getParameter("examinationId").length()>0)
			examinationId = Integer.parseInt(request
					.getParameter("examinationId"));
		else
			examinationId = (Integer) request.getAttribute("examinationId");

		Examination examination = examService.getExamination(examinationId);
		// 设置examination在jsp上的对象
		request.setAttribute("examination", examination);
		// 设置examination中科目的下拉框
		List<Subject> subjectList = subjectService.getSubjects();
		if (subjectList != null) {
			request.getSession().setAttribute("subjectId",
					examination.getSubject().getId());
			request.setAttribute("subjects", subjectList);
		}

		// 设置每个题型下的具体题目

		List<Examsection> examsections = new ArrayList<Examsection>(
				examination.getExamsections());
		Questiontype questiontype = null;
		for (int i = 0; i < examsections.size(); i++) {
			questiontype = examsections.get(i).getQuestiontype();
			if (questiontype.getTypeName().equals(DefaultValue.SINGLE_CHOICE)) {
				List<Singlechoice> singlechoices = (List<Singlechoice>) examService
						.getQuestions(examsections.get(i));
				request.setAttribute("singleChoices", singlechoices);
			} else if (questiontype.getTypeName().equals(
					DefaultValue.MULTI_CHOICE)) {
				List<Multichoice> multichoices = (List<Multichoice>) examService
						.getQuestions(examsections.get(i));
				request.setAttribute("multiChoices", multichoices);
			} else if (questiontype.getTypeName().equals(
					DefaultValue.TRUE_OR_FALSE)) {
				List<Trueorfalse> trueorfalses = (List<Trueorfalse>) examService
						.getQuestions(examsections.get(i));
				System.out.println(trueorfalses);
				request.setAttribute("trueOrFalses", trueorfalses);
			} else if (questiontype.getTypeName().equals(
					DefaultValue.MATERIAL_ANALYSIS)) {
				List<Materialanalysis> materialanalysis = (List<Materialanalysis>) examService
						.getQuestions(examsections.get(i));
				request.setAttribute("materialAnalysises", materialanalysis);
			}
		}
		return mapping.findForward("showExamination");
	}

	/**
	 * 修改试卷信息
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
	public ActionForward editExaminationInfor(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		// 获取jsp页面上的数据
		int examinationId = Integer.parseInt(request
				.getParameter("examinationId"));
		ExaminationForm examinationForm = (ExaminationForm) form;

		String examName = examinationForm.getExamName();
		String subjectName = examinationForm.getSubjectName();
		String examType = examinationForm.getExamType();
		String examTime = examinationForm.getExamTime();
		String examRequest = examinationForm.getExamRequest();

		System.out.println(examName);
		// 获取examination对象
		Examination examination = examService.getExamination(examinationId);
		// 更新examination对象属性
		if (examName != null)
			if(examName.length()>0)
			examination.setExamName(examName);
		if (subjectName != null)
			examination
					.setSubject(subjectService.getSubjectByName(subjectName));
		if (examType != null)
			if(examType.length()>0)
			examination.setExamType(examType);
		if (examTime != null)
			if(examTime.length()>0)
			examination.setExamTime(Integer.parseInt(examTime));
		if (examRequest != null)
			if(examRequest.length()>0)
			examination.setExamRequest(examRequest);

		return showExamination(mapping, form, request, response);
	}

	/**
	 * 修改试卷章节信息
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
	public ActionForward editExamSectionInfor(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		// 获得examinationSection的Id
		int examSectionId = Integer.parseInt(request
				.getParameter("examSectionId"));
		Examsection examsection = examService.getExamsection(examSectionId);
		// 获得examSection下的题目要求与分数
		String examSectionRequest = request.getParameter("request"
				+ examSectionId);
		String examSectionScore = request.getParameter("score" + examSectionId);

		// 更新examSection对象
		if (examSectionRequest != null)
			examsection.setRequest(examSectionRequest);
		if (examSectionScore != null)
			examsection.setQuestionScore(Integer.parseInt(examSectionScore));
		return showExamination(mapping, form, request, response);
	}

	/**
	 * 使题目顺序上移或下移
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public ActionForward moveSingleChoice(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {
		System.out.println(" 进入moveSingleChoice Action");

		// 获得操作类型、单选题Id、试卷Id
		String type = request.getParameter("type");
		int singleChoiceId = Integer.parseInt(request
				.getParameter("singleChoiceId"));
		int examId = Integer.parseInt(request.getParameter("examinationId"));

		examService.moveSingleChoice(singleChoiceId, type, examId);
		// 重新设置examinationId
		request.setAttribute("examinationId", examId);
		return showExamination(mapping, form, request, response);

	}

	/**
	 * 跳转到添加试卷的页面
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
	public ActionForward addExaminationUI(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		String subjectIdString = request.getParameter("subjectId");
		if (subjectIdString != null)
			request.getSession().setAttribute("subjectId",
					Integer.parseInt(subjectIdString));

		// 设置examination中科目的下拉框
		List<Subject> subjectList = subjectService.getSubjects();
		if (subjectList != null)
			request.setAttribute("subjects", subjectList);

		return mapping.findForward("addExamination");
	}

	/**
	 * 添加试卷
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
	public ActionForward addExamination(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		ExaminationForm examinationForm = (ExaminationForm) form;
		String examName = examinationForm.getExamName();
		String subjectName = examinationForm.getSubjectName();
		String examType = examinationForm.getExamType();
		String examTime = examinationForm.getExamTime();
		String examRequest = examinationForm.getExamRequest();
		Examination examination = new Examination();

		// 更新examination对象属性
		if (examName != null)
			examination.setExamName(examName);
		if (subjectName != null)
			examination
					.setSubject(subjectService.getSubjectByName(subjectName));
		if (examType != null)
			examination.setExamType(examType);
		if (examTime != null)
			if (examTime.length() > 0) {
				examination.setExamTime(Integer.parseInt(examTime));
			}
		if (examRequest != null)
			examination.setExamRequest(examRequest);
		examination = examService.addExaminationInfor(examination);
		request.setAttribute("examinationId", examination.getId());
		return showExamination(mapping, null, request, response);
	}
	/**添加试卷章节信息
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
	public ActionForward addExamination(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
	
		int examId=Integer.parseInt(request.getParameter("examinationId"));
		Examsection examsection=new Examsection();
		
		
	}
	/**
	 * 跳转到添加单项选择题的列表
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public ActionForward addExamQuestionUI(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {

		// 获得examSectionid，若是存在该参数则表明是从试卷部分跳转过来否则为添加题目界面
		String examSectionIdString = request.getParameter("examSectionId");
		System.out.println("examSectionIdString " + examSectionIdString);
		int subjectId = 0;
		String questionTypeName = request.getParameter("questionTypeName");
		if (questionTypeName != null) {
			questionTypeName = new String(
					questionTypeName.getBytes("ISO-8859-1"), "utf-8");
		}
		if (examSectionIdString != null) {
			int examSectionId = Integer.parseInt(examSectionIdString);
			Examsection existExamSection = examService
					.getExamsection(examSectionId);
			// 获得questionTypeName
			questionTypeName = existExamSection.getQuestiontype().getTypeName();
			request.setAttribute("questionTypeName", questionTypeName);
			subjectId = existExamSection.getExamination().getSubject().getId();
			request.getSession().setAttribute("examSectionId", examSectionId);
		} else {
			// 设置sectionName的值
			String sectionName = new String(request.getParameter("sectionName")
					.getBytes("ISO-8859-1"), "utf-8");
			request.setAttribute("sectionName", sectionName);
			Section existSection = sectionService
					.getSectionBySectionName(sectionName);

			String pageNowString = request.getParameter("pageNow");

			subjectId = existSection.getSubject().getId();

			// 加载章节下的题目
			List collection = questionService.listQuestionBySection(
					existSection.getId(), pageNowString, questionTypeName);

			Map<String, Integer> pageMap = (Map<String, Integer>) collection
					.get(0);
			request.setAttribute("pageCount", pageMap.get("pageCount"));
			request.setAttribute("pageNow", pageMap.get("pageNow"));

			// 设置问题
			if (questionTypeName.equals(DefaultValue.SINGLE_CHOICE))
				request.setAttribute("questions", (List) collection.get(1));
			else if (questionTypeName.equals(DefaultValue.MULTI_CHOICE))
				request.setAttribute("questions", (List) collection.get(1));
			else if (questionTypeName.equals(DefaultValue.TRUE_OR_FALSE))
				request.setAttribute("questions", (List) collection.get(1));
			else if (questionTypeName.equals(DefaultValue.MATERIAL_ANALYSIS))
				request.setAttribute("questions", (List) collection.get(1));
		}
		// 设置页面的subject的下拉菜单
		request.getSession().setAttribute("subjectId", subjectId);
		Subject subject = subjectService.getSubjectById(subjectId);
		request.setAttribute("subject", subject);
		// 设置页面的章节下拉菜单
		if (subjectId != 0) {
			List<Section> sections = sectionService
					.listSectionBySubject(subjectId);
			request.setAttribute("sections", sections);
		}
		// 设置题目类型下拉菜单
		request.setAttribute("questionTypeName", questionTypeName);
		return mapping.findForward("addExamQuestionUI");
	}

	/**
	 * 添加题目
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @param exam
	 * @return
	 */
	public ActionForward addExamQuestionInfor(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {

		String questionIdString = request.getParameter("questionId");
		String[] questionIdStrings = questionIdString.split(",");

		int examSectionId = (Integer) request.getSession().getAttribute(
				"examSectionId");
		// 获得examSection
		Examsection examsection = examService.getExamsection(examSectionId);
		if (questionIdString != null && !questionIdString.equals("undefined")) {
			for (int i = 0; i < questionIdStrings.length; i++) {
				int questionId = Integer.parseInt(questionIdStrings[i]);
				System.out.println("questionId " + questionId);
				examService.addExamQuestion(questionId, examSectionId,
						examsection);
			}

			request.setAttribute("examinationId", examsection.getExamination()
					.getId());
			return showExamination(mapping, null, request, response);
		} else
			return null;

	}

	/**
	 * 移除试卷题目
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
	public ActionForward removeExamQuestion(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		int questionId = Integer.parseInt(request.getParameter("questionId"));
		int examSectionId = (Integer) request.getSession().getAttribute(
				"examSectionId");
		// 获得examSection
		Examsection examsection = examService.getExamsection(examSectionId);
		examService.removeExamQuestion(questionId, examSectionId, examsection);
		request.setAttribute("examinationId", examsection.getExamination()
				.getId());
		return showExamination(mapping, null, request, response);
	}

	/**
	 * 显示问题的详细信息
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public ActionForward showExamQuestionDetail(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {
		int questionId = Integer.parseInt(request.getParameter("questionId"));
		String questionTypeName = new String(request.getParameter(
				"questionTypeName").getBytes("ISO-8859-1"), "utf-8");
		String forwardString = null;
		System.out.println(questionTypeName);
		if (questionTypeName.equals(DefaultValue.SINGLE_CHOICE)) {
			Singlechoice singlechoice = (Singlechoice) questionService
					.getQuestion(questionId, DefaultValue.SINGLE_CHOICE);
			request.setAttribute("singleChoice", singlechoice);
			System.out.println("单项选择测试");
			forwardString = "showExamSingleChoice";
		} else if (questionTypeName.equals(DefaultValue.MULTI_CHOICE)) {
			Multichoice multichoice = (Multichoice) questionService
					.getQuestion(questionId, DefaultValue.MULTI_CHOICE);
			request.setAttribute("multiChoice", multichoice);
			forwardString = "showExamMultiChoice";
		} else if (questionTypeName.equals(DefaultValue.TRUE_OR_FALSE)) {
			Trueorfalse trueorfalse = (Trueorfalse) questionService
					.getQuestion(questionId, DefaultValue.TRUE_OR_FALSE);
			request.setAttribute("trueOrFalse", trueorfalse);
			forwardString = "showExamTrueOrFalse";
		} else if (questionTypeName.equals(DefaultValue.MATERIAL_ANALYSIS)) {
			Materialanalysis materialanalysis = (Materialanalysis) questionService
					.getQuestion(questionId, DefaultValue.MATERIAL_ANALYSIS);
			request.setAttribute("materialAnalysis", materialanalysis);
			forwardString = "showExamMaterialAnalysis";
		}
		return mapping.findForward(forwardString);
	}
}