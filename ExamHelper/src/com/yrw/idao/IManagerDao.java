package com.yrw.idao;

import java.util.List;

import com.yrw.domains.Manager;
import com.yrw.domains.User;
/**   
 *    
 * ��Ŀ���ƣ�ExamHelper   
 * �����ƣ�ManagerInter 
 * �������� ��Թ���Ա�Ĳ����Ľӿ�
 * �����ˣ�Ҷ�����    
 * ����ʱ�䣺2014-03-15 
 * �޸��ˣ�     
 * �޸�ʱ�䣺 
 * �޸ı�ע��   
 * @version    
 *    
 */ 
public interface IManagerDao extends IBasicDao{
	/**��֤����Ա
	 * @param Manager
	 * @return 
	 */
	public List getManagerByNameAndPaw(String name,String password) ;

}
