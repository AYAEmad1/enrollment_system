/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package assign33;

import config.DBConnection;
import java.sql.SQLException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import models.Enrollment;

/**
 *
 * @author islam-bilisim
 */
public class Assign33 extends Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent p = FXMLLoader.load(getClass().getResource("/views/Enrollment.fxml"));

        Scene s = new Scene(p);
        stage.setScene(s);
        stage.setTitle("Enrollment System");
        stage.show();
    }

    @Override
    public void stop() {
        try {
            DBConnection.getInstance().closeConnection();
        } catch (SQLException ex) {
            System.getLogger(Assign33.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }
}
