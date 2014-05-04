package com.yrw.idao;

import java.util.List;

import org.hibernate.Session;

/**   
 *    
 * ��Ŀ���ƣ�ExamHelper   
 * �����ƣ�BasicServiceInter 
 * ��������  ���ݿ���������ĳ�����
 * �����ˣ�Ҷ�����    
 * ����ʱ�䣺2014-03-15 
 * �޸��ˣ�     
 * �޸�ʱ�䣺 
 * �޸ı�ע��   
 * @version    
 *    
 */ 
public interface IBasicDao {
	
	/**
	 * @param object
	 * @return
	 */
	public Object addReturnId(Object object);
	/**���
	 * ͨ���������
	 * @param Object
	 * @return 
	 */
	public void add(Object object);
	
	
	/**
	 * ɾ��
	 *����IDɾ������
	 * @param class
	 * @param id
	 * @return  
	 */
	public void deletById(Class clazz,java.io.Serializable id);
	/**
	 * ɾ���������
	 *����IDɾ������
	 * @param sql
	 * @return void 
	 */
	public void deletAll(String sql);
		
	
	
	/**����
	 *����hql��䣬ִ�и��²���
	 * @param hql���
	 * @param ��������
	 * @return List
	 */
	public void executeUpdate(String hql,Object []parameters);
	
	
	/**����
	 *ִ�ж�����²���
	 * @param Object����
	 * @return null
	 */
	public void update(Object object);
	
	
	/**��ѯ
	 * ͨ��ID����
	 * @param Class
	 * @param id
	 * @return Object
	 */
	public Object findById(Class clazz,java.io.Serializable id);
	
	
	/**��ѯ
	 * ͨ��hql�����и��Ӳ�ѯ
	 * @param hql���
	 * @param ��������
	 * @return List
	 */
	public List executeQuery(String hql,Object[]parameters);
	
	
	/**����
	 *ִ�в��ң�����Ψһ����
	 * @param hql���
	 * @param ��������
	 * @return Object
	 */
	public Object uniqueQuery(String hql,Object[]parameters);
	
	
	/**
	 * ҳ����ѯ
	 *�����������ң��õ���������������ÿҳ��ʾ��Ŀ������ҳ��
	 * @param hql���
	 * @param ��������
	 * @return ҳ��
	 */
	public int queryPageCount(String hql,Object[]parameters) ;
	
	
	/**��ҳ��ѯ
	 * ���ݵ�ǰҳ�룬���ظ�ҳ����ʾ������
	 * @param hql���
	 * @param ��������
	 * @param ��ǰҳ
	 * @return List
	 */
	public List executeQueryByPage(String hql,Object[]parameters,int pageNow);
	
	
	
}

