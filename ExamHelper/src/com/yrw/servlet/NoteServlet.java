package com.yrw.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsonobjects.JNote;
import com.jsonobjects.JUser;
import com.yrw.domains.Note;
import com.yrw.domains.User;
import com.yrw.service.NoteService;
import com.yrw.service.UserService;
import com.yrw.tools.FastJsonTools;

public class NoteServlet extends BaseServlet {

	private static final long serialVersionUID = 3585151855567516180L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset = utf-8");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String msg = "";

		// 收藏JsonString
		String jsonString = request.getParameter("note");

		// 获取类型
		String type = request.getParameter("type");

		// 获取系统逻辑组件
		NoteService noteService = (NoteService) getApplicationContext().getBean("noteService");
		UserService userService = (UserService) getApplicationContext().getBean("userService");

		/**
		 * 如果是增加一条笔记
		 */
		if (type.trim().equals("add")) {
			// 转化为json对象
			JNote jsonNote = FastJsonTools.createJsonBean(jsonString, JNote.class);

			// 转化为本地对象
			Note note = jsonNote.NetToLocal();
			noteService.addNote(note);
		}
		/**
		 * 如果是删除一条笔记
		 */
		else if (type.trim().equals("delete")) {
			// 转化为json对象
			JNote jsonNote = FastJsonTools.createJsonBean(jsonString, JNote.class);

			// 转化为本地对象
			Note note = jsonNote.NetToLocal();
			noteService.delNote(note);
		}
		/**
		 * 如果是修改
		 */
		else if (type.trim().equals("edit")) {
			// 转化为json对象
			JNote jsonNote = FastJsonTools.createJsonBean(jsonString, JNote.class);

			// 转化为本地对象
			Note note = jsonNote.NetToLocal();
			noteService.updateNote(note);
		}

		/**
		 * 如果是增加笔记列表
		 */
		else if (type.trim().equals("addList")) {
			List<JNote> jNotes = FastJsonTools.createJsonToListBean(jsonString, JNote.class);
			for (JNote jNote : jNotes) {
				Note note = jNote.NetToLocal();
				noteService.addNote(note);
			}
		}

		/**
		 * 如果是获取题目笔记列表
		 */
		else if (type.trim().equals("getNoteList")) {
			String questionTypeIdString = request.getParameter("questionTypeId");
			String questionIdString = request.getParameter("questionId");
			List<Note> noteList = noteService.getNoteList(Integer.parseInt(questionTypeIdString),
					Integer.parseInt(questionIdString));

			List<JNote> newNoteList = new ArrayList<JNote>();
			if (noteList != null) {
				for (Note note : noteList) {
					JNote jNote = JNote.LocalToNet(note);
					newNoteList.add(jNote);
				}
			}

			msg = FastJsonTools.createJsonString(newNoteList);
		}
		/**
		 * 如果是根据用户Key返回用户列表
		 */

		else if (type.trim().equals("getUserList")) {
			List<JUser> jUserList = FastJsonTools.createJsonToListBean(jsonString, JUser.class);
			List<JUser> newUserList = new ArrayList<JUser>();
			if (jUserList != null) {
				for (JUser jUser : jUserList) {
					User user = jUser.NetToLocal();
					user = userService.getUserByKey(user.getId());
					newUserList.add(JUser.LocalToNet(user));
				}

				msg = FastJsonTools.createJsonString(newUserList);
			}
		}

		out.write(msg);
		out.flush();
		out.close();

	}
}
