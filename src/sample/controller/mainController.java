package sample.controller;
//nazli araki 170503107

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.stage.Stage;

import java.time.format.DateTimeFormatter;

public class mainController {

    @FXML
    private Button mainEmployees;
    @FXML
    private Button mainCreatNewReport;


    @FXML
    private Button Coms;
    @FXML
    private Button mainEqus;
    @FXML
    private Button mainCreatNewEqu;


    @FXML
    private Button newCo;
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


    @FXML
    void newRep(ActionEvent event){

        System.out.println("go rep");
        Stage stage = null;
        Parent myNewScene = null;
        try{
            FXMLLoader f = new FXMLLoader(getClass().getResource("..//view//menafter.fxml")) ;
            Parent root1 = (Parent) f.load() ;

            Stage primaryStage = (Stage) mainCreatNewReport.getScene().getWindow();
            stage = new Stage() ;
            stage.setTitle("New Report");
            stage.setScene(new Scene(root1));
            stage.show();
            primaryStage.close();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

    }
    @FXML
    void newCo(ActionEvent event) {Stage stage = null;
        Parent myNewScene = null;
        try{
            FXMLLoader f = new FXMLLoader(getClass().getResource("..//view//creatCom.fxml")) ;

            Parent root1 = (Parent) f.load() ;

            Stage primaryStage = (Stage) newemp.getScene().getWindow();
            stage = new Stage() ;
            stage.setTitle("New Company");
            stage.setScene(new Scene(root1));
            stage.show();
            primaryStage.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    @FXML
    void newEqu(ActionEvent event) {
        Stage stage = null;
        Parent myNewScene = null;
        try{
            FXMLLoader f = new FXMLLoader(getClass().getResource("..//view//creatNewEqu.fxml")) ;

            Parent root1 = (Parent) f.load() ;

            Stage primaryStage = (Stage) newemp.getScene().getWindow();
            stage = new Stage() ;
            stage.setTitle("New Equipment");
            stage.setScene(new Scene(root1));
            stage.show();
            primaryStage.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
    @FXML
    void goEqus(ActionEvent event) {
        Stage stage = null;
        Parent myNewScene = null;
        try{
            FXMLLoader f = new FXMLLoader(getClass().getResource("..//view//equip.fxml")) ;

            Parent root1 = (Parent) f.load() ;

            Stage primaryStage = (Stage) newemp.getScene().getWindow();
            stage = new Stage() ;
            stage.setTitle("Equipments");
            stage.setScene(new Scene(root1));
            stage.show();
            primaryStage.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
    @FXML
    void goCo(ActionEvent event) {
        Stage stage = null;
        Parent myNewScene = null;
        try{
            FXMLLoader f = new FXMLLoader(getClass().getResource("..//view//firm.fxml")) ;

            Parent root1 = (Parent) f.load() ;

            Stage primaryStage = (Stage) newemp.getScene().getWindow();
            stage = new Stage() ;
            stage.setTitle("Companies");
            stage.setScene(new Scene(root1));
            stage.show();
            primaryStage.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

}



