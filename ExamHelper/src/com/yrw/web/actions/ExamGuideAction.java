/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.yrw.web.actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.yrw.domains.Examguidetype;
import com.yrw.service.ExamGuideService;
import com.yrw.service.SubjectService;

/** 
 * MyEclipse Struts
 * Creation date: 04-24-2014
 * 
 * XDoclet definition:
 * @struts.action parameter="flag" validate="true"
 */
public class ExamGuideAction extends DispatchAction {
	private ExamGuideService examGuideService;
	private SubjectService subjectService;
	
	public void setExamGuideService(ExamGuideService examGuideService) {
		this.examGuideService = examGuideService;
	}
	
	public void setSubjectService(SubjectService subjectService) {
		this.subjectService = subjectService;
	}

	/** 
	 * Method execute
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 */
	public ActionForward addExamGuide(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * 返回带有考试指南目录的页面
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
	public ActionForward examGuideType(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response){
		return null;
	}
}