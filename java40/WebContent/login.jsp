<%@page import="bean.MemberVO"%>
<%@page import="bean.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	MemberDAO dao = new MemberDAO();
	MemberVO vo = dao.one(id); 
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
<%
	if(vo.getPw().equals(pw)) {
%>
	<h3><%= id %>님 환영합니다.</h3>
<%
	} else {
%>
	<h3>로그인 실패입니다.</h3>
<%
	}
%>
		
</body>
</html>