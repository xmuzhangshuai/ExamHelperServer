package com.yrw.dao;

import java.util.List;

import com.yrw.domains.Scollection;
import com.yrw.idao.IScollectionDao;

public class SCollectionDao extends BasicDao implements IScollectionDao {

	@Override
	public void addScollection(Scollection scollection) {
		// TODO Auto-generated method stub
		this.add(scollection);
	}

	@Override
	public void deleteScollection(Scollection scollection) {
		// TODO Auto-generated method stub
		this.deletById(Scollection.class, scollection.getId());
	}

	@Override
	public Scollection getScollection(int questionTypeId, int questionId) {
		// TODO Auto-generated method stub
		String hql = "from Scollection as s where s.questiontype.id="
				+ questionTypeId + " and s.questionId=" + questionId;
		return (Scollection) this.uniqueQuery(hql, null);
	}

	@Override
	public List<Scollection> getScollectionsBySectionId(int sectionId,
			int pageNow) {
		// TODO Auto-generated method stub
		String hql = "from Scollection as s where s.section.id=" + sectionId
				+ " order by s.collectionNum desc";
		return this.executeQueryByPage(hql, null, pageNow);
	}

	@Override
	public int getPageCountBySectionId(int sectionId) {
		// TODO Auto-generated method stub
		String hql = "select count(s) from Scollection as s where s.section.id="
				+ sectionId;
		return queryPageCount(hql, null);
	}

	@Override
	public List<Scollection> getScollectionsByQuestionType(int questionTypeId,
			int pageNow) {
		// TODO Auto-generated method stub
		String hql = "from Scollection as s where s.questiontype.id="
				+ questionTypeId + " order by s.collectionNum desc";
		return this.executeQueryByPage(hql, null, pageNow);
	}

	@Override
	public int getPageCountByQuestionType(int questionTypeId) {
		// TODO Auto-generated method stub
		String hql = "select count(s) from Scollection as s where s.questiontype.id="
				+ questionTypeId + " order by s.collectionNum desc";
		return this.queryPageCount(hql, null);
	}

	@Override
	public List<Scollection> getScollections(int pageNow) {
		// TODO Auto-generated method stub
		String hql="from Scollection as s order by s.collectionNum desc";
		return this.executeQueryByPage(hql, null, pageNow);
	}

	@Override
	public int getPageCount() {
		// TODO Auto-generated method stub
		String hql="select count(*) from Scollection";
		return this.queryPageCount(hql,null);
	}

}
