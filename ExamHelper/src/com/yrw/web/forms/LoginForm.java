/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.yrw.web.forms;

import org.apache.struts.action.ActionForm;

/**   
 *    
 * 项目名称：ExamHelper   
 * 类名称：LoginForm   
 * 类描述：  管理员登陆验证时提交的表单
 * 创建人：叶睿雯    
 * 创建时间：2014-3-15   
 * 修改人：     
 * 修改时间：   
 * 修改备注：   
 * @version    
 *    
 */ 
public class LoginForm extends ActionForm {
	/*
	 * Generated fields
	 */

	/** name property */
	private String name;

	/** password property */
	private String password;


	
	/** 
	 * Returns the name.
	 * @return String
	 */
	public String getName() {
		return name;
	}

	/** 
	 * Set the name.
	 * @param name The name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/** 
	 * Returns the password.
	 * @return String
	 */
	public String getPassword() {
		return password;
	}

	/** 
	 * Set the password.
	 * @param password The password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
}