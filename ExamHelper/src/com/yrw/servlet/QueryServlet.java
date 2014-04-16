package com.yrw.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsonobjects.JQuerys;
import com.jsonobjects.JUser;
import com.yrw.domains.Query;
import com.yrw.domains.User;
import com.yrw.service.NoteService;
import com.yrw.service.QueryService;
import com.yrw.service.UserService;
import com.yrw.tools.FastJsonTools;

public class QueryServlet extends BaseServlet {

	private static final long serialVersionUID = -4233624704859203178L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset = utf-8");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String msg = "";
		String type = "";

		// ��ȡϵͳ�߼����
		QueryService queryService = (QueryService) getApplicationContext().getBean("queryService");
		UserService userService = (UserService) getApplicationContext().getBean("userService");

		// ����
		type = request.getParameter("type");
		// // ÿ�λ�ȡ��Ŀ����
		// int size = Integer.parseInt(request.getParameter("size").trim());
		// // ����һ����ʼ��ȡ
		// int startIndex =
		// Integer.parseInt(request.getParameter("startIndex").trim());

		// ����ǰ�ҳ���������б�
		if (type.equals("getQueryByPage")) {
			// ��ȡҳ��
			int pageNow = Integer.parseInt(request.getParameter("pageNow").trim());

			List<Map<String, Object>> data = new ArrayList<Map<String, Object>>();
			List<Query> queryList = queryService.getJQueryListByPage(pageNow);
			if (queryList != null) {
				for (Query query : queryList) {
					Map<String, Object> map = new HashMap<String, Object>();
					User user = userService.getUserByKey(query.getUser().getId());
					map.put("userImage", user.getAvatar());
					map.put("username", user.getNickname());
					map.put("userLocation", user.getArea());
					map.put("queryId", query.getId());
					map.put("queryContent", query.getQueryStem());
					map.put("queryImage", query.getQueryImage());
					map.put("queryTime", (Date)query.getQueryTime());
					// map.put("queryAnswerNum", queryService.get);
					data.add(map);
				}
			}

			if (data != null) {
				msg = FastJsonTools.createJsonString(data);
			}
		}

		out.write(msg);
		out.flush();
		out.close();
	}

}
