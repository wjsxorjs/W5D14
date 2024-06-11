<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ex5_for</title>
</head>
<body>
	<h1>JSTL의 for문 연습</h1>
	<c:set var="cnt" value="10" scope="page" />
	<c:set var="str" value="<strong>쌍용교육센터</strong>" scope="page" />
	
	<ul>
		<c:forEach varStatus="st" begin="1" end="${cnt }">
			<li>
				<c:out value="${st.index }."/>
				<c:out  value="${str }" escapeXml="false"/>
				
			</li>
		</c:forEach>
	</ul>
	
</body>
</html>