<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style type="text/css">
	input{
		width: 80px;
	}
</style>
<script type="text/javascript" src="../../js/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("button").click(function() {
			if(confirm("정말 로그아웃할래?")){
				//이동하기
				location.href = "logout.jsp";
				top.center.location.reload();
			}//if
		});//click
		
	});//function
</script>
</head>
<body>
<%
	request.setCharacterEncoding("UTF-8");
	
	String dbId = "asd";
	String dbPwd = "1234";
	
	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");

	if(session.getAttribute("id") == null){
%>
	<form method="post" action="login.kosta">
		아이디 : <input type="text" name="id"/><br>
		비밀번호 : <input type="text" name="pwd"/><br><br>
		<input type="submit" value="로그인"/><br>
	</form>
<%
	}//if
	else{//로그인 상태
		%>
			<h3><%=session.getAttribute("id") %>님 로그인중</h3>
			<button type="button">로그아웃</button>
		<% 
	}//else
%>
</body>
</html>