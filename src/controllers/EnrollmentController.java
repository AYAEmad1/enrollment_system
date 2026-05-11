/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controllers;

import dao.EnrollmentDAO;
import java.net.URL;
import java.sql.SQLException;
import java.text.spi.CollatorProvider;
import java.util.Collection;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import models.Enrollment;

/**
 * FXML Controller class
 *
 * @author islam-bilisim
 */
public class EnrollmentController implements Initializable {

    @FXML
    private TextField studentidtxt;
    @FXML
    private TextField cousreistxt;
    @FXML
    private TextField enrolldateidtxt;
    @FXML
    private TableView<Enrollment> tableid;
    @FXML
    private TableColumn<Enrollment, Integer> colId, colstid, colcourseid;
    @FXML
    private TableColumn<Enrollment, java.sql.Date> colendateid;

    /**
     * Initializes the controller class.
     */
    private EnrollmentDAO dao = new EnrollmentDAO();

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        colId.setCellValueFactory(new PropertyValueFactory<>("enrollment_id"));
        colstid.setCellValueFactory(new PropertyValueFactory<>("studentid"));
        colcourseid.setCellValueFactory(new PropertyValueFactory<>("courseid"));
        colendateid.setCellValueFactory(new PropertyValueFactory<>("enrollmentdate"));

        try {
            tableid.getItems().setAll(dao.getAllEnrollment());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    private void addbtn(ActionEvent event) {
        try {
            int Student_id = Integer.parseInt(studentidtxt.getText());
            int course_id = Integer.parseInt(cousreistxt.getText());
            Date date = java.sql.Date.valueOf(enrolldateidtxt.getText());
            Enrollment e = new Enrollment(0, Student_id, course_id, date);
            dao.addEn(e);
            System.out.println("Enrollment added successfully");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    private void updatebtn(ActionEvent event) {
        try {
            Enrollment selected = tableid.getSelectionModel().getSelectedItem();
            if (selected != null) {
                selected.setStudentid(Integer.parseInt(studentidtxt.getText()));
                selected.setCourseid(Integer.parseInt(cousreistxt.getText()));
                selected.setEnrollmentdate(java.sql.Date.valueOf(enrolldateidtxt.getText()));

                dao.updateEn(selected);
                tableid.getItems().setAll(dao.getAllEnrollment());
                System.out.println("Enrollment update successfully");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    @FXML
    private void deletebtn(ActionEvent event) {
        try {
            Enrollment selected = tableid.getSelectionModel().getSelectedItem();
            if (selected != null) {
                dao.deletEn(selected.getEnrollment_id());
                tableid.getItems().setAll(dao.getAllEnrollment());
                System.out.println("Enrollmentdeleted successfully");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    @FXML
    private void viewbtn(ActionEvent event) {
        try {
            tableid.getItems().setAll(dao.getAllEnrollment());
            System.out.println("ALL enrollments loaded");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

}
