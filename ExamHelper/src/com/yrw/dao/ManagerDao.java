package com.yrw.dao;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;

import com.yrw.domains.Manager;
import com.yrw.idao.IManagerDao;


/**   
 *    
 * ��Ŀ���ƣ�ExamHelper   
 * �����ƣ�ManagerService 
 * ��������  ��Թ���Ա����Ĳ������ϣ���ManagerInter��ʵ���࣬�Ҽ̳���BasicService�����������ࣩ
 * �����ˣ�Ҷ���   
 * ����ʱ�䣺2014-03-15   
 * �޸��ˣ�    
 * �޸�ʱ�䣺  
 * �޸ı�ע��   
 * @version    
 *    
 */ 


public class ManagerDao extends BasicDao implements IManagerDao {

	 
	/**��֤����Ա��½
	 * @param name
	 * @param password
	 * @return
	 */
	public List getManagerByNameAndPaw(String name,String password) {
		// TODO Auto-generated method stub
		String hql="from Manager where name=\'"+name+"\' and password=\'"+password+"\'";
		return this.executeQuery(hql, null);
	}
		
		
}
