package com.yrw.idao;

import java.util.List;

import com.yrw.domains.Examguide;
import com.yrw.domains.Examguidetype;

public interface IExamGuideDao extends IBasicDao {

	/**获得考试指南
	 * @return
	 */
	public List<Examguide> getExamguidesByExamguideTypeId(int examGuideTypeId);
	/**获得考试指南类别
	 * @return
	 */
	public List<Examguidetype> getExamguidetypesBySubjectId(int subjectId);
	
	/**通过考试指南id获得考试指南对象
	 * @param examGuideId
	 * @return
	 */
	public Examguide getExamguideById(int examGuideId);
	/**通过id号获得考试指南类别
	 * @param examGuideTypeId
	 * @return
	 */
	public Examguidetype getExamguidetypeById(int examGuideTypeId);
	
	public int getPageCount();
	
	public int getPageCount(int typeID);
	
	public int getTypePageCount();
	
	public List<Examguide> getExamguideListByPage(int pageNow);
	
	public List<Examguide> getExamguideListByPage(int pageNow,int typeID);
	
	public List<Examguidetype> getExamguidetypeListByPage(int pageNow);
	
	/**增加考试指南
	 * @param examguide
	 */
	public void addExamguide(Examguide examguide);
	/**增加考试指南类别
	 * @param examguidetype
	 */
	public void addExamguidetype(Examguidetype examguidetype);
	
	/**更新考试指南
	 * @param examguide
	 */
	public void editExamguide(Examguide examguide);
	/**跟新考试指南类别
	 * @param examguide
	 */
	public void editExamguideType(Examguidetype examguidetype);
	
	/**删除examGuide对象
	 * @param examguideId
	 */
	public void deletExamguide(int  examguideId);
	/**删除考试指南类别
	 * @param examguidetypeId
	 */
	public void deletExamguideType(int examguidetypeId);
	
	
}
