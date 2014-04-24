package com.yrw.service;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.jsonobjects.JExamGuide;
import com.jsonobjects.JExamGuideType;
import com.yrw.domains.Examguide;
import com.yrw.domains.Examguidetype;
import com.yrw.domains.Subject;
import com.yrw.idao.IExamGuideDao;
import com.yrw.idao.ISubjectDao;

public class ExamGuideService {

	private IExamGuideDao iExamGuideDao;
	private ISubjectDao iSubjectDao;

	public void setiExamGuideDao(IExamGuideDao iExamGuideDao) {
		this.iExamGuideDao = iExamGuideDao;
	}
	
	public void setiSubjectDao(ISubjectDao iSubjectDao) {
		this.iSubjectDao = iSubjectDao;
	}

	public ExamGuideService() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 根据科目ID返回考试指南列表
	 * 
	 * @param subjectID
	 * @return
	 */
	public List<JExamGuideType> getExamGuideTypeListBySubjectId(int subjectID) {
		List<Examguidetype> examguidetypes = iExamGuideDao.getExamguidetypesBySubjectId(subjectID);
		List<JExamGuideType> jExamGuideTypes = new ArrayList<JExamGuideType>();
		if (examguidetypes != null) {
			for (Examguidetype examguidetype : examguidetypes) {
				jExamGuideTypes.add(JExamGuideType.LocalToNet(examguidetype));
			}
		}
		return jExamGuideTypes;
	}

	/**
	 * 根据考试指南类型ID返回文章列表
	 * 
	 * @param examGuideTypeId
	 * @return
	 */
	public List<JExamGuide> getExamGuideListByTypeId(int examGuideTypeId) {
		List<Examguide> examguides = iExamGuideDao.getExamguidesByExamguideTypeId(examGuideTypeId);
		List<JExamGuide> jExamGuides = new ArrayList<JExamGuide>();
		if (examguides != null) {
			for (Examguide examguide : examguides) {
				jExamGuides.add(JExamGuide.LocalToNet(examguide));
			}
		}

		return jExamGuides;
	}

	/**
	 * 返回考试指南文章页码
	 * 
	 * @return
	 */
	public int getExamGuidePageCount() {
		return iExamGuideDao.getPageCount();
	}
	
	/**
	 * 返回考试指南文章页码
	 * 
	 * @return
	 */
	public int getExamGuidePageCount(int typeID) {
		return iExamGuideDao.getPageCount(typeID);
	}
	
	
	/**
	 * 返回考试指南目录页码
	 * @return
	 */
	public int getExamGuideTypePageCount(){
		return iExamGuideDao.getTypePageCount();
	}

	/**
	 * 根据页码返回列表
	 */
	public List<Examguide> getExamguideListByPage(int pageNow){
		return iExamGuideDao.getExamguideListByPage(pageNow);
	}
	
	/**
	 * 根据页码和类型
	 */
	public List<Examguide> getExamguideListByPage(int pageNow,int typeID){
		return iExamGuideDao.getExamguideListByPage(pageNow, typeID);
	}
	
	/**
	 * 根据页码返回列表
	 */
	public List<Examguidetype> getExamguideTypeListByPage(int pageNow){
		return iExamGuideDao.getExamguidetypeListByPage(pageNow);
	}
	
	/**
	 * 添加考试指南目录
	 */
	public void addExamType(int subjectID,String name){
		Subject subject = iSubjectDao.getSubjectById(subjectID);
		Examguidetype examguidetype = new Examguidetype(subject, name, null);
		iExamGuideDao.addExamguidetype(examguidetype);
	}
	
	/**
	 * 添加考试指南
	 * 
	 * @param typeID
	 * @param title
	 * @param url
	 * @param date
	 */
	public void addExamGuide(int typeID, String title, String url, String strDate) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = sdf.parse(strDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Examguidetype examguidetype = iExamGuideDao.getExamguidetypeById(typeID);
		Examguide examguide = new Examguide(examguidetype, title, url, new Timestamp(date.getTime()));
		iExamGuideDao.addExamguide(examguide);
	}
}
