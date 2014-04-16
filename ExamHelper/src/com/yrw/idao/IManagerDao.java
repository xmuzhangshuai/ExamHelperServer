package com.yrw.idao;

import java.util.List;

import com.yrw.domains.Manager;
import com.yrw.domains.User;
/**   
 *    
 * 项目名称：ExamHelper   
 * 类名称：ManagerInter 
 * 类描述： 针对管理员的操作的接口
 * 创建人：叶睿雯呢    
 * 创建时间：2014-03-15 
 * 修改人：     
 * 修改时间： 
 * 修改备注：   
 * @version    
 *    
 */ 
public interface IManagerDao extends IBasicDao{
	/**验证管理员
	 * @param Manager
	 * @return 
	 */
	public List getManagerByNameAndPaw(String name,String password) ;

}
