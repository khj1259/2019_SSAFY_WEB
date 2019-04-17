<%@page import="vo.BookVO"%>
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
			<th width="100">책 번호</th>
			<th width="300">책 제목</th>
			<th width="100">출판사</th>
			<th width="100">년도</th>
			<th width="100">가격(원)</th>
		</tr>
		<!-- jstl을 활용해서 반복구조를 쉽게 표현해 보자, request의 attribute에서 값을 꺼내기 -->
		<c:forEach var="book" items="${bookList }">
			<tr>
				<td>${book.bookid }</td>
				<td><a href="detailBook.do?bookid=${book.bookid }">${book.title}</a></td>
				<td>${book.publisher}</td>
				<td>${book.year}</td>
				<td>${book.price}</td>
			</tr>
		</c:forEach>
		
		<!-- 도서 추가 버튼을 만들고,
			 클릭시 addBook.do Get 방식
			 addBook.do 를 처리하는 Servlet
			 서블릿에서는 addBook.jsp 에 포워드
			 addBook.jsp 화면에서 추가할 정보를 입력받아옴 
			 addBook.do 돌아와서 서블릿에서 DB에 데이터를 INSERT 
		 -->
		 	<tr>
		 		<td colspan="5" align="right"><a href="addBook.do">도서추가</a></td>
		 	</tr>
		</table>
		
		<form action="searchBook.do">
			<select name="option">
				<option value="title">책 제목</option>
				<option value="publisher">출판사</option>
			</select>
			<input type="text" name="keyword"> <button type="submit">검색</button>
		</form>
		
		<!-- 만약에 EL JSTL 이 없다면 -->
		<%-- 
		<%
			List<BookVO> list = (List<BookVO>)request.getAttribute("bookList");
		%>
		<% 
			for(int i = 0; i < list.size(); i++){
				BookVO book = list.get(i);
		%>
		<tr>
			<td width="100"><%= book.getBookid() %></td>
			<td width="300"><%= book.getTitle() %></td>
			<td width="100"><%= book.getPublisher() %></td>
			<td width="100"><%= book.getYear() %></td>
			<td width="100"><%= book.getPrice() %></td>
		</tr>		
		<%		
			}
		%> --%>
</body>
</html>