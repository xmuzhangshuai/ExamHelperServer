package com.yrw.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsonobjects.JCollection;
import com.yrw.domains.Collection;
import com.yrw.service.CollectionService;
import com.yrw.tools.FastJsonTools;

public class CollectionServlet extends BaseServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset = utf-8");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");

		// 收藏JsonString
		String jsonString = request.getParameter("collection");

		// 获取类型
		String type = request.getParameter("type");

		// 获取系统逻辑组件
		CollectionService collectionService = (CollectionService) getApplicationContext().getBean("collectionService");

		/**
		 * 如果是增加一条收藏
		 */
		if (type.trim().equals("add")) {
			// 转化为json对象
			JCollection jsonObject = FastJsonTools.createJsonBean(jsonString, JCollection.class);

			// 转化为本地对象
			Collection collection = jsonObject.NetToLocal();

			collectionService.addCollection(collection);
		}
		/**
		 * 如果是删除一条收藏
		 */
		else if (type.trim().equals("delete")) {
			// 转化为json对象
			JCollection jsonObject = FastJsonTools.createJsonBean(jsonString, JCollection.class);

			// 转化为本地对象
			Collection collection = jsonObject.NetToLocal();

			collectionService.delCollection(collection);
		}
		/**
		 * 如果是删除列表
		 */
		else if (type.trim().equals("deleteAll")) {
			List<JCollection> jCollections = FastJsonTools.createJsonToListBean(jsonString, JCollection.class);
			for (JCollection jCollection : jCollections) {
				// 转化为本地对象
				Collection collection = jCollection.NetToLocal();
				collectionService.delCollection(collection);
			}
		}

	}

}
