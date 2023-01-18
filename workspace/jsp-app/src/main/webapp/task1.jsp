<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Repeated printing</title>
</head>
<body>
	<form action="">
		<span>Enter repeating number</span><input name="num"><br /> <input
			type="submit" value="Go"><br />
	</form>
	<hr>
	<%
		String num = request.getParameter("num");
		if(num!=null && !num.equals("")){
		for(int i =0;i<Integer.parseInt(num);i++){%>
			<h3>Hello World</h3>	
		<%}
		
		}%>
	<hr>
</body>
</html>