<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ex3_res</title>
</head>
<body>
	<h1>저장된 값들</h1>
	<h2>${param.count }</h2>
	<hr/>
	<h3>JSTL 비교문</h3>
	<%-- 파라미터 count를 저장하는 JSTL변수 i를 선언하시오. --%>
	<c:set var="i" value="${param.count }" />
	<h3>
		<c:if test="${i >= 50 }">
			50 이상
		</c:if>
		<c:if test="${i < 50 }">
			50 미만
		</c:if>
	</h3>
</body>
</html>