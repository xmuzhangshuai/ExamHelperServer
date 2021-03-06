/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.yrw.web.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.yrw.domains.Manager;
import com.yrw.service.LoginService;
import com.yrw.web.forms.LoginForm;

/**
 * 
 * 项目名称：ExamHelper 类名称：LoginActoin 类描述： 跟登陸、退出有關的分派action 创建人：叶睿雯 创建时间：2014-3-15
 * 修改人： 修改时间： 修改备注：
 * 
 * @version
 * 
 */
public class LoginAction extends DispatchAction {
	/*
	 * Generated Methods
	 */

	private LoginService loginService;
	


	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

	/**
	 * 管理员登陆验证
	 * 
	 * @param ActionMapping
	 * @param ActionForm
	 * @param HttpServletRequest
	 * @param HttpServletResponse
	 * @return ActionForward
	 * 
	 */
	public ActionForward login(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		LoginForm loginForm = (LoginForm) form;// TODO Auto-generated method
												// stub
		Manager manager = loginService.checkManager(loginForm.getName(),
				loginForm.getPassword());

		if (manager != null) {
			request.getSession().setAttribute("managerInfor", manager);
			return mapping.findForward("loginSuccess");
		} else{
			request.setAttribute("message", "用户名或密码错误，请重新输入");
			return mapping.findForward("goLoginUI");
			}
	}

	
	public ActionForward loadLeft(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
		
		Manager manager=(Manager) request.getSession().getAttribute("managerInfor");
		request.getSession().setAttribute("managerInfor", manager);
		return mapping.findForward("loadLeft");
	}

	/**
	 * 退出系统
	 * 
	 * @param ActionMapping
	 * @param ActionForm
	 * @param HttpServletRequest
	 * @param HttpServletResponse
	 * @return ActionForward
	 * 
	 */
	public ActionForward logout(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		request.getSession().invalidate();
		return mapping.findForward("goLoginUI");
	}

	/**
	 * 返回主界面
	 * 
	 * @param ActionMapping
	 * @param ActionForm
	 * @param HttpServletRequest
	 * @param HttpServletResponse
	 * @return ActionForward
	 * 
	 */
	public ActionForward goMainFrame(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		if (request.getSession().getAttribute("managerInfor") != null)
			return mapping.findForward("loginSuccess");
		else
			return mapping.findForward("fail");
	}

}