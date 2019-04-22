<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<META http-equiv="Expires" content="-1"> 
<META http-equiv="Pragma" content="no-cache"> 
<META http-equiv="Cache-Control" content="No-Cache"> 

<title>Insert title here</title>
<style type="text/css">
body {
	margin : 0 auto ;
	width : 500px;
	background-color: #D5D5D5;
}
table{
	width: 400px;
}
th {
	text-align : right;
	width: 40%;
	padding: 5px;
}
td {
	text-align : left;
	width: 60%;
	padding: 5px;
}

</style>
</head>
<body>
<h1> 회원 등록 결과 화면</h1>
<p/>

<table>
<tr><th> 아이디</th><td>${member.id }  </td></tr>
<tr><th> 비밀번호</th><td>${member.pw }  </td></tr>
<tr><th> 이름</th><td>${member.name } </td></tr>
<tr><th> 닉네임</th><td>${member.nickName}</td></tr>
<tr><th> 이메일</th><td>${member.email} </td></tr>
<tr><th> 홈페이지</th><td>${member.homePage} </td></tr>
<tr><th> 주소</th><td>${member.address } </td></tr>
<tr><th> 취미</th><td>${member.hobby }</td></tr>

</table>
<a href="mem.do?action=index.jsp"> 메인페이지 </a>
</body>
</html>



