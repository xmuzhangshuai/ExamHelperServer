package com.yrw.dao;

import java.util.List;

import com.yrw.domains.Collection;
import com.yrw.idao.ICollectionDao;

public class CollectionDao extends BasicDao implements ICollectionDao {

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
		// TODO Auto-generated method stub

	}

	@Override
	public void delCollection(Collection collection) {
		// TODO Auto-generated method stub

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

}
