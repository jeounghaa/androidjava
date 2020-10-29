<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
나는 수정하는 페이지입니다..<br>
검색결과: 
<table border=1>
	<tr>
		<th width="80">no</th>
		<td width="120">${vo.no}</td>
	</tr>
	<tr>
		<th>title</th>
		<td>${vo.title}</td>
	</tr>
	<tr>
		<th>content</th>
		<td>${vo.content}</td>
	</tr>
	<tr>
		<th>writer</th>
		<td>${vo.writer}</td>
	</tr>
</table>
<a href="index.jsp">첫 페이지로</a>
</body>
</html>