package com.yrw.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lxh.smart.File;
import org.lxh.smart.SmartUpload;
import org.lxh.smart.SmartUploadException;

public class TestServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 对象输出声明
		response.setContentType("text/html;charset=utf-8");

		PrintWriter out = response.getWriter();

		// 实例化组件
		SmartUpload su = new SmartUpload();
		// 初始化组件
		su.initialize(this.getServletConfig(), request, response);
		// 上传限制
		su.setMaxFileSize(5 * 1024 * 1024); // 设置大小5M
		su.setAllowedFilesList("gif,png,jpg"); // 设置上传类型

		// 上传文件
		try {
			su.upload();
		} catch (SmartUploadException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		/******* 如果是上传疑问图片 **********/

		// 准备上传的目录
		String path = this.getServletContext().getRealPath("QueryImages");

		java.io.File fpath = new java.io.File(path);
		if (!fpath.exists()) {
			fpath.mkdir();
		}

		try {
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

			// 返回图片存储路径
			out.println("QueryImages/" + fname);

		} catch (SecurityException e) {
			e.printStackTrace();
			// 违反上传限制的异常处理
			out.println("请选择合法的文件！'");
		} catch (SmartUploadException e) {
			e.printStackTrace();
			out.println("文件上传失败！");
		}
	}

}
