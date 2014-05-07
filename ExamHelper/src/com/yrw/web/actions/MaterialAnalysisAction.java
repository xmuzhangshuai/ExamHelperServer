/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.yrw.web.actions;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.yrw.config.DefaultValue;
import com.yrw.domains.Materialanalysis;
import com.yrw.domains.Questionsofmaterial;
import com.yrw.domains.Questiontype;
import com.yrw.domains.Section;
import com.yrw.domains.Subject;
import com.yrw.service.QuestionService;
import com.yrw.service.SectionService;
import com.yrw.service.SubjectService;
import com.yrw.web.forms.MaterialAnalysisForm;

/**
 * MyEclipse Struts Creation date: 04-17-2014
 * 
 * XDoclet definition:
 * 
 * @struts.action
 */
public class MaterialAnalysisAction extends DispatchAction {
	private QuestionService questionService;
	private SectionService sectionService;
	private SubjectService subjectService;

	public void setQuestionService(QuestionService questionService) {
		this.questionService = questionService;
	}

	public void setSectionService(SectionService sectionService) {
		this.sectionService = sectionService;
	}

	public void setSubjectService(SubjectService subjectService) {
		this.subjectService = subjectService;
	}

	/**
	 * 加载sectionList
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
	public ActionForward loadSectionList(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {

		String subjectString = request.getParameter("subjectId");
		String questionTypeNameString = request
				.getParameter("questionTypeName");
		int subjectId = 0;
		if (subjectString != null)
			if (subjectString.length() > 0) {
				subjectId = Integer.parseInt(subjectString);
				request.getSession().setAttribute("subjectId", subjectId);
			}
		if (questionTypeNameString != null)
			if (questionTypeNameString.length() > 0
					&& !questionTypeNameString.equals("null"))
				request.setAttribute("questionTypeName", questionTypeNameString);

		List<Section> sections = sectionService.listSectionBySubject(subjectId);
		request.setAttribute("sections", sections);

		List<Subject> subjects = subjectService.getSubjects();
		List<Questiontype> questiontypes = questionService.showQuestiontypes();
		request.setAttribute("subjects", subjects);
		request.setAttribute("questionTypes", questiontypes);

		return mapping.findForward("showMaterialAnalysisList");
	}

	/**
	 * 材料分析题列表
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public ActionForward showMaterialAnalysisList(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {
		// TODO Auto-generated method stub

		String sectionName = new String(request.getParameter("sectionName")
				.getBytes("ISO-8859-1"), "utf-8");
		
		String typeName = DefaultValue.MATERIAL_ANALYSIS;
		Section existSection = sectionService
				.getSectionBySectionName(sectionName);

		request.getSession().setAttribute("typeName", typeName);
		String pageNowString = request.getParameter("pageNow");
		// 设置subjectId
		int subjectId = existSection.getSubject().getId();
		request.getSession().setAttribute("subjectId", subjectId);
		request.setAttribute("subjects", subjectService.getSubjects());

		// 加载问题类型
		List<Questiontype> questiontypes = questionService.showQuestiontypes();
		request.setAttribute("questionTypeName", typeName);
		request.setAttribute("questionTypes", questiontypes);

		// 加载章节下的题目

		List collection = questionService.listQuestionBySection(
				existSection.getId(), pageNowString, typeName);

		Map<String, Integer> pageMap = (Map<String, Integer>) collection.get(0);
		request.setAttribute("pageCount", pageMap.get("pageCount"));
		request.setAttribute("pageNow", pageMap.get("pageNow"));
		// 为jsp中的section设置值
		request.setAttribute("sectionName", sectionName);
		List<Section> sections = sectionService.listSectionBySubject(subjectId);
		request.setAttribute("sections", sections);
		// 设置多选题问题
		request.setAttribute("materialAnalysises", (List) collection.get(1));

		return mapping.findForward((String) collection.get(2));
	}

	/**
	 * 显示多选题详情
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
	public ActionForward showMaterialAnalysis(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {

		int materialAnalysisId = Integer.parseInt(request
				.getParameter("materialAnalysisId"));

		// 设置材料分析题
		Materialanalysis materialanalysis = (Materialanalysis) questionService
				.getQuestion(materialAnalysisId, DefaultValue.MATERIAL_ANALYSIS);

		request.setAttribute("materialAnalysis", materialanalysis);
		// 设置分析题下的小题
		List<Questionsofmaterial> questionsofmaterials = questionService
				.getOrderedQuestionsofmaterials(materialanalysis.getId());
		request.setAttribute("questionOfMaterials", questionsofmaterials);

		// 获得subject下拉菜单里的所有subject
		request.setAttribute("subject", materialanalysis.getSection()
				.getSubject().getSubName());
		// 获得下拉菜单里的所有section
		request.setAttribute("sectionName", materialanalysis.getSection()
				.getSectionName());
		return mapping.findForward("showMaterialAnalysis");
	}

	/**
	 * 显示材料题下的小题
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
	public ActionForward showQuestionOfMaterial(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		int questionOfMaterialId = Integer.parseInt(request
				.getParameter("questionOfMaterialId"));
		Questionsofmaterial questionsofmaterial = (Questionsofmaterial) questionService
				.getQuestion(questionOfMaterialId,
						DefaultValue.QUESTION_OF_MATERIAL);
		request.setAttribute("questionOfMaterial", questionsofmaterial);
		return mapping.findForward("showQuestionOfMaterial");
	}

	/**
	 * 添加材料分析题小题的页面跳转
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
	public ActionForward addQuestionOfMaterialUI(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {

		int materialAnalysisId = Integer.parseInt(request
				.getParameter("materialAnalysisId"));
		int questionNumber = questionService
				.getMaxQuestionNumByMaterialId(materialAnalysisId);
		if (questionNumber != 0)
			request.setAttribute("questionNumber", questionNumber + 1);
		else
			request.setAttribute("questionNumber", 1);
		request.setAttribute("materialAnalysisId", materialAnalysisId);
		return mapping.findForward("addQuestionOfMaterial");
	}

	/**
	 * 添加材料分析题小题
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws UnsupportedEncodingException
	 */

