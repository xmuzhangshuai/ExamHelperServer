package com.yrw.idao;

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
}
