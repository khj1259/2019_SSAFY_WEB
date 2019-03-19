<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
body {
	text-align: center;
}
</style>
</head>
<body>
<h1><%=request.getParameter("id") %> 님 로그인 되었습니다!!</h1>
<a href="html/Book.html">도서 등록</a><br>
<a href="html/Login.html">로그아웃</a>
</body>
</html>