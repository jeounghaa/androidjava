<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	if(session.getAttribute("id") != null) {
%>
	<h1><%=session.getAttribute("id") %>님</h1>
<%
	} else {
%>
	<h1>손님</h1>
<%
	}
%>
</body>
</html>