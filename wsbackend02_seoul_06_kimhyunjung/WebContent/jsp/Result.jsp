<%@page import="com.ssafy.Book"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.gray{
		background-color: lightgray;
		text-align: center;
	}
	table {
		border: solid 1px black;
		width: 550px;
		margin: 0 auto;
	}
	td{
		border: solid 1px black;
	}
	body{
		text-align: center;
	}
	.ltd{
		width: 20%;
	}
</style>
</head>
<body>
	<h1>입력된 도서 정보</h1>
	<table>
		<tr class="gray"> 
			<td colspan="2">도서 정보</td>
		</tr>
		<% Book book = (Book)request.getAttribute("book"); %>
		<tr>
			<td class="gray ltd">도서명</td>
			<td><%=book.getTitle() %></td>
		</tr>
		<tr>
			<td class="gray ltd">도서번호</td>
			<td><%=book.getNum() %></td>
		</tr>
		<tr>
			<td class="gray ltd">도서분류</td>
			<td><%=book.getKind() %></td>
		</tr>
		<tr>
			<td class="gray ltd">도서국가</td>
			<td><%=book.getCountry() %></td>
		</tr>
		<tr>
			<td class="gray ltd">출판일</td>
			<td><%=book.getDate() %></td>
		</tr>
		<tr>
			<td class="gray ltd">출판사</td>
			<td><%=book.getPublisher() %></td>
		</tr>
		<tr>
			<td class="gray ltd">저 자</td>
			<td><%=book.getName() %></td>
		</tr>
		<tr>
			<td class="gray ltd">도서가격</td>
			<td><%=book.getPrice() %></td>
		</tr>
		<tr>
			<td class="gray ltd">도서설명</td>
			<td><%=book.getSummary() %></td>
		</tr>
	</table>
	<div>
		<a href="html/Book.html">추가 등록</a>
	</div>
</body>
</html>