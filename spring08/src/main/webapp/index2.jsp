<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>게시판검색.......</h3>
<a href="one.do">1번 게시글을 검색해보세요</a>
<a href="one.do?no=2">2번 게시글을 검색해보세요</a>
<a href="one.do?no=3">3번 게시글을 검색해보세요</a>
<hr color="red">
<!-- 태그 사이에 내용(content)이 비어있으면 : 빈태그 -->
<a href="index3.jsp"><button>이동할게요....</button></a><br>
<c:set var="str" value="너무 졸려요........힘들다........."></c:set>
6글자를 알려드릴게요.... → ${fn:substring(str, 0, 6) }<br>
길이는요...... → ${fn:length(str) }


<hr color="red">
<sql:setDataSource
	url="jdbc:mysql://localhost:3366/shop1"
	driver="com.mysql.jdbc.Driver"
	user="root"
	password="1234"
	scope="application"
	var="db"
/>
<sql:query var="list" dataSource="${db}">
select * from reply
</sql:query>

<c:forEach items="${list.rows }" var="vo">
	${vo.content},<br>
</c:forEach>



</body>
</html>