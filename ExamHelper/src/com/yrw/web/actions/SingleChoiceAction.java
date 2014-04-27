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
import com.yrw.domains.Singlechoice;
import com.yrw.domains.Subject;
import com.yrw.service.QuestionService;
import com.yrw.service.SectionService;
import com.yrw.service.SubjectService;
import com.yrw.web.forms.SingleChoiceForm;

/**
 * MyEclipse Struts Creation date: 04-17-2014
 * 
 * XDoclet definition:
 * 
 * @struts.action path="/singleChoice" name="singleChoiceForm" parameter="flag"
 *                scope="request" validate="true"
 */
public class SingleChoiceAction extends DispatchAction {

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
	 * Method showSingleChoiceList 按章节显示单选题列表
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 * @throws UnsupportedEncodingException
	 */
	public ActionForward showSingleChoiceList(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {
		// TODO Auto-generated method stub

		// 加载章节类型
		String sectionName;
		// 加载章节类型
		if (request.getAttribute("source") != null)
			sectionName = (String) request.getAttribute("sectionName");
		else
			sectionName = new String(request.getParameter("sectionName")
					.getBytes("ISO-8859-1"), "utf-8");
		String typeName = DefaultValue.SINGLE_CHOICE;

		request.getSession().setAttribute("typeName", typeName);
		String pageNowString = request.getParameter("pageNow");

		int subjectId = (Integer) request.getSession()
				.getAttribute("subjectId");

		// 加载问题类型
		List<Questiontype> questiontypes = questionService
				.showQuestiontypes(typeName);
		request.setAttribute("questionType", questiontypes.get(0));
		questiontypes.remove(0);
		request.setAttribute("questionTypes", questiontypes);

		// 加载章节下的题目
		Section existSection = sectionService
				.getSectionBySectionName(sectionName);
		List collection = questionService.listQuestionBySection(
				existSection.getId(), pageNowString, typeName);

		Map<String, Integer> pageMap = (Map<String, Integer>) collection.get(0);
		request.setAttribute("pageCount", pageMap.get("pageCount"));
		request.setAttribute("pageNow", pageMap.get("pageNow"));
		// 为jsp中的hidden设置值
		request.setAttribute("sectionName", sectionName);
		// 设置问题
		if (typeName.equals(DefaultValue.SINGLE_CHOICE))

			request.setAttribute("singleChoices", (List) collection.get(1));

		return mapping.findForward((String) collection.get(2));
	}

	/**
	 * 显示单项选择详情
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
	public ActionForward showSingleChoice(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		int singleChoiceId = Integer.parseInt(request
				.getParameter("singleChoiceId"));
		String isEdit = request.getParameter("edit");
		Singlechoice singlechoice = (Singlechoice) questionService
				.getQuestion(singleChoiceId, DefaultValue.SINGLE_CHOICE);
		request.setAttribute("singleChoice", singlechoice);

		// 获得subject下拉菜单里的所有subject
		int subjectId = (Integer) request.getSession()
				.getAttribute("subjectId");
		List<Subject> subjectList = subjectService.getSubjectList(subjectId);
		if (subjectList != null) {
			request.setAttribute("subject", subjectList.get(0));
			subjectList.remove(0);
			request.setAttribute("subjects", subjectList);
		} else
			request.setAttribute("subject", "暂无所属科目");

		// 获得下拉菜单里的所有section

		List<Section> sectionList = sectionService.listSectionBySubIdAndSecId(
				subjectId, singlechoice.getSection().getId());

		if (sectionList != null) {

			request.setAttribute("section", sectionList.get(0));
			sectionList.remove(0);
			request.setAttribute("sections", sectionList);
		} else
			request.setAttribute("section", "暂无所属科目");
		if (isEdit != null) {
			return mapping.findForward("editSingleChoice");
		} else
			return mapping.findForward("showSingleChoice");
	}

	/**
	 * Method addQuestionUI 跳转到添加单选题的UI界面
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 */
	public ActionForward addSingleChoiceUI(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		int subjectId = (Integer) request.getSession()
				.getAttribute("subjectId");

		List<Section> sectionList = sectionService.listSectionBySubject(subjectId);
		List<Subject> subjectList = subjectService.getSubjects();
		request.setAttribute("subjects", subjectList);
		request.setAttribute("sections", sectionList);
		return mapping.findForward("addSingleChoice");
	}

	/**
	 * Method addQuestion 添加单选题
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 * @throws UnsupportedEncodingException
	 */
	public ActionForward addSingleChoice(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {

		SingleChoiceForm singleChoiceForm = (SingleChoiceForm) form;
		Singlechoice singlechoice = new Singlechoice();
		singlechoice.setQuestionStem(singleChoiceForm.getQuestionStem());
		singlechoice.setOptionA(singleChoiceForm.getOptionA());
		singlechoice.setOptionB(singleChoiceForm.getOptionB());
		singlechoice.setOptionC(singleChoiceForm.getOptionC());
		singlechoice.setOptionD(singleChoiceForm.getOptionD());
		singlechoice.setOptionE(singleChoiceForm.getOptionE());
		singlechoice.setAnswer(singleChoiceForm.getAnswer());
		singlechoice.setAnalysis(singleChoiceForm.getAnalysis());
		singlechoice.setRemark(singleChoiceForm.getRemark());

		if (singleChoiceForm.getSectionName() != null) {
			Section section = sectionService
					.getSectionBySectionName(singleChoiceForm.getSectionName());
			singlechoice.setSection(section);
		} else {
			singlechoice.setSection(null);

		}

		questionService.addSingleChoice(singlechoice);
		// 设置在showQuestioBySection中要使用参数
		request.setAttribute("sectionName", singlechoice.getSection()
				.getSectionName());

		request.setAttribute("source", "addSingleChoice");
		return showSingleChoiceList(mapping, null, request, response);
	}

	/**
	 * 修该单项选择题
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public ActionForward editSingleChoice(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {
		SingleChoiceForm singleChoiceForm = (SingleChoiceForm) form;
		int singleChoiceId = Integer.parseInt(request
				.getParameter("singleChoiceId"));

		Singlechoice singlechoice = (Singlechoice) questionService.getQuestion(
				singleChoiceId, DefaultValue.SINGLE_CHOICE);
		System.out.println(singleChoiceForm.getRemark());

		singlechoice.setQuestionStem(singleChoiceForm.getQuestionStem());
		singlechoice.setOptionA(singleChoiceForm.getOptionA());
		singlechoice.setOptionB(singleChoiceForm.getOptionB());
		singlechoice.setOptionC(singleChoiceForm.getOptionC());
		singlechoice.setOptionD(singleChoiceForm.getOptionD());
		singlechoice.setOptionE(singleChoiceForm.getOptionE());
		singlechoice.setAnswer(singleChoiceForm.getAnswer());
		singlechoice.setAnalysis(singleChoiceForm.getAnalysis());
		singlechoice.setRemark(singleChoiceForm.getRemark());

		System.out.println("QuestionAction editSingleChoice  "
				+ singleChoiceForm.getSectionName()
				+ singleChoiceForm.getSubjectName());
		if (singleChoiceForm.getSectionName() != null) {
			Section section = sectionService
					.getSectionBySectionName(singleChoiceForm.getSectionName());
			singlechoice.setSection(section);
		}

		questionService.updateSingleChoice(singlechoice);
		//设置转到showSIngleChoiceLIst中要使用参数
		request.setAttribute("sectionName", singlechoice.getSection()
				.getSectionName());

		request.setAttribute("source", "editSingleChoice");
		return showSingleChoiceList(mapping, null, request, response);
	}

	/**
	 * 删除单选题
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public ActionForward deleteSingleChoice(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {
		int singleChoiceId = Integer.parseInt(request
				.getParameter("singleChoiceId"));
		Singlechoice singlechoice = (Singlechoice) questionService
				.getQuestion(singleChoiceId, DefaultValue.SINGLE_CHOICE);
		request.setAttribute("sectionName", singlechoice.getSection()
				.getSectionName());
		request.setAttribute("source", "deleteSingleChoice");
		questionService
				.deleteQuestion(DefaultValue.SINGLE_CHOICE, singlechoice);
		
		return showSingleChoiceList(mapping, null, request, response);

	}
}