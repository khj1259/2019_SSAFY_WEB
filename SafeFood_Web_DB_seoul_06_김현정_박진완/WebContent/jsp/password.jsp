<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% String pass=(String)request.getAttribute("pass"); %>
	비밀번호는 <%= pass %> 입니다.<br>
	<form action="main.mvc" method="get">
	<button type="submit" >돌아가기</button>
	</form>
	
</body>
</html>