<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><%
	String payment = request.getParameter("payment");
  double money = 10000;
  int m = 0;
  if(payment.equals("신용카드")) {
	 m = (int)(money*0.9);
  } else if(payment.equals("휴대폰결제")) {
	 m = (int)(money*0.8);
  }
%><%=m%>