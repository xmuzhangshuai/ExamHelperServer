package com.yrw.idao;

import java.util.List;

import com.yrw.domains.Examguide;
import com.yrw.domains.Examguidetype;

public interface iExamGuideDao extends IBasicDao {

	/**��ÿ���ָ��
	 * @return
	 */
	public List<Examguide> getExamguidesByExamguideTypeId(int examGuideTypeId);
	/**��ÿ���ָ�����
	 * @return
	 */
	public List<Examguidetype> getExamguidetypesBySubjectId(int subjectId);
	
	/**ͨ������ָ��id��ÿ���ָ�϶���
	 * @param examGuideId
	 * @return
	 */
	public Examguide getExamguideById(int examGuideId);
	/**ͨ��id�Ż�ÿ���ָ�����
	 * @param examGuideTypeId
	 * @return
	 */
	public Examguidetype getExamguidetypeById(int examGuideTypeId);
	
	
	/**���ӿ���ָ��
	 * @param examguide
	 */
	public void addExamguide(Examguide examguide);
	/**���ӿ���ָ�����
	 * @param examguidetype
	 */
	public void addExamguidetype(Examguidetype examguidetype);
	
	/**���¿���ָ��
	 * @param examguide
	 */
	public void editExamguide(Examguide examguide);
	/**���¿���ָ�����
	 * @param examguide
	 */
	public void editExamguideType(Examguidetype examguidetype);
	
	/**ɾ��examGuide����
	 * @param examguideId
	 */
	public void deletExamguide(int  examguideId);
	/**ɾ������ָ�����
	 * @param examguidetypeId
	 */
	public void deletExamguideType(int examguidetypeId);
	
	
}