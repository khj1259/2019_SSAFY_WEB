<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>도서추가</h1>
	<form action="addBook.do" method="post">
		제목 : <input type="text" name="title"><br>
		출판사 : <input type="text" name="publisher"><br>
		년도 : <input type="text" name="year"><br>
		가격 : <input type="text" name="price"><br>
		<button type="submit">도서추가</button>
	</form>
</body>
</html>