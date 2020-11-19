<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">
	table{
		width: 1090px;
		height: 600px;
		border: 1px red solid;
		border-collapse: collapse;
	}
	td{
		border: 1px gray solid;
	}
	table tr:first-child{
		height: 150px;
	}
	table tr:last-child {
		height: 50px;
	}
	table tr td:first-child {
		width: 200px;
		font-size: 13px;
	}
	table tr td:last-child {
		text-align: center;
	}
</style>
</head>
<body>
	<table>
		<tr>
			<td colspan="2" style="text-align: right;">
				<%@include file="top.jsp" %>
			</td>
		</tr>
		<tr>
			<td><iframe src="${pageContext.request.contextPath}/left.kosta" name="left" width="100%" height="100%" frameborder="0"></iframe></td>
			<td><iframe src="${pageContext.request.contextPath}/index.kosta" name="center" width="100%" height="100%" frameborder="0"></iframe></td>
		</tr>
		<tr>
			<td colspan="2" style="font-weight: bold; font-size: 16px;">
				<%@include file="footer.jsp" %>
			</td>
		</tr>
	</table>
</body>
</html>