package com.yrw.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsonobjects.JCollection;
import com.yrw.domains.Collection;
import com.yrw.service.CollectionService;
import com.yrw.tools.FastJsonTools;

public class CollectionServlet extends BaseServlet {
	private static final long serialVersionUID = 995075144103168711L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset = utf-8");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String msg = "";

		// �ղ�JsonString
		String jsonString = request.getParameter("collection");

		// ��ȡ����
		String type = request.getParameter("type");

		// ��ȡϵͳ�߼����
		CollectionService collectionService = (CollectionService) getApplicationContext().getBean("collectionService");

		/**
		 * ���������һ���ղ�
		 */
		if (type.trim().equals("add")) {
			// ת��Ϊjson����
			JCollection jsonObject = FastJsonTools.createJsonBean(jsonString, JCollection.class);

			// ת��Ϊ���ض���
			Collection collection = jsonObject.NetToLocal();

			collectionService.addCollection(collection);
		}
		/**
		 * �����ɾ��һ���ղ�
		 */
		else if (type.trim().equals("delete")) {
			// ת��Ϊjson����
			JCollection jsonObject = FastJsonTools.createJsonBean(jsonString, JCollection.class);

			// ת��Ϊ���ض���
			Collection collection = jsonObject.NetToLocal();

			collectionService.delCollection(collection);
		}
		/**
		 * �����ɾ���б�
		 */
		else if (type.trim().equals("deleteAll")) {
			List<JCollection> jCollections = FastJsonTools.createJsonToListBean(jsonString, JCollection.class);
			for (JCollection jCollection : jCollections) {
				// ת��Ϊ���ض���
				Collection collection = jCollection.NetToLocal();
				collectionService.delCollection(collection);
			}
		}

		else if (type.trim().equals("getCollectionListByUser")) {
			Integer userID = Integer.parseInt(request.getParameter("userId"));
			List<JCollection> temp = new ArrayList<JCollection>();
			List<Collection> collectionList = collectionService.getCollectionListByUser(userID);
			if (collectionList != null) {
				for (Collection collection : collectionList) {
					JCollection jCollection = JCollection.LocalToNet(collection);
					temp.add(jCollection);
				}
				msg = FastJsonTools.createJsonString(temp);
			}

		}
		out.write(msg);
		out.flush();
		out.close();
	}

}
