<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서 상세 정보 페이지</title>
<style type="text/css">
	.gray{
		background-color: lightgray;
		text-align: center;
	}
	table {
		border: solid 1px black;
		width: 550px;
		margin: 0 auto;
	}
	td{
		border: solid 1px black;
	}
	body{
		text-align: center;
	}
	.ltd{
		width: 20%;
	}
</style>

</head>
<body>
	<h1>도서 상세 정보</h1>
	<table>
		<tr class="gray"> 
			<td colspan="2">도서 정보</td>
		</tr>
		<tr>
			<td class="gray ltd">도서명</td>
			<td>${book.title }</td>
		</tr>
		<tr>
			<td class="gray ltd">도서번호</td>
			<td>${book.isbn }</td>
		</tr>
		<tr>
			<td class="gray ltd">도서분류</td>
			<td>${book.catalogue}</td>
		</tr>
		<tr>
			<td class="gray ltd">도서국가</td>
			<td>${book.nation}</td>
		</tr>
		<tr>
			<td class="gray ltd">출판일</td>
			<td>${book.date }</td>
		</tr>
		<tr>
			<td class="gray ltd">출판사</td>
			<td>${book.publisher }</td>
		</tr>
		<tr>
			<td class="gray ltd">저 자</td>
			<td>${book.author }</td>
		</tr>
		<tr>
			<td class="gray ltd">도서가격</td>
			<td>${book.price } ${book.currency }</td>
		</tr>
		<tr>
			<td class="gray ltd">도서설명</td>
			<td>${book.description}</td>
		</tr>
	</table>
	<div>
		<a href="list.mvc">도서목록으로 돌아가기</a>
		<a href="delete.mvc?isbn=${book.isbn }">도서 삭제</a>
	</div>

</body>
</html>