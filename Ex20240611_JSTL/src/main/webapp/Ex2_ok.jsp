<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ex2_form</title>
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");
	
	String u_name = request.getParameter("u_name");
	String cPage = request.getParameter("cPage");
	
	// Map 구조
	HashMap<String, String> u_map = new HashMap<>();
	u_map.put("cPage", cPage);
	
	request.setAttribute("u_name", u_name);
	request.setAttribute("u_map", u_map);
	
	session.setAttribute("msg", "쌍용교육센터");
	
%>
	<jsp:forward page="Ex2_res.jsp"/>
</body>
</html>