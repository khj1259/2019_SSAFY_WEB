<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>상품이 저장되었습니다.</h1>
	<h2> 상품명 : <%= (String) request.getAttribute("name") %></h2>
	<h2> 상품가격 : <%= (String) request.getAttribute("price") %></h2>
	<h2> 상품설명 : <%= (String) request.getAttribute("comment") %></h2>
	<a href="#">상품 목록</a>
</body>
</html>