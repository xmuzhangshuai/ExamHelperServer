package com.yrw.idao;

import java.util.Date;
import java.util.List;

import com.yrw.domains.Adimages;

public interface IAdImagesDao extends IBasicDao{
	/**
	 * 添加广告
	 * @param adimages
	 */
	public void addAdImage(Adimages adimages);
	
	public void addAdImage(String url);
	
	/**
	 * 返回当前广告
	 * @return
	 */
	public List<Adimages> getAdImageListByTime();
	
	/**
	 * 返回当前广告路径
	 * @return
	 */
	public List<String> getAdImageUrlListByTime();
}
