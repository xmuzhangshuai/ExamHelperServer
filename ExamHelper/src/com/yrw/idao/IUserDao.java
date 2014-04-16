package com.yrw.idao;

import com.yrw.domains.User;

/**����û�����Ĳ���
 * @author Administrator
 *
 */
public interface IUserDao extends IBasicDao {

	/**
	 * ͨ������������ȡuser����
	 * 
	 * @param mail
	 * @param password
	 * @return
	 */
	public User getUserByMailAndPsw(String mail, String password);

	/**ͨ�������ȡuser����
	 * @param mail
	 * @return
	 */
	public User getUserByMail(String mail);
	/**
	 * �����û�
	 * 
	 * @param user
	 * @return boolean
	 */
	public void addUser(User user);

	/**�޸��û���Ϣ
	 * @param user
	 * @return
	 */
	public void modifyUser(User user);
	
	/**
	 * ͨ���û�ID�����û�����
	 * @author ��˧
	 * @param key
	 * @return
	 */
	public User getUserById(int key);
}
