<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> <!-- 태그라이브러리 지시어 -->
<!doctype html>
<html lang="ko">
<head>
   <meta charset="UTF-8">
   <meta name="viewport" content="width=device-width, initial-scale=1">
   <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" >
   <title></title>
</head>
<body>
<div class="container">    
	<div class="row">
		<div class="col">
			<h1>홈</h1>
			<p>${message }</p> <!-- EL 표현식 -->
		</div>
	</div>
	
	<div class="row">
		<div class="col">
			<table class="table">
				<thead>
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>작성자</th>
						<th>등록일</th>
					</tr>
				</thead>
				<tbody>
				<!-- boardList에 담긴 객체 0, 1, 2, 3...들이 x에 담긴다 -->
				<c:forEach var="x" items="${boardList }">
					<tr>
						<td>${x.no}</td> <!-- x(board 객체)의 변수명만 적어주면 끝! -->
						<td>${x.title }</td>
						<td>${x.writer }</td>
						<td>${x.createdDate }</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>