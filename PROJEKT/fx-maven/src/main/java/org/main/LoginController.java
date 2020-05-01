package org.main;



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
import jfxtras.styles.jmetro.JMetro;
import jfxtras.styles.jmetro.JMetroStyleClass;
import jfxtras.styles.jmetro.Style;
import org.entity.UserEntity;

import java.io.IOException;


public class LoginController {


    public static int grantAccess = 0;
    public Label test;
    public TextField username;
    public Button login;
    public PasswordField password;
    public AnchorPane anchorPane;


    @FXML
    private void openMainWindow() throws IOException {

        Scene scene;
        FXMLLoader fxmlLoader = new
                FXMLLoader(getClass().getResource("main.fxml"));
        Parent root1 = fxmlLoader.load();
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        scene = (new Scene(root1));
        stage.setScene(scene);
        JMetro jMetro = new JMetro(Style.DARK);
        jMetro.setScene(scene);
        stage.setResizable(false);
        stage.show();


    }












   @FXML
    private boolean validateUser(){
       UserEntity temp_user = new UserEntity(username.getText(),password.getText());
       for (UserEntity user: App.usersList){
           if(user.equals(temp_user)) {
               grantAccess = user.getAccess_level();
               return true;

           }

       }
      return false;




   }


   @FXML
   private void handleButtonAction(ActionEvent event) throws IOException {
       if(validateUser()){
                   openMainWindow();
       test.setText("Zalogowano pomyślnie");}
       else
           test.setText("Nie poprawne Hasło lub Login");


   }

    @FXML
    void initialize() {
        anchorPane.getStyleClass().add(JMetroStyleClass.BACKGROUND);


    }



   }






