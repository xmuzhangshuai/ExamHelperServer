/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.yrw.web.forms;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

/** 
 * MyEclipse Struts
 * Creation date: 04-09-2014
 * 
 * XDoclet definition:
 * @struts.form name="sectionForm"
 */
public class SectionForm extends ActionForm {
	/*
	 * Generated fields
	 */

	/** subjectName property */
	private String subjectName;

	/** sectionName property */
	private String sectionName;

	/*
	 * Generated Methods
	 */

	/** 
	 * Method validate
	 * @param mapping
	 * @param request
	 * @return ActionErrors
	 */
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	/** 
	 * Method reset
	 * @param mapping
	 * @param request
	 */
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		// TODO Auto-generated method stub
	}

	/** 
	 * Returns the subjectName.
	 * @return String
	 */
	public String getSubjectName() {
		return subjectName;
	}

	/** 
	 * Set the subjectName.
	 * @param subjectName The subjectName to set
	 */
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	/** 
	 * Returns the sectionName.
	 * @return String
	 */
	public String getSectionName() {
		return sectionName;
	}

	/** 
	 * Set the sectionName.
	 * @param sectionName The sectionName to set
	 */
	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}
}