<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="ex7.vo.TestVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ex7</title>
</head>
<body>

<%
	TestVO t1 = new TestVO("마루치","010-1111-1111","maru@korea.com");
	TestVO t2 = new TestVO("아라치","010-2222-2222","ara@korea.com");
	TestVO t3 = new TestVO("창조리","010-3333-3333","chang@korea.com");
	
	// 위 객체들을 저장할 List구조 준비
	List<TestVO> t_list = new ArrayList<>();
	t_list.add(t1);
	t_list.add(t2);
	t_list.add(t3);
	
	// 리스트 구조 안에 앞서 만든 3개의 객체가 저장된 상태다.
	// 이런 리스트를 세션에 저장한다.
	session.setAttribute("t_list", t_list);
%>
	<button type="button" onclick="javascript:location.href='Ex7_for.jsp'">
	이동하기
	</button>
</body>
</html>