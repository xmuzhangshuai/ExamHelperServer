package com.yrw.dao;

import java.sql.Timestamp;
import java.util.List;

import com.yrw.domains.Collection;
import com.yrw.domains.Scollection;
import com.yrw.idao.ICollectionDao;
import com.yrw.idao.IScollectionDao;

public class CollectionDao extends BasicDao implements ICollectionDao {

	private IScollectionDao iScollectionDao;

	public void setiScollectionDao(IScollectionDao iScollectionDao) {
		this.iScollectionDao = iScollectionDao;
	}

	@Override
	public List getCollectionByUser(int userId, int pageNow) {
		// TODO Auto-generated method stub
		String hql = "select collection from Collection collection left join collection.user user where user.id="
				+ userId;
		return this.executeQueryByPage(hql, null, pageNow);
	}

	@Override
	public int getPageCountByUser(int userId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void addCollection(Collection collection) {
		int questionTypeId = collection.getQuestiontype().getId();
		int questionId = collection.getQuestionId();
		String hql = "from Collection as c where c.user.id="
				+ collection.getUser().getId() + " and c.questiontype.id="
				+ questionTypeId + " and c.questionId=" + questionId;
		Collection collection2 = (Collection) this.uniqueQuery(hql, null);
		if (collection2 != null) {
			collection2
					.setCollectTime(new Timestamp(System.currentTimeMillis()));
			this.update(collection2);
		} else {
			this.add(collection);
			// 修改scollection中关于用户收藏数目
			Scollection scollection = iScollectionDao.getScollection(
					questionTypeId, questionId);
			if (scollection != null) {
				scollection
						.setCollectionNum(scollection.getCollectionNum() + 1);
				iScollectionDao.update(scollection);
			} else {
				scollection = new Scollection();
				scollection.setCollectionNum(1);
				scollection.setQuestionId(questionId);
				scollection.setQuestiontype(collection.getQuestiontype());
				scollection.setSection(collection.getSection());
				iScollectionDao.add(scollection);
			}
		}
	}

	@Override
	public void delCollection(Collection collection) {
		// TODO Auto-generated method stub
		int questionId = collection.getQuestionId();
		int questionTypeId = collection.getQuestiontype().getId();
		String hql = "from Collection as c where c.user.id="
				+ collection.getUser().getId() + " and c.questiontype.id="
				+ questionTypeId + " and c.questionId=" + questionId;
		Collection collection2 = (Collection) this.uniqueQuery(hql, null);
		if (collection2 != null) {
			this.deletById(Collection.class, collection2.getId());
			// 修改Scollection中用户收藏次数统计
			Scollection scollection = iScollectionDao.getScollection(
					questionTypeId, questionId);
			scollection.setCollectionNum(scollection.getCollectionNum() - 1);
			iScollectionDao.update(scollection);
		}
	}

	@Override
	public List<Collection> getCollectionByUser(int userId) {
		// TODO Auto-generated method stub
		String hql = "select collection from Collection collection left join collection.user user where user.id="
				+ userId + "order by collection.collectTime desc";
		return this.executeQuery(hql, null);
	}

	@Override
	public List<Collection> getCollectionList() {
		// TODO Auto-generated method stub
		String hql = "select collection from Collection collection order by collection.collectTime desc";
		return this.executeQuery(hql, null);
	}

	@Override
	public int getSCollectionListPageCount() {
		// TODO Auto-generated method stub
		String hql = "select count(*) from Scollection";
		return this.queryPageCount(hql, null);
	}

	@Override
	public List<Scollection> getScollectionListByPage(int pageNow) {
		// TODO Auto-generated method stub
		String hql = "from Scollection order by collectionNum desc";
		return this.executeQueryByPage(hql, null, pageNow);
	}

}
