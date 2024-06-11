<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ex4_res</title>
</head>
<body>
	<%-- 파라미터 count를 저장하는 JSTL변수 i를 선언하시오. --%>
	<c:set var="s_id" value="${param.s_id }" />
	<c:set var="s_pw" value="${param.s_pw }" />
	<h3>
		<c:if test="${s_id eq 'admin' }"> <%-- ==, eq --%>
			${s_id } 관리자님, 환영합니다!
		</c:if>
		<c:if test="${s_id ne 'admin' }"> <%-- !=, ne --%>
			${s_id } 회원님, 환영합니다!
		</c:if>
		
	<%--
		<c:if test="${s_id.startsWith('admin') }">
			관리자님, 환영합니다!
		</c:if>
		<c:if test="${!s_id.startsWith('admin') }">
			회원님, 환영합니다!
		</c:if>
	 --%>
	</h3>
</body>
</html>