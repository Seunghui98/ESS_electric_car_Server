<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="ess.ConnectDB3" %>
<%@ page import="ess.GwangjuEss" %>
<%@ page import="org.json.simple.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

</body>
</html>
<% 
	request.setCharacterEncoding("utf-8");
	String id = request.getParameter("ename");
	/*		
	if(request.getParameter("loginid") != null){
		id = request.getParameter("loginid");
	}
	*/
	System.out.print(id);
	ConnectDB3 connect = new ConnectDB3();
	
	int num = 0;
	num = connect.GwangjuEss();
	
	JSONObject[] ess = new JSONObject[num];
	JSONArray essArray = new JSONArray();
	for(int i=0;i<num;i++){
		GwangjuEss list = connect.esslist(i+1);
		ess[i] = new JSONObject();
		ess[i].put("name", list.getName());
		ess[i].put("address", list.getAddress());
		ess[i].put("gu", list.getGu());
		ess[i].put("dong", list.getDong());
		ess[i].put("latitude", list.getLatitude());
		ess[i].put("longitude", list.getLongitude());
		ess[i].put("now", list.getNow());
		//out.println(ev[i].toJSONString());
		//out.println();
		essArray.add(ess[i]);
		ess[i].toJSONString();
		
	}
	out.clear();
	out.println(essArray.toString());
	//response.getWriter().write(evArray.toString());
	
	
	
	
%>