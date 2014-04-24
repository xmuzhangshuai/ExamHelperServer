package com.yrw.idao;

import java.util.List;

import com.yrw.domains.Snote;

public interface ISnoteDao extends IBasicDao{

	public void addSNote(Snote snote);
	public void deleteSNote(Snote snote);
	
	/**通过问题类型及问题id获得笔记统计的某个对象
	 * @param questionTypeId
	 * @param questionId
	 * @return
	 */
	public Snote getSnote(int questionTypeId,int questionId);
	/**通过章节id分页返回笔记统计
	 * @param sectionId
	 * @param pageNow
	 * @return
	 */
	public List<Snote> getSnotesBySectionId(int sectionId,int pageNow);
	/**通过章节id得到的笔记统计共有多少页
	 * @param sectionId
	 * @return
	 */
	public int getPageCountBySectionId(int sectionId);
	/**通过问题类型id分页返回笔记统计
	 * @param questionTypeId
	 * @param pageNow
	 * @return
	 */
	public List<Snote> getSnotesByQuestionTypeId(int questionTypeId,int pageNow);
	/**通过问题类型id返回的笔记统计总页数
	 * @param questionTypeId
	 * @return
	 */
	public int getPageCountByQuestionTypeId(int questionTypeId);
	/**分页返回笔记统计
	 * @param pageNow
	 * @return
	 */
	public List<Snote> getSnotes(int pageNow);
	/**笔记统计共有多少页 
	 * @return
	 */
	public int getPageCount();
	
}
