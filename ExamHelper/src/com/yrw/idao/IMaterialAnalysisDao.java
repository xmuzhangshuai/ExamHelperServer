package com.yrw.idao;

import java.util.List;
import java.util.Set;

import com.yrw.domains.Materialanalysis;
import com.yrw.domains.Questionsofmaterial;

/**
 * 
 * 项目名称：ExamHelper 类名称：IMaterialAnalysisDao 类描述： 针对材料分析题的有关操作的接口类，继承了IBasicDao
 * 创建人：叶睿雯 创建时间：2014-03-15 修改人： 修改时间： 修改备注：
 * 
 * @version
 * 
 */
public interface IMaterialAnalysisDao extends IBasicDao {

	/**通过材料分析题题干得到材料分析题列表
	 * @param pageNow
	 * @param stem
	 * @return
	 */
	public List getMaterialAnalysisByStem(int pageNow,String stem);
	/**通过材料分析题题干得到的列表页数
	 * @param stem
	 * @return
	 */
	public int getPageCountByStem(String stem);
	/**根据科目得到分析题
	 * @param pageNow
	 * @param subjectId
	 * @return
	 */
	public List getMaterialAnalysisBySubject(int pageNow,int subjectId);
	/**通过科目得到的分析题页数
	 * @param subjectId
	 * @return
	 */
	public int getPageCountBySubject(int subjectId);
	/**
	 * Method getMaterialAnalysisBySection 根据章节得到材料分析题列表
	 * 
	 * @param sectionId
	 * @param pageNow
	 * @return List
	 */
	public List getMaterialAnalysisBySection(int pageNow, int sectionId);
	/**
	 * 根据章节获取共有多少页的materialAnalysis信息
	 * 
	 * @param sectionId
	 * @return pageCount
	 */
	public int getPageCountBySection(int sectionId);
	/**
	 * 显示MaterialAnalysis的具体信息
	 * 
	 * @param materialAnalysisId
	 * @return Materialanalysis
	 */
	public Materialanalysis showMaterialAnalysis(int materialAnalysisId);

	/**
	 * Method delMaterialAnalysis 添加材料分析题
	 * 
	 * @param materialanalysis
	 * @return void
	 */
	public void addMaterialAnalysis(Materialanalysis materialanalysis);

	/** 删除材料分析题
	 * @param object
	 */
	public void delMaterialAnalysis(Object object);
	/**删除材料分析题下的小题
	 * @param questionsOfMaterial
	 */
	public void delQuestionsofMaterial(Set<Questionsofmaterial> questionsOfMaterial);
	/**
	 * Method delMaterialAnalysises 删除多条材料分析题
	 * 
	 * @param materialAnalysises
	 * @return void
	 */
	public void delMaterialAnalysises(List<Materialanalysis> materialanalysises);
	/**
	 * Method updateMaterialAnalysis 修改材料分析题
	 * 
	 * @param materialAnalysis
	 * @return void
	 */
	public void updateMaterialAnalysis(Materialanalysis materialanalysis);

	
}
