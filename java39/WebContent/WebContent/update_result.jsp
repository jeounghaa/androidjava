<%@page import="bean.BbsDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="vo" class="bean.BbsVO"></jsp:useBean>
<jsp:setProperty property="*" name="vo"/> 
<%
	BbsDAO dao = new BbsDAO();
	boolean result = dao.update(vo);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 글 수정 처리</title>
</head>
<body>
<h3>업데이트 결과는 <%= result %>입니다.!</h3><br>
<a href="index.html"><button>처음으로</button></a>
</body>
</html>