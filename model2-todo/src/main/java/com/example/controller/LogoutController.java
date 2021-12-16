package com.example.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/*
 * "model2-todo/logout.hta" 요청을 처리하는 컨트롤러다.
 * HttpSession 객체를 폐기시킨다.
 * 로그아웃 처리가 완료되면 홈화면을 재요청하는 url(/model2-todo/home.hta)을 응답으로 보낸다.
 */
public class LogoutController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		/**
		 * 1. HttpSession 객체를 획득한다.
		 * 2. session 객체를 폐기한다.
		 */
		
		HttpSession session = request.getSession();
		session.invalidate();
		return "redirect:/model2-todo/home.hta";
	}
}