	public ActionForward addQuestionOfMaterial(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {
		
		int materialAnalysisId = 0;
		if (request.getParameter("materialAnalysisId") != null){
			if (request.getParameter("materialAnalysisId").length() > 0)
				materialAnalysisId = Integer.parseInt(request.getParameter("materialAnalysisId"));
			}
		else if(request.getAttribute("materialAnalysisId")!=null){
			if(request.getAttribute("materialAnalysisId").toString().length()>0)
				materialAnalysisId=(Integer)request.getAttribute("materialAnalysisId");
		}
		
				
		Questionsofmaterial questionsofmaterial = new Questionsofmaterial();

		// 加载QuestionOfMaterialAnalysis中的属性
		questionsofmaterial.setAnalysis(request.getParameter("analysis"));
		questionsofmaterial.setAnswer(request.getParameter("answer"));
		if(request.getParameter("questionNumber")!=null)
			if(request.getParameter("questionNumber").length()>0)
		questionsofmaterial.setQuestionNumber(Integer.parseInt(request
				.getParameter("questionNumber")));
		questionsofmaterial.setQuestionStem(request
				.getParameter("questionStem"));
		if(request
				.getParameter("score")!=null)
			if(request
				.getParameter("score").length()>0)
		questionsofmaterial.setScore(Integer.parseInt(request
				.getParameter("score")));

		// 持久化questionOfMaterialAnalysis对象
		questionService.addQuestionofMaterial(materialAnalysisId,
				questionsofmaterial);
		// 设置在editMaterialAnalysis中要使用参数
		request.setAttribute("materialAnalysisId", materialAnalysisId);
		// String pageNowString=request.getParameter("pageNow");
		// if(pageNowString!=null)
		// if(pageNowString.length()>0)
		// requestsetAttribute("pageNow", pageNowString);
		return editMaterialAnalysisAfterSaved(mapping, form, request, response);
	}

	/**
	 * 保存修改该材料题小题
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws UnsupportedEncodingException
	 */

	public ActionForward saveQuestionOfMaterial(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {

		int questionOfMaterialId = Integer.parseInt(request
				.getParameter("questionOfMaterialId"));

		// 获取QuestionOfMaterial对象
		Questionsofmaterial questionsofmaterial = (Questionsofmaterial) questionService
				.getQuestion(questionOfMaterialId,
						DefaultValue.QUESTION_OF_MATERIAL);

		// 更新QuesitonOfMaterial对象数据
		questionsofmaterial.setAnalysis(request.getParameter("analysis"
				+ questionOfMaterialId));
		questionsofmaterial.setAnswer(request.getParameter("answer"
				+ questionOfMaterialId));
		questionsofmaterial.setQuestionStem(request.getParameter("questionStem"
				+ questionOfMaterialId));
		if(request.getParameter("score" + questionOfMaterialId)!=null)
			if(request.getParameter("score" + questionOfMaterialId).toString().length()>0)
		questionsofmaterial.setScore(Integer.parseInt(request
				.getParameter("score" + questionOfMaterialId)));

		// 持久化materialAnalysi对象
		questionService.updateQuestionofMaterial(questionsofmaterial);
		// 设置转到showMaterialAnalysis中要使用参数
		request.setAttribute("materialAnalysisId", questionsofmaterial
				.getMaterialanalysis().getId());
		//String pageNowString = request.getParameter("pageNow");
		// if(pageNowString!=null)
		// if(pageNowString.length()>0)
		// request.setAttribute("pageNow", pageNowString);
		return editMaterialAnalysisAfterSaved(mapping, form, request, response);
	}

	/**
	 * 删除材料题下的小题
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public ActionForward deleteQuestionOfMaterial(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {

		int questionOfMaterialId = Integer.parseInt(request
				.getParameter("questionOfMaterialId"));

		Questionsofmaterial questionsofmaterial = (Questionsofmaterial) questionService
				.getQuestion(questionOfMaterialId,
						DefaultValue.QUESTION_OF_MATERIAL);
		Materialanalysis materialanalysis = questionsofmaterial
				.getMaterialanalysis();
		questionService.deleteQuestion(DefaultValue.QUESTION_OF_MATERIAL,
				questionsofmaterial);
		// 修改剩余小题的小题编号
		questionService.updateQuestionNumber(
				questionsofmaterial.getQuestionNumber(), materialanalysis);
		// 设置跳转到showMaterialAnalysis的参数
		request.setAttribute("materialAnalysisId", materialanalysis.getId());

		return editMaterialAnalysisAfterSaved(mapping, form, request, response);

	}

	/**
	 * 移动小题位置
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
	public ActionForward moveQuestionOfMaterial(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
//		String pageNowString = request.getParameter("pageNow");
//		if (pageNowString != null)
//			if (pageNowString.length() > 0)
//				request.setAttribute("pageNow", pageNowString);

		int questionOfMaterialId = Integer.parseInt(request
				.getParameter("questionOfMaterialId"));
		String type = request.getParameter("type");
		Questionsofmaterial questionsofmaterial = (Questionsofmaterial) questionService
				.getQuestion(questionOfMaterialId,
						DefaultValue.QUESTION_OF_MATERIAL);
		if (type.equals("decrease"))
			questionService.decreaseQuestionNumber(questionsofmaterial);
		else {
			questionService.increaseQuestionNumber(questionsofmaterial);
		}

		// 设置跳转到showMaterialAnalysis的参数
		request.setAttribute("materialAnalysisId", questionsofmaterial
				.getMaterialanalysis().getId());
		return editMaterialAnalysisAfterSaved(mapping, form, request, response);

	}

	/**
	 * 添加材料分析题的页面跳转
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
	public ActionForward addMaterialAnalysisUI(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		String pageNowString = request.getParameter("pageNow");
		if (pageNowString != null)
			if (pageNowString.length() > 0)
				request.getSession().setAttribute("pageNow",
						Integer.parseInt(pageNowString));

		int subjectId = (Integer) request.getSession()
				.getAttribute("subjectId");

		List<Section> sectionList = sectionService
				.listSectionBySubject(subjectId);
		List<Subject> subjectList = subjectService.getSubjects();
		request.setAttribute("subjects", subjectList);
		request.setAttribute("sections", sectionList);
		return mapping.findForward("addMaterialAnalysis");
	}

	/**
	 * 添加材料分析题大题
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws UnsupportedEncodingException
	 */

	public ActionForward addMaterialAnalysis(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {
		String imageUrl = request.getParameter("imageUrl");

		MaterialAnalysisForm materialAnalysisForm = (MaterialAnalysisForm) form;
		Materialanalysis materialanalysis = new Materialanalysis();
		// 加载materialAnalysis中的属性
		materialanalysis.setMaterial(materialAnalysisForm.getMaterial());
		if (imageUrl != null)
			if (imageUrl.length() > 0)
				materialanalysis.setMaterialImage(imageUrl);
		materialanalysis.setRemark(materialAnalysisForm.getRemark());
		materialanalysis.setQuestionsofmaterials(null);

		if (materialAnalysisForm.getSectionName() != null) {
			Section section = sectionService
					.getSectionBySectionName(materialAnalysisForm
							.getSectionName());
			materialanalysis.setSection(section);
		} else {
			materialanalysis.setSection(null);

		}
		// 持久化materialAnalysis对象,并获得返回的Id
		questionService.addMaterialAnalysis(materialanalysis);

		// 设置subject下拉菜单
		request.setAttribute("subjects", subjectService.getSubjects());
		// 设置在section下拉列表
		request.setAttribute("sectionName", materialanalysis.getSection()
				.getSectionName());
		List<Section> sections = sectionService
				.listSectionBySubject(materialanalysis.getSection()
						.getSubject().getId());
		request.setAttribute("sections", sections);
		// 设置问题类型下拉菜单
		request.setAttribute("questionTypeName", DefaultValue.MATERIAL_ANALYSIS);
		request.setAttribute("questionTypes",
				questionService.showQuestiontypes());
		// 设置题目及页码

		List collection = questionService.listQuestionBySection(
				materialanalysis.getSection().getId(), null,
				DefaultValue.MATERIAL_ANALYSIS);
		// 设置页码
		Map<String, Integer> pageMap = (Map<String, Integer>) collection.get(0);
		request.setAttribute("pageCount", pageMap.get("pageCount"));
		request.setAttribute("pageNow", pageMap.get("pageNow"));
		// 设置单项选择题
		request.setAttribute("materialAnalysises",
				(List<Materialanalysis>) collection.get(1));
		return mapping.findForward("showMaterialAnalysisList");
	}

	/**
	 * 创建材料分析题时创建小题
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
	public ActionForward firstTimeAddQuestionOfMaterial(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		String imageUrl = request.getParameter("imageUrl");

		MaterialAnalysisForm materialAnalysisForm = (MaterialAnalysisForm) form;
		Materialanalysis materialanalysis = new Materialanalysis();
		// 加载materialAnalysis中的属性
		materialanalysis.setMaterial(materialAnalysisForm.getMaterial());
		System.out.println(materialAnalysisForm.getMaterial()+" materiaAnalysis");
		if (imageUrl != null)
			if (imageUrl.length() > 0)
				materialanalysis.setMaterialImage(imageUrl);
		materialanalysis.setRemark(materialAnalysisForm.getRemark());
		materialanalysis.setQuestionsofmaterials(null);

		if (materialAnalysisForm.getSectionName() != null) {
			Section section = sectionService
					.getSectionBySectionName(materialAnalysisForm
							.getSectionName());
			materialanalysis.setSection(section);
		} else {
			materialanalysis.setSection(null);

		}
		// 持久化materialAnalysis对象,并获得返回的Id
		int materialAnalysisId = questionService
				.addMaterialAnalysisWithReturn(materialanalysis);

		// 跳转到添加小题
		int questionNumber = questionService
				.getMaxQuestionNumByMaterialId(materialAnalysisId);
		if (questionNumber != 0)
			request.setAttribute("questionNumber", questionNumber + 1);
		else
			request.setAttribute("questionNumber", 1);

		request.setAttribute("materialAnalysisId", materialAnalysisId);

		return mapping.findForward("addQuestionOfMaterial");
	}

	/**
	 * 编辑材料分析题
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
	public ActionForward editMaterialAnalysis(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		
		int materialAnalysisId = 0;
		if (request.getParameter("materialAnalysisId") != null){
			if (request.getParameter("materialAnalysisId").length() > 0)
				materialAnalysisId = Integer.parseInt(request.getParameter("materialAnalysisId"));
			}
		
		
		Materialanalysis materialanalysis = (Materialanalysis) questionService
				.getQuestion(materialAnalysisId, DefaultValue.MATERIAL_ANALYSIS);
		request.setAttribute("materialAnalysis", materialanalysis);

		String pageNowString = request.getParameter("pageNow");
		if (pageNowString != null){
			if (pageNowString.length() > 0)
				request.getSession().setAttribute("pageNow",
					Integer.parseInt(pageNowString));
		}

		// 获得subject下拉菜单里的所有subject
		int subjectId = (Integer) request.getSession()
				.getAttribute("subjectId");
		List<Subject> subjectList = subjectService.getSubjects();
		if (subjectList != null) {
			request.setAttribute("subjects", subjectList);
		}

		// 获得下拉菜单里的所有section

		List<Section> sectionList = sectionService
				.listSectionBySubject(subjectId);
		if (sectionList != null) {
			request.setAttribute("sectionName", materialanalysis.getSection()
					.getSectionName());
			request.setAttribute("sections", sectionList);
		}

		return mapping.findForward("editMaterialAnalysis");
	}

	/**
	 * 小题修改保存完成后,跳转到编辑材料分析题页面
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
	public ActionForward editMaterialAnalysisAfterSaved(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		int materialAnalysisId = (Integer) request
				.getAttribute("materialAnalysisId");
		Materialanalysis materialanalysis = (Materialanalysis) questionService
				.getQuestion(materialAnalysisId, DefaultValue.MATERIAL_ANALYSIS);
		request.setAttribute("materialAnalysis", materialanalysis);

//		String pageNowString = (String) request.getAttribute("pageNow");
//		if (pageNowString != null)
//			if (pageNowString.length() > 0)
//				request.setAttribute("pageNow", Integer.parseInt(pageNowString));

		// 获得subject下拉菜单里的所有subject
		int subjectId = (Integer) request.getSession()
				.getAttribute("subjectId");
		List<Subject> subjectList = subjectService.getSubjects();
		if (subjectList != null) {
			request.setAttribute("subjects", subjectList);
		}

		// 获得下拉菜单里的所有section

		List<Section> sectionList = sectionService
				.listSectionBySubject(subjectId);
		if (sectionList != null) {
			request.setAttribute("sectionName", materialanalysis.getSection()
					.getSectionName());
			request.setAttribute("sections", sectionList);
		}

		return mapping.findForward("editMaterialAnalysis");
	}

	/**
	 * 保存修该材料题大题题干
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws UnsupportedEncodingException
	 */

	public ActionForward saveMaterialAnalysis(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {

//		String pageNowString = request.getParameter("pageNow");
//		if (pageNowString != null)
//			if (pageNowString.length() > 0)
//				request.setAttribute("pageNow", Integer.parseInt(pageNowString));

		MaterialAnalysisForm materialAnalysisForm = (MaterialAnalysisForm) form;
		int materialAnalysisId = Integer.parseInt(request
				.getParameter("materialAnalysisId"));

		Materialanalysis materialanalysis = (Materialanalysis) questionService
				.getQuestion(materialAnalysisId, DefaultValue.MATERIAL_ANALYSIS);

		// 更新material对象数据
		materialanalysis.setMaterial(materialAnalysisForm.getMaterial());
		// materialanalysis.setMaterialImage(materialAnalysisForm
		// .getMaterialImage());
		materialanalysis.setRemark(materialAnalysisForm.getRemark());

		if (materialAnalysisForm.getSectionName() != null) {
			Section section = sectionService
					.getSectionBySectionName(materialAnalysisForm
							.getSectionName());
			materialanalysis.setSection(section);
		}
		// 持久化materialAnalysi对象
		questionService.updateMaterialAnalysis(materialanalysis);
		//设置转往editMaterialAnalysis页面
		request.setAttribute("materialAnalysisId", materialAnalysisId);
		return editMaterialAnalysisAfterSaved(mapping, materialAnalysisForm, request, response);
	}

	/**
	 * 删除材料题（包含材料题下的小题）
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public ActionForward deleteMaterialAnalysis(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {
		int materialAnalysisId = Integer.parseInt(request
				.getParameter("materialAnalysisId"));
		Materialanalysis materialanalysis = (Materialanalysis) questionService
				.getQuestion(materialAnalysisId, DefaultValue.MATERIAL_ANALYSIS);
		// 设置section下拉框
		request.setAttribute("sectionName", materialanalysis.getSection()
				.getSectionName());
		request.setAttribute(
				"sections",
				sectionService.listSectionBySubject(materialanalysis
						.getSection().getSubject().getId()));
		// 设置subject下拉框
		request.setAttribute("subjects", subjectService.getSubjects());
		// 设置questionType下拉框
		request.setAttribute("questionTypeName", DefaultValue.MATERIAL_ANALYSIS);
		request.setAttribute("questionTypes",
				questionService.showQuestiontypes());

		questionService.deleteQuestion(DefaultValue.MATERIAL_ANALYSIS,
				materialanalysis);

		// 设置页码及问题
		String pageNowString = request.getParameter("pageNow");
		List collection = questionService.listQuestionBySection(
				materialanalysis.getSection().getId(), pageNowString,
				DefaultValue.MATERIAL_ANALYSIS);
		// 设置页码
		Map<String, Integer> pageMap = (Map<String, Integer>) collection.get(0);
		request.setAttribute("pageCount", pageMap.get("pageCount"));
		request.setAttribute("pageNow", pageMap.get("pageNow"));
		// 设置单项选择题
		request.setAttribute("materialAnalysises",
				(List<Materialanalysis>) collection.get(1));

		return mapping.findForward("showMaterialAnalysisList");

	}
	/**删除多道材料分析题
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	public ActionForward delMaterialAnalysisByList(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException{
		String idString = request.getParameter("materialAnalysisList");
		if (idString != null)
			if (idString.length() > 0)
				questionService.deletQuestionByList(idString,
						DefaultValue.MATERIAL_ANALYSIS);

		// 设置section下拉框
		String sectionName = request.getParameter("sectionName");
		if (sectionName != null)
			if (sectionName.length() > 0)
				sectionName = new String(request.getParameter("sectionName")
						.getBytes("ISO-8859-1"), "utf-8");
		request.setAttribute("sectionName", sectionName);
		request.setAttribute("sections", sectionService
				.listSectionBySubject(sectionService.getSectionBySectionName(
						sectionName).getSubject().getId()));
		// 设置subject下拉框
		request.setAttribute("subjects", subjectService.getSubjects());
		// 设置questionType下拉框
		request.setAttribute("questionTypeName", DefaultValue.MATERIAL_ANALYSIS);
		request.setAttribute("questionTypes",
				questionService.showQuestiontypes());

		// 设置页码及问题
		String pageNowString = request.getParameter("pageNow");

		List collection = questionService.listQuestionBySection(sectionService
				.getSectionBySectionName(sectionName).getId(), pageNowString,
				DefaultValue.MATERIAL_ANALYSIS);
		// 设置页码
		Map<String, Integer> pageMap = (Map<String, Integer>) collection.get(0);
		request.setAttribute("pageCount", pageMap.get("pageCount"));
		request.setAttribute("pageNow", pageMap.get("pageNow"));
		// 设置单项选择题
		request.setAttribute("materialAnalysises",
				(List<Materialanalysis>) collection.get(1));

		return mapping.findForward("showMaterialAnalysisList");
	}
}