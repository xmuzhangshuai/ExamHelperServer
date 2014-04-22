package com.yrw.service;

import java.util.ArrayList;
import java.util.List;

import com.yrw.domains.User;
import com.yrw.idao.IUserDao;

public class UserService {
	private IUserDao iUserDao;

	public void setiUserDao(IUserDao iUserDao) {
		this.iUserDao = iUserDao;
	}

	/**
	 * 用户登录确认
	 * 
	 * @param userMail
	 * @param password
	 * @return User
	 */
	public User checkUser(String userMail, String password) {

		User user = iUserDao.getUserByMailAndPsw(userMail, password);
		try {
			if (user == null)
				return null;
			else
				return user;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

	public User addUser(User user) {
		iUserDao.add(user);
		User user2 = (User) iUserDao.getUserByMail(user.getMail());
		try {
			if (user2 != null)
				return user2;
			else
				return null;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
	
	/**
	 * 获取用户列表
	 * @return
	 */
	public List<User> getUserListByPage(int pageNow) {
		List<User> users = new ArrayList<User>();
		users = iUserDao.getUserListByPage(pageNow);
		return users;
	}
	
	public int getPageCount(){
		return iUserDao.getPageCountOfUser();
	}

	public void modifyUser(User user) {
		iUserDao.modifyUser(user);
	}

	public User getUserByKey(int key) {
		User user = iUserDao.getUserById(key);
		return user;
	}
}
