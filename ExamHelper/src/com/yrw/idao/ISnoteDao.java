package com.yrw.idao;

import java.util.List;

import com.yrw.domains.Snote;

public interface ISnoteDao extends IBasicDao{

	public void addSNote(Snote snote);
	public void deleteSNote(Snote snote);
	
	/**ͨ���������ͼ�����id��ñʼ�ͳ�Ƶ�ĳ������
	 * @param questionTypeId
	 * @param questionId
	 * @return
	 */
	public Snote getSnote(int questionTypeId,int questionId);

	/**ͨ����������id��ҳ���رʼ�ͳ��
	 * @param questionTypeId
	 * @param pageNow
	 * @return
	 */
	public List<Snote> getSnotesByQuestionTypeId(int questionTypeId,int pageNow);
	/**ͨ����������id���صıʼ�ͳ����ҳ��
	 * @param questionTypeId
	 * @return
	 */
	public int getPageCountByQuestionTypeId(int questionTypeId);
	/**��ҳ���رʼ�ͳ��
	 * @param pageNow
	 * @return
	 */
	public List<Snote> getSnotes(int pageNow);
	/**�ʼ�ͳ�ƹ��ж���ҳ 
	 * @return
	 */
	public int getPageCount();
	
}