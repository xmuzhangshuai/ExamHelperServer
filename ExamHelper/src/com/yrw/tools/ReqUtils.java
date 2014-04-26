package com.yrw.tools;

import java.io.UnsupportedEncodingException;
import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * Title:Request�Ĳ���ת��
 * </p>
 * <li>��Requestȡ�õĸ��ֱ������͵�ת��</li> <br>
 * <b>CopyRight: yyhweb[���ɻ���]</b>
 * 
 * @author stephen
 * @version YHBBS-2.0
 */
public class ReqUtils {

	/**
	 * @param request
	 *            request
	 * @throws UnsupportedEncodingException
	 */
	public static void setCharacterEncoding(HttpServletRequest request)
			throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
	}

	/**
	 * @param request
	 * @param paramName
	 *            ��������
	 * @return ��request��ȡ������Ӧ�ַ���ֵ
	 */
	public static String getString(HttpServletRequest request, String paramName) {
		String value = request.getParameter(paramName);
		return value != null ? value : "";
	}

	/**
	 * @param request
	 * @param paramName
	 *            ��������
	 * @return ��request��ȡ���Զ�Ӧ�ַ���ֵ
	 */
	public static String getStrAtt(HttpServletRequest request, String paramName) {
		String value = (String) request.getAttribute(paramName);
		return value != null ? value : "";
	}

	/**
	 * @param request
	 * @param paramName
	 *            ��������
	 * @return ��request��ȡ������Ӧ����ֵ
	 */
	public static String[] getArray(HttpServletRequest request, String paramName) {
		return request.getParameterValues(paramName);
	}

	/**
	 * @param request
	 * @param paramName
	 *            ��������
	 * @return ��request��ȡ������ӦByteֵ
	 */
	public static byte getByte(HttpServletRequest request, String paramName) {
		String value = request.getParameter(paramName);
		if (value == null || value.length() == 0)
			return 0;
		else
			return Byte.parseByte(value);
	}

	/**
	 * @param request
	 * @param paramName
	 *            ��������
	 * @return ��request��ȡ������Ӧ����ֵ
	 */
	public static int getInt(HttpServletRequest request, String paramName) {
		String value = request.getParameter(paramName);
		if (value == null || value.length() == 0)
			return 0;
		else {
			try {
				return Integer.parseInt(value);
			} catch (Exception e) {
				e.printStackTrace();
				return 0;
			}
		}
	}

	/**
	 * @param request
	 * @param paramName
	 *            ��������
	 * @return ��request��ȡ������Ӧ����ֵ
	 */
	public static int getIntAtt(HttpServletRequest request, String paramName) {
		String value = request.getAttribute(paramName).toString();
		if (value == null || value.length() == 0)
			return 0;
		else {
			try {
				return Integer.parseInt(value);
			} catch (Exception e) {
				e.printStackTrace();
				return 0;
			}
		}
	}

	/**
	 * @param request
	 * @param paramName
	 *            ��������
	 * @return ��request��ȡ������Ӧ������ֵ
	 */
	public static long getLong(HttpServletRequest request, String paramName) {
		String value = request.getParameter(paramName);
		if (value == null || value.length() == 0)
			return 0L;
		else {
			try {
				return Long.parseLong(value);
			} catch (Exception e) {
				e.printStackTrace();
				return 0L;
			}
		}

	}

	/**
	 * @param request
	 * @param paramName
	 *            ��������
	 * @return ��request��ȡ������Ӧ������ֵ
	 */
	public static short getShort(HttpServletRequest request, String paramName) {
		String value = request.getParameter(paramName);
		if (value == null || value.length() == 0)
			return 0;
		else
			return Short.parseShort(value);
	}

	/**
	 * @param request
	 * @param paramName
	 *            ��������
	 * @return ��request��ȡ������Ӧ����ֵ
	 */
	public static boolean getBoolean(HttpServletRequest request, String paramName) {
		String value = request.getParameter(paramName);
		if (value == null || value.length() == 0)
			return false;
		else
			return Boolean.valueOf(value).booleanValue();
	}
}
