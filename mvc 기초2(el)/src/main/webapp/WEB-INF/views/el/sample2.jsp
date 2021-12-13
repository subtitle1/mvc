<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
	<div class="row mb-3">
		<div class="col">
			<h1>EL의 연산자</h1>
		</div>
	</div>
	<div class="row mb-3">
		<div class="col">
			<h1>empty 연산자</h1>
			<%--
				loginedUser라는 속성명으로 저장된 속성이 없다. null이 조회된다. 
				empty 연산자는 속성값이 null이면 true를 반환한다.
			--%>
			<p>${empty loginedUser } : ${loginedUser }</p> 
			
			<%-- 
				cart1이라는 속성명으로 조회된 값이 null이다.
				empty 연산자는 속성값이 null이면 true를 반환한다.
			--%>
			<p>${empty cart1 } : ${cart1 }</p> 
			
			<%-- 
				cart2이라는 속성명으로 조회된 값이 길이가 0이다. (비어있는 리스트다)
				empty 연산자는 속성값이 비어있는 List인 경우 true를 반환한다.
			--%>
			<p>${empty cart2 } : ${cart2 }</p> 
			
			<%-- 
				cart3이라는 속성명으로 조회된 값이 객체를 여러개 포함하고 있는 리스트다.
				empty 연산자는 속성값이 객체를 여러개 포함하고 있는 리스트인 경우 false를 반환한다.
			--%>
			<p>${empty cart3 } : ${cart3 }</p>
		</div>
	</div>
	<div class="row mb-3">
		<div class="col">
			<h1>산술연산자와 비교연산자</h1>
			<table class="table">
				<thead>
					<tr>
						<th>번호</th>
						<th>상품명</th>
						<th>가격</th>
						<th>할인율</th>
						<th>할인가격</th>
						<th>구매수량</th>
						<th>구매금액</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>${cart3[0].no }</td>
		                <td>${cart3[0].name }</td>
		                <td>${cart3[0].price }</td>
		                <td>${cart3[0].discountedRate*100 } %</td>
		                <td class="fw-bold ${cart3[0].discountedRate gt 0 ? 'text-danger' : '' }">${cart3[0].price*(1 - cart3[0].discountedRate) }</td>
		                <td>${cart3[0].amount }</td>
		                <td>${(cart3[0].price*(1 - cart3[0].discountedRate))*cart3[0].amount }</td>
					</tr>
					<tr>
						<td>${cart3[1].no }</td>
						<td>${cart3[1].name }</td>
						<td>${cart3[1].price }</td>
						<td>${cart3[1].discountPercent }%</td>
						<td  class="fw-bold ${cart3[1].discountedRate gt 0 ? 'text-danger' : '' }">${cart3[1].discountedPrice }</td>
						<td>${cart3[1].amount }</td>
						<td>${cart3[1].orderPrice }</td>
					</tr>
					<tr>
						<td>${cart3[2].no }</td>
						<td>${cart3[2].name }</td>
						<td>${cart3[2].price }</td>
						<td>${cart3[2].discountPercent }%</td>
						<td  class="fw-bold ${cart3[2].discountedRate gt 0 ? 'text-danger' : '' }">${cart3[2].discountedPrice }</td>
						<td>${cart3[2].amount }</td>
						<td>${cart3[2].orderPrice }</td>
					</tr>
					<tr>
						<td>${cart3[3].no }</td>
						<td>${cart3[3].name }</td>
						<td>${cart3[3].price }</td>
						<td>${cart3[3].discountPercent }%</td>
						<td  class="fw-bold ${cart3[3].discountedRate gt 0 ? 'text-danger' : '' }">${cart3[3].discountedPrice }</td>
						<td>${cart3[3].amount }</td>
						<td>${cart3[3].orderPrice }</td>
					</tr>
					<tr>
						<td>${cart3[4].no }</td>
						<td>${cart3[4].name }</td>
						<td>${cart3[4].price }</td>
						<td>${cart3[4].discountPercent }%</td>
						<td  class="fw-bold ${cart3[4].discountedRate gt 0 ? 'text-danger' : '' }">${cart3[4].discountedPrice }</td>
						<td>${cart3[4].amount }</td>
						<td>${cart3[4].orderPrice }</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	<div class="row mb-3">
		<div class="col">
			<h1>EL의 연산자</h1>
		</div>
	</div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>