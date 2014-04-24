package com.yrw.idao;

import java.util.List;

import com.yrw.domains.Scollection;

public interface IScollectionDao extends IBasicDao {

	public void addScollection(Scollection scollection);
	public void deleteScollection(Scollection scollection);
	/**通过题目类型Id，以及题目Id得到该题目
	 * @param questionTypeId
	 * @param questionId
	 * @return
	 */
	public Scollection getScollection(int questionTypeId,int questionId);
	/**分页返回通过章节id查找到的收藏情况
	 * @param sectionId
	 * @param pageNow
	 * @return
	 */
	public List<Scollection> getScollectionsBySectionId(int sectionId,int pageNow);
	/**通过章节id查的收藏情况的总页数
	 * @param sectionId
	 * @return
	 */
	public int getPageCountBySectionId(int sectionId);
	
	/**分页返回通过问题类型Id查找到的收藏情况
	 * @param questionType
	 * @param pageNow
	 * @return
	 */
	public List<Scollection> getScollectionsByQuestionType(int questionTypeId,int pageNow);
	
	/**通过问题类型Id查找到的收藏情况共有几页
	 * @param questionType
	 * @return
	 */
	public int getPageCountByQuestionType(int questionType);
	
	/**分页返回收藏情况
	 * @param pageNow
	 * @return
	 */
	public List<Scollection> getScollections(int pageNow);
	/**收藏情况共有页数

	 * @return
	 */
	public int getPageCount();
	
}
