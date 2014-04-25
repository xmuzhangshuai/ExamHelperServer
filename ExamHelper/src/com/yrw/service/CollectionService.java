package com.yrw.service;

import java.util.List;

import com.yrw.domains.Collection;
import com.yrw.domains.Scollection;
import com.yrw.idao.ICollectionDao;

/**
 * @author Administrator
 * 
 */
public class CollectionService {
	private ICollectionDao icollectionDao;

	public void setIcollectionDao(ICollectionDao icollectionDao) {
		this.icollectionDao = icollectionDao;
	}

	/**
	 * 添加记录
	 * 
	 * @param collection
	 */
	public void addCollection(Collection collection) {
	icollectionDao.addCollection(collection);

	}

	/**
	 * 删除记录
	 * 
	 * @param collection
	 */
	public void delCollection(Collection collection) {
		icollectionDao.delCollection(collection);
	}

	/**
	 * 根据用户ID返回收藏列表
	 * 
	 * @param userID
	 * @return
	 */
	public List<Collection> getCollectionListByUser(int userID) {
		return icollectionDao.getCollectionByUser(userID);
	}

	/**
	 * 返回所有收藏
	 * 
	 * @return
	 */
	public List<Collection> getCollections() {
		return icollectionDao.getCollectionList();
	}

	/**
	 * 返回统计Collection页码
	 * @return
	 */
	public int  getSCollectionListPageCount() {
		return icollectionDao.getSCollectionListPageCount();
	}

	/**
	 * 根据页码返回list
	 * @return
	 */
	public List<Scollection> getScollectionListByPageNow(int pageNow){
		return icollectionDao.getScollectionListByPage(pageNow);
	}
}
