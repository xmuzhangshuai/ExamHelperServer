package com.yrw.idao;

import java.util.Date;
import java.util.List;

import com.yrw.domains.Query;

/**
 * 
 * ��Ŀ���ƣ�ExamHelper �����ƣ�IQueryDao �������� ������ʵ��йز����Ľӿ��࣬�̳���IBasicDao �����ˣ�Ҷ���
 * ����ʱ�䣺2014-03-15 �޸��ˣ� �޸�ʱ�䣺 �޸ı�ע��
 * 
 * @version
 * 
 */
/**
 * @author Administrator
 *
 */
/**
 * @author Administrator
 *
 */
public interface IQueryDao extends IBasicDao {

	/**
	 * Method getQuery �õ������б�
	 * 
	 * @param pageNow
	 * @return List
	 * 
	 */
	public List getQuery(int pageNow);

	

	/**
	 * Method getQueryByUser �õ�ĳλ�û��������б�
	 * 
	 * @param pageNow
	 * @param userId
	 * @return List
	 */
	public List getQueryByUser(int userId, int pageNow);

	/**
	 * Method getQueryByQueryStem ͨ��������ɵõ������б�
	 * 
	 * @param pageNow
	 * @param queryStem
	 * @return List
	 */
	public List getQueryByQueryStem(String queryStem, int pageNow);
	
	/**���ݲ��ô𰸵Ŀͻ�id��ȡ�����б�
	 * @param adoptUserId
	 * @param pageNow
	 * @return
	 */
	public List getQueryByAdoptUserId(int adoptUserId,int pageNow);

	
	/**���ݲ��ô𰸵Ŀͻ�id��ȡ�����⹲��ҳ��
	 * @param adoptUserId
	 * @return
	 */
	public int getPageCountByAdoptUserId(int adoptUserId);
	/**
	 * Method getPageCountByUser �����û�id��ȡ�����ʹ��ж���ҳ��
	 * 
	 * @param userId
	 * @return pageCount
	 */
	public int getPageCountByUser(int userId);

	/**
	 * Method getPageCountByQueryStem ������ɲ�ѯ�õ����ж���ҳ��query��Ϣ
	 * 
	 * @param String
	 *            questionStem
	 * @return pageCount
	 */
	public int getPageCountByQueryStem(String queryStem);

	

	/**
	 * Method getPageCount ���������б��ҳ��
	 * 
	 * 
	 * @return pageCount
	 */
	public int getPageCount();

	/**
	 * Method addQuery ����������Ϣ
	 * 
	 * @param query
	 */
	public void addQuery(Query query);

	/**
	 * Method addQuery ɾ��������Ϣ
	 * 
	 * @param queryId
	 * @return void
	 */
	public void delQuery(int queryId);
	
	/**�޸�����
	 * @param query
	 */
	public void modifyQuery(Query query);
	
	/**������ʾĳ������
	 * @param queryId
	 * @return
	 */
	public Query showQuery(int queryId);
	
	/**
	 * �����û��ǳƷ��������б�
	 * @return
	 */
	public List<Query> getQueryListByName(String name);
}
