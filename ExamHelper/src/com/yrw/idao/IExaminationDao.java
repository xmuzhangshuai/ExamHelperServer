package com.yrw.idao;

import java.util.List;

import com.yrw.domains.Examination;

/**
 * 
 * 项目名称：ExamHelper 类名称：IExaminationDao 类描述： 针对试卷的有关操作的接口类，继承了IBasicDao 创建人：叶睿雯
 * 创建时间：2014-03-15 修改人： 修改时间： 修改备注：
 * 
 * @version
 * 
 */
public interface IExaminationDao extends IBasicDao {

	/**
	 * Method getExam 得到试卷列表
	 * 
	 * @param pageNow
	 * @return exams
	 */
	public List getExam(int pageNow);

	/**
	 * Method getpageCount 所有试卷列表页数
	 * 
	 * @return pageCount
	 */
	public int getPageCount();

	/**
	 * Method getExamByName 通过名字查找到试卷
	 * 
	 * @param examName
	 * @param pageNow
	 * @return exams
	 */
	public List getExamByName(String examName, int pageNow);

	/**
	 * Method getPageCountByName
	 * 
	 * @param examName
	 * @return pageCount
	 */
	public int getPageCountByName(String examName);

	/**
	 * Method getExamBySubject 得到某个科目的所有试卷列表
	 * 
	 * @param pageNow
	 * @param subjectId
	 * @return exams
	 */
	public List getExamBySubject(int subjectId, int pageNow);

	/**
	 * Method getPageCountBySubject
	 * 
	 * @param subjectId
	 * @return pageCount
	 */
	public int getPageCountBySubject(int subjectId);

	/**
	 * Method addExam
	 * 
	 * @param examId
	 * @return List
	 */
	public List showExam(int examId);

	/**
	 * Method addExam
	 * 
	 * @param examination
	 */
	public void addExam(Examination examination);

	/**
	 * Method delExam
	 * 
	 * @param examination
	 */
	public void delExam(Examination examination);
	/**
	 * Method delExams
	 * 
	 * @param examination
	 */
	public void delExam(List<Examination> examinations);
	/**
	 * Method delExam
	 * 
	 * @param examination
	 */
	public void modifyExam(Examination examination);
	

}
