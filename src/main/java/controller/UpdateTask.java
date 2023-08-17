package controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import dto.MyUser;
import dto.Task;

@WebServlet("/updatetask")
public class UpdateTask extends HttpServlet{
	
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	 MyUser user=(MyUser) req.getSession().getAttribute("user");
		if (user == null) {
			resp.getWriter().print("<h1>seesion expired,login again</h1>");
			req.getRequestDispatcher("Login.html").include(req, resp);
		} else {
//			logic to fetch task object
			int id = Integer.parseInt(req.getParameter("id"));
			String taskname=req.getParameter("taskname");
			String taskdescription=req.getParameter("taskdescription");
			int nofdays=Integer.parseInt(req.getParameter("num"));
			
		   Task task=new Task();
		   task.setId(id);
		   task.setName(taskname);
		   task.setDescription(taskdescription);
		   task.setTaskDate(LocalDate.now());
		   task.setCompletiondate(LocalDate.now().plusDays(nofdays));
		   
		   UserDao dao=new UserDao();
		   dao.update(task);
		   
		   MyUser user2=dao.findByEmail(user.getEmail());
			req.getSession().setAttribute("user",user2);
           resp.getWriter().print("<h1>updated sucessfully</h1>");
           req.setAttribute("list", user2.getTask());
           req.getRequestDispatcher("homejsp.jsp").include(req, resp);
		
}
}
}

