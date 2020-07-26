

//nazli araki 170503107


package sample.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class creatComcontroller implements Initializable {

    @FXML
    private TextField cos;

    @FXML
    private TextField il;

    @FXML
    private TextField proname;

    @FXML
    private TextField jobo;

    @FXML
    private Button comcreatnew;

    @FXML
    private Button goHom;

    @FXML
    private TextField ofno;

    @FXML
    void gohom(ActionEvent event) throws IOException {

        Stage primaryStage = (Stage) ofno.getScene().getWindow();


        System.out.println("goHome");
        Stage stage = null;
        Parent myNewScene = null;
        try{
            FXMLLoader f = new FXMLLoader(getClass().getResource("..//view//main.fxml")) ;

            Parent root1 = (Parent) f.load() ;

            Stage primaryStage1 = (Stage) ofno.getScene().getWindow();
            stage = new Stage() ;
            stage.setTitle("New company");
            stage.setScene(new Scene(root1));
            stage.show();
            primaryStage1.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    @FXML
    public void initialize(URL location, ResourceBundle resources)  {
        comcreatnew.setOnAction(event ->
        {
            mySQLconn o3 = new mySQLconn();

            System.out.println("firstname is : " + cos.getText());

            o3.doInsertee(cos.getText(), proname.getText(), il.getText(), jobo.getText(), ofno.getText() );

        }       );
    }
}
