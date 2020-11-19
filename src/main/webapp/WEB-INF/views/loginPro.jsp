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
	<%
		request.setCharacterEncoding("UTF-8");
		
		String dbId = "asd";
		String dbPwd = "1234";
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		
		if(dbId.equals(id) && dbPwd.equals(pwd)){
			session.setAttribute("id", id);
			session.setAttribute("time", new Date().toLocaleString());
			
			//if(session.getAttribute("id") != null){
				%>
				<%-- <h3><%=session.getAttribute("id") %>님 로그인중</h3> --%>
				<script type="text/javascript">
					//parent.center.location.reload();
					top.location.href = "index.jsp";
				</script>
				<%-- 접속시간 : <%=session.getAttribute("time") %> <br>
				<button type="button">로그아웃</button> --%>
				<%
			//}//if
			
		}//if
		else{
			%>
			<script type="text/javascript">
				alert("정보가 일치하지 않습니다.");
				history.back();
			</script>
			<% 
		}//else
		
	%>
</body>
</html>