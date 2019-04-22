<%@ page contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
h1, h4 {
	text-align: center;
}
a {
	margin: 10px;
}

</style>
</head>
<body>
<h1> 메인 페이지 </h1>
<p/>
<h4>${msg}</h4>
<c:if test="${empty user}">
	<jsp:include  page="Login.html"/>
	<p/>
	<h4><a href="mem.do?action=MEMBERREG">회원가입</a>  <a href="book.do?action=SEARCH">도서 목록</a> </h4>
</c:if>
<c:if test="${not empty user}">
	<h4> <a href="book.do?action=REGBOOK">도서 등록</a>  <a href="book.do?action=SEARCH">도서 목록</a></h4>
</c:if>
</body>
</html>