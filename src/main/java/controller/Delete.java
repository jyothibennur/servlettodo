package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import dto.MyUser;
import dto.Task;
@WebServlet("/deletestatus")
public class Delete extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MyUser user=(MyUser) req.getSession().getAttribute("user");
		if (user == null) {
			resp.getWriter().print("<h1>seesion expired,login again</h1>");
			req.getRequestDispatcher("Login.html").include(req, resp);
		} else {
			int id = Integer.parseInt(req.getParameter("id"));
			UserDao dao = new UserDao();
			Task task = dao.fetchTask(id);
			
			dao.remove(task);   
		
//			MyUser user2=dao.findByEmail(user.getEmail());
			req.getSession().setAttribute("user",user);
            resp.getWriter().print("<h1>status removed sucessfully</h1>");
            req.setAttribute("list", user.getTask());
            req.getRequestDispatcher("homejsp.jsp").include(req, resp);
		}

	}


}
