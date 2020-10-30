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
<h3>회원 검색 정보입니다.</h3>
<table border=1>
	<tr>
		<th width="150">id</th>
		<th width="150">pw</th>
		<th width="150">name</th>
		<th width="150">tel</th>
	</tr>
	<c:forEach var="vo" items="${list}">
	<tr>
		<td>${vo.id}</td>
		<td>${vo.pw}</td>
		<td>${vo.name}</td>
		<td>${vo.tel}</td>
	</tr>
	</c:forEach>
</table>
<%-- 회원 id: ${vo.id} <br>
회원 pw: ${vo.pw}<br>
회원 name: ${vo.name}<br>
회원 tel: ${vo.tel} --%>
</body>
</html>