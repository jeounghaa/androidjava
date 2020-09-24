<%@page import="java.util.List"%>
<%@page import="bean.MemberVO"%>
<%@page import="bean.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- DAO를 이용해서 결과를 ArrayList로 받아온 후 html을 만든다 -->
<%
	MemberDAO dao = new MemberDAO();
	List<MemberVO> list = dao.all();
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전체 검색</title>
<style type="text/css">
	th {
		width: 100px;
		background: gray;
	}
	td {
		text-align: center;
		background: silver;
	}
</style>
</head>
<body>
	<h3 style="color:green;">검사결과의 개수는 <%=list.size() %>개</h3>
	<table border="1">
	<tr>
		<th>아이디</th>
		<th>비밀번호</th>
		<th>이름</th>
		<th>전화번호</th>
	</tr>
	<% 
		for(int i = 0; i < list.size(); i++) { 
		MemberVO vo = list.get(i);
	%>
	<tr>
		<td><%=vo.getId() %></td>
		<td><%=vo.getPw() %></td>
		<td><%=vo.getName() %></td>
		<td><%=vo.getTel() %></td>
	</tr>
<%-- 	검색된 id <%=vo.getId() %><br>
	검색된 pw <%=vo.getPw() %><br>
	검색된 name <%=vo.getName() %><br>
	검색된 tel <%=vo.getTel() %><br> --%>
<%--  검색된 id <%=list.get(i).getId() %><br>
	검색된 pw <%=list.get(i).getPw() %><br>
	검색된 name <%=list.get(i).getName() %><br>
	검색된 tel <%=list.get(i).getTel() %><br> --%>
<!-- 	<hr> -->
	<% } %>
	</table>
</body>
</html>