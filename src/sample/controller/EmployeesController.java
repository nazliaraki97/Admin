package sample.controller;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
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
/*
    @FXML
    private TableColumn<Employee, String> id;

    @FXML
    private TableColumn<Employee, String> fn;

    @FXML
    private TableColumn<Employee, String> ln;

    @FXML
    private TableColumn<Employee, String> un;

    @FXML
    private TableColumn<Employee, String> jt;
*/

    @FXML
    private Button ed;

    @FXML
    private TableView<Employee> table = new TableView<Employee>();

    /*
    private final ObservableList<Employee> data =
            FXCollections.observableArrayList(
                    new Employee("1", "Smith", "jacob","smith@example.com","admin"),
                    new Employee("2","Isabella", "Johnson", "isabella.johnson@example.com","emp")
            );

     */

    /*
 @FXML
 private TableView<Person>

 table = new TableView<Person>();
    private final ObservableList<Person> data =
            FXCollections.observableArrayList(
                    new Person("Jacob", "Smith", "jacob.smith@example.com"),
                    new Person("Isabella", "Johnson", "isabella.johnson@example.com"),
                    new Person("Ethan", "Williams", "ethan.williams@example.com"),
                    new Person("Emma", "Jones", "emma.jones@example.com"),
                    new Person("Michael", "Brown", "michael.brown@example.com")
            );
*/

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
        System.out.println(mySQLconn.doSelect());
        System.out.println("select");






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


        ObservableList<Employee> data = mySQLconn.doSelect();;






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





   //     mySQLconn.doSelect();
/*
        table.setEditable(true);

        TableColumn id = new TableColumn("ID");
        id.setMinWidth(100);
        id.setCellValueFactory(
                new PropertyValueFactory<Employee, String>("id"));

        TableColumn fn = new TableColumn("First Name");
        fn.setMinWidth(100);
        fn.setCellValueFactory(
                new PropertyValueFactory<Employee, String>("firstName"));

        TableColumn ln = new TableColumn("Last Name");
        ln.setMinWidth(100);
        ln.setCellValueFactory(
                new PropertyValueFactory<Employee, String>("lastName"));

        TableColumn un = new TableColumn("Email");
        un.setMinWidth(100);
        un.setCellValueFactory(
                new PropertyValueFactory<Employee, String>("userName"));

        TableColumn jt = new TableColumn("job");
        jt.setMinWidth(100);
        jt.setCellValueFactory(
                new PropertyValueFactory<Employee, String>("jobtitle"));

        table.setItems(data);
        table.getColumns().addAll(id, fn, ln,un,jt);
*/
    }





    public static class Person {

        private final SimpleStringProperty firstName;
        private final SimpleStringProperty lastName;
        private final SimpleStringProperty email;

        private Person(String fName, String lName, String email) {
            this.firstName = new SimpleStringProperty(fName);
            this.lastName = new SimpleStringProperty(lName);
            this.email = new SimpleStringProperty(email);
        }

        public String getFirstName() {
            return firstName.get();
        }

        public void setFirstName(String fName) {
            firstName.set(fName);
        }

        public String getLastName() {
            return lastName.get();
        }

        public void setLastName(String fName) {
            lastName.set(fName);
        }

        public String getEmail() {
            return email.get();
        }

        public void setEmail(String fName) {
            email.set(fName);
        }
    }
}
