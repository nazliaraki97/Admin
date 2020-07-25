package sample.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.model.Employee;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class editController implements Initializable {

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

    public static Employee emp ;
    void fillForm(Employee emp){

        System.out.println("emo id : " + emp.getId() );

        firstname.setText( emp.getFirstName() );
        password.setText( emp.getPassword() );
        lastname.setText( emp.getLastName() );
        username.setText( emp.getUserName() );
        jobtitle.setText( emp.getJobTitle() );

    }

    static String se ;


    @FXML
    private Button gohome ;

    @FXML
    private void goHme (ActionEvent event) throws IOException {
        System.out.println("goHome");

        Stage stage = null;
        Parent myNewScene = null;
        try{
            FXMLLoader f = new FXMLLoader(getClass().getResource("..//view//Employees.fxml")) ;

            Parent root1 = (Parent) f.load() ;

            Stage primaryStage = (Stage) gohome.getScene().getWindow();
            stage = new Stage() ;
            stage.setTitle("Employee Management");
            stage.setScene(new Scene(root1));
            stage.show();
            primaryStage.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        //    stage = (Stage) ed.getScene().getWindow();
        //    myNewScene = FXMLLoader.load(getClass().getResource("src\\sample\\view\\login.fxml"));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        fillForm(emp) ;


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

            System.out.println("firstname is : " + firstname.getText() );

            mySQLconn.doUpdate(firstname.getText(),lastname.getText(),username.getText(),password.getText(),jobtitle.getText(),   emp.getId()  ); ;
        });


    }


}
