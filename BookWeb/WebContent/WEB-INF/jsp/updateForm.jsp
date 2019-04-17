<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>정보 수정 페이지</h1>
	<form action="updateBook.do" method="post">
		<table style="width: 300px">
			<tr>
				<th>책 번호</th>
				<td><input value="${book.bookid }" name="bookid" readonly="readonly"></td>
			</tr>
			<tr>
				<th>책 제목</th>
				<td><input value="${book.title }" name="title"></td>
			</tr>
			<tr>
				<th>출판사</th>
				<td><input value="${book.publisher }" name="publisher"></td>
			</tr>
			<tr>
				<th>년도</th>
				<td><input value="${book.year }" name="year"></td>
			</tr>
			<tr>
				<th>가격</th>
				<td><input value="${book.price }" name="price"></td>
			</tr>
			<tr>
				<td></td>
				<td><button type="submit">수정</button></td>
			</tr>
		</table>
	</form>
</body>
</html>