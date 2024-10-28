package com.users.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDao;
import com.db.DBConnection;
import com.entity.User;

@WebServlet("../userLogin")
public class UserLogin  extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		HttpSession session = req.getSession();
		
		UserDao dao=new UserDao(DBConnection.getConn());
		User users=dao.loginUser(email, password);
		
		//logic for a static Admin
		if (users!=null) {
			
			//if "adminObj" obj available then give the access of admin page, 
			//otherwise "adminObj" is not present in obj then others user is login(which is not admin). so dont give him the access of Admin.
			//the below line specially check the admin is log in or not! "adminObj" object is available that means admin is log in.
			session.setAttribute("userObj", users);
			resp.sendRedirect("index.jsp");
		}
		else {
			session.setAttribute("errorMsg", "Invalid Username or Password.");
			resp.sendRedirect("user_login.jsp");
		}
		
	}

}