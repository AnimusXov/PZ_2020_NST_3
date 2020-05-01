package org.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import jfxtras.styles.jmetro.*;
import org.entity.UserEntity;

import java.io.IOException;
import java.util.ArrayList;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    public static ArrayList<UserEntity> usersList= new ArrayList<>();

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("login"));
        JMetro jMetro = new JMetro(Style.DARK);
        stage.setScene(scene);
        jMetro.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));

    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        UserEntity user = new UserEntity("pracownik1","haslo",1);
        UserEntity user2 = new UserEntity("admin","123456",3);
        UserEntity user3 = new UserEntity("kierownik","haslo2",2);
        usersList.add(user);
        usersList.add(user2);
        usersList.add(user3);
        return fxmlLoader.load();

    }


    public static void main(String[] args) {


        launch();



    }

}