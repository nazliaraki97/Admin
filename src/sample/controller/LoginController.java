package sample.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {

    @FXML
    private TextField loginUsername;

    @FXML
    private PasswordField loginPassword;

    @FXML
    private Button loginButton;

    @FXML
    private Button loginSignupButton;
    @FXML
    void initialize(){

      loginButton.setOnAction(event ->
      {
         // System.out.println( loginUsername.getText().equals("aaa")  );

          if((loginUsername.getText().equals("admin")) &&  (loginPassword.getText().equals("123"))  ){
              System.out.println("logged");

              System.out.println("goMain");
              Stage stage = null;
              Parent myNewScene = null;
              try{
                  FXMLLoader f = new FXMLLoader(getClass().getResource("..//view//main.fxml")) ;

                  Parent root1 = (Parent) f.load() ;

                  Stage primaryStage = (Stage) loginPassword.getScene().getWindow();
                  stage = new Stage() ;
                  stage.setTitle("Employee Management");
                  stage.setScene(new Scene(root1));
                  stage.show();
                  primaryStage.close();
              }catch (Exception e){
                  System.out.println(e.getMessage());
              }
          }
      });

    }

}
