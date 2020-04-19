package org.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import jfxtras.styles.jmetro.*;
import java.io.IOException;
import java.util.ArrayList;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    public static ArrayList<User> usersList= new ArrayList<>();

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
        User user = new User("pracownik1","haslo",1);
        User user2 = new User("admin","123456",3);
        User user3 = new User("kierownik","haslo2",2);
        usersList.add(user);
        usersList.add(user2);
        usersList.add(user3);
        return fxmlLoader.load();

    }


    public static void main(String[] args) {


        launch();



    }

}