<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>정보 수정 페이지</h1>
	<form action="updateProduct.do" method="post">
		<table style="width: 300px">
			<tr>
				<th>상품코드</th>
				<td><input value="${product.code }" name="code" readonly="readonly"></td>
			</tr>
			<tr>
				<th>상품코드</th>
				<td><input value="${product.name }" name="name"></td>
			</tr>
			<tr>
				<th>가격</th>
				<td><input value="${product.price }" name="price"></td>
			</tr>
			<tr>
				<td></td>
				<td><button type="submit">수정</button></td>
			</tr>
		</table>
	</form>
</body>
</html>