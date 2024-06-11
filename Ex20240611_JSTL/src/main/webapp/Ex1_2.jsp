<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ex1_2</title>
</head>
<body>
<%
	// 요청시 한글처리
	request.setCharacterEncoding("utf-8");
	
	request.setAttribute("age", "30");
	request.setAttribute("s1", "만세!");

%>
<%--
	EL(Expression Language(표현언어))
 --%>
 
	<h1><s>${param.v1}</s></h1>
	<h1><u>${param.u_name}</u></h1>
	<h1>request 값: ${requestScope.age}</h1>
	<h2>세션값: ${sessionScope.s1}</h2>
	<h2>(중복시)값: ${s1}</h2>
	<%--
		request > session > application 순으로 검색.
		그러므로 -Scope문을 붙이는 것이 속도 측면에서 좋다.
	--%>


</body>
</html>