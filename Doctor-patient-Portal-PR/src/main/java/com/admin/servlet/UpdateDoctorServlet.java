package com.admin.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.DoctorDao;
import com.db.DBConnection;
import com.entity.Doctor;

@WebServlet("/updateDoctor")
public class UpdateDoctorServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            // Get all data coming from doctor.jsp doctor details
            String fullName = req.getParameter("fullName");
            String dateOfBirth = req.getParameter("dateOfBirth");
            String qualification = req.getParameter("qualification");
            String specialist = req.getParameter("specialist");
            String email = req.getParameter("email");
            String phone = req.getParameter("phone");
            String password = req.getParameter("password");

            // Get ID for updating the doctor details
            int id = Integer.parseInt(req.getParameter("id"));

            // Create a Doctor object with the retrieved data
            Doctor doctor = new Doctor(id, fullName, dateOfBirth, qualification, specialist, email, phone, password);

            // Create a DoctorDao instance and update the doctor
            DoctorDao docDAO = new DoctorDao(DBConnection.getConn());
            boolean f = docDAO.updateDoctor(doctor);

            HttpSession session = req.getSession();

            if (f) {
                session.setAttribute("successMsg", "Doctor updated successfully");
                resp.sendRedirect("admin/view_doctor.jsp");
            } else {
                session.setAttribute("errorMsg", "Something went wrong on server!");
                resp.sendRedirect("admin/view_doctor.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
            // Optionally, you could set an error message in the session here
            HttpSession session = req.getSession();
            session.setAttribute("errorMsg", "An error occurred while updating the doctor.");
            resp.sendRedirect("admin/view_doctor.jsp");
        }
    }
}