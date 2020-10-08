<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!--
		표현식(Expression) 
			-> Expression Language(EL): 속성을 지정된 경우에만 프린트 가능 
	-->
	설정된 세션 id는 <%= session.getAttribute("id") %><br>
	설정된 앱 count는 <%=application.getAttribute("count") %><br>
	설정된 세션 name은 ${name}
</body>
</html>