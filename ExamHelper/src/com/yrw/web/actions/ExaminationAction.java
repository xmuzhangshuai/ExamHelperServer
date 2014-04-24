/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.yrw.web.actions;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.yrw.config.DefaultValue;
import com.yrw.domains.Examination;
import com.yrw.domains.Examsection;
import com.yrw.domains.Materialanalysis;
import com.yrw.domains.Multichoice;
import com.yrw.domains.Questiontype;
import com.yrw.domains.Singlechoice;
import com.yrw.domains.Subject;
import com.yrw.domains.Trueorfalse;
import com.yrw.service.ExamService;
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

	public void setSubjectService(SubjectService subjectService) {
		this.subjectService = subjectService;
	}

	public void setExamService(ExamService examService) {
		this.examService = examService;
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
	public ActionForward showExamList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		int subjectId = (Integer) request.getSession()
				.getAttribute("subjectId");
		System.out.println("Action: showExam" + subjectId);
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
		int examinationId;
		if((request	.getParameter("examinationId")!=null)
				examinationId = Integer.parseInt(request
				.getParameter("examinationId"));
		else {
			examinationId=(Integer) request.getAttribute("examinationId");
		}
		
		Examination examination = examService.getExamination(examinationId);
		// 设置examination在jsp上的对象
		request.setAttribute("examination", examination);
		// 设置examination中科目的下拉框
		List<Subject> subjectList = subjectService.getSubjectList(examination
				.getSubject().getId());
		if (subjectList != null) {
			request.setAttribute("subject", subjectList.get(0));
			subjectList.remove(0);
			request.setAttribute("subjects", subjectList);
		} else
			request.setAttribute("subject", "暂无所属科目");
		// 设置examination下的题型
		List<Examsection> examsections = new ArrayList<Examsection>(
				examination.getExamsections());
		request.setAttribute("examSections", examsections);
		// 设置每个题型下的具体题目
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

		// 获取examination对象
		Examination examination = examService.getExamination(examinationId);
		// 更新examination对象属性
		if (examName != null)
			examination.setExamName(examName);
		if (subjectName != null)
			examination
					.setSubject(subjectService.getSubjectByName(subjectName));
		if (examType != null)
			examination.setExamType(examType);
		if (examTime != null)
			examination.setExamTime(Integer.parseInt(examTime));
		if (examRequest != null)
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
	/**使题目顺序上移或下移
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	public ActionForward moveSingleChoice(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException{
		//获得操作类型、单选题Id、试卷Id
		String type=request.getParameter("type");
		int singleChoiceId=Integer.parseInt(request.getParameter("singleChoiceId"));
		int examId=Integer.parseInt(request.getParameter("examinationId"));
		examService.moveSingleChoice(singleChoiceId, type, examId);		
		//重新设置examinationId
		request.setAttribute("examinationId", examId);
		mapping.findForward("showExamination");
		
	}
}