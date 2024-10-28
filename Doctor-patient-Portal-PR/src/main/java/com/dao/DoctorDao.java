package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.entity.Doctor;

public class DoctorDao {

    private Connection conn;

    public DoctorDao(Connection conn) {
        this.conn = conn;
    }

    public boolean registerDoctor(Doctor doctor) {
        boolean f = false;
        try {

			String sql = "insert into doctor(fullName,dateOfBirth,qualification,specialist,email,phone,password) values(?,?,?,?,?,?,?)";

			PreparedStatement pstmt = this.conn.prepareStatement(sql);
			pstmt.setString(1, doctor.getFullName());
			pstmt.setString(2, doctor.getDateOfBirth());
			pstmt.setString(3, doctor.getQualification());
			pstmt.setString(4, doctor.getSpecialist());
			pstmt.setString(5, doctor.getEmail());
			pstmt.setString(6, doctor.getPhone());
			pstmt.setString(7, doctor.getPassword());

			pstmt.executeUpdate();
			// if query inserted or all ok than
			f = true;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
    }

    public List<Doctor> getAllDoctor() {
        List<Doctor> docList = new ArrayList<>();
        try {
            String sql = "SELECT * FROM doctor ORDER BY id DESC";
            PreparedStatement pstmt = this.conn.prepareStatement(sql);
            ResultSet resultSet = pstmt.executeQuery();
            while (resultSet.next()) {
                Doctor doctor = new Doctor();
                doctor.setId(resultSet.getInt("id"));
                doctor.setFullName(resultSet.getString("fullName"));
                doctor.setDateOfBirth(resultSet.getString("dateOfBirth"));
                doctor.setQualification(resultSet.getString("qualification"));
                doctor.setSpecialist(resultSet.getString("specialist"));
                doctor.setEmail(resultSet.getString("email"));
                doctor.setPhone(resultSet.getString("phone"));
                doctor.setPassword(resultSet.getString("password"));
                docList.add(doctor);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return docList;
    }

    public Doctor getDoctorById(int id) {
        Doctor doctor = null;
        try {
            String sql = "SELECT * FROM doctor WHERE id=?";
            PreparedStatement pstmt = this.conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet resultSet = pstmt.executeQuery();
            if (resultSet.next()) {
                doctor = new Doctor();
                doctor.setId(resultSet.getInt("id"));
                doctor.setFullName(resultSet.getString("fullName"));
                doctor.setDateOfBirth(resultSet.getString("dateOfBirth"));
                doctor.setQualification(resultSet.getString("qualification"));
                doctor.setSpecialist(resultSet.getString("specialist"));
                doctor.setEmail(resultSet.getString("email"));
                doctor.setPhone(resultSet.getString("phone"));
                doctor.setPassword(resultSet.getString("password"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return doctor;
    }

    public boolean updateDoctor(Doctor doctor) {
        boolean f = false;
        try {
            String sql = "UPDATE doctor SET fullName=?, dateOfBirth=?, qualification=?, specialist=?, email=?, phone=?, password=? WHERE id=?";
            PreparedStatement pstmt = this.conn.prepareStatement(sql);
            pstmt.setString(1, doctor.getFullName());
            pstmt.setString(2, doctor.getDateOfBirth());
            pstmt.setString(3, doctor.getQualification());
            pstmt.setString(4, doctor.getSpecialist());
            pstmt.setString(5, doctor.getEmail());
            pstmt.setString(6, doctor.getPhone());
            pstmt.setString(7, doctor.getPassword());
            pstmt.setInt(8, doctor.getId());
            pstmt.executeUpdate();
            f = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return f;
    }

    public boolean deleteDoctorById(int id) {
        boolean f = false;
        try {
            String sql = "DELETE FROM doctor WHERE id=?";
            PreparedStatement pstmt = this.conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            f = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return f;
    }

    public Doctor loginDoctor(String email, String password) {
        Doctor doctor = null;
        try {
            String sql = "SELECT * FROM doctor WHERE email=? AND password=?";
            PreparedStatement pstmt = this.conn.prepareStatement(sql);
            pstmt.setString(1, email);
            pstmt.setString(2, password);
            ResultSet resultSet = pstmt.executeQuery();
            if (resultSet.next()) {
                doctor = new Doctor();
                doctor.setId(resultSet.getInt("id"));
                doctor.setFullName(resultSet.getString("fullName"));
                doctor.setDateOfBirth(resultSet.getString("dateOfBirth"));
                doctor.setQualification(resultSet.getString("qualification"));
                doctor.setSpecialist(resultSet.getString("specialist"));
                doctor.setEmail(resultSet.getString("email"));
                doctor.setPhone(resultSet.getString("phone"));
                doctor.setPassword(resultSet.getString("password"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return doctor;
    }

    // Count methods using COUNT(*)
    public int countTotalDoctor() {
        return count("doctor");
    }

    public int countTotalAppointment() {
        return count("appointment");
    }

    public int countTotalUser() {
        return count("user_details");
    }

    public int countTotalSpecialist() {
        return count("specialist");
    }

    public int countTotalAppointmentByDoctorId(int doctorId) {
        int i = 0;
        try {
            String sql = "SELECT COUNT(*) FROM appointment WHERE doctorId=?";
            PreparedStatement pstmt = this.conn.prepareStatement(sql);
            pstmt.setInt(1, doctorId);
            ResultSet resultSet = pstmt.executeQuery();
            if (resultSet.next()) {
                i = resultSet.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

    private int count(String tableName) {
        int count = 0;
        try {
            String sql = "SELECT COUNT(*) FROM " + tableName;
            PreparedStatement pstmt = this.conn.prepareStatement(sql);
            ResultSet resultSet = pstmt.executeQuery();
            if (resultSet.next()) {
                count = resultSet.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }
}