<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><%
	
    String pw = request.getParameter("pw");
    String pwch = request.getParameter("pwch");
    String result = "비밀번호가 맞지 않습니다.";
    if(pw.equals(pwch)){
    	result = "비밀번호가 일치합니다.";
    }
    %><%= result %>