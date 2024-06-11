<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ex8_choose</title>
</head>
<body>
<%--
	현재 페이지는 money라는 파라미터를 받는다.
	money에 따라 과일을 선택할 수 있다.
	사과: 1000
	배: 1700
	샤인머스캣: 2500
 --%>
 
 	<h2>choose문</h2>
	<c:choose>
		<c:when test="${param.money >= 2500 }">
			사과, 배, 샤인머스켓 중 하나를 선택!
		</c:when>
		<c:when test="${param.money >= 1700 }">
			사과, 배 중 하나를 선택!
		</c:when>
		<c:when test="${param.money >= 1000 }">
			사과 하나를 선택!
		</c:when>
		<c:otherwise>
			선택할 수 있는 과일이 없습니다.
		</c:otherwise>
	</c:choose>
 
 	<hr/>
 	<h2>if문</h2>
 	<c:if test="${param.money >= 2500 }">
		사과, 배, 샤인머스켓 중 하나를 선택!
	</c:if>
	<c:if test="${2500>param.money and param.money >= 1700 }">
		사과, 배 중 하나를 선택!
	</c:if>
	<c:if test="${1700>param.money and param.money >= 1000 }">
		사과 하나를 선택!
	</c:if>
	<c:if test="${1000>param.money}">
		선택할 수 있는 과일이 없습니다.
	</c:if>
 
 
</body>
</html>