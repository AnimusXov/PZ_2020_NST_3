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
import org.entities.UserEntity;
import org.hibernate.Session;
import org.hibernateutil.HibernateUtil;


import javax.persistence.Query;
import java.io.IOException;
import java.util.Optional;


public class LoginController {


    public static int grantAccess = 0;
    public Label test;
    public TextField username;
    public Button login;
    public PasswordField password;
    public AnchorPane anchorPane;


    @FXML
    private void openMainWindow() throws IOException {

        Stage primaryStage = (Stage) username.getScene().getWindow();
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
        primaryStage.close();
        stage.show();



    }


   @FXML
    private boolean validateUser(){
       Session session = HibernateUtil.getSessionFactory().openSession();

       UserEntity emp_user = new UserEntity();
       emp_user.setUsername(username.getText());
       emp_user.setPassword(password.getText());

       String hql = "select access_level from UserEntity where username= :username and password= :password";
       Query query = session.createQuery(hql);

       query.setParameter("username", emp_user.getUsername());
       query.setParameter("password", emp_user.getPassword());


       Optional first = query.getResultList().stream().findFirst();
       if(first.isPresent()){
       grantAccess = (int) query.getSingleResult();
       System.out.println(first);
       return true;}
       else
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






