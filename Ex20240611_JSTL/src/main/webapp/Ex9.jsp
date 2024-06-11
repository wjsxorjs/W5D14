<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ex9</title>
</head>
<body>
	<form action="Ex9_function.jsp" method="post">
		값: <input type="text" name="str"  />
		<br/>
		<input type="checkbox" name="hobby" value="music" id="hb1"/>
		<label for="hb1">music</label>
		&nbsp;
		<input type="checkbox" name="hobby" value="book" id="hb2"/>
		<label for="hb2">book</label>
		&nbsp;
		<input type="checkbox" name="hobby" value="movie" id="hb3"/>
		<label for="hb3">movie</label>
		&nbsp;
		<button>보내기</button>
	</form>
</body>
</html>