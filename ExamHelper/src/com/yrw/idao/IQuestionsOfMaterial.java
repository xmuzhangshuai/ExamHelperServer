package com.yrw.idao;

import java.util.List;

import com.yrw.domains.Questionsofmaterial;

import net.sf.cglib.transform.impl.AddDelegateTransformer;

/**
 * 
 * ��Ŀ���ƣ�ExamHelper �����ƣ�IQuestionsOfMaterial �������� ��Զ�ѡ�����������йز����Ľӿ��࣬�̳���IBasicDao �����ˣ�Ҷ���
 * ����ʱ�䣺2014-03-15 �޸��ˣ� �޸�ʱ�䣺 �޸ı�ע��
 * 
 * @version
 * 
 */
public interface IQuestionsOfMaterial extends IBasicDao {

	
	/**ͨ��С����ɵõ��������б�
	 * @param pageNow
	 * @param stem
	 * @return
	 */
	public List getQuestionofMaterialByStem(int pageNow,String stem);
	/**ͨ��С����ɵõ��������б����ҳ��
	 * @param stem
	 * @return
	 */
	public int getPageCountByStem(String stem);
	/**
	 * @param pageNow
	 * @param materialId
	 * @return
	 */
	public List getQuestionOfMaterialByMaterialId(int pageNow,int materialId);
	
	/**�õ�ĳ��materialAnalysis�µ�����С��
	 * @param materialId
	 * @return
	 */
	public List getQuestionOfMaterialByMaterialId(int materialId);
	/**
	 * @param materialId
	 * @return
	 */
	public int getPageCountByMaterialId(int materialId);
	/**ͨ���������Id�Ż�øò������µ�С���������
	 * @param materiaAnalysisId
	 * @return
	 */
	public int getMaxQuestionNumByMaterialId(int materiaAnalysisId);
	
	/**��ʾ������С���������
	 * @param questionOfMaterial
	 * @return Questionofmaterial
	 */
	public Questionsofmaterial showQuestionOfMaterial(int questionOfMaterial);
	/**���������С��
	 * @param questionOfMaterial
	 */
	public void addQuestionOfMaterial(Questionsofmaterial questionOfMaterial );
	/**ɾ��������С��
	 * @param questionOfMaterial
	 */
	public void delQuestionOfMaterial(Object object );
	/**�޸ķ�����С��
	 * @param questionOfMaterial
	 */
	public void updateQuestionOfMaterial(Questionsofmaterial questionOfMaterial );
}
