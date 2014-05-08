package com.yrw.tools;

import java.util.ArrayList;
import java.util.List;

public class CommonTools {

	/**
	 * ���б����ݷ�ת����
	 * 
	 * @param list
	 * @return
	 */
	public static <T> List<T> reverseList(List<T> list) {
		List<T> temp = new ArrayList<T>();
		if (list != null) {
			for (int i = list.size() - 1; i > -1; i--) {
				temp.add(list.get(i));
			}
		}
		return temp;
	}

}
