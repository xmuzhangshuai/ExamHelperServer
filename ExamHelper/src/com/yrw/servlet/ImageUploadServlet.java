package com.yrw.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lxh.smart.File;
import org.lxh.smart.SmartUpload;
import org.lxh.smart.SmartUploadException;

/**
 * 
 * �����ƣ�ImageUploadServlet �������������ϴ�ͼƬ �����ˣ� ��˧ ����ʱ�䣺2014��4��16�� ����9:57:08
 */
public class ImageUploadServlet extends BaseServlet {

	private static final long serialVersionUID = -678603018626900185L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// �����������
		response.setContentType("text/html;charset=utf-8");

		PrintWriter out = response.getWriter();

		// ʵ�������
		SmartUpload su = new SmartUpload();
		// ��ʼ�����
		su.initialize(this.getServletConfig(), request, response);
		// �ϴ�����
		su.setMaxFileSize(5 * 1024 * 1024); // ���ô�С5M
		su.setAllowedFilesList("gif,png,jpg"); // �����ϴ�����

		// �ϴ��ļ�
		try {
			su.upload();
		} catch (SmartUploadException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		String type = su.getRequest().getParameter("type");
		String userID = su.getRequest().getParameter("userID");

		/******* ������ϴ�����ͼƬ **********/
		if (type.equals("queryImage")) {

			// ׼���ϴ���Ŀ¼
			String path = this.getServletContext().getRealPath("QueryImages");

			java.io.File fpath = new java.io.File(path);
			if (!fpath.exists()) {
				fpath.mkdir();
			}

			try {
				// ��ȡ�ϴ��ĵ�һ���ļ�
				File file = su.getFiles().getFile(0);
				// �ж��Ƿ����ļ��ϴ���û��ѡ���ļ�����ʾ�û�
				if (file.isMissing()) {
					out.println("��ѡ��Ҫ�ϴ����ļ���");
					return;
				}

				// ���չ���׼���ļ���������
				String fname = new Date().getTime() + (new Random().nextInt(900) + 100) + userID + "."
						+ file.getFileExt();
				// ���ļ��ӻ�����ת�Ƶ�ָ��Ŀ¼��
				file.saveAs(path + "/" + fname);

				// ����ͼƬ�洢·��
				out.println("QueryImages/" + fname);

			} catch (SecurityException e) {
				e.printStackTrace();
				// Υ���ϴ����Ƶ��쳣����
				out.println("��ѡ��Ϸ����ļ���'");
			} catch (SmartUploadException e) {
				e.printStackTrace();
				out.println("�ļ��ϴ�ʧ�ܣ�");
			}
		}

	}

}
