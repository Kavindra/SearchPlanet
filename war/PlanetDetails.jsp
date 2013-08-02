<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2 align = "center"> Planet Details-V3</h2>

<%
	String jsonstring = (String)request.getAttribute("jsonstring");
	//List<String> excerpts = (List<String>)request.getAttribute("excerpts");
	String excerpts = (String)request.getAttribute("excerpts");
	
	//out.println("<br><h3 align = \"center\">Results</h3>");
	out.println("<table width = \"70%\" align = \"center\" border = \"1\">");
	out.println("<tr><td>" + excerpts + "</td></tr>");
	out.println("</table><br><br>");
	/*
	out.println("<table width = \"70%\" align = \"center\" border = \"1\">");
	out.println("<tr><td>Excerpts</td></tr>");
	for(String excerpt:excerpts)
	{
		out.println("<tr><td>" + excerpt + "</td></tr>");
	}
	out.println("</table><br><br>");*/

%>
</body>
</html>