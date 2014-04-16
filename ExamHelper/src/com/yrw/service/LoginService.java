package com.yrw.service;

import java.util.List;

import com.yrw.domains.Manager;
import com.yrw.domains.User;
import com.yrw.idao.IManagerDao;
import com.yrw.idao.ISubjectDao;
import com.yrw.idao.IUserDao;

public class LoginService {

	private IManagerDao iManagerDao;
	private ISubjectDao iSubjectDao;
	

	public void setiSubjectDao(ISubjectDao iSubjectDao) {
		this.iSubjectDao = iSubjectDao;
	}

	public void setiManagerDao(IManagerDao iManagerDao) {
		this.iManagerDao = iManagerDao;
	}

	public Manager checkManager(String name, String password) {

		List list = (List) iManagerDao.getManagerByNameAndPaw(name, password);
		try {
			if (list.size() == 1)
				return (Manager) list.get(0);
		} catch (Exception e) {
			return null;
		}

		return null;

	}

	
	public List loadSubjectName() {

		List list = iSubjectDao.getSubject();
		return list;
	}
}
