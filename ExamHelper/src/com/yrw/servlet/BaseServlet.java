package com.yrw.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class BaseServlet extends HttpServlet {
	private static final long serialVersionUID = -5343230425576331940L;

	private ApplicationContext ctx;

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		// 获取web应用中的ApplicationContext实例
		ctx = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
	}

	// 返回Web应用中的Spring实例
	public ApplicationContext getApplicationContext() {
		return this.ctx;
	}

}
