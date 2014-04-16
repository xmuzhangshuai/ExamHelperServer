package com.yrw.tools;


import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

public class FastJsonTools {

	public FastJsonTools() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 把对象生成Json字符串
	 * 
	 * @param object
	 * @return
	 */
	public static String createJsonString(Object object) {
		String jsonString = JSON.toJSONString(object);
		return jsonString;
	}

	/**
	 * 把Json字符串生成对象
	 * 
	 * @param jsonString
	 * @param cls
	 * @return
	 */
	public static <T> T createJsonBean(String jsonString, Class<T> cls) {
		T t = JSON.parseObject(jsonString, cls);
		return t;
	}

	/**
	 * 把Json字符串生成对象列表
	 * 
	 * @param jsonString
	 * @param cls
	 * @return
	 */
	public static <T> List<T> createJsonToListBean(String jsonString, Class<T> cls) {
		List<T> list = null;
		list = JSON.parseArray(jsonString, cls);
		return list;
	}

	/**
	 * @param jsonString
	 * @return
	 */
	public static List<Map<String, Object>> createJsonToListMap(String jsonString) {
		List<Map<String, Object>> list2 = JSON.parseObject(jsonString, new TypeReference<List<Map<String, Object>>>() {
		});
		return list2;
	}
}
