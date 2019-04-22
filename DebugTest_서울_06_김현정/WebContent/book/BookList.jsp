<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서 정보</title>
<style type="text/css">
h1, h4 {
	text-align: center;
}

#bookTable {
	margin: auto auto;
}

body, p {
	text-align: center;
}

#bookTable th{
	text-align: right;
}

#bookTable td {
	border: 1px solid black;
	padding: 10px 0px;
}

#bookTable tr:nth-child(2) {
	text-align: center;
	background-color: lightgray;
}

#bookTable td {
	width: 100px;
}

#bookTable td:nth-child(2) {
	width: 300px;
}
#bookTable td:nth-child(1) {
	width: 150px;
}
</style>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script type="text/javascript">
$(function(){
	 $(".subject").mouseover(function(){
		 var isbn=$(this).context.id;
		 console.log(isbn);
		 $.ajax({
			 url : "book.do?action=DESC",
			 type : "get",
			 data :{isbn: isbn},
			 error  : function(xhr, status,message){
				 alert("error:"+message);
			 },
			 success : function(data){
				 $("#result").html("<h5>"+data+"</h5>");
			 }
		 });
	 });
});
</script>
</head>
<body>
	<h1>도서 목록 화면</h1>
	<c:if test="${not empty user }">
<h4>${user} 님 로그인 되었습니다. <a href="mem.do?action=LOGOUT">로그아웃</a></h4>
</c:if>
	<table id="bookTable">
		<tr>
			<th  colspan="4">
				<form action="book.do" method="get">
					<input type="hidden" name="action" value="SEARCH"> 
					<select name="searchField" id="searchField">
						<option value="LIST">전체</option>
						<option value="TITLE">도서명</option>
						<option value="PUBLISHER">출판사</option>
						<option value="PRICE">가격</option>
					</select> 
					<input type="text" id="searchText" name="searchText"> 
					<input type="submit" value="검색">
				</form>
			</th>
		</tr>
		<tr>
			<td>도서번호</td>
			<td>도서명</td>
			<td>도서분류</td>
			<td>저자</td>
		</tr>
		<c:choose>
			<c:when test="${empty books}">
				<tr>
					<td colspan="4">입력된 도서정보가 없습니다.</td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach items="${requestScope.books}" var="b">
					<tr>
						<td>${b.isbn}</td>
						<td><span id="${b.isbn}" class="subject"><a href="./book.do?action=VIEW&isbn=${b.isbn}">${b.title}</span></a></td>
						<td>${b.catalogue}</td>
						<td>${b.author}</td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</table>
	<div id="result"></div>
	<p>
		<a href='book.do?action=REGBOOK'>도서 등록</a> <a href='index.jsp'>메인페이지</a> 
	</p>
</body>
</html>
