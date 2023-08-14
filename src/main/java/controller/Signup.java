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

@WebServlet("/signup")
public class Signup extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String number = req.getParameter("number");
		String gender = req.getParameter("gender");
		String dob = req.getParameter("dob");
		String adress = req.getParameter("adress");
		String pwd = req.getParameter("password");
		String[] lang = req.getParameterValues("language");

		MyUser user = new MyUser();
		user.setAdress(adress);
		user.setDob(LocalDate.parse(dob));
		user.setEmail(email);
		user.setGender(gender);
		user.setLanguage(lang);
		user.setMobile(Long.parseLong(number));
		user.setName(name);
		user.setPwd(pwd);
		
//		verify to email doesn't exist
	                           

		UserDao dao = new UserDao();
		MyUser myuser=dao.findByEmail(email);
		if(myuser==null)
		{
			dao.save(user);
			resp.getWriter().print("<h1 style=\"color:green\">Account Created Success</h1>");
			req.getRequestDispatcher("Login.html").include(req, resp);
		}
		else
		{
			resp.getWriter().print("<h1 style=\"color:green\">email should not be repeated</h1>");
			req.getRequestDispatcher("signup.html").include(req, resp);
		}

		

	}

}
