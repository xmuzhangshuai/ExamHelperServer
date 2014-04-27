package com.yrw.service;

import java.util.List;

import com.yrw.idao.IAdImagesDao;

public class AdImagesService {
	private IAdImagesDao iAdImagesDao;

	public void setiAdImagesDao(IAdImagesDao iAdImagesDao) {
		this.iAdImagesDao = iAdImagesDao;
	}
	
	/**
	 * 添加图片
	 * @param url
	 */
	public void addAdImage(String url){
		iAdImagesDao.addAdImage(url);
	}
	
	/**
	 * 返回图片路径列表
	 * @return
	 */
	public List<String> getAdImageUrlListByTime(){
		return iAdImagesDao.getAdImageUrlListByTime();
	}
}
