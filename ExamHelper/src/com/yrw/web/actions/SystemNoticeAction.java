/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.yrw.web.actions;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.yrw.domains.Serrorquestions;
import com.yrw.domains.Subject;
import com.yrw.domains.Systemnotice;
import com.yrw.service.SystemNoticeService;
import com.yrw.tools.ReqUtils;

public class SystemNoticeAction extends DispatchAction {
	private SystemNoticeService systemNoticeService;

	public void setSystemNoticeService(SystemNoticeService systemNoticeService) {
		this.systemNoticeService = systemNoticeService;
	}

	/**
	 * 显示系统公告列表
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
	public ActionForward showNoticeList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int pageNow = 1;
		int pageCount = systemNoticeService.getSystemnoticePageCountByPage();
		String pageNowString = request.getParameter("pageNow");
		if (pageNowString != null) {
			pageNow = Integer.parseInt(pageNowString);
			if (pageNow < 1)
				pageNow = 1;
			else if (pageNow > pageCount)
				pageNow = pageCount;
		}


		List<Systemnotice> systemnoticeList = systemNoticeService.getSystemnoticeListByPage(pageNow);
		
		request.setAttribute("systemnoticeList", systemnoticeList);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("pageNow", pageNow);
		return mapping.findForward("showNoticeList");
	}
	
	/**
	 * 添加系统公告
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward addSystemNotice(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String noticeContent = request.getParameter("content");
		String url = request.getParameter("url");
		Timestamp time = new Timestamp(new Date().getTime());
		boolean valid = ReqUtils.getBoolean(request, "valided");
		boolean haveDetail =  ReqUtils.getBoolean(request, "haveDetail");
		Systemnotice systemnotice = new Systemnotice(noticeContent, url, time, valid, haveDetail);
		systemNoticeService.addNotice(systemnotice);
		return showNoticeList(mapping, form, request, response);
	}
}
















