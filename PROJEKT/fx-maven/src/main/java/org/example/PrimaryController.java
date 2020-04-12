package org.example;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Popup;

public class PrimaryController {

    public Label test;
    public TextField username;
    boolean grantAccess = false;

    // create a popup

    public Button login;
    public PasswordField password;


   @FXML
    private boolean validateUser(){

       User temp_user = new User(username.getText(),password.getText());
       return username.getText().equals("test")&&password.getText().equals("test1");
   }


   @FXML
   private void handleButtonAction(ActionEvent event) {
       if(validateUser())
           test.setText("Sukces");
       else
           test.setText("Porażka");

   }



   }






