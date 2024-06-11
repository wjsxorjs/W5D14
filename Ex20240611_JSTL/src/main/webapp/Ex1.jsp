<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ex1</title>
</head>
<body>
<%--
	1. apache.org 접속 후 Apache Project List 항목에서 Tomcat을 선택한다.
	2. 좌측 메뉴 상단의 [Taglibs] 선택
	3. 화면 중앙에 파란색 [Download]를 클릭
	4. 화면 상단에 [Apache Standard Taglib] 링크걸린 항목을 선택
	5. [Standard1.1]항목의 [download]를 선택!
	6. 나타나는 화면에서 [binaries/] 선택 후
	7.  하단 6번째 jakarta-taglibs-standard-1.1.2.zip 다운로드후 압축해제
	8. lib 폴더에 있는 2개의 jar파일을 [프로젝트 폴더/.../WEB-INF/lib]에 붙여넣는다
--%>
<%
	session.setAttribute("s1", "대한민국");
%>
<form action="Ex1_2.jsp" method="post">
	<input type="hidden" name="v1" value="100"/>
	<input type="text" name="u_name" /><br/>
	<button type="button" onclick="exe(this.form)">보내기</button>
</form>

<script>
	function exe(frm){
		frm.submit();
	}
</script>
</body>
</html>