package com.doctor.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.DoctorDao;
import com.dao.UserDao;
import com.db.DBConnection;
import com.entity.Doctor;


@WebServlet("/doctorLogin")
public class DoctorLoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//get email and password which is coming from doctor_login.jsp page
		String email = req.getParameter("email");
		String password = req.getParameter("password");

		//create session
		HttpSession session = req.getSession();

		//create DB connection
		DoctorDao docDao = new DoctorDao(DBConnection.getConn());
		
		//call loginDoctor() method for doctor login which method declared in DoctorDAO 
		Doctor doctor = docDao.loginDoctor(email, password);

		if (doctor != null) {
			//means doctor is valid or exist
			//then store particular logged in doctor object in session
			session.setAttribute("doctorObj", doctor);
			//and redirect the particular doctor index page which is reside doctor folder
			resp.sendRedirect("doctor/index.jsp");//doctor index means dashboard of doctors
		} else {
			session.setAttribute("errorMsg", "Invalid email or password");
			resp.sendRedirect("doctor-login.jsp");
		}

	}

}
