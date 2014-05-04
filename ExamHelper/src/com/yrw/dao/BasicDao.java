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
 * 项目名称：ExamHelper 类名称：BaseService 类描述： 对数据库操作的基本操作实现类 创建人：叶睿雯 创建时间：2014-3-15
 * 上午10:16:11 修改备注：
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
	 *            通过applicationContext中的sessionFactory注入
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	 * 添加 通过对象添加
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
	 * 删除 根据ID删除对象
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
			System.out.println("没有对应ID，无法删除。");
		}

	}

	/**
	 * 删除多个对象 根据ID删除对象
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
			System.out.println("无法删除多个对象");
		}
	}

	/**
	 * 更新 根据hql语句，执行更新操作
	 * 
	 * @param hql语句
	 * @param 查找条件
	 * @return List
	 */
	@Override
	public void executeUpdate(String hql, Object[] parameters) {
		// TODO Auto-generated method stub

		Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
		query.executeUpdate();
	}

	/**
	 * 更新 执行对象更新操作
	 * 
	 * @param Object对象
	 * @return null
	 */
	public void update(Object objcet) {
		// TODO Auto-generated method stub
		try {
			this.sessionFactory.getCurrentSession().update(objcet);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("无法更新");
		}
	}

	/**
	 * 查询 通过ID查找
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
			System.out.println("无法找到该Id所对应对象");
		}

		return object;
	}

	/**
	 * 查询 通过hql语句进行复杂查询
	 * 
	 * @param hql语句
	 * @param 查找条件
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
	 * 查找 执行查找，返回唯一对象
	 * 
	 * @param hql语句
	 * @param 查找条件
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
			System.out.println("无法得到唯一对象");
		}

		return object;
	}

	/**
	 * 分页查询 根据当前页码，返回该页需显示的数据
	 * 
	 * @param hql语句
	 * @param 查找条件
	 * @param 当前页
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
	 * 页数查询 根据条件查找，得到数据条数，根据每页显示数目，返回页数
	 * 
	 * @param hql语句
	 * @param 查找条件
	 * @return 页数
	 */
	public int queryPageCount(String hql, Object[] parameters) {

		Object rowCount = this.uniqueQuery(hql, parameters);
		int pageCount = Integer.parseInt(rowCount.toString());
		return (pageCount - 1) / DefaultValue.PAGE_SIZE + 1;

	}

}
