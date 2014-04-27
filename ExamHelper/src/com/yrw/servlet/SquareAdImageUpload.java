package com.yrw.servlet;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.util.Streams;

public class SquareAdImageUpload extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * ʵ�ֶ��ļ���ͬʱ�ϴ�
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ���ý��յı����ʽ
		request.setCharacterEncoding("UTF-8");
		String newfileName = "" + new Date().getTime() + (new Random().nextInt(900) + 100);// �ļ�����
		String fileRealPath = "";// �ļ������ʵ��ַ

		String fileRealResistPath = "";// �ļ������ʵ���·��

		// ���� ������� ���� ��request ����һ��..��������
		// String name = request.getParameter("name");

		String firstFileName = "";
		// ����������ϴ��ļ������ڵ�����·��
		String savePath = this.getServletContext().getRealPath("AdImages") + "\\";
		File file = new File(savePath);
		if (!file.isDirectory()) {
			file.mkdir();
		}

		try {
			DiskFileItemFactory fac = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(fac);
			upload.setHeaderEncoding("UTF-8");
			// ��ȡ����ϴ��ļ�
			List fileList = fileList = upload.parseRequest(request);
			// �����ϴ��ļ�д�����
			Iterator it = fileList.iterator();
			while (it.hasNext()) {
				FileItem item = (FileItem) it.next();

				// ���item���ļ��ϴ�����
				// ����ļ�����·��
				String fileName = item.getName();
				if (fileName != null) {
					firstFileName = item.getName().substring(item.getName().lastIndexOf("\\") + 1);
					String formatName = firstFileName.substring(firstFileName.lastIndexOf("."));// ��ȡ�ļ���׺��
					fileRealPath = savePath + newfileName + formatName;// �ļ������ʵ��ַ

					BufferedInputStream in = new BufferedInputStream(item.getInputStream());// ����ļ�������
					BufferedOutputStream outStream = new BufferedOutputStream(new FileOutputStream(new File(
							fileRealPath)));// ����ļ������
					Streams.copy(in, outStream, true);// ��ʼ���ļ�д����ָ�����ϴ��ļ���
					// �ϴ��ɹ�����������ݿ�
					if (new File(fileRealPath).exists()) {
						// ����·����ֵ
						fileRealResistPath = fileRealPath.substring(fileRealPath.lastIndexOf("\\") + 1);
					}
				}
			}
		} catch (FileUploadException ex) {
			ex.printStackTrace();
			return;
		}
		response.getWriter().write("1");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
