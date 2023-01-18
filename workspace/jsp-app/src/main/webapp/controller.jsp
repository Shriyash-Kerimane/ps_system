<%@page import="com.demo.web.util.Authenticator"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:useBean id="auth" class="com.demo.web.util.Authenticator"
	scope="session" />

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:setProperty property="username" name="auth" value='<%=request.getParameter("username") %>'/>
<jsp:setProperty property="password" name="auth" value='<%=request.getParameter("password") %>'/>
<%
if(((Authenticator) session.getAttribute("auth")).isLoggedIn()){
%>
<jsp:forward page="success.jsp" />
<% 
}else{
%>
<jsp:forward page="fail.jsp" />
<%
}	
%>

</body>
</html>