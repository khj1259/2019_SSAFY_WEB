<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	현재시간 : <%= request.getAttribute("time") %> <br>
	2 : ${time }
	<!-- EL : 서블릿이 출력에 사용할 데이터를 Attribute에 실어 보내준 것을
				jsp에서 꺼내기 위한 용도
	 -->
</body>
</html>