<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>게시글</h3>
<table border=1>
	<tr>
		<th width="80">no</th>
		<td width="120">${bbsVO.no}</td>
	</tr>
	<tr>
		<th>title</th>
		<td>${bbsVO.title}</td>
	</tr>
	<tr>
		<th>content</th>
		<td>${bbsVO.content}</td>
	</tr>
	<tr>
		<th>writer</th>
		<td>${bbsVO.writer}</td>
	</tr>
</table>
<a href="index.jsp">첫페이지</a>
<a href="update.do">수정하는 페이지</a>
<a href="delete.do">삭제하는 페이지</a>
</body>
</html>