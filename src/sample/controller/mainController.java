package sample.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class mainController {

    @FXML
    private Button mainEmployees;

    @FXML
    private Button mainCreatNewReport;

    @FXML
    private Button newemp;

    @FXML
    private Button mainLogout;

    @FXML
    void goOut(ActionEvent event) {

        System.out.println("goHome");
        Stage stage = null;
        Parent myNewScene = null;
        try{
            FXMLLoader f = new FXMLLoader(getClass().getResource("..//view//login.fxml")) ;

            Parent root1 = (Parent) f.load() ;

            Stage primaryStage = (Stage) newemp.getScene().getWindow();
            stage = new Stage() ;
            stage.setTitle("New Employee");
            stage.setScene(new Scene(root1));
            stage.show();
            primaryStage.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }


    @FXML
    void goEmps(ActionEvent event) {

        System.out.println("goHome");
        Stage stage = null;
        Parent myNewScene = null;
        try{
            FXMLLoader f = new FXMLLoader(getClass().getResource("..//view//Employees.fxml")) ;

            Parent root1 = (Parent) f.load() ;

            Stage primaryStage = (Stage) newemp.getScene().getWindow();
            stage = new Stage() ;
            stage.setTitle("New Employee");
            stage.setScene(new Scene(root1));
            stage.show();
            primaryStage.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }


    @FXML
    void newEmp(ActionEvent event) {

        System.out.println("goHome");
        Stage stage = null;
        Parent myNewScene = null;
        try{
            FXMLLoader f = new FXMLLoader(getClass().getResource("..//view//creatNewEmployee.fxml")) ;

            Parent root1 = (Parent) f.load() ;

            Stage primaryStage = (Stage) newemp.getScene().getWindow();
            stage = new Stage() ;
            stage.setTitle("New Employee");
            stage.setScene(new Scene(root1));
            stage.show();
            primaryStage.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}
