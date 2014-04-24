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
	 * ���ݿ�ĿID���ؿ���ָ���б�
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
	 * ���ݿ���ָ������ID���������б�
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
	 * ���ؿ���ָ������ҳ��
	 * 
	 * @return
	 */
	public int getExamGuidePageCount() {
		return iExamGuideDao.getPageCount();
	}
	
	/**
	 * ���ؿ���ָ������ҳ��
	 * 
	 * @return
	 */
	public int getExamGuidePageCount(int typeID) {
		return iExamGuideDao.getPageCount(typeID);
	}
	
	
	/**
	 * ���ؿ���ָ��Ŀ¼ҳ��
	 * @return
	 */
	public int getExamGuideTypePageCount(){
		return iExamGuideDao.getTypePageCount();
	}

	/**
	 * ����ҳ�뷵���б�
	 */
	public List<Examguide> getExamguideListByPage(int pageNow){
		return iExamGuideDao.getExamguideListByPage(pageNow);
	}
	
	/**
	 * ����ҳ�������
	 */
	public List<Examguide> getExamguideListByPage(int pageNow,int typeID){
		return iExamGuideDao.getExamguideListByPage(pageNow, typeID);
	}
	
	/**
	 * ����ҳ�뷵���б�
	 */
	public List<Examguidetype> getExamguideTypeListByPage(int pageNow){
		return iExamGuideDao.getExamguidetypeListByPage(pageNow);
	}
	
	/**
	 * ��ӿ���ָ��Ŀ¼
	 */
	public void addExamType(int subjectID,String name){
		Subject subject = iSubjectDao.getSubjectById(subjectID);
		Examguidetype examguidetype = new Examguidetype(subject, name, null);
		iExamGuideDao.addExamguidetype(examguidetype);
	}
	
	/**
	 * ��ӿ���ָ��
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
