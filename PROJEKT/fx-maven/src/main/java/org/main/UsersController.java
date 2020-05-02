package org.main;

import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import jfxtras.styles.jmetro.JMetroStyleClass;
import org.entity.UserEntity;

public class UsersController {
    public Button add;
    public Button more_info;
    public Button edit;
    public Button delete;
    public AnchorPane anchorPane;
    public TableColumn<Object, Object> username;
    public TableColumn<Object, Object> password;
    public TableColumn<Object, Object> access_level;



    public void initialize() {
        username.setCellValueFactory(new PropertyValueFactory<>("username"));
        password.setCellValueFactory(new PropertyValueFactory<>("password"));
        access_level.setCellValueFactory(new PropertyValueFactory<>("access_level"));




        anchorPane.getStyleClass().add(JMetroStyleClass.BACKGROUND);
    }
}
