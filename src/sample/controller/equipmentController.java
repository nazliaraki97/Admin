package sample.controller;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import sample.model.equipment;

public class equipmentController {
    @FXML
    private Button ed;

    @FXML
    private TableView<equipment> table = new TableView<equipment>();


    @FXML
    void initialize(){

        table.setEditable(true);
        TableColumn idc = new TableColumn("id");
        idc.setMinWidth(100);
        idc.setCellValueFactory(
                new PropertyValueFactory<equipment, String>("Pole_Distance"));
        TableColumn pd = new TableColumn("Pole_Distance");
        pd.setMinWidth(100);
        pd.setCellValueFactory(
                new PropertyValueFactory<equipment, String>("Pole_Distance"));

        TableColumn en = new TableColumn("Eq_name");
        en.setMinWidth(100);
        en.setCellValueFactory(
                new PropertyValueFactory<equipment, String>("Eq_name"));

        TableColumn cm = new TableColumn("Carrier_Medium");
        cm.setMinWidth(100);
        cm.setCellValueFactory(
                new PropertyValueFactory<equipment, String>("Carrier_Medium"));

        TableColumn mt = new TableColumn("Mag_Tech");
        mt.setMinWidth(200);
        mt.setCellValueFactory(
                new PropertyValueFactory<equipment, String>("Mag_Tech"));

        TableColumn li = new TableColumn("Light_Intensity");
        li.setMinWidth(50);
        li.setCellValueFactory(
                new PropertyValueFactory<equipment, String>("Light_Intensity"));
        TableColumn disofl = new TableColumn("DistanceofLight");
        disofl.setMinWidth(50);
        disofl.setCellValueFactory(
                new PropertyValueFactory<equipment, String>("DistanceofLight"));


        TableColumn editCol = new TableColumn("edit");


        ObservableList<equipment> data = mySQLconn.doSelecte();






        //DELETE Button
        TableColumn actionCol = new TableColumn("Action");
        actionCol.setCellValueFactory(new PropertyValueFactory<>("DUMMY"));

        Callback<TableColumn<equipment, String>, TableCell<equipment, String>> cellFactory
                = //
                new Callback<TableColumn<equipment, String>, TableCell<equipment, String>>()
                {
                    @Override
                    public TableCell call(final TableColumn<equipment, String> param)
                    {
                        final TableCell<equipment, String> cell = new TableCell<equipment, String>()
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

        Callback<TableColumn<equipment, String>, TableCell<equipment, String>> cellFactory2
                = //
                new Callback<TableColumn<equipment, String>, TableCell<equipment, String>>()
                {
                    @Override
                    public TableCell call(final TableColumn<equipment, String> param)
                    {
                        final TableCell<equipment, String> cell = new TableCell<equipment, String>()
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
