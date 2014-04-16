package com.yrw.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class BaseServlet extends HttpServlet {
	private static final long serialVersionUID = -5343230425576331940L;

	private ApplicationContext ctx;

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		// ��ȡwebӦ���е�ApplicationContextʵ��
		ctx = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
	}

	// ����WebӦ���е�Springʵ��
	public ApplicationContext getApplicationContext() {
		return this.ctx;
	}

}
