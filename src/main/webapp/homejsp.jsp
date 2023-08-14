<%@page import="dto.Task"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%List<Task> tasks=(List<Task>)request.getAttribute("list"); %>

    <table border="1" cellspacing="10px" cellpadding="5px">
      <center><h1>Welcome to TODO Home</h1></center>
      <tr>
       <th>Id</th>
       <th>TaskName</th>
       <th>TaskDescription</th>
       <th>TaskDate</th>
       <th>CompletionDate</th>
       <th>Status</th>
       <th>Change</th>
       <th>Update</th>
       <th>Delete</th>
       </tr>
       
        <%
           for(Task task:tasks){ 
        %>
       <tr>
       <td><%=task.getId() %></td>
       <td><%=task.getName() %></td>
       <td><%=task.getDescription() %></td>
       <td><%=task.getTaskDate() %></td>
       <td><%=task.getCompletiondate() %></td>
       <td><%if(task.isStatus())%>completed<%else %>Not completed</td>
       <th><a href="changestatus?id=<%=task.getId()%>"><button>change</button></a></th>
       <th><a href="updatestatus?id=<%=task.getId()%>"><button>update</button></a></th>
       <th><a href="deletestatus?id=<%=task.getId()%>"><button>delete</button></a></th>
       </tr>
       <%} %>
       
       </table>
       
    
    <a href="tasksession"><button>AddTask</button></a>
       <a href="logout"><button>Logout</button></a>
      
     
</body>
</html>