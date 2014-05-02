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

public class MaterImageUploadServlet extends BaseServlet {

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// �����������
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		// ׼���ϴ���Ŀ¼
		String path = this.getServletContext().getRealPath("MaterialImages");

		java.io.File fpath = new java.io.File(path);
		if (!fpath.exists()) {
			fpath.mkdir();
		}
		// ʵ�������
		SmartUpload su = new SmartUpload();
		// ��ʼ�����
		su.initialize(this.getServletConfig(), request, response);

		// �ϴ�����
		su.setMaxFileSize(1024 * 1024); // ���ô�С100KB
		su.setAllowedFilesList("gif,png,jpg"); // �����ϴ�����
		try {
			// �ϴ��ļ�
			su.upload();
			// ��ȡ�ϴ��ĵ�һ���ļ�
			File file = su.getFiles().getFile(0);
			// �ж��Ƿ����ļ��ϴ���û��ѡ���ļ�����ʾ�û�
			if (file.isMissing()) {
				out.println("��ѡ��Ҫ�ϴ����ļ���");
				return;
			}

			// ��ȡϵͳ��ҵ���߼����
			// UserService userService = (UserService)
			// getApplicationContext().getBean("userService");
			// String mail = su.getRequest().getParameter("mail");
			// String pass = su.getRequest().getParameter("pass");
			// User user = userService.checkUser(mail, pass);

			// ���չ���׼���ļ���������
			String fname = new Date().getTime() + (new Random().nextInt(900) + 100) + "." + file.getFileExt();
			// ���ļ��ӻ�����ת�Ƶ�ָ��Ŀ¼��
			file.saveAs(path + "/" + fname);

			// user.setAvatar("MaterialImages/" + fname);
			// userService.modifyUser(user);

			out.println("OK!");

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
