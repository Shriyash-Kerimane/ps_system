<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <form action="">
        <span>Username</span><input name="name"><br />
        <span>Password</span><input name="pass"><br />
        <input type="submit" value="Add"><br />
   </form>
   <%
    String name = request.getParameter("name");
    String pass = request.getParameter("pass");
    
   if (name != null || pass != null && !name.equals("") && !pass.equals("")) {
       if (name.equals(pass)) {
    %>
    <jsp:forward page="success.jsp" />
   <%
    } else {
    %>
    <jsp:forward page="fail.jsp" />
    <%
    }
   }
    %>
</body>
</html>