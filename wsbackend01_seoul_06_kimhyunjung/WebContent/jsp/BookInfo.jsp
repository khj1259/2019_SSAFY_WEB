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
		<tr>
			<td class="gray ltd">도서명</td>
			<td><%=(String) request.getAttribute("title") %></td>
		</tr>
		<tr>
			<td class="gray ltd">도서번호</td>
			<td><%=(String) request.getAttribute("num") %></td>
		</tr>
		<tr>
			<td class="gray ltd">도서분류</td>
			<td><%=(String) request.getAttribute("kind") %></td>
		</tr>
		<tr>
			<td class="gray ltd">도서국가</td>
			<td><%=(String) request.getAttribute("country") %></td>
		</tr>
		<tr>
			<td class="gray ltd">출판일</td>
			<td><%=(String) request.getAttribute("date") %></td>
		</tr>
		<tr>
			<td class="gray ltd">출판사</td>
			<td><%=(String) request.getAttribute("publisher") %></td>
		</tr>
		<tr>
			<td class="gray ltd">저 자</td>
			<td><%=(String) request.getAttribute("name") %></td>
		</tr>
		<tr>
			<td class="gray ltd">도서가격</td>
			<td><%=(String) request.getAttribute("price") %></td>
		</tr>
		<tr>
			<td class="gray ltd">도서설명</td>
			<td><%=(String) request.getAttribute("summary") %></td>
		</tr>
	</table>
	<div>
		<a href="html/Book.html">도서 등록</a>
	</div>
</body>
</html>