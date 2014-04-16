package com.yrw.dao;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;

import com.yrw.domains.Manager;
import com.yrw.idao.IManagerDao;


/**   
 *    
 * 项目名称：ExamHelper   
 * 类名称：ManagerService 
 * 类描述：  针对管理员对象的操作集合，是ManagerInter的实现类，且继承了BasicService（基础操作类）
 * 创建人：叶睿雯   
 * 创建时间：2014-03-15   
 * 修改人：    
 * 修改时间：  
 * 修改备注：   
 * @version    
 *    
 */ 


public class ManagerDao extends BasicDao implements IManagerDao {

	 
	/**验证管理员登陆
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
