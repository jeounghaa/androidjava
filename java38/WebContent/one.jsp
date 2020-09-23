<%@page import="bean.MemberVO"%>
<%@page import="bean.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 1. id값 받아와야 함 -->
<!-- 2. DAO와 연동하여 결과 받아와야 함 -->
<!-- 3. html로 만들어서 전송해야함 -->
<%
	String id = request.getParameter("id");
	
	MemberDAO dao = new MemberDAO();
	MemberVO vo = dao.one(id);
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3><%=vo.getId() %>회원 정보 검색 내용입니다.</h3>
	<hr color="red">
	<table border="1">
		<tr bgcolor="green">
			<th width="100">아이디</th>
			<th width="100">패스워드</th>
			<th width="100">이름</th>
			<th width="100">연락처</th>
		</tr>
		<tr bgcolor="pink">
			<td><%=vo.getId() %></td>
			<td><%=vo.getPw() %></td>
			<td><%=vo.getName() %></td>
			<td><%=vo.getTel() %></td>
		</tr>
	</table>
	<hr color="red">
	<a href="index.html">
		<button style="background: orange">처음페이지로</button>
	</a>
	<a href="update.jsp?id=<%=vo.getId()%>">
		<button style="background: aqua">수정페이지로</button>
	</a>
	<a href="delete.jsp?id=<%=vo.getId()%>">
		<button style="background: lime">삭제페이지로</button>
	</a>
</body>
</html>