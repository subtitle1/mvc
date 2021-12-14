package kr.co.jhta.jstl.controller;

import com.sample.model2.controller.Controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JstlController1 implements Controller {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setAttribute("message", "jstl 태그 라이브러리 연습 페이지입니다.");
		
		// 악의적인 사용자가 사이트의 정보(쿠키, 세션아이디)를 탈취하기 위해 스크립트 코드를 작성하는 것을 방지한다
		request.setAttribute("content", "<script>function demo() { alert('실행됨') }</script> <button onclick='demo();'>클릭</button>");
		
		request.getRequestDispatcher("/WEB-INF/views/jstl/sample1.jsp").forward(request, response);
	}
}
