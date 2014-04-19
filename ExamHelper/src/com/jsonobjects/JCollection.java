package com.jsonobjects;

import java.sql.Timestamp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yrw.domains.Collection;
import com.yrw.idao.IQuestionTypeDao;
import com.yrw.idao.ISectionDao;
import com.yrw.idao.IUserDao;

/**
 * Entity mapped to table COLLECTION.
 */
public class JCollection {

	private Long id;
	private long question_id;
	private java.util.Date collect_time;
	private long user_id;
	private long questionType_id;
	private long section_id;

	public JCollection() {
	}

	public JCollection(Long id) {
		this.id = id;
	}

	public JCollection(Long id, long question_id, java.util.Date collect_time, long user_id, long questionType_id,
			long section_id) {
		this.id = id;
		this.question_id = question_id;
		this.collect_time = collect_time;
		this.user_id = user_id;
		this.questionType_id = questionType_id;
		this.section_id = section_id;
	}

	/**
	 * 将网络传回的Collection变为本地Collection
	 * 
	 * @return
	 */
	public com.yrw.domains.Collection NetToLocal() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		IUserDao iUserDao = (IUserDao) applicationContext.getBean("userDao");
		IQuestionTypeDao iQuestionTypeDao = (IQuestionTypeDao) applicationContext.getBean("questionTypeDao");
		ISectionDao iSectionDao = (ISectionDao) applicationContext.getBean("sectionDao");

		com.yrw.domains.Collection localCollection = new com.yrw.domains.Collection(iUserDao.getUserById(new Long(
				user_id).intValue()), iQuestionTypeDao.getQuestiontypeById(new Long(questionType_id).intValue()),
				iSectionDao.getSectionById(new Long(section_id).intValue()), new Long(question_id).intValue(),
				new Timestamp(collect_time.getTime()));

		return localCollection;
	}

	/**
	 * 本地Collection变为网络Collection
	 * 
	 * @param netCollection
	 * @return
	 */
	public static JCollection LocalToNet(Collection localCollection) {

		JCollection netCollection = new JCollection((long) localCollection.getId(), localCollection.getQuestionId(),
				localCollection.getCollectTime(), localCollection.getUser().getId(), localCollection.getQuestiontype()
						.getId(), localCollection.getSection().getId());

		return netCollection;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public long getQuestion_id() {
		return question_id;
	}

	public void setQuestion_id(long question_id) {
		this.question_id = question_id;
	}

	public java.util.Date getCollect_time() {
		return collect_time;
	}

	public void setCollect_time(java.util.Date collect_time) {
		this.collect_time = collect_time;
	}

	public long getUser_id() {
		return user_id;
	}

	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}

	public long getQuestionType_id() {
		return questionType_id;
	}

	public void setQuestionType_id(long questionType_id) {
		this.questionType_id = questionType_id;
	}

	public long getSection_id() {
		return section_id;
	}

	public void setSection_id(long section_id) {
		this.section_id = section_id;
	}

}
