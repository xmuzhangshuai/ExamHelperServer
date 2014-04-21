package com.yrw.idao;

import java.util.List;

import com.yrw.domains.Questionsofmaterial;

import net.sf.cglib.transform.impl.AddDelegateTransformer;

/**
 * 
 * 项目名称：ExamHelper 类名称：IQuestionsOfMaterial 类描述： 针对多选题具体问题的有关操作的接口类，继承了IBasicDao 创建人：叶睿雯
 * 创建时间：2014-03-15 修改人： 修改时间： 修改备注：
 * 
 * @version
 * 
 */
public interface IQuestionsOfMaterial extends IBasicDao {

	
	/**通过小题题干得到材料题列表
	 * @param pageNow
	 * @param stem
	 * @return
	 */
	public List getQuestionofMaterialByStem(int pageNow,String stem);
	/**通过小题题干得到材料题列表的总页数
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
	
	/**得到某个materialAnalysis下的所有小题
	 * @param materialId
	 * @return
	 */
	public List getQuestionOfMaterialByMaterialId(int materialId);
	/**
	 * @param materialId
	 * @return
	 */
	public int getPageCountByMaterialId(int materialId);
	/**通过材料题的Id号获得该材料题下的小题的最大序号
	 * @param materiaAnalysisId
	 * @return
	 */
	public int getMaxQuestionNumByMaterialId(int materiaAnalysisId);
	
	/**显示分析题小题具体内容
	 * @param questionOfMaterial
	 * @return Questionofmaterial
	 */
	public Questionsofmaterial showQuestionOfMaterial(int questionOfMaterial);
	/**新添分析题小题
	 * @param questionOfMaterial
	 */
	public void addQuestionOfMaterial(Questionsofmaterial questionOfMaterial );
	/**删除分析题小题
	 * @param questionOfMaterial
	 */
	public void delQuestionOfMaterial(Object object );
	/**修改分析题小题
	 * @param questionOfMaterial
	 */
	public void updateQuestionOfMaterial(Questionsofmaterial questionOfMaterial );
}
