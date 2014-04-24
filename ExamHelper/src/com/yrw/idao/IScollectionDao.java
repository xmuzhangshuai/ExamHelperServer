package com.yrw.idao;

import java.util.List;

import com.yrw.domains.Scollection;

public interface IScollectionDao extends IBasicDao {

	public void addScollection(Scollection scollection);
	public void deleteScollection(Scollection scollection);
	/**ͨ����Ŀ����Id���Լ���ĿId�õ�����Ŀ
	 * @param questionTypeId
	 * @param questionId
	 * @return
	 */
	public Scollection getScollection(int questionTypeId,int questionId);
	/**��ҳ����ͨ���½�id���ҵ����ղ����
	 * @param sectionId
	 * @param pageNow
	 * @return
	 */
	public List<Scollection> getScollectionsBySectionId(int sectionId,int pageNow);
	/**ͨ���½�id����ղ��������ҳ��
	 * @param sectionId
	 * @return
	 */
	public int getPageCountBySectionId(int sectionId);
	
	/**��ҳ����ͨ����������Id���ҵ����ղ����
	 * @param questionType
	 * @param pageNow
	 * @return
	 */
	public List<Scollection> getScollectionsByQuestionType(int questionTypeId,int pageNow);
	
	/**ͨ����������Id���ҵ����ղ�������м�ҳ
	 * @param questionType
	 * @return
	 */
	public int getPageCountByQuestionType(int questionType);
	
	/**��ҳ�����ղ����
	 * @param pageNow
	 * @return
	 */
	public List<Scollection> getScollections(int pageNow);
	/**�ղ��������ҳ��

	 * @return
	 */
	public int getPageCount();
	
}
