<%@page import="bean.BbsVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="bean.BbsDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	String title = request.getParameter("title");
	BbsDAO dao = new BbsDAO();
	ArrayList<BbsVO> list = dao.all(title);
%>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 글 제목 검색</title>
<style type="text/css">
	th {
		width: 100px;
		background: white;
	}
	td {
		background: black;
		color: white;
		text-align: center;
	}
</style>
</head>
<body>
	<h3><%=title %>로 검색한 결과</h3>
	<table border = "1">
		<tr>
			<th>NO</th>
			<th>TITLE</th>
			<th>CONTENT</th>
			<th>WRITER</th>
		</tr>
<%
		for (int i = 0; i < list.size(); i++) {
			BbsVO vo = list.get(i);			
%>
		<tr>
			<td><%=vo.getNo() %></td>
			<td><%=vo.getTitle() %></td>
			<td><%=vo.getContent() %></td>
			<td><%=vo.getWriter() %></td>
		</tr>
	</table>
<%
		}
%>
	<a href="index.html"><button>처음으로</button></a>
</body>
</html>