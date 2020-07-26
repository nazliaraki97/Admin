package sample.controller;
//nazli araki 170503107

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.model.Employee;
import sample.model.equipment;

import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class menafterco {

    @FXML
    private DatePicker MuDp;

    @FXML
    private TextField OpRepId;

    @FXML
    private TextField EvRepId;

    @FXML
    private TextField OnRepId;

    @FXML
    private TextField EqRepId;

    @FXML
    private Button creat;


    @FXML
    private DatePicker dp;

    @FXML
    void newRepo(ActionEvent event){


            mySQLconn o2 = new mySQLconn() ;
            o2.doSert(EqRepId.getText()) ;

        ObservableList <equipment> data = FXCollections.observableArrayList(o2.doSert(EqRepId.getText()));

        mySQLconn o3 = new mySQLconn() ;
        o2.doSert1(EvRepId.getText()) ;
        ObservableList <Employee> dataa = FXCollections.observableArrayList(o2.doSert1(EvRepId.getText()));
      /*  if(dataa.get(2).getJobTitle()=="evaluator"){

        }else {
            dataa=null;
        }*/

        mySQLconn o4 = new mySQLconn() ;
        o2.doSert2(OpRepId.getText()) ;
        ObservableList <Employee> dataaa = FXCollections.observableArrayList(o2.doSert2(OpRepId.getText()));
       /* if(dataaa.get(2).getJobTitle()=="operator"){

        }else {
            dataaa=null;
        }*/

        System.out.println("go repyy");
        Stage stage = null;
        Parent myNewScene = null;
        try{
            FXMLLoader f = new FXMLLoader(getClass().getResource("..//view//creatReport.fxml")) ;
            Parent root1 = (Parent) f.load() ;


            String date = dp.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            String date1 = MuDp.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

            System.out.println(date);
            CreatReport cr2 =f.getController();

            CreatReport cr1 =f.getController();
            CreatReport cr =f.getController();
            cr.myfun(date,date1);
            cr1.myfun1(data);

            cr2.myfun2(dataa,dataaa);



            Stage primaryStage = (Stage) creat.getScene().getWindow();
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

    public void initialize(URL location, ResourceBundle resources) {



}}
