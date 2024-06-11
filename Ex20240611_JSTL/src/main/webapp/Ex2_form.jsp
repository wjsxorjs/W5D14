<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ex2_form</title>
</head>
<body>
	<h1>JSTL연습</h1>
	<form action="Ex2_ok.jsp" method="post">
		<input type="text" name="u_name" placeholder="이름을 입력하세요"/>
		<br/>
		<input type="hidden" name="cPage" value="2"/>
		<select name="u_phone">
			<option value="010">010</option>
			<option value="011">011</option>
			<option value="017">017</option>
		</select>
		<input type="text" name="u_phone" />
		<input type="text" name="u_phone" />
		<button>보내기</button>
	</form>
</body>
</html>