/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import config.DBConnection;
import models.Enrollment;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author islam-bilisim
 */
public class EnrollmentDAO {

    public void addEn(Enrollment e) {
        try {
            Connection conn = DBConnection.getInstance().getConnection();           
            PreparedStatement ps = conn.prepareStatement("INSERT INTO enrollment (student_id,course_id,enrollment_date) VALUES(?,?,?)");
            ps.setInt(1, e.getStudentid());
            ps.setInt(2, e.getCourseid());
            ps.setDate(3, new java.sql.Date(e.getEnrollmentdate().getTime()));

            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EnrollmentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void updateEn(Enrollment e) {
        try {
            Connection conn = DBConnection.getInstance().getConnection();
            PreparedStatement ps = conn.prepareStatement("UPDATE enrollment SET student_id=?, course_id=?,enrollment_date=? WHERE enrollment_id =?");
            ps.setInt(1, e.getStudentid());
            ps.setInt(2, e.getCourseid());
            ps.setDate(3, new java.sql.Date(e.getEnrollmentdate().getTime()));
            ps.setInt(4, e.getEnrollment_id());
   ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EnrollmentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void deletEn(int enrollment_id) throws SQLException {

        try {
            Connection conn = DBConnection.getInstance().getConnection();


            PreparedStatement ps = conn.prepareStatement("DELETE FROM enrollment WHERE enrollment_id=?");
            ps.setInt(1, enrollment_id);
               ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EnrollmentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Enrollment> getAllEnrollment() throws SQLException {
        Connection conn = DBConnection.getInstance().getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM enrollment;");
        List<Enrollment> list = new ArrayList<>();
        while (rs.next()) {

            Enrollment e = new Enrollment(
                    rs.getInt("enrollment_id"),
                    rs.getInt("student_id"), 
                    rs.getInt("course_id"),
                    rs.getDate("enrollment_date")
            );
            list.add(e);
        }
        return list;
    }

}
