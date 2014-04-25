package com.yrw.idao;

import java.util.List;

import com.yrw.domains.Collection;
import com.yrw.domains.Scollection;

import net.sf.cglib.transform.impl.AddDelegateTransformer;

/**
 * 
 * ��Ŀ���ƣ�ExamHelper �����ƣ�ICollectionDao �������� ����ղص��йز����Ľӿ��࣬�̳���IBasicDao �����ˣ�Ҷ���
 * ����ʱ�䣺2014-03-15 �޸��ˣ� �޸�ʱ�䣺 �޸ı�ע��
 * 
 * @version
 * 
 */

public interface ICollectionDao extends IBasicDao {

	/**
	 * Method getCollectionByUser �õ�ĳλ�û��ղ���Ϣ
	 * 
	 * @param userId
	 * @param pageNow
	 * @return List
	 */
	public List getCollectionByUser(int userId, int pageNow);

	/**
	 * �����û�ID���رʼ��б�
	 * @param userId
	 * @return
	 */
	public List<Collection> getCollectionByUser(int userId);

	/**
	 * Method getPageCountByUser �õ�ĳλ�û��ղ���Ϣҳ��
	 * 
	 * @param userId
	 * @param pageNow
	 * @return List
	 */
	public int getPageCountByUser(int userId);

	/**
	 * Method addCollection �����ղ���Ϣ
	 * 
	 * @param JCollection
	 * @return void
	 */
	public void addCollection(Collection collection);

	/**
	 * Method delCollection ɾ���ղ���Ϣ
	 * 
	 * @param JCollection
	 * @return void
	 */
	public void delCollection(Collection collection);

	public List<Collection> getCollectionList();
	
	public int getSCollectionListPageCount();
	
	public List<Scollection> getScollectionListByPage(int pageNow);
}
