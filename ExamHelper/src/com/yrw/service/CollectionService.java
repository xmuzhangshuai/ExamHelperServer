package com.yrw.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.yrw.domains.Collection;
import com.yrw.domains.satatics.Scollection;
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
		String hql = "from Collection as c where c.user.id=" + collection.getUser().getId() + " and c.questiontype.id="
				+ collection.getQuestiontype().getId() + " and c.questionId=" + collection.getQuestionId();
		Collection collection2 = (Collection) icollectionDao.uniqueQuery(hql, null);
		if (collection2 != null) {
			collection2.setCollectTime(new Timestamp(System.currentTimeMillis()));
			icollectionDao.update(collection2);
		} else
			icollectionDao.add(collection);

	}

	/**
	 * ɾ����¼
	 * 
	 * @param collection
	 */
	public void delCollection(Collection collection) {

		String hql = "from Collection as c where c.user.id=" + collection.getUser().getId() + " and c.questiontype.id="
				+ collection.getQuestiontype().getId() + " and c.questionId=" + collection.getQuestionId();
		Collection collection2 = (Collection) icollectionDao.uniqueQuery(hql, null);
		if (collection2 != null) {
			icollectionDao.deletById(Collection.class, collection2.getId());
		}
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

	/**
	 * ��ȡScollectionͳ���б�
	 * 
	 * @return
	 */
	public List<Scollection> getScollections() {
		List<Scollection> scollectionList = new ArrayList<Scollection>();
		List<Collection> collectionList = getCollections();
		if (collectionList != null) {
			for (Collection collection : collectionList) {
				
			}
		}
		return scollectionList;
	}

}
