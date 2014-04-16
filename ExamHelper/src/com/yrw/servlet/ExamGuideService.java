package com.yrw.servlet;


import java.util.ArrayList;
import java.util.List;

public class ExamGuideService {

	public ExamGuideService() {
		// TODO Auto-generated constructor stub
	}

	public List<ExamGuideType> getExamGuideTypeList() {
		List<ExamGuideType> list = new ArrayList<ExamGuideType>();
		list.add(new ExamGuideType("考试政策", (long) 1));
		list.add(new ExamGuideType("报考指南", (long) 2));
		list.add(new ExamGuideType("考试经验", (long) 3));
		list.add(new ExamGuideType("考试动态", (long) 4));
		list.add(new ExamGuideType("考试大纲", (long) 5));
		return list;
	}

	public List<ExamGuide> getExamGuideList(Long typeId) {
		List<ExamGuide> list = new ArrayList<ExamGuide>();
		if (typeId == 1) {
			list.add(new ExamGuide(
					(long) 1001,
					"2014年全国硕士学位研究生招生简章",
					"高等学校和科学研究机构（以下简称招生单位）招收硕士研究生，是为了培养热爱祖国，拥护中国共产党的领导，拥护社会主义制度，遵纪守法，品德良好，具有服务国家、服务人民的社会责任感，掌握本学科坚实的基础理论和系统的专业知识，具有创新精神、创新能力和从事科学研究、教学、管理等工作能力的高层次学术型专门人才以及具有较强解决实际问题的能力、能够承担专业技术或管理工作、具有良好职业素养的高层次应用型专门人才。 ",
					(long) 1));
			list.add(new ExamGuide((long) 1002, "考研如何选择适合你",
					"大家在选择所谓“热”专业时往往忽视一点，就是如何才是“热”专业。而大众的热专业于你来讲真的也能算是热专业吗?为大家分析“热”专业的本质，望对考研人有所帮助。 ", (long) 1));
		} else if (typeId == 3) {
			list.add(new ExamGuide(
					(long) 1003,
					"2014年全国硕士学位",
					"高等学校和科学研究机构（以下简称招生单位）招收硕士研究生，是为了培养热爱祖国，拥护中国共产党的领导，拥护社会主义制度，遵纪守法，品德良好，具有服务国家、服务人民的社会责任感，掌握本学科坚实的基础理论和系统的专业知识，具有创新精神、创新能力和从事科学研究、教学、管理等工作能力的高层次学术型专门人才以及具有较强解决实际问题的能力、能够承担专业技术或管理工作、具有良好职业素养的高层次应用型专门人才。 ",
					(long) 3));
			list.add(new ExamGuide((long) 1004, "考研如何选择适合你的热门专业",
					"大家在选择所谓“热”专业时往往忽视一点，就是如何才是“热”专业。而大众的热专业于你来讲真的也能算是热专业吗?为大家分析“热”专业的本质，望对考研人有所帮助。 ", (long) 3));

		} else if (typeId == 5) {
			list.add(new ExamGuide(
					(long) 1005,
					"年全国硕士学位研究生招生简章",
					"高等学校和科学研究机构（以下简称招生单位）招收硕士研究生，是为了培养热爱祖国，拥护中国共产党的领导，拥护社会主义制度，遵纪守法，品德良好，具有服务国家、服务人民的社会责任感，掌握本学科坚实的基础理论和系统的专业知识，具有创新精神、创新能力和从事科学研究、教学、管理等工作能力的高层次学术型专门人才以及具有较强解决实际问题的能力、能够承担专业技术或管理工作、具有良好职业素养的高层次应用型专门人才。 ",
					(long) 5));
			list.add(new ExamGuide((long) 1006, "如何选择适合你的热门专业",
					"大家在选择所谓“热”专业时往往忽视一点，就是如何才是“热”专业。而大众的热专业于你来讲真的也能算是热专业吗?为大家分析“热”专业的本质，望对考研人有所帮助。 ", (long) 5));

		}
		return list;
	}

}
