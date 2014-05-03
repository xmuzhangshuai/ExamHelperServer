package com.yrw.idao;

import java.util.List;

import com.yrw.domains.Examsection;

/**
 * 
 * 项目名称：ExamHelper 类名称：IExamSectionDao 类描述： 针对试卷大题的有关操作的接口类，继承了IBasicDao 创建人：叶睿雯
 * 创建时间：2014-03-15 修改人： 修改时间： 修改备注：
 * 
 * @version
 * 
 */
public interface IExamSectionDao extends IBasicDao {
	/**
	 * Method getExamBySection 得到某张试卷大题类型
	 * 
	 * @param pageNow
	 * @param examId
	 * @return List
	 */
	public List getExamBySection(int examId, int pageNow);

	/**
	 * Method getPageCount 得到某张试卷大题类型列表页数
	 * 
	 * @param examId
	 * @return List
	 */
	public List getPageCount(int examId);

	/**得到examSection对象
	 * @param examSectioId
	 * @return
	 */
	public Examsection showExamsection(int examSectioId);
	/**
	 * Method addExamSection 增加试卷大题
	 * 
	 * @param examSection
	 * @return void
	 */
	public void addExamSection(Examsection examSection);

	/**
	 * Method delExamSection 减少试卷大题
	 * 
	 * @param examSection
	 * @return void
	 */
	public void delExamSection(Examsection examsection);
	/**
	 * Method modifyExamSection 修改试卷大题
	 * 
	 * @param examsection
	 * @return void
	 */
	public void modifyExamSection(Examsection examsection);
	
	/**获得某个试卷章节以外的同一试卷章节
	 * @param examId
	 * @param examSectionId
	 * @return
	 */
	public List<Examsection> getExamsectionsByExamIdAndExamSectionId(int examId,int examSectionId);
}
