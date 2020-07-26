package sample.controller;
//nazli araki 170503107

import javafx.beans.property.SimpleStringProperty;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Callback;
import sample.model.Employee;

import java.io.IOException;

public class EmployeesController {

    @FXML
    private Button ed;

    @FXML
    private TableView<Employee> table = new TableView<Employee>();



    @FXML private AnchorPane ap;
    void goEditScreen(Employee emp){
        System.out.println("eee");
        Stage stage = null;
        Parent myNewScene = null;
        try{
            FXMLLoader f = new FXMLLoader(getClass().getResource("..//view//editEmployee.fxml")) ;
            editController e = new editController() ;
            e.emp = emp ;
            Parent root1 = (Parent) f.load() ;
            //    e.fillForm("1111");


            Stage primaryStage = (Stage) ed.getScene().getWindow();
            stage = new Stage() ;
            stage.setTitle("ddd0");
            stage.setScene(new Scene(root1));
            stage.show();
            primaryStage.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @FXML
    private void handleMenuButtonAction (ActionEvent event) throws IOException {

        Stage primaryStage = (Stage) ed.getScene().getWindow();


        System.out.println("goHome");
        Stage stage = null;
        Parent myNewScene = null;
        try{
            FXMLLoader f = new FXMLLoader(getClass().getResource("..//view//main.fxml")) ;

            Parent root1 = (Parent) f.load() ;

            Stage primaryStage1 = (Stage) ed.getScene().getWindow();
            stage = new Stage() ;
            stage.setTitle("New Employee");
            stage.setScene(new Scene(root1));
            stage.show();
            primaryStage1.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    //    primaryStage.close();
    }

    @FXML
    void initialize(){

        table.setEditable(true);

        TableColumn idCol = new TableColumn("ID");
        idCol.setMinWidth(100);
        idCol.setCellValueFactory(
                new PropertyValueFactory<Employee, String>("id"));

        TableColumn firstNameCol = new TableColumn("First Name");
        firstNameCol.setMinWidth(100);
        firstNameCol.setCellValueFactory(
                new PropertyValueFactory<Employee, String>("firstName"));

        TableColumn lastNameCol = new TableColumn("Last Name");
        lastNameCol.setMinWidth(100);
        lastNameCol.setCellValueFactory(
                new PropertyValueFactory<Employee, String>("lastName"));

        TableColumn userNameCol = new TableColumn("email");
        userNameCol.setMinWidth(200);
        userNameCol.setCellValueFactory(
                new PropertyValueFactory<Employee, String>("userName"));

        TableColumn jobCol = new TableColumn("Job");
        jobCol.setMinWidth(50);
        jobCol.setCellValueFactory(
                new PropertyValueFactory<Employee, String>("jobTitle"));

        TableColumn editCol = new TableColumn("edit");
        jobCol.setMinWidth(50);
        jobCol.setCellValueFactory(
                new PropertyValueFactory<Employee, String>("jobTitle"));


        ObservableList<Employee> data = mySQLconn.doSelect();






        //DELETE Button
        TableColumn actionCol = new TableColumn("Action");
        actionCol.setCellValueFactory(new PropertyValueFactory<>("DUMMY"));

        Callback<TableColumn<Employee, String>, TableCell<Employee, String>> cellFactory
                = //
                new Callback<TableColumn<Employee, String>, TableCell<Employee, String>>()
                {
                    @Override
                    public TableCell call(final TableColumn<Employee, String> param)
                    {
                        final TableCell<Employee, String> cell = new TableCell<Employee, String>()
                        {

                            final Button btn = new Button("Delete");

                            {
                                btn.setOnAction(event -> {
                                    System.out.println("delete row : " + table.getItems().get(getIndex()).getId() );

                                    mySQLconn.doDelete(table.getItems().get(getIndex()).getId()) ;
                                        table.getItems().remove(getIndex());
                                });
                            }

                            @Override
                            public void updateItem(String item, boolean empty)
                            {
                                super.updateItem(item, empty);
                                if (empty) {
                                    setGraphic(null);
                                    setText(null);
                                }
                                else {
                                    setGraphic(btn);
                                    setText(null);
                                }
                            }
                        };
                        return cell;
                    }
                };

        actionCol.setCellFactory(cellFactory);
// END OF DELETE





        //EDIT Button

        TableColumn editingCol = new TableColumn("EDIT");
        editingCol.setCellValueFactory(new PropertyValueFactory<>("DUMMY"));

        Callback<TableColumn<Employee, String>, TableCell<Employee, String>> cellFactory2
                = //
                new Callback<TableColumn<Employee, String>, TableCell<Employee, String>>()
                {
                    @Override
                    public TableCell call(final TableColumn<Employee, String> param)
                    {
                        final TableCell<Employee, String> cell = new TableCell<Employee, String>()
                        {

                            final Button btn = new Button("EDIT");

                            {
                                btn.setOnAction(event -> {
                                    System.out.println("delete row : " + table.getItems().get(getIndex()).getId() );
                                    goEditScreen(table.getItems().get(getIndex())) ;
                                //    mySQLconn.doUpdate(table.getItems().get(getIndex()).getId()) ;
                                //    table.getItems().removeAll(data) ;
                                //    ObservableList<Employee> data = mySQLconn.doSelect();
                                //    table.setItems(data);

                                    //    table.getItems().addAll(data) ;
                                });
                            }

                            @Override
                            public void updateItem(String item, boolean empty)
                            {
                                super.updateItem(item, empty);
                                if (empty) {
                                    setGraphic(null);
                                    setText(null);
                                }
                                else {
                                    setGraphic(btn);
                                    setText(null);
                                }
                            }
                        };
                        return cell;
                    }
                };

        editingCol.setCellFactory(cellFactory2);
        // END OF EDIT






        table.setItems(data);
        table.getColumns().addAll(idCol , firstNameCol, lastNameCol, userNameCol,jobCol , actionCol , editingCol);

    }

}
