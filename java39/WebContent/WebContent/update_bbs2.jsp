<%@page import="bean.BbsVO"%>
<%@page import="bean.BbsDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int no = Integer.parseInt(request.getParameter("no"));
	BbsDAO dao = new BbsDAO();
	BbsVO vo = dao.one(no);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 글 수정</title>
<style type="text/css">
	th {
		background: black;
		color: white;
	}
</style>
</head>
<body>
	<form action="update_result.jsp">
		<table border="1">
			<tr>
				<th>NO</th>
				<td>
					<input type="text" name="no" value="<%= vo.getNo() %>" readonly="readonly">
				</td>
				<td rowspan="4">
					<button type="submit" style="height: 120px; background: red; color: white;">수정</button>
				</td>
			</tr>
			<tr>
				<th>TITLE</th>
				<td>
					<input type="text" name="title" value="<%= vo.getTitle() %>">
				</td>
			</tr>
			<tr>
				<th>CONTENT</th>
				<td>
					<input type="text" name="content" value="<%= vo.getContent() %>">
				</td>
			</tr>
			<tr>
				<th>WRITER</th>
				<td>
					<input type="text" name="writer" value="<%= vo.getWriter() %>">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>