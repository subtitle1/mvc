package com.example.controller;

import java.util.List;

import org.apache.commons.lang3.math.NumberUtils;

import com.example.dao.CategoryDao;
import com.example.dao.StatusDao;
import com.example.dao.TodoDao;
import com.example.dto.TodoDto;
import com.example.vo.Category;
import com.example.vo.Status;
import com.example.vo.User;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/*
 *  model2-todo/todo/detail.hta 요청을 처리하는 컨트롤러다
 *  요청객체에서 일정번호를 조회한다
 *  일정번호에 해당하는 일정정보(TodoDao)를 조회한다
 *  전체 카테고리 정보(List)와 전체 상태 정보(List)를 조회한다
 *  요청객체에 속성으로 일정정보, 전체 카테고리/상태 리스트를 저장한다
 *  todo/detail.jsp로 내부이동하는 url을 FrontControllerServlet에게 반환한다
 */
public class TodoDetailController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("loginUser");
		if (user == null) {
			return "redirect:/model2-todo/loginform.hta?error=required";
		}
		
		int no = NumberUtils.toInt(request.getParameter("no"));
		TodoDto todoDto = TodoDao.getInstance().getTodoByNo(no);
		
		List<Category> categoryList = CategoryDao.getInstance().getAllCategories();
		List<Status> statusList = StatusDao.getInstance().getAllStatus();
		
		request.setAttribute("todo", todoDto);
		request.setAttribute("categoryList", categoryList);
		request.setAttribute("statusList", statusList);
		
		return "todo/detail.jsp";
	}
}
