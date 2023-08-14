package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet
public class Tables extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	int num1=Integer.parseInt(req.getParameter("num1"));
	int num2=Integer.parseInt(req.getParameter("num2"));
	
	for(int i=1;i<=num2;i++)
	{
	  
	}

	}
}
