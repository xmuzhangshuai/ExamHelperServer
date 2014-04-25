package com.yrw.service;

import java.util.List;

import javax.swing.ListModel;

import com.yrw.domains.Collection;
import com.yrw.domains.Scollection;
import com.yrw.idao.ICollectionDao;
import com.yrw.idao.IScollectionDao;

/**
 * @author Administrator
 * 
 */
public class CollectionService {
	private ICollectionDao icollectionDao;
	private IScollectionDao iScollectionDao;

	public void setIcollectionDao(ICollectionDao icollectionDao) {
		this.icollectionDao = icollectionDao;
	}

	public void setiScollectionDao(IScollectionDao iScollectionDao) {
		this.iScollectionDao = iScollectionDao;
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
		return iScollectionDao.getPageCount();
	}

	/**
	 * 根据页码返回list
	 * @return
	 */
	public List<Scollection> getSCollectionListByPageNow(int pageNow){
		return iScollectionDao.getScollections(pageNow);
	}
	/**通过问题类型获得返回统计collection页码
	 * @param questionTypeId
	 * @return
	 */
	public int getSCollectionListPageCountByQuestionType(int questionTypeId){
		return iScollectionDao.getPageCountByQuestionType(questionTypeId);
	}
	/**根据页码及问题类型返回List
	 * @param pageNow
	 * @param questionTypeId
	 * @return
	 */
	public List<Scollection> getSCollectionListByQuestionType(int pageNow,int questionTypeId){
		return iScollectionDao.getScollectionsByQuestionType(questionTypeId, pageNow);
	}
	
	/**根据章节返回收藏统计的页码
	 * @param sectionId
	 * @return
	 */
	public int getSCollectionListPageCountBySection(int sectionId){
		return iScollectionDao.getPageCountBySectionId(sectionId);
	}
	/**根据章节返回收藏统计的列表
	 * @param sectionId
	 * @param pageNow
	 * @return
	 */
	public List<Scollection> getScollectionListBySection(int sectionId,int pageNow){
		return iScollectionDao.getScollectionsBySectionId(sectionId, pageNow);
	}
	/**根据科目返回收藏统计的页数
	 * @param subjectId
	 * @return
	 */
	public int getSCollectionListPageCountBySubject(int subjectId){
		return iScollectionDao.getPageCountBySubject(subjectId);
	}
	/**根据科目分页返回收藏情况列表
	 * @param subjectId
	 * @return
	 */
	public List<Scollection> getSCollectionListBySubject(int subjectId,int pageNow){
		return iScollectionDao.getScollectionBySubject(subjectId, pageNow);
	}
}
