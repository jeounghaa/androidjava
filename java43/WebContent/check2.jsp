<%@page import="bean.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><%
	String id = request.getParameter("id");
  MemberDAO dao = new MemberDAO();
  int result = dao.read(id);
  String i = "중복된 id입니다.";
  if(result == 0) {
	  i="사용가능한 id입니다.";
  }%><%=i%>