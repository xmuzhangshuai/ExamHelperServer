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
	 * 实现多文件的同时上传
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 设置接收的编码格式
		request.setCharacterEncoding("UTF-8");
		String newfileName = "" + new Date().getTime() + (new Random().nextInt(900) + 100);// 文件名称
		String fileRealPath = "";// 文件存放真实地址

		String fileRealResistPath = "";// 文件存放真实相对路径

		// 名称 界面编码 必须 和request 保存一致..否则乱码
		// String name = request.getParameter("name");

		String firstFileName = "";
		// 获得容器中上传文件夹所在的物理路径
		String savePath = this.getServletContext().getRealPath("AdImages") + "\\";
		File file = new File(savePath);
		if (!file.isDirectory()) {
			file.mkdir();
		}

		try {
			DiskFileItemFactory fac = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(fac);
			upload.setHeaderEncoding("UTF-8");
			// 获取多个上传文件
			List fileList = fileList = upload.parseRequest(request);
			// 遍历上传文件写入磁盘
			Iterator it = fileList.iterator();
			while (it.hasNext()) {
				FileItem item = (FileItem) it.next();

				// 如果item是文件上传表单域
				// 获得文件名及路径
				String fileName = item.getName();
				if (fileName != null) {
					firstFileName = item.getName().substring(item.getName().lastIndexOf("\\") + 1);
					String formatName = firstFileName.substring(firstFileName.lastIndexOf("."));// 获取文件后缀名
					fileRealPath = savePath + newfileName + formatName;// 文件存放真实地址

					BufferedInputStream in = new BufferedInputStream(item.getInputStream());// 获得文件输入流
					BufferedOutputStream outStream = new BufferedOutputStream(new FileOutputStream(new File(
							fileRealPath)));// 获得文件输出流
					Streams.copy(in, outStream, true);// 开始把文件写到你指定的上传文件夹
					// 上传成功，则插入数据库
					if (new File(fileRealPath).exists()) {
						// 虚拟路径赋值
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
