<%@page import="bean.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><%
	String id = request.getParameter("id");
  MemberDAO dao = new MemberDAO();
  int result = dao.read(id);%><%=result%>