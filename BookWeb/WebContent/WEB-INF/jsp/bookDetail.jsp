<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>상세 정보 페이지</h1>
		<table style="width: 300px">
			<tr>
				<th>책 번호</th>
				<td>${book.bookid }</td>
			</tr>
			<tr>
				<th>책 제목</th>
				<td>${book.title }</td>
			</tr>
			<tr>
				<th>출판사</th>
				<td>${book.publisher }</td>
			</tr>
			<tr>
				<th>년도</th>
				<td>${book.year }</td>
			</tr>
			<tr>
				<th>가격</th>
				<td>${book.price }</td>
			</tr>
			<tr>
				<td><a href="updateForm.do?bookid=${book.bookid }">수정</a></td>
				<form action="deleteBook.do" method="post">
				<td>
					<input type="text" name="bookid" hidden="hidden" value="${book.bookid }">
					<button type="submit">삭제</button>
				</td>
				</form>
			</tr>
		</table>
	
</body>
</html>