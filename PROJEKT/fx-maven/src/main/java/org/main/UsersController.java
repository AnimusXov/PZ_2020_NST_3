package org.main;

import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import jfxtras.styles.jmetro.JMetroStyleClass;

public class UsersController {
    public Button add;
    public Button more_info;
    public Button edit;
    public Button delete;
    public TableView<User> userList;
    public AnchorPane anchorPane;
    public TableColumn<Object, Object> username;
    public TableColumn<Object, Object> password;
    public TableColumn<Object, Object> access_level;



    public void initialize() {
        username.setCellValueFactory(new PropertyValueFactory<>("username"));
        password.setCellValueFactory(new PropertyValueFactory<>("password"));
        access_level.setCellValueFactory(new PropertyValueFactory<>("access_level"));
        User user = new User("Marcin13",    1);
        User user2 = new User("Kowalski01",    1);
        User user3= new User("Adamczyk",    1);
        User user4 = new User("Admin",    3);
        User user5 = new User("Kierownik",    2);

        userList.getItems().add(user);
        userList.getItems().add(user2);
        userList.getItems().add(user3);
        userList.getItems().add(user4);
        userList.getItems().add(user5);


        anchorPane.getStyleClass().add(JMetroStyleClass.BACKGROUND);
    }
}
