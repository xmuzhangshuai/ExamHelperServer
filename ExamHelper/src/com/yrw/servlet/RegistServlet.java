package com.yrw.servlet;

/**
 * 注册的Servlet
 * 
 * @author zhangshuai
 * 
 */
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yrw.domains.User;
import com.yrw.service.UserService;
import com.yrw.tools.FastJsonTools;

public class RegistServlet extends BaseServlet {

	private static final long serialVersionUID = 6681985975893794892L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset = utf-8");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String msg = "";

		String mail = request.getParameter("mail");
		String pass = request.getParameter("pass");
		String phone = request.getParameter("phone");

		User user = new User(mail, pass, null, null, 0, phone, null, null,
				null, null, null, 0, null, null, null, null, null, null);

		// 获取系统的业务逻辑组件
		UserService userService = (UserService) getApplicationContext()
				.getBean("userService");

		// 返回注册好的对象
		User local = userService.addUser(user);
		com.jsonobjects.JUser net = com.jsonobjects.JUser.LocalToNet(local);
		if (net != null) {
			msg = FastJsonTools.createJsonString(net);
		}

		out.write(msg);
		out.flush();
		out.close();
	}

}
