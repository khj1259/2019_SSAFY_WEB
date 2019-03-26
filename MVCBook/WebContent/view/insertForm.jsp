<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서 등록 페이지</title>
<style type="text/css">
	.gray{
		background-color: lightgray;
	}
	.star{
		color: orange;
	}
	td{
		border: solid 1px lightgray;
		margin: 0px;
	}
	.center{
		text-align: center;
	}
	.right{
		text-align: right;
	}
	table{
		margin: 0 auto;
	}
</style>
<script type="text/javascript">
	$(document).ready(function(){
		$('#submit').click(function(e) {
			var num1 = $("#num1").val();
			var num2 = $("#num2").val();
			var num3 = $("#num3").val();
			var title = $("#title").val();
			var catalogue = $("#catalogue").val();
			var author = $("#author").val();
			if(num1=='' || num2=='' || num3==''){
				alert('도서번호를 입력해주세요');
				e.preventDefault();
			}else if(title==''){
				alert('도서제목을 입력해주세요');
				e.preventDefault();
			}else if(catalogue==''){
				alert('도서종류를 선택해주세요');
				e.preventDefault();
			}else if(author==''){
				alert('저자를 입력해 주세요');
				e.preventDefault();
			}
			
		});
		
	});
</script>

</head>
<body>
	<form method="post" action="insert.mvc">
		<table>
			<tr class="gray">
				<th colspan="2"><h1>도서 등록 화면</h1></th>
			</tr>
			<tr class="right">
				<td colspan="2"><span class="star">* </span> 표시가 된 항목은 필수 입력 항목입니다.</td> 
			</tr>
			<tr class="gray">
				<td colspan="2"></td> 
			</tr>
			<tr>
				<td><span class="star">* </span>도서번호</td>
				<td><input type="text" name="num1" id="num1">-
					<input type="text" name="num2" id="num2">-
					<input type="text" name="num3" id="num3"></td>
			</tr>
			<tr>
				<td><span class="star">* </span>도서제목</td>
				<td><input type="text" name="title" id="title"></td>
			</tr>
			<tr>
				<td><span class="star">* </span>도서종류</td>
				<td>
					<select name="catalogue" id="catalogue">
						<option value="">해당 항목을 선택하세요</option>
						<option value="프로그래밍">프로그래밍</option>
						<option value="소설">소설</option>
						<option value="동화">동화</option>
						<option value="수필">수필</option>
					</select>
				</td>
			</tr>
			<tr>
				<td><span>* </span>출판국가</td>
				<td>
					<input type="radio" name="nation" value="국내">국내도서
					<input type="radio" name="nation" value="외국">외국도서
				</td>
			</tr>
			<tr>
				<td><span>* </span>출 판 일</td>
				<td><input type="date" name="date"></td>
			</tr>
			<tr>
				<td><span>* </span>출판사</td>
				<td>
					<select name="publisher">
						<option value="">해당 항목을 선택하세요</option>
						<option value="한빛">한빛</option>
						<option value="동아">동아</option>
						<option value="길벗">길벗</option>
						<option value="사이버출판사">사이버출판사</option>
					</select>
				</td>
			</tr>
			<tr>
				<td><span class="star">* </span>저   자</td>
				<td><input type="text" name="author" id="author"></td>
			</tr>
			<tr>
				<td><span>* </span>도서가격</td>
				<td>
					<input type="text" name="price"> 
					<select name="currency">
						<option value="원">원</option>
						<option value="$">$</option>
					</select>
				</td>
			</tr>
			<tr>
				<td><span>* </span>요약내용</td>
				<td class="gray"><textarea rows="6" cols="60" name="description"></textarea></td>
			</tr>
			<tr class="gray center">
				<td colspan="2">
					<input type="submit" value="도서등록" id="submit">
					<input type="reset" value="취      소">
					<a href="list.mvc">뒤로가기</a>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>