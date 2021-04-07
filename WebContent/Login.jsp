<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="ess.ConnectDB"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="org.json.simple.*" %>
<%@ page import="ess.User" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
</body>
</html>

<%
	request.setCharacterEncoding("UTF-8");
	String id = request.getParameter("id");
	/*		
	if(request.getParameter("loginid") != null){
		id = request.getParameter("loginid");
	}
	*/
	System.out.print(id);
	String pwd = request.getParameter("password");
	/*
	if(request.getParameter("loginpwd") != null){
		pwd = request.getParameter("loginpwd");
	}
	*/
	System.out.print(pwd);
	ConnectDB connectDB = ConnectDB.getInstance();
	String returns = "";
	returns = connectDB.logindb(id, pwd);
	out.clear();
	out.println(returns);
	
	
	
	
 %>