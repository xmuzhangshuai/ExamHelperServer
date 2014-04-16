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

public class ManageUserServlet extends BaseServlet {

	private static final long serialVersionUID = 1083647979898512283L;

	/**
	 * 更新用户信息
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset = utf-8");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String msg = "";

		// 获取系统的业务逻辑组件
		UserService userService = (UserService) getApplicationContext().getBean("userService");

		String type = request.getParameter("type");

		// 如果是更新用户
		if (type == null) {
			String userString = request.getParameter("com.bishe.examhelper.updateuser");
			String mail = request.getParameter("mail");
			String pass = request.getParameter("pass");

			if (userString != null) {
				JUser jUser = FastJsonTools.createJsonBean(userString, JUser.class);
				try {
					// 更新进数据库
					userService.modifyUser(jUser.NetToLocal());
					msg = "OK";
				} catch (Exception e) {
					// TODO: handle exception
					msg = "ERROR";
				}
			}

			if (mail != null && pass != null) {
				User user = userService.checkUser(mail, pass);
				user.setCollections(null);
				user.setNotes(null);
				user.setQueries(null);
				user.setErrorquestionses(null);
				user.setAnswerqueries(null);
				user.setStudyrecords(null);

				if (user != null) {
					msg = FastJsonTools.createJsonString(user);
				}
			}
		}

		// 如果是根据用户ID获取用户
		else if (type.equals("getUserById")) {
			String userKeyString = request.getParameter("userID");
			int userKey = Integer.parseInt(userKeyString);
			User user = userService.getUserByKey(userKey);
			if (user != null) {
				JUser jUser = JUser.LocalToNet(user);
				msg = FastJsonTools.createJsonString(jUser);
			}
		}

		out.write(msg);
		out.flush();
		out.close();
	}
}
