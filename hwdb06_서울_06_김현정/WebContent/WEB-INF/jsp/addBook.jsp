<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>상품추가</h1>
	<form action="addProduct.do" method="post">
		상품코드 : <input type="text" name="code"><br>
		상품명 : <input type="text" name="name"><br>
		가격 : <input type="text" name="price"><br>
		<button type="submit">상품추가</button>
	</form>
</body>
</html>