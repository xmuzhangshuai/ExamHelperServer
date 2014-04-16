package com.yrw.dao;

import java.util.List;

import com.yrw.domains.Answerquery;
import com.yrw.idao.IAnswerQueryDao;

public class AnswerQueryDao extends BasicDao implements IAnswerQueryDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.yrw.idao.IAnswerQueryDao#getAnswerQuery(int)
	 */
	@Override
	public List getAnswerQuery(int pageNow) {
		// TODO Auto-generated method stub
		String hql = "from Answerquery order by answerTime desc";
		List list = this.executeQueryByPage(hql, null, pageNow);
		return list;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.yrw.idao.IAnswerQueryDao#getPageCount()
	 */
	@Override
	public int getPageCount() {
		// TODO Auto-generated method stub
		String hql = "select count(*) from Answerquery";
		int pageCount = this.queryPageCount(hql, null);
		return pageCount;
	}

	/* (non-Javadoc)
	 * @see com.yrw.idao.IAnswerQueryDao#getAnswerQueryByUserId(int, int)
	 */
	@Override
	public List getAnswerQueryByUserId(int pageNow, int userId) {
		// TODO Auto-generated method stub
		String hql= "select answerQuery from Answerquery answerQuery left join  answerQuery.user"
				+ " user where user.id="+ userId + " order by answerQuery.answerTime";
		List list = this.executeQueryByPage(hql, null, pageNow);
		return list;
	}

	/* (non-Javadoc)
	 * @see com.yrw.idao.IAnswerQueryDao#getPageCountByUserId(int)
	 */
	@Override
	public int getPageCountByUserId(int userId) {
		// TODO Auto-generated method stub
		String hql = "select count(answerQuery) from Answerquery answerQuery left join  answerQuery.user"
				+ " user where user.id="+ userId + " order by answerQuery.answerTime";
		int pageCount = this.queryPageCount(hql, null);
		return pageCount;
	}

	@Override
	public List getAnswerQueryByQueryId(int queryId, int pageNow) {
		// TODO Auto-generated method stub
		String hql = "select answerQuery from Answerquery answerQuery left join answerQuery.query query where query.id="
				+ queryId+" order by answerQuery.answerTime";
		List list = this.executeQueryByPage(hql, null, pageNow);
		return list;
	}

	/* (non-Javadoc)
	 * @see com.yrw.idao.IAnswerQueryDao#getPageCountByQueryId(int)
	 */
	@Override
	public int getPageCountByQueryId(int queryId) {
		// TODO Auto-generated method stub
		String hql = "select answerQuery from Answerquery answerQuery left join answerQuery.query query where query.id="
				+ queryId;
		int pageCount = this.queryPageCount(hql, null);
		return pageCount;
	}

	@Override
	public Answerquery showAnswerQuery(int answerQueryId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addAnswerQuery(Answerquery answerquery) {
		// TODO Auto-generated method stub
		this.add(answerquery);

	}

	@Override
	public void delAnswerQuery(int  answerqueryId) {
		// TODO Auto-generated method stub
		this.deletById(Answerquery.class, answerqueryId);
	}

	@Override
	public void delAnswerQuerys(List<Integer> answerqueryIds) {
		// TODO Auto-generated method stub
	
		String hql = "delete from Answerquery where id in (";
		for (int i = 0; i < answerqueryIds.size() - 1; i++)
			hql = hql + answerqueryIds.get(i) + ",";
		hql = hql + answerqueryIds.get(answerqueryIds.size() - 1) + ")";
		this.deletAll(hql);

	}

	@Override
	public void modifyAnswerQuery(Answerquery answerquery) {
		// TODO Auto-generated method stubt
		this.update(answerquery);
	}

}
