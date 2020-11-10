<%@page import="org.json.simple.JSONArray"%>
<%@page import="org.json.simple.JSONObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	JSONObject jobject1 = new JSONObject();
	jobject1.put("id", "root");
	jobject1.put("pw", "1234");
	jobject1.put("name", "park");
	jobject1.put("tel", "011");
	
 	JSONObject jobject2 = new JSONObject();
	jobject2.put("id", "root1");
	jobject2.put("pw", "12341");
	jobject2.put("name", "park1");
	jobject2.put("tel", "0111");
	
	JSONArray array = new JSONArray();
	array.add(0, jobject1);
	array.add(1, jobject2);
	
	JSONObject main = new JSONObject();
	main.put("array", array);
	
	out.println(main.toJSONString());
%>