package org.main;

import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import jfxtras.styles.jmetro.JMetroStyleClass;
import org.entities.TaskEntity;
import org.entities.UserEntity;
import org.hibernateutil.HibernateUtil;
import org.service.GenericServiceImpl;
import org.service.IGenericService;

public class UsersController {
    public Button add;
    public Button more_info;
    public Button edit;
    public Button delete;
    public AnchorPane anchorPane;
    public TableColumn<Object, Object> username;
    public TableColumn<Object, Object> password;
    public TableColumn<Object, Object> access_level;
    public TableView<UserEntity> userList;


    public void initialize() {
        IGenericService<UserEntity> usersService = new GenericServiceImpl<>(
                UserEntity.class, HibernateUtil.getSessionFactory());

        username.setCellValueFactory(new PropertyValueFactory<>("username"));
        password.setCellValueFactory(new PropertyValueFactory<>("password"));
        access_level.setCellValueFactory(new PropertyValueFactory<>("accessLevel"));
        userList.getItems().addAll(usersService.getAll());




        anchorPane.getStyleClass().add(JMetroStyleClass.BACKGROUND);
    }
}
