<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>도서 목록 화면</title>
<style type="text/css">
.gray {
    background-color: lightgray;
    text-align: center;
}
table {
    border: solid 1px black;
    width: 550px;
    margin: 0 auto;
}
td {
    border: solid 1px black;
}
body {
    text-align: center;
}
.SearchBar {
   /*  text-align: right; */
}

</style>
</head>
<body>
    <h1>도서 목록 화면</h1>
    <div class="SearchBar">
        <form method="get" action="search.mvc">
            <select name="option" id="option">
                <option value="isbn">Isbn</option>
                <option value="title">도서명</option>
                <option value="publisher">출판사</option>
                <option value="price">가격</option>
            </select> 
            <input type="text" name="searchValue">
            <input type="submit" value="검색">
        </form>
    </div>
    <!-- table 동적 생성 -->
    <table>
        <tr class="gray">
            <th>도서번호</th>
            <th>도서명</th>
            <th>도서분류</th>
            <th>저자</th>
        </tr>
        <c:forEach items="${list }" var="book">
        	<tr>
        		<td>${book.isbn }</td>
        		<td><a href="read.mvc?isbn=${book.isbn }">${book.title }</a></td>
        		<td>${book.catalogue }</td>
        		<td>${book.author }</td>
        	</tr>
        </c:forEach>
    </table>
    <a href="insertForm.mvc">도서 등록</a><br>
    <a href="list.mvc">도서목록 전체 보기</a>
</body>
</html>
