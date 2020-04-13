package org.example;



import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;


public class PrimaryController {


    public Label test;
    public TextField username;
    int grantAccess = 0;
    public Button login;
    public PasswordField password;


    @FXML
    private void openAdminWindow() throws IOException {
        System.out.println("aaaaaa");
        FXMLLoader fxmlLoader = new
                FXMLLoader(getClass().getResource("admin.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        //set what you want on your stage
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Report Page");
        stage.setScene(new Scene(root1));
        stage.setResizable(false);
        stage.show();


    }












   @FXML
    private boolean validateUser(){
       User temp_user = new User(username.getText(),password.getText());
       for (User user: App.usersList){
           if(user.equals(temp_user)) {
               grantAccess = user.getAccess_level();
               return true;

           }

       }
      return false;




   }


   @FXML
   private void handleButtonAction(ActionEvent event) throws IOException {
       if(validateUser()) {
           switch (grantAccess) {
               case 3:
                   openAdminWindow();
                   break;

           }}
       else
           test.setText("Nie poprawne Hasło lub Login");


   }



   }






