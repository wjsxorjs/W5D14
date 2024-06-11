<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ex2_res</title>
</head>
<body>
	<h1>저장된 값들</h1>
	<h2>${cPage }</h2>
	<h3>
		같은 이름으로 request와 session에 저장이 되었다면
		보통 우선순위는 request에 있다. (다만, 시스템에 따라 다를 수 있다)
	</h3>
	<h2>sessionScope.msg: ${sessionScope.msg }</h2>
	<h2>request에 저장된 map 구조에 있는 값: ${requestScope.u_map.cPage}</h2>
	<hr/>
	<h3>JSTL변수 선언하기</h3>
	<c:set var="ar" value="${paramValues.u_phone}" />
	<h3>JSTL 반복문</h3>
	<%-- for(String item: list) --%>
	<c:forEach var="item" items="${ar }">
		<h4>${item }</h4>
	</c:forEach>
</body>
</html>