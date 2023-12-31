package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.jni.User;

import dao.UserDao;
import dto.MyUser;
import dto.Task;

@WebServlet("/changestatus")
public class Change extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MyUser user=(MyUser) req.getSession().getAttribute("user");
		if (user == null) {
			resp.getWriter().print("<h1>seesion expired,login again</h1>");
			req.getRequestDispatcher("Login.html").include(req, resp);
		} else {
//			logic to fetch task object
			int id = Integer.parseInt(req.getParameter("id"));
			UserDao dao = new UserDao();
			Task task = dao.fetchTask(id);
//			logic to change status
			if (task.isStatus()) 
				task.setStatus(false);
			 else 
                task.setStatus(true);
//			 logic to update in database  
			dao.update(task);
//			logic to update session
			MyUser user2=dao.findByEmail(user.getEmail());
			req.getSession().setAttribute("user",user2);
            resp.getWriter().print("<h1>status changed sucessfully</h1>");
//            to carry the data to home.jsp page
            req.setAttribute("list", user2.getTask());
            req.getRequestDispatcher("homejsp.jsp").include(req, resp);
		}
	}
}
