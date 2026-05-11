/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.util.Date;

/**
 *
 * @author islam-bilisim
 */
public class Enrollment {

    public void setEnrollment_id(int enrollment_id) {
        this.enrollment_id = enrollment_id;
    }

    public int getEnrollment_id() {
        return enrollment_id;
    }
    private int enrollment_id;
    private int student_id;
    private int course_id;
    private Date enrollment_date;

    public Enrollment(int enrollment_id, int student_id, int course_id1, Date enrollment_date) {
        this.enrollment_id = enrollment_id;
        this.student_id = student_id;
        this.course_id = course_id1;
        this.enrollment_date = enrollment_date;
    }

    public void setStudentid(int student_id) {
        this.student_id = student_id;
    }

    public void setCourseid(int course_id) {
        this.course_id = course_id;
    }

    public void setEnrollmentdate(Date enrollment_date) {
        this.enrollment_date = enrollment_date;
    }

    public int getStudentid() {
        return student_id;
    }

    public int getCourseid() {
        return course_id;
    }

    public Date getEnrollmentdate() {
        return enrollment_date;
    }

}
