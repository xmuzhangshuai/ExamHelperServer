package com.yrw.idao;

import java.util.List;

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

	/**
	 * ��ȡuserҳ��
	 * @return
	 */
	public int getPageCountOfUser();
	
	/**
	 * ��ҳ����user�б�
	 * @param pageNow
	 * @return
	 */
	public List<User> getUserListByPage(int pageNow);
	
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
	
	/**
	 * ��ID���𷵻�User
	 * @return
	 */
	public List<User> getUserList();

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
	
	/**
	 * �������Ʒ����û��б�
	 * @param name
	 * @return
	 */
	public List<User> getUserListByName(String name);
}
