<%@page import="bean.MemberVO"%>
<%@page import="bean.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- 1. id값 받아와야 함. -->
    <!-- 2. dao와 연동하여 결과 받아와야 함. -->
    <!-- 3. html로 만들어서 전송해야함. -->
<%
	String id = request.getParameter("id");
	MemberDAO dao = new MemberDAO();
	MemberVO vo = dao.one(id);
%>    
     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 검색</title>
</head>
<body>
<h3><%= vo.getId() %>님의 회원정보 검색 내용입니다.</h3>
<hr color="red">
<table>
	<tr align="center">
		<td width="100" bgcolor="yellow">아이디</td>
		<td width="200" bgcolor="pink"><%= vo.getId() %> </td>
	</tr>
	<tr align="center">
		<td width="100" bgcolor="yellow">패스워드</td>
		<td width="200" bgcolor="pink"><%= vo.getPw() %> </td>
	</tr>
	<tr align="center">
		<td width="100" bgcolor="yellow">이름</td>
		<td width="200" bgcolor="pink"><%= vo.getName()%> </td>
	</tr>
	<tr align="center">
		<td width="100" bgcolor="yellow">전화번호</td>
		<td width="200" bgcolor="pink"><%= vo.getTel() %> </td>
	</tr>
</table>
<hr color="green">
[ 	<a href="index.html"><button style=background:green>처음페이지로</button></a> |
	<a href="update.jsp?id=<%= vo.getId() %>"><button style=background:gold>수정</button></a> |
	<a href="delete.jsp?id=<%= vo.getId() %>"><button style=background:lime>삭제</button></a> 
]  








</body>
</html>