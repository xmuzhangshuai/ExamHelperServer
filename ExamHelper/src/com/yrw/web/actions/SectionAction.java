/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.yrw.web.actions;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.yrw.domains.Section;
import com.yrw.domains.Subject;
import com.yrw.service.SectionService;
import com.yrw.service.SubjectService;
import com.yrw.web.forms.SectionForm;

/**
 * 
 * 项目名称：ExamHelper 类名称：ListQuestion 类描述： 显示题目方式有关的action 创建人：叶睿雯 创建时间：2014-3-17
 * 修改人： 修改时间： 修改备注：
 * 
 * @version
 * 
 */
public class SectionAction extends DispatchAction {
	/*
	 * Generated Methods
	 */

	
	private SectionService sectionService;
	private SubjectService subjectService;




	public void setSubjectService(SubjectService subjectService) {
		this.subjectService = subjectService;
	}

	public void setSectionService(SectionService sectionService) {
		this.sectionService = sectionService;
	}

	

	/**
	 * Method 为跳转到选择显示方式的action
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 */
	public ActionForward chooseType(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int subjectId = Integer.parseInt(request.getParameter("subjectId"));
		request.getSession().setAttribute("subjectId", subjectId);
		System.out.println("chooseType");
		return showSection(mapping, form, request, response);
	}

	/**
	 * Method 罗列某科目下的所有章节
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 */
	public ActionForward showSection(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int subjectId = (Integer) request.getSession()
				.getAttribute("subjectId");
		System.out.println("Action: showSection" + subjectId);
		String pageNowString = request.getParameter("pageNow");
		List list = sectionService.listSection(pageNowString, subjectId);

		Map<String, Integer> map = (Map<String, Integer>) list.get(0);
		request.setAttribute("pageNow", map.get("pageNow"));
		request.setAttribute("pageCount", map.get("pageCount"));

		List<Section> sectionList = (List<Section>) list.get(1);
		request.setAttribute("sections", sectionList);

		request.getSession().setAttribute("subjectId", subjectId);
		
		return mapping.findForward("listSection");
	}

	/**
	 * 跳转到修改section的UI界面
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
	public ActionForward updateSectionUI(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {

		int sectionId = Integer.parseInt(request.getParameter("sectionId"));
		Section section = sectionService.showSection(sectionId);
		List<Subject> subjectList = subjectService.getSubjectList(section
				.getSubject().getId());

		request.setAttribute("section", section);
		request.setAttribute("subject", subjectList.get(0));
		subjectList.remove(0);
		request.setAttribute("subjects", subjectList);
		return mapping.findForward("updateSectionUI");

	}

	/**
	 * Method 跟新section内容
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 */
	public ActionForward updateSection(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int sectionId = Integer.parseInt(request.getParameter("sectionId"));

		SectionForm sectionForm = (SectionForm) form;
		String sectionName = sectionForm.getSectionName();
		String subjectName = sectionForm.getSubjectName();

		System.out.println("ListQuestionAction updateSection "+sectionName+" "+subjectName);
		
		sectionService.updateSection(sectionName, subjectName, sectionId);

		int subjectId=subjectService.getSubjectIdBySubjectName(subjectName);
		System.out.println("Action:updateSection"+subjectId);
		request.getSession().setAttribute("subjectId", subjectId);
		return showSection(mapping, null, request, response);
	}

	/**
	 * 跳转到增加section的UI界面
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
	public ActionForward addSectionUI(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		List<Subject> subjectList = subjectService.getSubjects();

		request.setAttribute("subjects", subjectList);
		return mapping.findForward("addSectionUI");
	}

	/**
	 * Method 新增section内容
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 */
	public ActionForward addSection(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

		SectionForm sectionForm = (SectionForm) form;
		String sectionName = sectionForm.getSectionName();
		String subjectName = sectionForm.getSubjectName();

		if (sectionService.addSection(sectionName, subjectName)){
			int subjectId=subjectService.getSubjectIdBySubjectName(subjectName);
			request.getSession().setAttribute("subjectId", subjectId);
			return showSection(mapping, null, request, response);}
		else {

			request.setAttribute("message", "该章节已存在，请重新创建");
			return mapping.findForward("fail");
		}
	}
	/**删除某个章节
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
	public ActionForward deleteSection(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response){
		int sectionId = Integer.parseInt(request.getParameter("sectionId"));
		sectionService.deleteSection(sectionId);
		
		return showSection(mapping, null, request, response);
	}
	
	
}