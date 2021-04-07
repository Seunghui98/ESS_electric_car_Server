<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="ess.ConnectDB2" %>
<%@ page import="ess.GwangjuEv" %>
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
	ConnectDB2 connect = new ConnectDB2();
	
	int num = 0;
	num = connect.GwangEv();
	
	JSONObject[] ev = new JSONObject[num];
	JSONArray evArray = new JSONArray();
	for(int i=0;i<num;i++){
		GwangjuEv list = connect.evlist(i+1);
		ev[i] = new JSONObject();
		ev[i].put("name", list.getName());
		ev[i].put("address", list.getAddress());
		ev[i].put("gu", list.getGu());
		ev[i].put("dong1", list.getDong1());
		ev[i].put("dong2", list.getDong2());
		ev[i].put("latitude", list.getLatitude());
		ev[i].put("longitude", list.getLongitude());
		ev[i].put("facility", list.getFacility());
		ev[i].put("now", list.getNow());
		//out.println(ev[i].toJSONString());
		//out.println();
		evArray.add(ev[i]);
		ev[i].toJSONString();
		
	}
	out.clear();
	out.println(evArray.toString());
	//response.getWriter().write(evArray.toString());
	
	
	
	
%>