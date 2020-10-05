<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><%
    //파라메터값 받아주고
    String id =  request.getParameter("id");
    //replyDAO로 댓글을 저장처리
    //성공하면 저장된 데이터를 전송
    int length = id.length(); 
    String result = length +" "; 
    %><%= result %>