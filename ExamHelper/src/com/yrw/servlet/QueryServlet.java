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

import com.jsonobjects.JAnswerQuery;
import com.jsonobjects.JQuerys;
import com.yrw.domains.Answerquery;
import com.yrw.domains.Query;
import com.yrw.domains.User;
import com.yrw.service.QueryService;
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

		// ����
		type = request.getParameter("type");

		// ����ǰ�ҳ���������б�
		if (type.equals("getQueryByPage")) {
			// ��ȡҳ��
			int pageNow = Integer.parseInt(request.getParameter("pageNow").trim());

			List<Map<String, Object>> data = new ArrayList<Map<String, Object>>();
			List<Query> queryList = queryService.getJQueryListByPage(pageNow);
			if (queryList != null) {
				for (Query query : queryList) {
					Map<String, Object> map = new HashMap<String, Object>();
					User user = query.getUser();
					map.put("userImage", user.getAvatar());
					map.put("username", user.getNickname());
					map.put("userID", user.getId());
					map.put("userLocation", user.getArea());
					map.put("queryId", query.getId());
					map.put("queryContent", query.getQueryStem());
					map.put("queryImage", query.getQueryImage());
					map.put("queryTime", (Date) query.getQueryTime());
					map.put("queryAnswerNum", queryService.getAnswerCountByQueryID(query.getId()));
					data.add(map);
				}
			}

			if (data != null) {
				msg = FastJsonTools.createJsonString(data);
			}
		}
		// ����Ƿ�������
		else if (type.equals("addquery")) {
			String queryString = request.getParameter("query");
			JQuerys jQuerys = FastJsonTools.createJsonBean(queryString, JQuerys.class);
			try {
				queryService.addQuery(jQuerys.NetToLocal());
				msg = "OK";
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				msg = "NOT OK";
			}

		}

		// ����Ǹ�������ID���ػش����ݺ��û�����
		else if (type.equals("getAnswerList")) {
			int queryID = Integer.parseInt(request.getParameter("queryID"));
			List<Answerquery> answerqueries = queryService.getAnswerListByQueryID(queryID);
			if (answerqueries != null) {
				List<Map<String, Object>> data = new ArrayList<Map<String, Object>>();
				for (Answerquery answerquery : answerqueries) {
					Map<String, Object> map = new HashMap<String, Object>();
					User user = answerquery.getUser();
					map.put("userID", user.getId());
					map.put("headImage", user.getAvatar());
					map.put("userName", user.getNickname());
					map.put("gengder", user.getGender());
					map.put("location", user.getArea());
					map.put("answerTime", (Date) answerquery.getAnswerTime());
					map.put("answerContent", answerquery.getAnswerContent());
					data.add(map);
				}
				msg = FastJsonTools.createJsonString(data);
			}

		}
		// ����Ǵ���
		else if (type.equals("addAnswer")) {
			String jsonString = request.getParameter("answerQuery");
			JAnswerQuery jAnswerQuery = FastJsonTools.createJsonBean(jsonString, JAnswerQuery.class);
			if (jAnswerQuery != null) {
				try {
					Answerquery answerquery = jAnswerQuery.NetToLocal();
					queryService.addAnswerQuery(answerquery);
					msg = "ok";
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
					msg = "NotOK";
				}

			}

		}
		// �����û�ID���������б�
		else if (type.equals("myQueryList")) {
			// ��ȡҳ��
			int pageNow = Integer.parseInt(request.getParameter("pageNow").trim());
			// ��ȡ�û�ID
			int userID = Integer.parseInt(request.getParameter("userID").trim());

			List<Map<String, Object>> data = new ArrayList<Map<String, Object>>();
			List<Query> queryList = queryService.getQueryByUserId(userID, pageNow);
			if (queryList != null) {
				for (Query query : queryList) {
					Map<String, Object> map = new HashMap<String, Object>();
					User user = query.getUser();
					map.put("userImage", user.getAvatar());
					map.put("username", user.getNickname());
					map.put("userID", user.getId());
					map.put("userLocation", user.getArea());
					map.put("queryId", query.getId());
					map.put("queryContent", query.getQueryStem());
					map.put("queryImage", query.getQueryImage());
					map.put("queryTime", (Date) query.getQueryTime());
					map.put("queryAnswerNum", queryService.getAnswerCountByQueryID(query.getId()));
					data.add(map);
				}
			}

			if (data != null) {
				msg = FastJsonTools.createJsonString(data);
			}
		}

		// �����û�ID���ػش��б�
		else if (type.equals("myAnswerList")) {
			// ��ȡҳ��
			int pageNow = Integer.parseInt(request.getParameter("pageNow").trim());
			// ��ȡ�û�ID
			int userID = Integer.parseInt(request.getParameter("userID").trim());

			List<Map<String, Object>> data = new ArrayList<Map<String, Object>>();
			List<Answerquery> answerquerieList = queryService.getAnswerQueryByUserId(userID, pageNow);
			List<Query> querieList = new ArrayList<Query>();
			if (answerquerieList != null) {
				for (Answerquery answerquery : answerquerieList) {
					Map<String, Object> map = new HashMap<String, Object>();
					Query query = answerquery.getQuery();
					if (!querieList.contains(query)) {
						querieList.add(query);
						User user = query.getUser();
						map.put("userImage", user.getAvatar());
						map.put("username", user.getNickname());
						map.put("userID", user.getId());
						map.put("userLocation", user.getArea());
						map.put("queryId", query.getId());
						map.put("queryContent", query.getQueryStem());
						map.put("queryImage", query.getQueryImage());
						map.put("queryTime", (Date) query.getQueryTime());
						map.put("queryAnswerNum", queryService.getAnswerCountByQueryID(query.getId()));
						map.put("answerList", FastJsonTools.createJsonString(JQuerys.LocalListToNetList(queryService
								.getAnswerQueriesByUserAndQuery(userID, query.getId()))));
						data.add(map);
					}
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
