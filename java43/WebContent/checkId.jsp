<%@page import="bean.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><%
	MemberDAO dao = new MemberDAO();
  String id = request.getParameter("id");
  int i = dao.read(id);
  String result = "사용가능한 id입니다.";
  if(i == 1) {
	  result = "중복된 id입니다.";
  }
%><%=result%>