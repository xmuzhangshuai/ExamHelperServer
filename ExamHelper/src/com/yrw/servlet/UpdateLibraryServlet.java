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
 * �����ƣ�UpdateLibraryServlet ���������û�����ϸ��� �����ˣ� ��˧ ����ʱ�䣺2014��4��29�� ����10:57:07
 */
public class UpdateLibraryServlet extends BaseServlet {

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset = utf-8");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String msg = "";
		// ��ȡϵͳ��ҵ���߼����
		UpdateLibraryService updateLibraryService = (UpdateLibraryService) getApplicationContext().getBean(
				"updateLibraryService");

		String jsonString = request.getParameter("data");
		List<Map<String, Object>> data = FastJsonTools.createJsonToListMap(jsonString);

		if (updateLibraryService.checkUpdate(data)) {
			msg = "haveUpdate";
		}

		out.write(msg);
		out.flush();
		out.close();
	}

}
