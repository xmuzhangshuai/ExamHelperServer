package com.yrw.idao;

import java.util.List;

import com.yrw.domains.User;

/**针对用户对象的操作
 * @author Administrator
 *
 */
public interface IUserDao extends IBasicDao {

	/**
	 * 通过邮箱和密码获取user对象
	 * 
	 * @param mail
	 * @param password
	 * @return
	 */
	public User getUserByMailAndPsw(String mail, String password);

	/**
	 * 获取user页数
	 * @return
	 */
	public int getPageCountOfUser();
	
	/**
	 * 分页返回user列表
	 * @param pageNow
	 * @return
	 */
	public List<User> getUserListByPage(int pageNow);
	
	/**通过邮箱获取user对象
	 * @param mail
	 * @return
	 */
	public User getUserByMail(String mail);
	/**
	 * 新增用户
	 * 
	 * @param user
	 * @return boolean
	 */
	public void addUser(User user);
	
	/**
	 * 按ID倒叙返回User
	 * @return
	 */
	public List<User> getUserList();

	/**修改用户信息
	 * @param user
	 * @return
	 */
	public void modifyUser(User user);
	
	/**
	 * 通过用户ID返回用户内容
	 * @author 张帅
	 * @param key
	 * @return
	 */
	public User getUserById(int key);
	
	/**
	 * 根据名称返回用户列表
	 * @param name
	 * @return
	 */
	public List<User> getUserListByName(String name);
}
