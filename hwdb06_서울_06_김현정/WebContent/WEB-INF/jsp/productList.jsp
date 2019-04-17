<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<table style="text-align: center;">
		<tr>
			<th width="300">상품코드</th>
			<th width="300">상품명</th>
			<th width="100">가격</th>
		</tr>
		<!-- jstl을 활용해서 반복구조를 쉽게 표현해 보자, request의 attribute에서 값을 꺼내기 -->
		<c:forEach var="product" items="${list }">
			<tr>
				<td>${product.code }</td>
				<td><a href="detailProduct.do?code=${product.code }">${product.name}</a></td>
				<td>${product.price}</td>
			</tr>
		</c:forEach>
		
		 	<tr>
		 		<td colspan="3" align="right"><a href="addProduct.do">상품추가</a></td>
		 	</tr>
		</table>
		
		<form action="searchProduct.do">
			<select name="option">
				<option value="name">상품명</option>
				<option value="code">코드</option>
			</select>
			<input type="text" name="keyword"> <button type="submit">검색</button>
		</form>
		
</body>
</html>