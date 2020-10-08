<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	설정된 세션 id는 <%= session.getAttribute("id") %><br>
	설정된 앱 count는 <%=application.getAttribute("count") %>
</body>
</html>