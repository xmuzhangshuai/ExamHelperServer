package com.yrw.dao;

import java.util.Date;
import java.util.List;

import com.yrw.domains.Query;
import com.yrw.idao.IQueryDao;

public class QueryDao extends BasicDao implements IQueryDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.yrw.idao.IQueryDao#getQuery(int)
	 */
	@Override
	public List getQuery(int pageNow) {
		// TODO Auto-generated method stub
		String hql = "from Query order by queryTime desc";
		return this.executeQueryByPage(hql, null, pageNow);
	}

	/* (non-Javadoc)
	 * @see com.yrw.idao.IQueryDao#getPageCount()
	 */
	@Override
	public int getPageCount() {
		// TODO Auto-generated method stub
		String hql = "select count(*) from Query";
		return this.queryPageCount(hql, null);

	}

	/* (non-Javadoc)
	 * @see com.yrw.idao.IQueryDao#getQueryByUser(int, int)
	 */
	@Override
	public List getQueryByUser(int userId, int pageNow) {
		// TODO Auto-generated method stub
		String hql = "select query from Query query left join query.user user where user.id=" + userId
				+ " order by query.queryTime desc";
		return this.executeQueryByPage(hql, null, pageNow);
	}

	/* (non-Javadoc)
	 * @see com.yrw.idao.IQueryDao#getPageCountByUser(int)
	 */
	@Override
	public int getPageCountByUser(int userId) {
		// TODO Auto-generated method stub
		String hql = "select count(query) from Query query left join query.user user where user.id=" + userId
				;
		return this.queryPageCount(hql, null);
	}

	/* (non-Javadoc)
	 * @see com.yrw.idao.IQueryDao#getQueryByQueryStem(java.lang.String, int)
	 */
	@Override
	public List getQueryByQueryStem(String queryStem, int pageNow) {
		// TODO Auto-generated method stub
		String hql = "from Query where queryStem like '%" + queryStem
				+ "%' order by queryTime desc";
		return this.executeQueryByPage(hql, null, pageNow);
	}

	/* (non-Javadoc)
	 * @see com.yrw.idao.IQueryDao#getPageCountByQueryStem(java.lang.String)
	 */
	@Override
	public int getPageCountByQueryStem(String queryStem) {
		// TODO Auto-generated method stub
		String hql = "from Query where queryStem like '%" + queryStem
				+ "%' order by queryTime desc";
		return this.queryPageCount(hql, null);
	}

	/* (non-Javadoc)
	 * @see com.yrw.idao.IQueryDao#getQueryByAdoptUserId(int, int)
	 */
	@Override
	public List getQueryByAdoptUserId(int adoptUserId, int pageNow) {
		// TODO Auto-generated method stub
		String hql = "from Query where adoptUserId=" + adoptUserId
				+ " order by queryTime desc";
		return this.executeQueryByPage(hql, null, pageNow);
	}

	/* (non-Javadoc)
	 * @see com.yrw.idao.IQueryDao#getPageCountByAdoptUserId(int)
	 */
	@Override
	public int getPageCountByAdoptUserId(int adoptUserId) {
		// TODO Auto-generated method stub
		String hql = "select count(*) from Query where adoptUserId="
				+ adoptUserId;
		return this.queryPageCount(hql, null);
	}

	
	/* (non-Javadoc)
	 * @see com.yrw.idao.IQueryDao#showQuery(int)
	 */
	public Query showQuery(int queryId){
		String hql="from Query where id="+queryId;
		return (Query)this.uniqueQuery(hql, null);
		
	}
	/* (non-Javadoc)
	 * @see com.yrw.idao.IQueryDao#addQuery(com.yrw.domains.Query)
	 */
	@Override
	public void addQuery(Query query) {
		// TODO Auto-generated method stub
		this.add(query);
	}

	/* (non-Javadoc)
	 * @see com.yrw.idao.IQueryDao#delQuery(int)
	 */
	@Override
	public void delQuery(int queryId) {
		// TODO Auto-generated method stub
		this.deletById(Query.class, queryId);
	}

	/* (non-Javadoc)
	 * @see com.yrw.idao.IQueryDao#modifyQuery(com.yrw.domains.Query)
	 */ 
	public void modifyQuery(Query query) {
		this.update(query);
	}
}
