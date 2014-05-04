package com.yrw.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import com.yrw.config.DefaultValue;
import com.yrw.idao.IBasicDao;

/**
 * 
 * ��Ŀ���ƣ�ExamHelper �����ƣ�BaseService �������� �����ݿ�����Ļ�������ʵ���� �����ˣ�Ҷ��� ����ʱ�䣺2014-3-15
 * ����10:16:11 �޸ı�ע��
 * 
 * @version
 * 
 */
@Transactional
public abstract class BasicDao implements IBasicDao {

	@Resource
	private SessionFactory sessionFactory;

	/**
	 * @param sessionFactory
	 *            ͨ��applicationContext�е�sessionFactoryע��
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	 * ��� ͨ���������
	 * 
	 * @param Object
	 * @return
	 */
	@Override
	public void add(Object object) {
		// TODO Auto-generated method stub	
		this.sessionFactory.getCurrentSession().save(object);
	}

	
	public Object addReturnId(Object object){
		return this.sessionFactory.getCurrentSession().save(object);
	}
	/**
	 * ɾ�� ����IDɾ������
	 * 
	 * @param class
	 * @param id
	 * @return
	 */
	public void deletById(Class clazz, java.io.Serializable id) {

		Session session = this.sessionFactory.getCurrentSession();
		try {
			Object object = this.findById(clazz, id);
			session.delete(object);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("û�ж�ӦID���޷�ɾ����");
		}

	}

	/**
	 * ɾ��������� ����IDɾ������
	 * 
	 * @param sql
	 * @return id
	 */
	public void deletAll(String sql) {

		DataSource ds = (DataSource) new ClassPathXmlApplicationContext(
				"applicationContext.xml").getBean("dataSource");
		PreparedStatement stmt = null;
		try {
			Connection connection = ds.getConnection();
			stmt = connection.prepareStatement(sql);
			stmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("�޷�ɾ���������");
		}
	}

	/**
	 * ���� ����hql��䣬ִ�и��²���
	 * 
	 * @param hql���
	 * @param ��������
	 * @return List
	 */
	@Override
	public void executeUpdate(String hql, Object[] parameters) {
		// TODO Auto-generated method stub

		Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
		query.executeUpdate();
	}

	/**
	 * ���� ִ�ж�����²���
	 * 
	 * @param Object����
	 * @return null
	 */
	public void update(Object objcet) {
		// TODO Auto-generated method stub
		try {
			this.sessionFactory.getCurrentSession().update(objcet);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("�޷�����");
		}
	}

	/**
	 * ��ѯ ͨ��ID����
	 * 
	 * @param Class
	 * @param id
	 * @return Object
	 */
	@Override
	public Object findById(Class clazz, Serializable id) {
		// TODO Auto-generated method stub
		Object object = null;
		try {
			object = this.sessionFactory.getCurrentSession().get(clazz, id);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("�޷��ҵ���Id����Ӧ����");
		}

		return object;
	}

	/**
	 * ��ѯ ͨ��hql�����и��Ӳ�ѯ
	 * 
	 * @param hql���
	 * @param ��������
	 * @return List
	 */
	@Override
	public List executeQuery(String hql, Object[] parameters) {
		// TODO Auto-generated method stub
		Query query = this.sessionFactory.getCurrentSession().createQuery(hql);

		if (parameters != null && parameters.length > 0)
			for (int i = 0; i < parameters.length; i++) {

				query.setString(i, (String) parameters[i]);

			}
		List list = query.list();
		if (list.size() != 0)
			return list;
		else
			return null;
	}

	/**
	 * ���� ִ�в��ң�����Ψһ����
	 * 
	 * @param hql���
	 * @param ��������
	 * @return Object
	 */
	public Object uniqueQuery(String hql, Object[] parameters) {

		Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
		if (parameters != null && parameters.length >= 0)
			for (int i = 0; i < parameters.length; i++)
				query.setString(i, (String) parameters[i]);
		Object object = null;
		try {
			object = query.uniqueResult();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("�޷��õ�Ψһ����");
		}

		return object;
	}

	/**
	 * ��ҳ��ѯ ���ݵ�ǰҳ�룬���ظ�ҳ����ʾ������
	 * 
	 * @param hql���
	 * @param ��������
	 * @param ��ǰҳ
	 * @return List
	 */
	@Override
	public List executeQueryByPage(String hql, Object[] parameters, int pageNow) {
		// TODO Auto-generated method stub
		Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
		if (parameters != null && parameters.length > 0)
			for (int i = 0; i < parameters.length; i++)
				query.setString(i, (String) parameters[i]);
		query.setFirstResult((pageNow - 1) * DefaultValue.PAGE_SIZE);
		query.setMaxResults(DefaultValue.PAGE_SIZE);
		List list = query.list();

		if (list.size() != 0) {
		
			return list;
		} else
			return null;
	}

	/**
	 * ҳ����ѯ �����������ң��õ���������������ÿҳ��ʾ��Ŀ������ҳ��
	 * 
	 * @param hql���
	 * @param ��������
	 * @return ҳ��
	 */
	public int queryPageCount(String hql, Object[] parameters) {

		Object rowCount = this.uniqueQuery(hql, parameters);
		int pageCount = Integer.parseInt(rowCount.toString());
		return (pageCount - 1) / DefaultValue.PAGE_SIZE + 1;

	}

}
