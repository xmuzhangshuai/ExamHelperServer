package com.yrw.service;

import java.sql.Timestamp;
import java.util.Date;
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
	 * Ìí¼Ó¼ÇÂ¼
	 * 
	 * @param collection
	 */
	public void addCollection(Collection collection) {
		String hql = "from Collection as c where c.user.id="
				+ collection.getUser().getId() + " and c.questiontype.id="
				+ collection.getQuestiontype().getId() + " and c.questionId="
				+ collection.getQuestionId();
		Collection collection2 = (Collection) icollectionDao.uniqueQuery(hql,
				null);
		if (collection2 != null) {
			collection2.setCollectTime(new Timestamp(System.currentTimeMillis()));
			icollectionDao.update(collection2);
		} else
			icollectionDao.add(collection);

	}

	/**É¾³ý¼ÇÂ¼
	 * @param collection
	 */
	public void delCollection(Collection collection) {

		String hql = "from Collection as c where c.user.id="
				+ collection.getUser().getId() + " and c.questiontype.id="
				+ collection.getQuestiontype().getId() + " and c.questionId="
				+ collection.getQuestionId();
		Collection collection2 = (Collection) icollectionDao.uniqueQuery(hql,
				null);
		if (collection2 != null) {
			icollectionDao.deletById(Collection.class, collection2.getId());
		}
	}

	
}
