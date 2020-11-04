<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>게시물 하나 검색화면</h3>
<table border="1">
	<tr>
		<th width="100">no</th>
		<th width="100">title</th>
		<th width="100">content</th>
		<th width="100">writer</th>
	</tr>
	<tr>
		<td height="50">${one.no }</td>
		<td>${one.title }</td>
		<td>${one.content }</td>
		<td>${one.writer }</td>
	</tr>
</table>
<hr color="red">
<div id="d1" style="width: 300px; height: 300px; border: 1px solid green; background: lightgray">
	<table border="1">
		<c:forEach items="${list}" var="vo">
			<tr>
				<td width="100">${vo.no }</td>
				<td width="100">${vo.content }</td>
				<td width="100">${vo.writer }</td>
			</tr>
		</c:forEach>
	</table>
</div>
</body>
</html>