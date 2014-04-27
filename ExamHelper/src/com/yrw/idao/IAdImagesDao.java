package com.yrw.idao;

import java.util.Date;
import java.util.List;

import com.yrw.domains.Adimages;

public interface IAdImagesDao extends IBasicDao{
	/**
	 * ��ӹ��
	 * @param adimages
	 */
	public void addAdImage(Adimages adimages);
	
	public void addAdImage(String url);
	
	/**
	 * ���ص�ǰ���
	 * @return
	 */
	public List<Adimages> getAdImageListByTime();
	
	/**
	 * ���ص�ǰ���·��
	 * @return
	 */
	public List<String> getAdImageUrlListByTime();
}
