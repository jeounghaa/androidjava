<%@page import="bean.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	MemberDAO dao = new MemberDAO();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	if(dao.one(id) == null) {
%>
	<h3>사용하실 수 있는 아이디입니다.</h3>
<%
	} else{
%>
	<h3>중복된 아이디입니다.</h3>
<%
	}
%>
</body>
</html>