package com.yrw.idao;

import java.util.List;

import com.yrw.domains.Note;

/**
 * 项目名称：ExamHelper 类名称：INoteDao 类描述： 针对笔记的有关操作的接口类，继承了IBasicDao
 * 创建人：叶睿雯 创建时间：2014-03-15 修改人： 修改时间： 修改备注：
 * 
 */
public interface INoteDao extends IBasicDao {

	
	/**根据题目得到note列表
	 * @param questiontypeId
	 * @param questionId
	 * @return
	 */
	public List<Note> getNoteByQuestion(int questiontypeId,int questionId);

	/**
	 * @param userId
	 * @return
	 */
	public List<Note> getNoteByUserId(int userId);

	/**根据用户Id及问题类型及问题id获得唯一笔记对象
	 * @param note
	 * @return
	 */
	public Note getNoteByUserAndQustion(Note note);

	/**
	 * @param noteId
	 * @return
	 */
	
	public Note showNote(int noteId);
	/**
	 * @param note
	 */
	public void addNote(Note note);
	/**
	 * @param note
	 */
	public void delNote(Note note);

	/**
	 * @param note
	 */
	public void modifyNote(Note note);
}
