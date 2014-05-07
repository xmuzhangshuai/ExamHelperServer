package com.yrw.dao;

import java.util.List;

import com.yrw.domains.User;
import com.yrw.idao.IUserDao;

public class UserDao extends BasicDao implements IUserDao {

	@Override
	public User getUserByMailAndPsw(String mail, String password) {
		// TODO Auto-generated method stub
		String hql = "from User where mail=\'" + mail + "\' and password=\'" + password + "\'";
		User user = (User) this.uniqueQuery(hql, null);
		return user;
	}

	@Override
	public User getUserByMail(String mail) {
		String hql = "from User where mail=\'" + mail + "\'";
		User user = (User) this.uniqueQuery(hql, null);
		return user;
	}

	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		this.add(user);
	}

	@Override
	public void modifyUser(User user) {
		// TODO Auto-generated method stub
		this.update(user);
	}

	@Override
	public User getUserById(int key) {
		// TODO Auto-generated method stub
		return (User) this.findById(User.class, key);
	}

	@Override
	public List<User> getUserList() {
		// TODO Auto-generated method stub
		String hql = "from User order by id desc";
		return this.executeQuery(hql, null);
	}

	@Override
	public int getPageCountOfUser() {
		// TODO Auto-generated method stub
		String hql = "select count(*) from User";
		return this.queryPageCount(hql, null);
	}

	@Override
	public List<User> getUserListByPage(int pageNow) {
		// TODO Auto-generated method stub
		String hql = "from User order by id desc";
		return this.executeQueryByPage(hql, null, pageNow);
	}

	@Override
	public List<User> getUserListByName(String name) {
		// TODO Auto-generated method stub
		String hql = "from User where nickname like\'%" + name  + "%\'";
		return this.executeQuery(hql, null);
	}

}
