package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import dao.UserDao;
import dto.MyUser;
import dto.Task;

@WebServlet("/login")
public class Login extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    String email=req.getParameter("email");
		String password=req.getParameter("password");
		 
		UserDao dao = new UserDao();
		MyUser user=dao.findByEmail(email);
		if(user==null)
		{
		   resp.getWriter().print("<h1 style=\"color:green\">Incorrect Email</h1>");
		   req.getRequestDispatcher("Login.html").include(req, resp);
		}
		else {
			if(user.getPwd().equals(password))
	       {
		    req.getSession().setAttribute("user", user);
		    req.getSession().setMaxInactiveInterval(10);
			resp.getWriter().print("<h1 style=\"color:green\">login sucess</h1>");
			
		     
			req.setAttribute("list",user.getTask());
//			we can write like this also list is just a key value we can give any value
//			req.setAttribute("list", dao.fetchAllTask());
			
	        req.getRequestDispatcher("homejsp.jsp").include(req, resp);
		    }
			else {
				resp.getWriter().print("<h1 style=\"color:green\">Incorrect password</h1>");
				req.getRequestDispatcher("Login.html").include(req, resp);
		   }
		}
		
     }
  }
