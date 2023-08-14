<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form>
<%
int num1 = Integer.parseInt(request.getParameter("num1"));
int num2 = Integer.parseInt(request.getParameter("num2"));
%>
<%
   for(int i=1;i<=num2;i++){ 
%>
  <h1><%=num1+"*"+i+"="+(num1*i) %></h1>
  
  <%} %>
</form>

</body>
</html>