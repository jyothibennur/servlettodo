package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import dao.UserDao;
import dto.MyUser;
import dto.Task;
@WebServlet("/Addtask")
public class AddTask extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MyUser user=(MyUser) req.getSession().getAttribute("user");
		if (user == null) {
			resp.getWriter().print("<h1>seesion expired,login again</h1>");
			req.getRequestDispatcher("Login.html").include(req, resp);
		} else {

		String taskname=req.getParameter("taskname");
		String taskdescription=req.getParameter("taskdescription");
		int nofdays=Integer.parseInt(req.getParameter("num"));
		
	   Task task=new Task();
	   task.setName(taskname);
	   task.setDescription(taskdescription);
	   task.setTaskDate(LocalDate.now());
	   task.setCompletiondate(LocalDate.now().plusDays(nofdays));
	   
	   
	   MyUser myUser=(MyUser)req.getSession().getAttribute("user");
	   List<Task>list=myUser.getTask();
	   if(list==null)
		   list=new ArrayList<Task>();
	       list.add(task);
	       
	      myUser.setTask(list);
	      
	      UserDao dao=new UserDao();
		   dao.save(task);
		  dao.update(myUser);
	   
	   MyUser user2=dao.findByEmail(user.getEmail());
	   req.getSession().setAttribute("task", user2);
	   
	   resp.getWriter().print("<h1 style='color:green'>Task added sucessfully</h1>");
	   req.setAttribute("list", myUser.getTask());
	   req.getRequestDispatcher("homejsp.jsp").include(req, resp);
	   
		
	}
	
    

}
}
