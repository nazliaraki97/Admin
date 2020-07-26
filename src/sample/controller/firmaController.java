package sample.controller;
//nazli araki 170503107

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Callback;
import sample.model.firma;

import java.io.IOException;

public class firmaController {
    @FXML
    private Button ed;

    @FXML
    private TableView<firma> table = new TableView<firma>();
    @FXML
    void goHme(ActionEvent event) throws IOException {

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
    }
    void goEditScreen(firma fi){
        System.out.println("fff");
        Stage stage = null;
        Parent myNewScene = null;
        try{
            FXMLLoader f = new FXMLLoader(getClass().getResource("..//view//editCom.fxml")) ;
            editCocontroller e = new editCocontroller() ;
            e.fi = fi ;
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
    void initialize(){

        table.setEditable(true);
        TableColumn idc = new TableColumn("id");
        idc.setMinWidth(100);
        idc.setCellValueFactory(
                new PropertyValueFactory<firma, String>("id"));

        TableColumn cs = new TableColumn("Costumer");
        cs.setMinWidth(100);
        cs.setCellValueFactory(
                new PropertyValueFactory<firma, String>("Costumer"));

        TableColumn pn = new TableColumn("Project_name");
        pn.setMinWidth(100);
        pn.setCellValueFactory(
                new PropertyValueFactory<firma, String>("Project_name"));

        TableColumn il = new TableColumn("il_ilce");
        il.setMinWidth(100);
        il.setCellValueFactory(
                new PropertyValueFactory<firma, String>("il_ilce"));

        TableColumn jo = new TableColumn("job_order_no");
        jo.setMinWidth(200);
        jo.setCellValueFactory(
                new PropertyValueFactory<firma, String>("job_order_no"));

        TableColumn of = new TableColumn("offer_no");
        of.setMinWidth(50);
        of.setCellValueFactory(
                new PropertyValueFactory<firma, String>("offer_no"));



        TableColumn editCol = new TableColumn("edit");


        ObservableList<firma> data = mySQLconn.doSelectee();






        //DELETE Button
        TableColumn actionCol = new TableColumn("Action");
        actionCol.setCellValueFactory(new PropertyValueFactory<>("DUMMY"));

        Callback<TableColumn<firma, String>, TableCell<firma, String>> cellFactory
                = //
                new Callback<TableColumn<firma, String>, TableCell<firma, String>>()
                {
                    @Override
                    public TableCell call(final TableColumn<firma, String> param)
                    {
                        final TableCell<firma, String> cell = new TableCell<firma, String>()
                        {

                            final Button btn = new Button("Delete");

                            {
                                btn.setOnAction(event -> {
                                    System.out.println("delete row : " + table.getItems().get(getIndex()).getId() );

                                    mySQLconn.doDeleteii(table.getItems().get(getIndex()).getId()) ;
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

        Callback<TableColumn<firma, String>, TableCell<firma, String>> cellFactory2
                = //
                new Callback<TableColumn<firma, String>, TableCell<firma, String>>()
                {
                    @Override
                    public TableCell call(final TableColumn<firma, String> param)
                    {
                        final TableCell<firma, String> cell = new TableCell<firma, String>()
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
        table.getColumns().addAll( cs, pn, il,jo ,of , actionCol , editingCol,idc);

    }
}
