package com.yrw.service;

import java.util.List;

import com.yrw.idao.IAdImagesDao;

public class AdImagesService {
	private IAdImagesDao iAdImagesDao;

	public void setiAdImagesDao(IAdImagesDao iAdImagesDao) {
		this.iAdImagesDao = iAdImagesDao;
	}
	
	/**
	 * ���ͼƬ
	 * @param url
	 */
	public void addAdImage(String url){
		iAdImagesDao.addAdImage(url);
	}
	
	/**
	 * ����ͼƬ·���б�
	 * @return
	 */
	public List<String> getAdImageUrlListByTime(){
		return iAdImagesDao.getAdImageUrlListByTime();
	}
}
