package com.yrw.service;

import java.sql.Timestamp;
import java.util.List;

import com.yrw.domains.Collection;
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
	 * ��Ӽ�¼
	 * 
	 * @param collection
	 */
	public void addCollection(Collection collection) {
	icollectionDao.addCollection(collection);

	}

	/**
	 * ɾ����¼
	 * 
	 * @param collection
	 */
	public void delCollection(Collection collection) {
		icollectionDao.delCollection(collection);
	}

	/**
	 * �����û�ID�����ղ��б�
	 * 
	 * @param userID
	 * @return
	 */
	public List<Collection> getCollectionListByUser(int userID) {
		return icollectionDao.getCollectionByUser(userID);
	}

	/**
	 * ���������ղ�
	 * 
	 * @return
	 */
	public List<Collection> getCollections() {
		return icollectionDao.getCollectionList();
	}


}
