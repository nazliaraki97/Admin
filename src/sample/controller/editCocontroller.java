package sample.controller;
//nazli araki 170503107

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.model.equipment;
import sample.model.firma;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class editCocontroller implements Initializable {
    @FXML
    private TextField cos;

    @FXML
    private TextField pname;

    @FXML
    private TextField il;

    @FXML
    private TextField job;

    @FXML
    private TextField off;
    @FXML
    private Button cocreatnew;
    @FXML
    private Button gohome ;

    public static firma fi ;
    void fillForm(firma fi){

        System.out.println("emo id : " +fi.getId() );

        cos.setText( fi.getCostumer() );
        pname.setText( fi.getProject_name() );
        il.setText( fi.getIl_ilce() );
        job.setText( fi.getJob_order_no() );
        off.setText( fi.getOffer_no() );

    }
    @FXML
    private void goHme (ActionEvent event) throws IOException {
        System.out.println("goHome");

        Stage stage = null;
        Parent myNewScene = null;
        try{
            FXMLLoader f = new FXMLLoader(getClass().getResource("..//view//firm.fxml")) ;

            Parent root1 = (Parent) f.load() ;

            Stage primaryStage = (Stage) cocreatnew.getScene().getWindow();
            stage = new Stage() ;
            stage.setTitle("company Management");
            stage.setScene(new Scene(root1));
            stage.show();
            primaryStage.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        fillForm(fi);


        cocreatnew.setOnAction(event -> {


            System.out.println("firstname is : " + cos.getText() );

            mySQLconn.doUpdateii(cos.getText(),pname.getText(),il.getText(),job.getText(),off.getText(),fi.getId()  );


        });
    }
}
