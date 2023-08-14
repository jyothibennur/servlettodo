package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/tasksession")
public class Tasksession extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	if(req.getSession().getAttribute("user")==null) {
			   resp.getWriter().print("<h1>seesion expired,login again</h1>");
		   req.getRequestDispatcher("Login.html").include(req, resp);
	}
	else
	{
	  req.getRequestDispatcher("AddTask.html").forward(req, resp);
	}

	}

    }

