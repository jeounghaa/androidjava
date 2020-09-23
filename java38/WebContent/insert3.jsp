<%@page import="bean.BbsVO"%>
<%@page import="bean.BbsDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="vo" class="bean.BbsVO"></jsp:useBean>
<jsp:setProperty property="*" name="vo"/>
<%
	BbsDAO dao = new BbsDAO();
	boolean result = dao.create(vo);
	// 4. 처리결과를 client 알려주어야함
	String check = "작성 실패";
	if(result) {
		check = "작성 성공";
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bbs</title>
</head>
<body>
<h3>게시판 <%=check %>입니다!</h3>
<a href="bbs.html">게시판 글 작성하러 가기</a>
</body>
</html>