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
import com.yrw.domains.Multichoice;
import com.yrw.domains.Questiontype;
import com.yrw.domains.Section;
import com.yrw.domains.Singlechoice;
import com.yrw.domains.Subject;
import com.yrw.service.QuestionService;
import com.yrw.service.SectionService;
import com.yrw.service.SubjectService;
import com.yrw.web.forms.MultiChoiceForm;
import com.yrw.web.forms.SingleChoiceForm;

/**
 * MyEclipse Struts Creation date: 04-17-2014
 * 
 * XDoclet definition:
 * 
 * @struts.action path="/multiChoice" name="multiChoiceForm" parameter="flag"
 *                scope="request" validate="true"
 */
public class MultiChoiceAction extends DispatchAction {
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
	 * Method showQuestionBySection 按题目章节
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 * @throws UnsupportedEncodingException
	 */
	public ActionForward showMultiChoiceList(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {
		// TODO Auto-generated method stub
		String sectionName;
		// 加载章节类型
		if (request.getAttribute("source") != null)
			sectionName = (String) request.getAttribute("sectionName");
		else
			sectionName = new String(request.getParameter("sectionName")
					.getBytes("ISO-8859-1"), "utf-8");

		
		String typeName = DefaultValue.MULTI_CHOICE;
		Section existSection = sectionService
				.getSectionBySectionName(sectionName);

		request.getSession().setAttribute("typeName", typeName);
		String pageNowString = request.getParameter("pageNow");

		int subjectId = existSection.getSubject().getId();
		request.getSession().setAttribute("subjectId", subjectId);
		request.getSession().setAttribute("subjectId", subjectId);
		request.setAttribute("subjects", subjectService.getSubjects());

		// 加载问题类型
		List<Questiontype> questiontypes = questionService
				.showQuestiontypes();
		request.setAttribute("questionTypeName", typeName);
		request.setAttribute("questionTypes", questiontypes);

		// 加载章节下的题目
		

		List collection = questionService.listQuestionBySection(
				existSection.getId(), pageNowString, typeName);

		Map<String, Integer> pageMap = (Map<String, Integer>) collection.get(0);
		request.setAttribute("pageCount", pageMap.get("pageCount"));
		request.setAttribute("pageNow", pageMap.get("pageNow"));
		// 为jsp中的section设置值
		request.setAttribute("sectionName", sectionName);
		// 设置问题

		if (typeName.equals(DefaultValue.MULTI_CHOICE))

			request.setAttribute("multiChoices", (List) collection.get(1));

		return mapping.findForward((String) collection.get(2));
	}

	/**
	 * 显示多项选择详情
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
	public ActionForward showMultiChoice(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		int multiChoiceId = Integer.parseInt(request
				.getParameter("multiChoiceId"));
		String isEdit = request.getParameter("edit");
		Multichoice multichoice = (Multichoice) questionService.getQuestion(
				multiChoiceId, DefaultValue.MULTI_CHOICE);
		request.setAttribute("multiChoice", multichoice);

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
				subjectId, multichoice.getSection().getId());

		if (sectionList != null) {

			request.setAttribute("section", sectionList.get(0));
			sectionList.remove(0);
			request.setAttribute("sections", sectionList);
		} else
			request.setAttribute("section", "暂无所属科目");
		if (isEdit != null) {
			return mapping.findForward("editMultiChoice");
		} else
			return mapping.findForward("showMultiChoice");
	}

	/**
	 * 修该多项选择题
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public ActionForward editMultiChoice(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {

		MultiChoiceForm multiChoiceForm = (MultiChoiceForm) form;
		int multiChoiceId = Integer.parseInt(request
				.getParameter("multiChoiceId"));

		Multichoice multichoice = (Multichoice) questionService.getQuestion(
				multiChoiceId, DefaultValue.MULTI_CHOICE);

		multichoice.setQuestionStem(multiChoiceForm.getQuestionStem());
		multichoice.setOptionA(multiChoiceForm.getOptionA());
		multichoice.setOptionB(multiChoiceForm.getOptionB());
		multichoice.setOptionC(multiChoiceForm.getOptionC());
		multichoice.setOptionD(multiChoiceForm.getOptionD());
		multichoice.setOptionE(multiChoiceForm.getOptionE());
		multichoice.setOptionF(multiChoiceForm.getOptionF());
		multichoice.setAnalysis(multiChoiceForm.getAnalysis());

		if (multiChoiceForm.getAnswerA() != null)
			multichoice.setAnswerA(true);
		else
			multichoice.setAnswerA(false);
		if (multiChoiceForm.getAnswerB() != null)
			multichoice.setAnswerB(true);
		else
			multichoice.setAnswerB(false);
		if (multiChoiceForm.getAnswerC() != null)
			multichoice.setAnswerC(true);
		else
			multichoice.setAnswerC(false);
		if (multiChoiceForm.getAnswerD() != null)
			multichoice.setAnswerD(true);
		else
			multichoice.setAnswerD(false);
		if (multiChoiceForm.getAnswerE() != null)
			multichoice.setAnswerE(true);
		else
			multichoice.setAnswerE(false);
		if (multiChoiceForm.getAnswerF() != null)
			multichoice.setAnswerF(true);
		else
			multichoice.setAnswerF(false);

		multichoice.setRemark(multiChoiceForm.getRemark());

		if (multiChoiceForm.getSectionName() != null) {
			Section section = sectionService
					.getSectionBySectionName(multiChoiceForm.getSectionName());
			multichoice.setSection(section);
		}

		questionService.updateMultiChoice(multichoice);
		// 设置在showMultiChoice中要使用参数
		request.setAttribute("sectionName", multichoice.getSection()
				.getSectionName());
		request.setAttribute("source", "editMultiChoice");
		return showMultiChoiceList(mapping, multiChoiceForm, request, response);

	}

	/**
	 * Method addMultiChoiceUI 跳转到添加多选题的UI界面
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 */
	public ActionForward addMultiChoiceUI(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		int subjectId = (Integer) request.getSession()
				.getAttribute("subjectId");
		System.out.println("MultiChoiceAction addMultiChoiceUI " + subjectId);
		List<Section> sectionList = sectionService.listSectionBySubject(subjectId);
		List<Subject> subjectList = subjectService.getSubjects();
		request.setAttribute("subjects", subjectList);
		request.setAttribute("sections", sectionList);
		return mapping.findForward("addMultiChoice");
	}

	/**
	 * Method addMultiChoice 添加多选题
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 * @throws UnsupportedEncodingException
	 */
	public ActionForward addMultiChoice(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws UnsupportedEncodingException {

		MultiChoiceForm multiChoiceForm = (MultiChoiceForm) form;
		Multichoice multichoice = new Multichoice();
		multichoice.setQuestionStem(multiChoiceForm.getQuestionStem());
		multichoice.setOptionA(multiChoiceForm.getOptionA());
		multichoice.setOptionB(multiChoiceForm.getOptionB());
		multichoice.setOptionC(multiChoiceForm.getOptionC());
		multichoice.setOptionD(multiChoiceForm.getOptionD());
		multichoice.setOptionE(multiChoiceForm.getOptionE());
		multichoice.setOptionF(multiChoiceForm.getOptionF());
		if (multiChoiceForm.getAnswerA() != null)
			multichoice.setAnswerA(true);
		else
			multichoice.setAnswerA(false);
		if (multiChoiceForm.getAnswerB() != null)
			multichoice.setAnswerB(true);
		else
			multichoice.setAnswerB(false);
		if (multiChoiceForm.getAnswerC() != null)
			multichoice.setAnswerC(true);
		else
			multichoice.setAnswerC(false);
		if (multiChoiceForm.getAnswerD() != null)
			multichoice.setAnswerD(true);
		else
			multichoice.setAnswerD(false);
		if (multiChoiceForm.getAnswerE() != null)
			multichoice.setAnswerE(true);
		else
			multichoice.setAnswerE(false);
		if (multiChoiceForm.getAnswerF() != null)
			multichoice.setAnswerF(true);
		else
			multichoice.setAnswerF(false);

		multichoice.setRemark(multiChoiceForm.getRemark());

		if (multiChoiceForm.getSectionName() != null) {
			Section section = sectionService
					.getSectionBySectionName(multiChoiceForm.getSectionName());

			multichoice.setSection(section);
		} else {
			multichoice.setSection(null);

		}

		questionService.addMultiChoice(multichoice);
		// 设置在showQuestioBySection中要使用参数
		request.setAttribute("sectionName", multichoice.getSection()
				.getSectionName());
		request.setAttribute("source", "addMultiChoice");
		return showMultiChoiceList(mapping, multiChoiceForm, request, response);
	}

	/**
	 * 删除多选题
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public ActionForward deleteMultiChoice(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {
		int multiChoiceId = Integer.parseInt(request
				.getParameter("multiChoiceId"));
		
		Multichoice multichoice = (Multichoice) questionService.getQuestion(
				multiChoiceId, DefaultValue.MULTI_CHOICE);
		if (multichoice != null) {
			request.setAttribute("sectionName", multichoice.getSection()
					.getSectionName());
			System.out.println("deleteMultiChoice "+multichoice.getSection().getSectionName());
			questionService.deleteQuestion(DefaultValue.MULTI_CHOICE,
					multichoice);
			
		}

		request.setAttribute("source", "deleteMultiChoice");

		return showMultiChoiceList(mapping, null, request, response);

	}
}