<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>연습할게요....</title>
</head>
<body>

소숫점....<fmt:formatNumber value="11111.333456" pattern="0.0000"></fmt:formatNumber><br>
<c:set var="date" value="<%= new Date() %>" />
날짜나오게...<fmt:formatDate value="${date}" type="date" dateStyle="full"/><br>


<sql:setDataSource
	url="jdbc:mysql://localhost:3366/shop1"
	driver="com.mysql.jdbc.Driver"
	user="root"
	password="1234"
	scope="application"
	var="db"
/>

<sql:update dataSource="${db}">
 insert into bbs values(null, '너무 졸리다..', '피곤해요...', 'ogillinghamd')
</sql:update>
</body>
</html>