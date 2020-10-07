<%@page import="bean.NewsDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="vo" class="bean.NewsVO"></jsp:useBean>
<jsp:setProperty property="*" name="vo"/>
<%
NewsDAO dao = new NewsDAO();
boolean result = dao.create(vo);
%><%= result%>