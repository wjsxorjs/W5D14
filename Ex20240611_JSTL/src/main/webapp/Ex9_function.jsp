<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ex9_function</title>
</head>
<body>
<%--
	현재 페이지는 str라는 파라미터를 받는다.
	받은 파라미터의 길이를 구해보자.
--%>
 
	<h2>파라미터 값(param.str): ${param.str }</h2>
	<h2>str.length(): ${param.str.length() }</h2>
	<h2>str의 substring(0,3) : ${param.str.substring(0,3) }</h2>
	<h2>str.IndexOf("E"): ${param.str.indexOf("E") }</h2>
	<h2>str.replace("E","e"): ${param.str.replace("E","e") }</h2>
	<hr/>
	<hr/>
 <%-- JSTL 변수 선언 후 파라미터 값을 저장하자 --%>
	<c:set var="s1" value="${param.str }"></c:set>
	<h2>fn:length(s1): ${fn:length(s1) }</h2>	
	<h2>fn:substring(s1,0,3): ${fn:substring(s1,0,3) }</h2>
	<h2>fn:indexOf(s1,"E"): ${fn:indexOf(s1,"E")}</h2>
	<h2>fn:replace(s1,"E","e"): ${fn:replace(s1,"E","e")}</h2>
	<h2>fn:toLowerCase(s1): ${fn:toLowerCase(s1) }</h2>	
	<h2>fn:startsWith(s1, "A"): ${fn:startsWith(s1, "A") }</h2>	
	<h2>fn:join(배열, 구문자): ${fn:join(paramValues.hobby, ",") }</h2>	
 	
 
</body>
</html>