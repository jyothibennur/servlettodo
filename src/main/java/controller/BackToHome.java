package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.MyUser;

@WebServlet("/backhome")
public class BackToHome extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 MyUser user=(MyUser) req.getSession().getAttribute("user");
		 if(user==null)
		 {
			 resp.getWriter().print("<h1>session expired,login again");
			 req.getRequestDispatcher("Login.html").include(req, resp);
		 }
		 else
		 {
			 req.setAttribute("list", user.getTask());
			 req.getRequestDispatcher("homejsp.jsp").include(req, resp);
		 }
	}
	

}
