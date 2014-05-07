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
import org.hibernate.Session;

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
	private Object List;

	public void setSubjectService(SubjectService subjectService) {
		this.subjectService = subjectService;
	}

	public void setSectionService(SectionService sectionService) {
		this.sectionService = sectionService;
	}

	/**
	 * 为选择科目时显示所有section
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
	public ActionForward showAllSectionList(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		String pageNowString = request.getParameter("pageNow");
		List collection = sectionService.listSection(pageNowString);

		Map<String, Integer> map = (Map<String, Integer>) collection.get(0);
		request.setAttribute("pageNow", map.get("pageNow"));
		request.setAttribute("pageCount", map.get("pageCount"));

		List<Section> sectionList = (List<Section>) collection.get(1);
		request.setAttribute("sections", sectionList);

		request.getSession().removeAttribute("subjectId");

		return mapping.findForward("listSection");
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
	public ActionForward showSectionListBySubject(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		String subjectIdString = request.getParameter("subjectId");
		int subjectId = 0;
		if (subjectIdString != null)
			if (subjectIdString.length() > 0)
				subjectId = Integer.parseInt(request.getParameter("subjectId"));

		String pageNowString = request.getParameter("pageNow");
		List collection = sectionService.listSectionBySubject(pageNowString,
				subjectId);

		Map<String, Integer> map = (Map<String, Integer>) collection.get(0);
		request.setAttribute("pageNow", map.get("pageNow"));
		request.setAttribute("pageCount", map.get("pageCount"));

		List<Section> sectionList = (List<Section>) collection.get(1);
		request.setAttribute("sections", sectionList);

		request.getSession().setAttribute("subjectId", subjectId);
		request.setAttribute("subjects", subjectService.getSubjects());

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
		List<Subject> subjectList = subjectService.getSubjects();

		request.setAttribute("section", section);
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

		System.out.println("ListQuestionAction updateSection " + sectionName
				+ " " + subjectName);

		sectionService.updateSection(sectionName, subjectName, sectionId);

		int subjectId = subjectService.getSubjectIdBySubjectName(subjectName);
		System.out.println("Action:updateSection" + subjectId);
		request.getSession().setAttribute("subjectId", subjectId);
		return showSectionListBySubject(mapping, null, request, response);
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
		request.setAttribute("pageNow", request.getParameter("pageNow"));

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
		//添加章节信息
		int subjectId =(Integer) request.getSession().getAttribute("subjectId");
		if (subjectName != null)
			if (subjectName.length() > 0)
				subjectId = Integer.parseInt(subjectName);
		if (sectionService.addSection(sectionName, subjectId)) {
			//设置subject下拉菜单
			request.getSession().setAttribute("subjectId", subjectId);
			request.setAttribute("subjects", subjectService.getSubjects());
			//设置题目及页码信息
			Map<String, Integer>pageMap=sectionService.getPageMap(null, subjectId);
			request.setAttribute("pageNow", pageMap.get("pageNow"));
			request.setAttribute("pageCount", pageMap.get("pageCount"));
			request.setAttribute("sections", sectionService.getSectionsBySubject(pageMap.get("pageNow"), subjectId));
			return mapping.findForward("listSection");
		} else {

			request.setAttribute("message", "该章节已存在，请重新创建");
			return mapping.findForward("fail");
		}
	}

	/**
	 * 删除多个section
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
	public ActionForward delSectionByList(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {

		String sectionList = request.getParameter("sectionList");
		if (sectionList != null)
			if (sectionList.length() > 0)
				sectionService.deletSectionByList(sectionList);

		String pageNowString = request.getParameter("pageNow");
		int subjectId = (Integer) request.getSession()
				.getAttribute("subjectId");
		// 设置页码
		Map<String, Integer> pageMap = sectionService.getPageMap(pageNowString,
				subjectId);
		request.setAttribute("pageNow", pageMap.get("pageNow"));
		request.setAttribute("pageCount", pageMap.get("pageCount"));
		// 设置sections
		List<Section> sections = sectionService.getSectionsBySubject(
				pageMap.get("pageNow"), subjectId);
		request.setAttribute("sections", sections);
		// 设置subject下拉菜单
		request.setAttribute("subjects", subjectService.getSubjects());

		return mapping.findForward("listSection");
	}

	/**
	 * 删除某个章节
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
	public ActionForward deleteSection(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		int sectionId = Integer.parseInt(request.getParameter("sectionId"));

		sectionService.deleteSection(sectionId);

		String pageNowString = request.getParameter("pageNow");
		int subjectId = (Integer) request.getSession()
				.getAttribute("subjectId");
		// 设置页码
		Map<String, Integer> pageMap = sectionService.getPageMap(pageNowString,
				subjectId);
		request.setAttribute("pageNow", pageMap.get("pageNow"));
		request.setAttribute("pageCount", pageMap.get("pageCount"));
		// 设置sections
		List<Section> sections = sectionService.getSectionsBySubject(
				pageMap.get("pageNow"), subjectId);
		request.setAttribute("sections", sections);
		// 设置subject下拉菜单
		request.setAttribute("subjects", subjectService.getSubjects());

		return mapping.findForward("listSection");
	}

}