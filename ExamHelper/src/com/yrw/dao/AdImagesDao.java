package com.yrw.dao;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.yrw.domains.Adimages;
import com.yrw.idao.IAdImagesDao;

public class AdImagesDao extends BasicDao implements IAdImagesDao {

	@Override
	public void addAdImage(Adimages adimages) {
		// TODO Auto-generated method stub
		this.add(adimages);
	}

	@Override
	public void addAdImage(String url) {
		// TODO Auto-generated method stub
		Adimages adimages = new Adimages(url, new Timestamp(new Date().getTime()));
		this.addAdImage(adimages);
	}

	@Override
	public List<Adimages> getAdImageListByTime() {
		// TODO Auto-generated method stub
		String hql = "from Adimages order by time desc";
		List list = this.executeQuery(hql, null);
		if (list != null) {
			if (list.size() > 8) {
				list = list.subList(0, 7);
			}
		}
		return list;
	}

	@Override
	public List<String> getAdImageUrlListByTime() {
		// TODO Auto-generated method stub
		List<Adimages> adimages = this.getAdImageListByTime();
		List<String> urlList = new ArrayList<String>();
		if (adimages != null) {
			for (Adimages ad : adimages) {
				urlList.add(ad.getUrl());
			}
		}
		return urlList;
	}

}
