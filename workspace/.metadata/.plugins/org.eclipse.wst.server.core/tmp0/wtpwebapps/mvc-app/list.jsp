
<%@page import="java.util.List"%>
<%@page import="com.demo.web.Emp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List Page</title>
</head>
<body>
	<% 
	List<Emp> elist=(List)session.getAttribute("eList");
	if (elist.size()!=0){
	for(Emp e: elist ){
		out.println(e.getEmpId()+" "+e.getName()+" "+e.getCity());
	}
		
	}else{
		out.println("No data");
	}
%>

</body>
</html>