package com.yrw.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsonobjects.JUser;
import com.yrw.domains.User;
import com.yrw.service.UserService;
import com.yrw.tools.FastJsonTools;

public class LoginServlet extends BaseServlet {
	private static final long serialVersionUID = 8329251969551864815L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset = utf-8");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();

		// 获取系统的业务逻辑组件
		UserService userService = (UserService) getApplicationContext().getBean("userService");

		String mail = request.getParameter("mail");
		String pass = request.getParameter("pass");

		// 验证用户登录
		User user = userService.checkUser(mail, pass);
		if (user != null) {
			user.setCollections(null);
			user.setNotes(null);
			user.setQueries(null);
			user.setErrorquestionses(null);
			user.setAnswerqueries(null);
			user.setStudyrecords(null);
		}

		JUser jUser = JUser.LocalToNet(user);

		String msg = "";
		if (user != null) {
			msg = FastJsonTools.createJsonString(jUser);
		}

		out.write(msg);
		out.flush();
		out.close();
	}
}
