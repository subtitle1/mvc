package com.example.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/*
 * "model2-todo/loginform.hta" 요청을 처리하는 컨트롤러다.
 * 내부이동할 loginform.jsp를 FrontControllerServlet에게 반환한다.
 */
public class LoginFormController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		return "loginform.jsp";
	}
}
