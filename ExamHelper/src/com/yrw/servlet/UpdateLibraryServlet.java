package com.yrw.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yrw.service.UpdateLibraryService;
import com.yrw.tools.FastJsonTools;

/**
 * 类名称：UpdateLibraryServlet 类描述：用户检查更细题库 创建人： 张帅 创建时间：2014年4月29日 上午10:57:07
 */
public class UpdateLibraryServlet extends BaseServlet {

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset = utf-8");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String msg = "";
		// 获取系统的业务逻辑组件
		UpdateLibraryService updateLibraryService = (UpdateLibraryService) getApplicationContext().getBean(
				"updateLibraryService");

		String jsonString = request.getParameter("data");
		List<Map<String, Object>> data = FastJsonTools.createJsonToListMap(jsonString);

		// 如果有更新，返回SectionList
		if (updateLibraryService.checkUpdate(data)) {
			int subjectId = Integer.parseInt((String) data.get(0).get("subjectId"));
			msg = FastJsonTools.createJsonString(updateLibraryService.getJSections(subjectId));
		}

		out.write(msg);
		out.flush();
		out.close();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset = utf-8");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String msg = "";
		// 获取系统的业务逻辑组件
		UpdateLibraryService updateLibraryService = (UpdateLibraryService) getApplicationContext().getBean(
				"updateLibraryService");

		out.write(msg);
		out.flush();
		out.close();
	}

}
