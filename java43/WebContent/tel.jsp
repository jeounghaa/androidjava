<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><%
    
    String tel =  request.getParameter("tel");
    String check = tel.substring(0,3);
    double r = (Math.random()*9000)+1000;//최소 4자리 만들기
    String result = "";
    if(check.equals("010")){
    	result = "11" + (int)r;
    }else if(check.equals("011")){
    	result = "22" + (int)r;
    }else{
    	result = "33" + (int)r;
    }
    %><%=result%>