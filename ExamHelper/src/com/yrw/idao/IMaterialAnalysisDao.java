package com.yrw.idao;

import java.util.List;
import java.util.Set;

import com.yrw.domains.Materialanalysis;
import com.yrw.domains.Questionsofmaterial;

/**
 * 
 * ��Ŀ���ƣ�ExamHelper �����ƣ�IMaterialAnalysisDao �������� ��Բ��Ϸ�������йز����Ľӿ��࣬�̳���IBasicDao
 * �����ˣ�Ҷ��� ����ʱ�䣺2014-03-15 �޸��ˣ� �޸�ʱ�䣺 �޸ı�ע��
 * 
 * @version
 * 
 */
public interface IMaterialAnalysisDao extends IBasicDao {

	/**ͨ�����Ϸ�������ɵõ����Ϸ������б�
	 * @param pageNow
	 * @param stem
	 * @return
	 */
	public List getMaterialAnalysisByStem(int pageNow,String stem);
	/**ͨ�����Ϸ�������ɵõ����б�ҳ��
	 * @param stem
	 * @return
	 */
	public int getPageCountByStem(String stem);
	/**���ݿ�Ŀ�õ�������
	 * @param pageNow
	 * @param subjectId
	 * @return
	 */
	public List getMaterialAnalysisBySubject(int pageNow,int subjectId);
	/**ͨ����Ŀ�õ��ķ�����ҳ��
	 * @param subjectId
	 * @return
	 */
	public int getPageCountBySubject(int subjectId);
	/**
	 * Method getMaterialAnalysisBySection �����½ڵõ����Ϸ������б�
	 * 
	 * @param sectionId
	 * @param pageNow
	 * @return List
	 */
	public List getMaterialAnalysisBySection(int pageNow, int sectionId);
	/**
	 * �����½ڻ�ȡ���ж���ҳ��materialAnalysis��Ϣ
	 * 
	 * @param sectionId
	 * @return pageCount
	 */
	public int getPageCountBySection(int sectionId);
	/**
	 * ��ʾMaterialAnalysis�ľ�����Ϣ
	 * 
	 * @param materialAnalysisId
	 * @return Materialanalysis
	 */
	public Materialanalysis showMaterialAnalysis(int materialAnalysisId);

	/**
	 * Method delMaterialAnalysis ��Ӳ��Ϸ�����
	 * 
	 * @param materialanalysis
	 * @return void
	 */
	public void addMaterialAnalysis(Materialanalysis materialanalysis);

	/** ɾ�����Ϸ�����
	 * @param object
	 */
	public void delMaterialAnalysis(Object object);
	/**ɾ�����Ϸ������µ�С��
	 * @param questionsOfMaterial
	 */
	public void delQuestionsofMaterial(Set<Questionsofmaterial> questionsOfMaterial);
	/**
	 * Method delMaterialAnalysises ɾ���������Ϸ�����
	 * 
	 * @param materialAnalysises
	 * @return void
	 */
	public void delMaterialAnalysises(List<Materialanalysis> materialanalysises);
	/**
	 * Method updateMaterialAnalysis �޸Ĳ��Ϸ�����
	 * 
	 * @param materialAnalysis
	 * @return void
	 */
	public void updateMaterialAnalysis(Materialanalysis materialanalysis);

	
}
