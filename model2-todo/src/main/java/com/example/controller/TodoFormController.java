package com.example.controller;

import java.util.List;

import com.example.dao.CategoryDao;
import com.example.vo.Category;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/*
 * "model2-todo/todo/form.hta" 요청을 처리하는 컨트롤러다.
 * 일정등록 화면에서 출력할 전체 카테고리 정보를 조회한다.
 * 조회된 카테고리 정보를 jsp에게 전달하기 위해서 요청객체에 속성으로 저장한다.
 * 내부이동할 todo/form.jsp url을 frontControllerServlet에게 반환한다.
 */
public class TodoFormController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		/*
		 * 1. 모든 카테고리 정보를 조회한다.
		 * 2. 조회된 카테고리 리스트를 요청객체에 "categoryList"라는 속성명으로 저장한다.
		 * 3. 내부이동할 URL을 반환한다.
		 */
		List<Category> categoryList = CategoryDao.getInstance().getAllCategories();
		request.setAttribute("categoryList", categoryList);
		
		return "todo/form.jsp";
	}
}
