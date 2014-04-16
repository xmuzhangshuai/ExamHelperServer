package com.yrw.idao;

import java.util.List;

import com.yrw.domains.Studyrecord;

/**
 * 
 * 项目名称：ExamHelper 类名称：IStudyRecordDao 类描述： 针对学习记录的有关操作的接口类，继承了IBasicDao 创建人：叶睿雯
 * 创建时间：2014-03-15 修改人： 修改时间： 修改备注：
 * 
 * @version
 * 
 */
public interface IStudyRecordDao extends IBasicDao {

	/**
	 * @param pageNow
	 * @param userId
	 * @return
	 */
	public List getStudyRecordByUserId(int pageNow,int userId);
	/**
	 * @param userId
	 * @return
	 */
	public int getPageCountByUserId(int userId);
	
	/**
	 * @param studyRecordId
	 * @return
	 */
	public List showStudyRecord(int studyRecordId);
	/**
	 * @param studyrecord
	 */
	public void addStudyRecord(Studyrecord studyrecord);
	/**
	 * @param studyrecord
	 */
	public void delStudyRecord(Studyrecord studyrecord);
}
