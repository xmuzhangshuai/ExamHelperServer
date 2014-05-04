package com.yrw.idao;

import java.util.List;

import org.hibernate.Session;

/**   
 *    
 * 项目名称：ExamHelper   
 * 类名称：BasicServiceInter 
 * 类描述：  数据库基础操作的抽象类
 * 创建人：叶睿雯呢    
 * 创建时间：2014-03-15 
 * 修改人：     
 * 修改时间： 
 * 修改备注：   
 * @version    
 *    
 */ 
public interface IBasicDao {
	
	/**
	 * @param object
	 * @return
	 */
	public Object addReturnId(Object object);
	/**添加
	 * 通过对象添加
	 * @param Object
	 * @return 
	 */
	public void add(Object object);
	
	
	/**
	 * 删除
	 *根据ID删除对象
	 * @param class
	 * @param id
	 * @return  
	 */
	public void deletById(Class clazz,java.io.Serializable id);
	/**
	 * 删除多个对象
	 *根据ID删除对象
	 * @param sql
	 * @return void 
	 */
	public void deletAll(String sql);
		
	
	
	/**更新
	 *根据hql语句，执行更新操作
	 * @param hql语句
	 * @param 查找条件
	 * @return List
	 */
	public void executeUpdate(String hql,Object []parameters);
	
	
	/**更新
	 *执行对象更新操作
	 * @param Object对象
	 * @return null
	 */
	public void update(Object object);
	
	
	/**查询
	 * 通过ID查找
	 * @param Class
	 * @param id
	 * @return Object
	 */
	public Object findById(Class clazz,java.io.Serializable id);
	
	
	/**查询
	 * 通过hql语句进行复杂查询
	 * @param hql语句
	 * @param 查找条件
	 * @return List
	 */
	public List executeQuery(String hql,Object[]parameters);
	
	
	/**查找
	 *执行查找，返回唯一对象
	 * @param hql语句
	 * @param 查找条件
	 * @return Object
	 */
	public Object uniqueQuery(String hql,Object[]parameters);
	
	
	/**
	 * 页数查询
	 *根据条件查找，得到数据条数，根据每页显示数目，返回页数
	 * @param hql语句
	 * @param 查找条件
	 * @return 页数
	 */
	public int queryPageCount(String hql,Object[]parameters) ;
	
	
	/**分页查询
	 * 根据当前页码，返回该页需显示的数据
	 * @param hql语句
	 * @param 查找条件
	 * @param 当前页
	 * @return List
	 */
	public List executeQueryByPage(String hql,Object[]parameters,int pageNow);
	
	
	
}

