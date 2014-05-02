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

		// 对象输出声明
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		// 准备上传的目录
		String path = this.getServletContext().getRealPath("MaterialImages");

		java.io.File fpath = new java.io.File(path);
		if (!fpath.exists()) {
			fpath.mkdir();
		}
		// 实例化组件
		SmartUpload su = new SmartUpload();
		// 初始化组件
		su.initialize(this.getServletConfig(), request, response);

		// 上传限制
		su.setMaxFileSize(1024 * 1024); // 设置大小100KB
		su.setAllowedFilesList("gif,png,jpg"); // 设置上传类型
		try {
			// 上传文件
			su.upload();
			// 获取上传的第一个文件
			File file = su.getFiles().getFile(0);
			// 判断是否有文件上传，没有选择文件则提示用户
			if (file.isMissing()) {
				out.println("请选择要上传的文件！");
				return;
			}

			// 按照规则准备文件名按规则
			String fname = new Date().getTime() + (new Random().nextInt(900) + 100) + "." + file.getFileExt();
			// 把文件从缓存区转移到指定目录中
			file.saveAs(path + "/" + fname);

			request.setAttribute("imageUrl", "MaterialImages/" + fname);
			request.setAttribute("state", "上传成功");
			request.getRequestDispatcher("/MaterImage.jsp").forward(request, response);

		} catch (SecurityException e) {
			e.printStackTrace();
			// 违反上传限制的异常处理
			out.println("请选择合法的文件！'");
			request.setAttribute("state", "请选择合法的文件！");
			request.getRequestDispatcher("/MaterImage.jsp").forward(request, response);
		} catch (SmartUploadException e) {
			e.printStackTrace();
			out.println("文件上传失败！");
			request.setAttribute("state", "文件上传失败！！");
			request.getRequestDispatcher("/MaterImage.jsp").forward(request, response);
		}

	}

}
