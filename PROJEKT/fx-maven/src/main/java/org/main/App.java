package org.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import jfxtras.styles.jmetro.JMetro;
import jfxtras.styles.jmetro.Style;
import org.entity.UserEntity;
import org.hibernate.HibernateException;
import org.hibernate.Metamodel;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernateutil.HibernateUtil;

import javax.persistence.metamodel.EntityType;
import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;




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
        return fxmlLoader.load();

    }


    public static void main(String[] args) {
        UserEntity user = new UserEntity();
        user.setUsername("pracownik4");
        user.setPassword("haslo123");
        user.setAccessLevel(1);

        //Create session factory object

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        //getting session object from session factory
        Session session = sessionFactory.openSession();
        //getting transaction object from session object
        session.beginTransaction();

        session.save(user);
        System.out.println("Inserted Successfully");
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
        launch();







    }

}