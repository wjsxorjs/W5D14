<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ex6_for</title>
</head>
<body>
	<h1>JSTL의 for문 연습</h1>
	<c:set var="cnt" value="5" />
	
	<ol>
		<%-- for(int i=1; i<=cnt; i++) --%>
		<c:forEach begin="1" end="${cnt }">
			<li>쌍용교육센터</li>
		</c:forEach>
	</ol>
	
<%
	String[] ar = {"JAVA","Spring","Next.js","Python"};
	// 위와 같은 배열이 현재 페이지로 전달될 때는 파라미터 또는
	// request에 특정 이름으로 저장되어 왔을 것이다.
	request.setAttribute("ar", ar);
%>
	<ul>
		<c:forEach var="str" varStatus="vs" items="${requestScope.ar }">
			<li>${vs.index} : ${str }</li>
		</c:forEach>
	</ul>
	
</body>
</html>