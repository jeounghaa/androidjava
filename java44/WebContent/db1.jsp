<%@page import="bean.MemberDAO2"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="vo2" class="bean.MemberVO2"></jsp:useBean>
<jsp:setProperty property="*" name="vo2"/>
<%
	MemberDAO2 dao = new MemberDAO2();
	boolean result = dao.create(vo2);
%><%=result%>