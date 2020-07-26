package sample.controller;
//nazli araki 170503107

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

public class creatnewEQcontroller  implements Initializable {

    @FXML
    private TextField pold;

    @FXML
    private TextField mtech;

    @FXML
    private TextField eqname;

    @FXML
    private TextField li;

    @FXML
    private Button eqcreatnew;

    @FXML
    private Button goHom;

    @FXML
    private TextField camed;

    @FXML
    private TextField dol;

    @FXML
    void gohom(ActionEvent event) throws IOException {

        Stage primaryStage = (Stage) dol.getScene().getWindow();


        System.out.println("goHome");
        Stage stage = null;
        Parent myNewScene = null;
        try{
            FXMLLoader f = new FXMLLoader(getClass().getResource("..//view//main.fxml")) ;

            Parent root1 = (Parent) f.load() ;

            Stage primaryStage1 = (Stage) dol.getScene().getWindow();
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
        eqcreatnew.setOnAction(event ->
        {
            mySQLconn o2 = new mySQLconn();

            System.out.println("firstname is : " + pold.getText());

            o2.doInserte(pold.getText(), eqname.getText(), camed.getText(), mtech.getText(), li.getText() ,dol.getText());

        }       );
    }
}
