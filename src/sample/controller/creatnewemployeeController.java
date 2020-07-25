package sample.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class creatnewemployeeController {

    @FXML
    private TextField firstname;

    @FXML
    private TextField lastname;

    @FXML
    private TextField username;

    @FXML
    private PasswordField password;

    @FXML
    private Button employeecreatnew;

    @FXML
    private MenuButton jobtitle;

    @FXML
    private MenuItem adminjob;

    @FXML
    private MenuItem employeejob;
    static String se ;



    @FXML
    private void goEmps (ActionEvent event) throws IOException {

        Stage primaryStage = (Stage) employeecreatnew.getScene().getWindow();


        System.out.println("goHome");
        Stage stage = null;
        Parent myNewScene = null;
        try{
            FXMLLoader f = new FXMLLoader(getClass().getResource("..//view//main.fxml")) ;

            Parent root1 = (Parent) f.load() ;

            Stage primaryStage1 = (Stage) employeecreatnew.getScene().getWindow();
            stage = new Stage() ;
            stage.setTitle("New Employee");
            stage.setScene(new Scene(root1));
            stage.show();
            primaryStage1.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }


    @FXML
    void initialize(){

       adminjob.setOnAction(event -> {
           se = "admin" ;
           System.out.println("adminjob is : " + adminjob.getText());
           jobtitle.setText(se);
       });

        employeejob.setOnAction(event -> {
            se = "employee" ;
            System.out.println("employeejob is : " + employeejob.getText());
            jobtitle.setText(se);

        });


        employeecreatnew.setOnAction(event ->
        {

            mySQLconn o1 = new mySQLconn() ;

           System.out.println("firstname is : " + firstname.getText() );

               o1.doInsert(firstname.getText(),lastname.getText(),username.getText(),password.getText(),se) ;
        });

    }

}
