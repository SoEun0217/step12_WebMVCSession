<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
   		//클라이언트쪽의 Cache기능 만료
   		response.setHeader("Cache-Control", "no-store");
   	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="../../js/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
$(function() {
	/* $("button").click(function() {
		if(confirm("정말 로그아웃할래?")){
			//이동하기
			location.href = "logout.jsp";
			parent.document.location.reload();
		}//if
	});//click */
});//function
</script>
</head>
<body>
	
<h1>${id}님이 로그인 중입니다.</h1>
</body>
</html>