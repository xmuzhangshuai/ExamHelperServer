/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.yrw.web.actions;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.yrw.config.DefaultValue;
import com.yrw.domains.Questiontype;
import com.yrw.domains.Section;
import com.yrw.domains.Subject;
import com.yrw.domains.Trueorfalse;
import com.yrw.service.QuestionService;
import com.yrw.service.SectionService;
import com.yrw.service.SubjectService;
import com.yrw.web.forms.TrueOrFalseForm;

/**
 * MyEclipse Struts Creation date: 04-17-2014
 * 
 * XDoclet definition:
 * 
 * @struts.action validate="true"
 */
public class TrueOrFalseAction extends DispatchAction {
	private QuestionService questionService;
	private SectionService sectionService;
	private SubjectService subjectService;

	public void setQuestionService(QuestionService questionService) {
		this.questionService = questionService;
	}

	public void setSectionService(SectionService sectionService) {
		this.sectionService = sectionService;
	}

	public void setSubjectService(SubjectService subjectService) {
		this.subjectService = subjectService;
	}

	/**
	 * 加载sectionList
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
	public ActionForward loadSectionList(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {

		String subjectString = request.getParameter("subjectId");
		String questionTypeNameString = request
				.getParameter("questionTypeName");
		int subjectId = 0;
		if (subjectString != null)
			if (subjectString.length() > 0) {
				subjectId = Integer.parseInt(subjectString);
				request.getSession().setAttribute("subjectId", subjectId);
			}
		if (questionTypeNameString != null)
			if (questionTypeNameString.length() > 0
					&& !questionTypeNameString.equals("null"))
				request.setAttribute("questionTypeName", questionTypeNameString);

		List<Section> sections = sectionService.listSectionBySubject(subjectId);
		request.setAttribute("sections", sections);

		List<Subject> subjects = subjectService.getSubjects();
		List<Questiontype> questiontypes = questionService.showQuestiontypes();
		request.setAttribute("subjects", subjects);
		request.setAttribute("questionTypes", questiontypes);

		return mapping.findForward("showTrueOrFalseList");
	}

	/**
	 * Method showTrueOrFalseList 按章节显示判断题
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 * @throws UnsupportedEncodingException
	 */
	public ActionForward showTrueOrFalseList(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {
		// TODO Auto-generated method stub

		// 加载章节类型
		String sectionName = new String(request.getParameter("sectionName")
				.getBytes("ISO-8859-1"), "utf-8");
		String typeName = DefaultValue.TRUE_OR_FALSE;
		String pageNowString = request.getParameter("pageNow");

		Section existSection = sectionService
				.getSectionBySectionName(sectionName);
		int subjectId = existSection.getSubject().getId();
		request.getSession().setAttribute("subjectId", subjectId);
		request.setAttribute("subjects", subjectService.getSubjects());

		// 加载问题类型
		List<Questiontype> questiontypes = questionService.showQuestiontypes();
		request.setAttribute("questionTypeName", typeName);
		request.setAttribute("questionTypes", questiontypes);

		// 为jsp中的hidden设置值
		request.setAttribute("sectionName", sectionName);
		List<Section> sections = sectionService.listSectionBySubject(subjectId);
		request.setAttribute("sections", sections);

		// 加载章节下的题目
		List collection = questionService.listQuestionBySection(
				existSection.getId(), pageNowString, typeName);

		Map<String, Integer> pageMap = (Map<String, Integer>) collection.get(0);
		request.setAttribute("pageCount", pageMap.get("pageCount"));
		request.setAttribute("pageNow", pageMap.get("pageNow"));
		// 设置问题
		request.setAttribute("trueOrFalses", (List) collection.get(1));

		return mapping.findForward((String) collection.get(2));
	}

	/**
	 * 显示判断题详情
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
	public ActionForward showTrueOrFalse(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		int trueOrFalseId = Integer.parseInt(request
				.getParameter("trueOrFalseId"));
		Trueorfalse trueorfalse = (Trueorfalse) questionService.getQuestion(
				trueOrFalseId, DefaultValue.TRUE_OR_FALSE);
		request.setAttribute("trueOrFalse", trueorfalse);

		// 获得subject下拉菜单里的所有subject
		request.setAttribute("subject", trueorfalse.getSection().getSubject()
				.getSubName());
		// 获得下拉菜单里的所有section
		request.setAttribute("sectionName", trueorfalse.getSection()
				.getSectionName());
		return mapping.findForward("showTrueOrFalse");
	}

	/**
	 * Method 跳转到添加判断题的UI界面
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 * @throws UnsupportedEncodingException 
	 */
	public ActionForward addTrueOrFalseUI(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {
		String pageNowString = request.getParameter("pageNow");
		if (pageNowString != null)
			if (pageNowString.length() > 0)
				request.setAttribute("pageNow", Integer.parseInt(pageNowString));

		int subjectId = (Integer) request.getSession()
				.getAttribute("subjectId");

		List<Section> sectionList = sectionService
				.listSectionBySubject(subjectId);
		List<Subject> subjectList = subjectService.getSubjects();
		request.setAttribute("subjects", subjectList);
		if (request.getParameter("sectionName") != null)
			if (request.getParameter("sectionName").length() > 0)
				request.setAttribute("sectionName",
						new String(request.getParameter("sectionName")
								.getBytes("ISO-8859-1"), "utf-8"));
		request.setAttribute("sections", sectionList);
		return mapping.findForward("addTrueOrFalse");
	}

	/**
	 * Method 添加判断题
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 * @throws UnsupportedEncodingException
	 */
	public ActionForward addTrueOrFalse(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws UnsupportedEncodingException {

		TrueOrFalseForm trueOrFalseForm = (TrueOrFalseForm) form;
		Trueorfalse trueorfalse = new Trueorfalse();
		trueorfalse.setQuestionStem(trueOrFalseForm.getQuestionStem());

		trueorfalse
				.setAnswer(Boolean.parseBoolean(trueOrFalseForm.getAnswer()));
		trueorfalse.setAnalysis(trueOrFalseForm.getAnalysis());
		trueorfalse.setRemark(trueOrFalseForm.getRemark());

		if (trueOrFalseForm.getSectionName() != null) {
			Section section = sectionService
					.getSectionBySectionName(trueOrFalseForm.getSectionName());
			trueorfalse.setSection(section);
		} else {
			trueorfalse.setSection(null);

		}
		questionService.addTrueOrFalse(trueorfalse);

		// 设置subject下拉菜单
		request.setAttribute("subjects", subjectService.getSubjects());
		// 设置在section下拉列表
		request.setAttribute("sectionName", trueorfalse.getSection()
				.getSectionName());
		List<Section> sections = sectionService
				.listSectionBySubject(trueorfalse.getSection().getSubject()
						.getId());
		request.setAttribute("sections", sections);
		// 设置问题类型下拉菜单
		request.setAttribute("questionTypeName", DefaultValue.TRUE_OR_FALSE);
		request.setAttribute("questionTypes",
				questionService.showQuestiontypes());
		// 设置题目及页码

		List collection = questionService.listQuestionBySection(trueorfalse
				.getSection().getId(), null, DefaultValue.TRUE_OR_FALSE);
		// 设置页码
		Map<String, Integer> pageMap = (Map<String, Integer>) collection.get(0);
		request.setAttribute("pageCount", pageMap.get("pageCount"));
		request.setAttribute("pageNow", pageMap.get("pageNow"));
		// 设置单项选择题
		request.setAttribute("trueOrFalses",
				(List<Trueorfalse>) collection.get(1));
		return mapping.findForward("showTrueOrFalseList");
	}

	/**
	 * 编辑判断题
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
	public ActionForward editTrueOrFalse(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		int trueOrFalseId = Integer.parseInt(request
				.getParameter("trueOrFalseId"));
		Trueorfalse trueorfalse = (Trueorfalse) questionService.getQuestion(
				trueOrFalseId, DefaultValue.TRUE_OR_FALSE);
		request.setAttribute("trueOrFalse", trueorfalse);

		String pageNowString = request.getParameter("pageNow");
		if (pageNowString != null)
			if (pageNowString.length() > 0)
				request.setAttribute("pageNow", Integer.parseInt(pageNowString));

		// 获得subject下拉菜单里的所有subject
		int subjectId = (Integer) request.getSession()
				.getAttribute("subjectId");
		List<Subject> subjectList = subjectService.getSubjects();
		if (subjectList != null) {
			request.setAttribute("subjects", subjectList);
		}

		// 获得下拉菜单里的所有section

		List<Section> sectionList = sectionService
				.listSectionBySubject(subjectId);
		if (sectionList != null) {
			request.setAttribute("sectionName", trueorfalse.getSection()
					.getSectionName());
			request.setAttribute("sections", sectionList);
		}

		return mapping.findForward("editTrueOrFalse");
	}

	/**
	 * 保存修改后的判断题
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws UnsupportedEncodingException
	 */

	public ActionForward saveTrueOrFalse(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {
		// 设置返回页码
		String pageNowString = request.getParameter("pageNow");
		if (pageNowString != null)
			if (pageNowString.length() > 0)
				request.setAttribute("pageNow", pageNowString);
		// 存储更改过后的trueOrFalse
		TrueOrFalseForm trueOrFalseForm = (TrueOrFalseForm) form;
		int trueOrFalseId = Integer.parseInt(request
				.getParameter("trueOrFalseId"));

		Trueorfalse trueorfalse = (Trueorfalse) questionService.getQuestion(
				trueOrFalseId, DefaultValue.TRUE_OR_FALSE);

		trueorfalse.setQuestionStem(trueOrFalseForm.getQuestionStem());
		trueorfalse.setAnswer(Boolean.parseBoolean(request
				.getParameter("answer")));
		trueorfalse.setAnalysis(trueOrFalseForm.getAnalysis());
		trueorfalse.setRemark(trueOrFalseForm.getRemark());

		if (trueOrFalseForm.getSectionName() != null) {
			Section section = sectionService
					.getSectionBySectionName(trueOrFalseForm.getSectionName());
			trueorfalse.setSection(section);
		}

		questionService.updateTrueOrFalse(trueorfalse);
		// 获得subject下拉菜单里的所有subject
		int subjectId = (Integer) request.getSession()
				.getAttribute("subjectId");
		List<Subject> subjectList = subjectService.getSubjects();
		if (subjectList != null) {
			request.setAttribute("subjects", subjectList);
		}
		// 设置section下拉菜单
		request.setAttribute("sectionName", trueorfalse.getSection()
				.getSectionName());
		List<Section> sections = sectionService.listSectionBySubject(subjectId);
		request.setAttribute("sections", sections);
		// 设置科目列表
		request.setAttribute("subjects", subjectService.getSubjects());
		// 设置题型
		request.setAttribute("questionTypeName", DefaultValue.TRUE_OR_FALSE);
		request.setAttribute("questionTypes",
				questionService.showQuestiontypes());
		// 设置题目及页码
		List collection = questionService.listQuestionBySection(trueorfalse
				.getSection().getId(), pageNowString,
				DefaultValue.TRUE_OR_FALSE);
		// 设置页码
		Map<String, Integer> pageMap = (Map<String, Integer>) collection.get(0);
		request.setAttribute("pageCount", pageMap.get("pageCount"));
		request.setAttribute("pageNow", pageMap.get("pageNow"));
		// 设置单项选择题
		request.setAttribute("trueOrFalses",
				(List<Trueorfalse>) collection.get(1));
		return mapping.findForward("showTrueOrFalseList");
	}

	/**
	 * 删除判断题
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public ActionForward deleteTrueOrFalse(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {
		int trueOrFalseId = Integer.parseInt(request
				.getParameter("trueOrFalseId"));
		Trueorfalse trueorfalse = (Trueorfalse) questionService.getQuestion(
				trueOrFalseId, DefaultValue.TRUE_OR_FALSE);

		// 设置section下拉框
				request.setAttribute("sectionName", trueorfalse.getSection()
						.getSectionName());
				request.setAttribute(
						"sections",
						sectionService.listSectionBySubject(trueorfalse.getSection()
								.getSubject().getId()));
				// 设置subject下拉框
				request.setAttribute("subjects", subjectService.getSubjects());
				// 设置questionType下拉框
				request.setAttribute("questionTypeName", DefaultValue.TRUE_OR_FALSE);
				request.setAttribute("questionTypes",
						questionService.showQuestiontypes());

				// 删除该选择题
				questionService
						.deleteQuestion(DefaultValue.TRUE_OR_FALSE, trueorfalse);

				// 设置页码及问题
				String pageNowString = request.getParameter("pageNow");
				List collection = questionService.listQuestionBySection(trueorfalse
						.getSection().getId(), pageNowString,
						DefaultValue.TRUE_OR_FALSE);
				// 设置页码
				Map<String, Integer> pageMap = (Map<String, Integer>) collection.get(0);
				request.setAttribute("pageCount", pageMap.get("pageCount"));
				request.setAttribute("pageNow", pageMap.get("pageNow"));
				// 设置单项选择题
				request.setAttribute("trueOrFalses",
						(List<Trueorfalse>) collection.get(1));

				return mapping.findForward("showTrueOrFalseList");
	}
	/**
	 * 删除多题判断题
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public ActionForward delTrueOrFalseByList(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {
		String idString = request.getParameter("trueOrFalseList");
		if (idString != null)
			if (idString.length() > 0)
				questionService.deletQuestionByList(idString,
						DefaultValue.TRUE_OR_FALSE);

		// 设置section下拉框
		String sectionName = request.getParameter("sectionName");
		if (sectionName != null)
			if (sectionName.length() > 0)
				sectionName = new String(request.getParameter("sectionName")
						.getBytes("ISO-8859-1"), "utf-8");
		request.setAttribute("sectionName", sectionName);
		request.setAttribute("sections", sectionService
				.listSectionBySubject(sectionService.getSectionBySectionName(
						sectionName).getSubject().getId()));
		// 设置subject下拉框
		request.setAttribute("subjects", subjectService.getSubjects());
		// 设置questionType下拉框
		request.setAttribute("questionTypeName", DefaultValue.TRUE_OR_FALSE);
		request.setAttribute("questionTypes",
				questionService.showQuestiontypes());

		// 设置页码及问题
		String pageNowString = request.getParameter("pageNow");

		List collection = questionService.listQuestionBySection(sectionService
				.getSectionBySectionName(sectionName).getId(), pageNowString,
				DefaultValue.TRUE_OR_FALSE);
		// 设置页码
		Map<String, Integer> pageMap = (Map<String, Integer>) collection.get(0);
		request.setAttribute("pageCount", pageMap.get("pageCount"));
		request.setAttribute("pageNow", pageMap.get("pageNow"));
		// 设置单项选择题
		request.setAttribute("trueOrFalses",
				(List<Trueorfalse>) collection.get(1));

		return mapping.findForward("showTrueOrFalseList");
	}

}