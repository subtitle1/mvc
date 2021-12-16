package com.example.controller;

import java.util.List;

import org.apache.commons.lang3.math.NumberUtils;

import com.example.dao.TodoDao;
import com.example.dto.Pagination;
import com.example.dto.TodoDto;
import com.example.vo.User;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/*
 * "model2-todo/todo/list.hta" 요청을 처리하는 컨트롤러다.
 * 요청객체에서 페이지번호를 조회한다.
 * 페이징처리에 필요한 정보를 조회하고, Pagination 객체를 생성한다.
 * 페이지번호에 해당하는 일정목록정보를 조회한다.
 * todo/list.jsp에 데이터를 전달하기 위해 요청객체에 Pagination 객체, List<Todo> 객체를 속성으로 저장한다.
 * 내부이동할 jsp url을 FrontControllerServlet에게 반환한다.
 */
public class TodoListController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("loginUser");
		if (user == null) {
			return "redirect:/model2-todo/loginform.hta?error=required";
		}
		
		int pageNo = NumberUtils.toInt(request.getParameter("page"), 1);
		int totalRows = TodoDao.getInstance().getTotalRows();
		Pagination pagination = new Pagination(pageNo, totalRows);
		
		int beginIndex = pagination.getBeginIndex();
		int endIndex = pagination.getEndIndex();
		List<TodoDto> todoList = TodoDao.getInstance().getTodos(beginIndex, endIndex);

		request.setAttribute("pagination", pagination);
		request.setAttribute("todoList", todoList);
		
		return "todo/list.jsp";
	}
}
