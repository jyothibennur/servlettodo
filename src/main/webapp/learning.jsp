<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
      <%--comment --%>
     <!-- System.out.println("hello"); -->
     
     <%--Scriptlet tag --%>
     <%-- <% System.out.println("this is java code");%> --%>
     
     <%--declarative tag --%>
     <%-- <%! int a=5 ;%> --%>
     <%!int b=6; %>
     <%System.out.print(b); %>
     
     <%--Expression tag --%>
     <h1><%=new Random().nextInt(100,999) %></h1>
     
 </body>
</html>