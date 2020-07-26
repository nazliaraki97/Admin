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

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class editEqcontroller implements Initializable {
    @FXML
    private TextField pold;

    @FXML
    private TextField mtech;

    @FXML
    private TextField eqname;

    @FXML
    private TextField li;

    @FXML
    private TextField camed;

    @FXML
    private TextField dol;
    @FXML
    private Button eqcreatnew;
    @FXML
    private Button gohome ;

    public static equipment eq ;
    void fillForm(equipment eq){

        System.out.println("emo id : " +eq.getId() );

        pold.setText( eq.getPole_Distance() );
        eqname.setText( eq.getEq_name() );
        camed.setText( eq.getCarrier_Medium() );
        mtech.setText( eq.getMag_Tech() );
        li.setText( eq.getLight_Intensity() );
        dol.setText( eq.getDistanceofLight() );

    }
    @FXML
    private void goHme (ActionEvent event) throws IOException {
        System.out.println("goHome");

        Stage stage = null;
        Parent myNewScene = null;
        try{
            FXMLLoader f = new FXMLLoader(getClass().getResource("..//view//equip.fxml")) ;

            Parent root1 = (Parent) f.load() ;

            Stage primaryStage = (Stage) eqcreatnew.getScene().getWindow();
            stage = new Stage() ;
            stage.setTitle("Equip Management");
            stage.setScene(new Scene(root1));
            stage.show();
            primaryStage.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        fillForm(eq);


        eqcreatnew.setOnAction(event -> {


            System.out.println("firstname is : " + pold.getText() );

            mySQLconn.doUpdatei(pold.getText(),eqname.getText(),camed.getText(),mtech.getText(),li.getText(),dol.getText(),eq.getId()  );


        });
    }
    }
