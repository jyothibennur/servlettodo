<%@page import="java.time.Period"%>
<%@page import="dto.Task"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
Task task=(Task)request.getAttribute("task");
%>
<form action="updatetask" method="post">
<th><input type="text" name="id" value=<%=task.getId() %> hidden required></th>
      <fieldset>
      <table>
      <tr>
      <th><label for="name">Task Name</label></th>
      <th><input type="text" id="task" name="taskname" placeholder="task name" value="<%=task.getName() %>" required></th>
      </tr>
      
      <tr>
      <th><label for="task">Task Description</label></th>
      <th><input type="text" id="task" name="taskdescription" placeholder="task description"  value="<%=task.getDescription() %>" required></th>
      </tr>
      
      <tr>
      <th><label for="num">No of days  <br>required to complete task</label></th>
      <th><input type="text" id="num" name="num" placeholder="task name" value="<%=Period.between(task.getTaskDate(),task.getCompletiondate()).getDays()%>" required></th>
      </tr>
      
      <tr>
      <th><button>update</button></th>
      <th><button type="reset">Cancel</button></th>
      </tr>
      
      </table>
      </fieldset>
    </form><br>
   
    <a href="backhome"><button>Back</button></a>
</body>
</html>