package com.example.controller;


import java.util.Date;

import org.apache.commons.lang3.math.NumberUtils;
import org.apache.commons.lang3.time.DateUtils;

import com.example.dao.TodoDao;
import com.example.dao.UserDao;
import com.example.vo.Todo;
import com.example.vo.User;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/*
 * "model2-todo/todo/insert.hta" 요청을 처리하는 컨트롤러다.
 * todoform.jsp에서 제출한 폼입력값을 요청파라미터로 조회한다.
 * 작성자는 로그인된 사용자이기 때문에 HttpSession에서 인증된 사용자정보를 조회한다.
 * Todo 객체를 생성해서 카테고리번호, 작성자 번호, 제목, 처리예정일, 내용을 저장한다.
 * TodoDao의 insertTodo(todo) 메소드를 실행해서 테이블에 저장시킨다.
 * 목록화면을 재요청하는 "/model2-todo/todo/list.hta" url을 frontControllerServlet에게 전달한다.
 */
public class TodoInsertController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * 1. 요청객체에서 session 객체를 획득한다.
		 * 2. 세션객체에서 로그인된 사용자정보를 조회한다.
		 * 3. 로그인 사용자 정보가 null이면 "redirect:/model2-todo/loginform.hta?error=required"을 반환한다.
		 * 4. todo/form.jsp가 제출한 값을 조회한다.
		 * 	  처리예정일은 java.util.Date 타입으로 변환한다.
		 * 5. Todo 객체에 조회된 값을 저장한다.
		 * 6. Todo 객체를 dao에 전달해서 등록시킨다.
		 * 7. 화면 목록을 재요청하는 URL을 응답으로 보낸다.
		 */
		
		HttpSession session = request.getSession();
		
		User user = (User) session.getAttribute("loginUser");
		if (user == null) {
			return "redirect:/model2-todo/loginform.hta?error=required";
		}
		
		int categoryNo = NumberUtils.toInt(request.getParameter("categoryNo"));
		String title = request.getParameter("title");
		Date dueDate = DateUtils.parseDate(request.getParameter("dueDate"), "yyyy-mm-dd");
		String content = request.getParameter("content");
		
		Todo todo = new Todo();
		todo.setCategoryNo(categoryNo);
		todo.setTitle(title);
		todo.setDueDate(dueDate);
		todo.setContent(content);
		todo.setUserNo(user.getNo());
		
		TodoDao.getInstance().insertTodo(todo);
		
		return "redirect:/model2-todo/todo/list.hta";
	}
}
