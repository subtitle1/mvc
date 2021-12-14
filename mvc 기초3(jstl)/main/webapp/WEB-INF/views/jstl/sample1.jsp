<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- 
	jstl 태그 라이브러리를 jsp 페이지에 사용할 수 있도록 포함시키기
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>
<html lang="ko">
<head>
   <meta charset="UTF-8">
   <meta name="viewport" content="width=device-width, initial-scale=1">
   <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" >
   <title></title>
</head>
<body>
<c:set var="menu" value="샘플1"></c:set>
<%@ include file="navbar.jsp"%>
<div class="container">    
	<div class="row mb-3">
		<div class="col">
			<h1>c:out 태그</h1>
		</div>
	</div>
	<div class="row mb-3">
		<div class="col-4 border">
			<h3>c:out으로 속성값 출력</h3>
			<p><c:out value="${message }"></c:out></p>
			<p><c:out value="${content }" escapeXml="true"></c:out></p> <%-- escapeXml의 기본값은 true, false로 하면 태그가 적용됨 --%>
			<p><c:out value="${title }" default="없음"></c:out></p> <%-- default값이 있어서 값이 없을 때의 기본값 정의 가능 --%>
		</div>
		<div class="col-4 border">
			<h3>EL 표현식으로 속성값 출력</h3>
			<p>${message }</p>
			<p>${content }</p>
			<p>${title }</p>
		</div>
		<div class="col-4 border">
			<h3>표현식으로 속성값 출력</h3>
			<p><%=request.getAttribute("message") %></p>
			<p><%=request.getAttribute("content") %></p>
			<p><%=request.getAttribute("title") %></p>
		</div>
	</div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>