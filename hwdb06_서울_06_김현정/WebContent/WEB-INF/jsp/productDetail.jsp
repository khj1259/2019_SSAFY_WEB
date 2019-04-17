<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>상세 정보 페이지</h1>
		<table style="width: 300px">
			<tr>
				<th>상품 코드</th>
				<td>${product.code }</td>
			</tr>
			<tr>
				<th>상품 명</th>
				<td>${product.name }</td>
			</tr>
			<tr>
				<th>가격</th>
				<td>${product.price }</td>
			</tr>
			<tr>
				<td><a href="updateProduct.do?code=${product.code }">수정</a></td>
				<form action="deleteProduct.do" method="post">
				<td>
					<input type="text" name="code" hidden="hidden" value="${product.code }">
					<button type="submit">삭제</button>
				</td>
				</form>
			</tr>
		</table>
	
</body>
</html>