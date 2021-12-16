package com.example.controller;

import java.util.Date;

import org.apache.commons.lang3.math.NumberUtils;
import org.apache.commons.lang3.time.DateUtils;

import com.example.dao.TodoDao;
import com.example.dto.TodoDto;
import com.example.vo.Todo;
import com.example.vo.User;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class TodoUpdateController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("loginUser");
		if (user == null) {
			return "redirect:/model2-todo/loginform.hta?error=required";
		}
		
		int todoNo = NumberUtils.toInt(request.getParameter("no"));
		int pageNo = NumberUtils.toInt(request.getParameter("page"));
		
		int categoryNo = NumberUtils.toInt(request.getParameter("categoryNo"));
		String title = request.getParameter("title");
		Date dueDate = DateUtils.parseDate(request.getParameter("dueDate"), "yyyy-mm-dd");
		int statusNo = NumberUtils.toInt(request.getParameter("statusNo"));
		String content = request.getParameter("content");
		
		TodoDto todoDto = TodoDao.getInstance().getTodoByNo(todoNo);
		if (todoDto.getUserNo() != user.getNo()) {
			return "redirect:/model2-todo/todo/detail.hta?no="+todoNo+"&page="+pageNo;
		}
		
		Todo todo = new Todo();
		todo.setNo(todoNo);
		todo.setCategoryNo(categoryNo);
		todo.setTitle(title);
		todo.setDueDate(dueDate);
		todo.setStatusNo(statusNo);
		todo.setContent(content);
		
		TodoDao.getInstance().updateTodo(todo);
		
		return "redirect:/model2-todo/todo/detail.hta?no="+todoNo+"&page="+pageNo;
	}
}
