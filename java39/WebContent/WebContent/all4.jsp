<%@page import="bean.BbsVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="bean.BbsDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	BbsDAO dao = new BbsDAO();
	ArrayList<BbsVO> list = dao.all();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 전체 검색</title>
<style type="text/css">
	th {
		width: 100px;
		background: purple;
		color: white;
	}
	td {
		background: teal;
		text-align: center;
		color: white;
	}
</style>
</head>
<body>
	<table border="1">
		<tr>
			<th>NO</th>
			<th>TITLE</th>
			<th>CONTENT</th>
			<th>WRITER</th>
		</tr>
		<%
			for(int i = 0; i < list.size(); i++) {
				BbsVO vo = list.get(i);
		%>
		<tr>
			<td><%=vo.getNo() %></td>
			<td><%=vo.getTitle() %></td>
			<td><%=vo.getContent() %></td>
			<td><%=vo.getWriter() %></td>
		</tr>
		<%
			}
		%>
	</table><br>
	<a href="index.html"><button>처음으로</button></a>
</body>
</html>