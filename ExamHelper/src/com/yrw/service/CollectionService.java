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

	/**
	 * ����ͳ��Collectionҳ��
	 * @return
	 */
	public int  getSCollectionListPageCount() {
		return iScollectionDao.getPageCount();
	}

	/**
	 * ����ҳ�뷵��list
	 * @return
	 */
	public List<Scollection> getSCollectionListByPageNow(int pageNow){
		return iScollectionDao.getScollections(pageNow);
	}
	/**ͨ���������ͻ�÷���ͳ��collectionҳ��
	 * @param questionTypeId
	 * @return
	 */
	public int getSCollectionListPageCountByQuestionType(int questionTypeId){
		return iScollectionDao.getPageCountByQuestionType(questionTypeId);
	}
	/**����ҳ�뼰�������ͷ���List
	 * @param pageNow
	 * @param questionTypeId
	 * @return
	 */
	public List<Scollection> getSCollectionListByQuestionType(int pageNow,int questionTypeId){
		return iScollectionDao.getScollectionsByQuestionType(questionTypeId, pageNow);
	}
	
	/**�����½ڷ����ղ�ͳ�Ƶ�ҳ��
	 * @param sectionId
	 * @return
	 */
	public int getSCollectionListPageCountBySection(int sectionId){
		return iScollectionDao.getPageCountBySectionId(sectionId);
	}
	/**�����½ڷ����ղ�ͳ�Ƶ��б�
	 * @param sectionId
	 * @param pageNow
	 * @return
	 */
	public List<Scollection> getScollectionListBySection(int sectionId,int pageNow){
		return iScollectionDao.getScollectionsBySectionId(sectionId, pageNow);
	}
	/**���ݿ�Ŀ�����ղ�ͳ�Ƶ�ҳ��
	 * @param subjectId
	 * @return
	 */
	public int getSCollectionListPageCountBySubject(int subjectId){
		return iScollectionDao.getPageCountBySubject(subjectId);
	}
	/**���ݿ�Ŀ��ҳ�����ղ�����б�
	 * @param subjectId
	 * @return
	 */
	public List<Scollection> getSCollectionListBySubject(int subjectId,int pageNow){
		return iScollectionDao.getScollectionBySubject(subjectId, pageNow);
	}
}
