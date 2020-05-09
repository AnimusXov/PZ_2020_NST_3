package org.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import jfxtras.styles.jmetro.JMetroStyleClass;
import org.entities.EmployeeEntity;
import org.entities.UserEntity;
import org.hibernate.Session;
import org.hibernateutil.HibernateUtil;
import org.service.GenericServiceImpl;
import org.service.IGenericService;

import java.io.IOException;

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
    public TextField username_textField;
    public TextField password_textField;
    public TextField accessLevel_textField;
    public TextField name_textField;
    public TextField surname_textField;
    public Label information_label;

    IGenericService<UserEntity> usersService = new GenericServiceImpl<>(
            UserEntity.class, HibernateUtil.getSessionFactory());
    IGenericService<EmployeeEntity> employeeSerive = new GenericServiceImpl<>(
            EmployeeEntity.class, HibernateUtil.getSessionFactory());
    public void initialize() {


        username.setCellValueFactory(new PropertyValueFactory<>("username"));
        password.setCellValueFactory(new PropertyValueFactory<>("password"));
        access_level.setCellValueFactory(new PropertyValueFactory<>("access_level"));
        userList.getItems().addAll(usersService.getAll());





        anchorPane.getStyleClass().add(JMetroStyleClass.BACKGROUND);
    }


    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        if(checkIfEmpty()) {
            Session session = HibernateUtil.getSessionFactory().openSession();


            session.beginTransaction();
            EmployeeEntity emp_employee = new EmployeeEntity();
            UserEntity emp_user = new UserEntity();


            emp_user.setUsername(username_textField.getText());
            emp_user.setPassword(password_textField.getText());
            emp_user.setAccess_level(Integer.valueOf(accessLevel_textField.getText()));


            emp_employee.setName(name_textField.getText());
            emp_employee.setSurname(surname_textField.getText());





                emp_employee.setUser(emp_user);
                emp_user.setEmployeeEntity(emp_employee);

                session.merge(emp_user);
            session.getTransaction().commit();

          //  employeeSerive.save(emp_employee);
          //  usersService.save(emp_user);
            session.close();
            information_label.setText("Dodano Użytkownika Pomyślnie");
        }
        information_label.setText("Wypełnij wszystkie pola");






    }

    boolean  checkIfEmpty(){
        return !(username_textField.getText().isEmpty() || password_textField.getText().isEmpty() || accessLevel_textField.getText().isEmpty() ||
                name_textField.getText().isEmpty() || surname_textField.getText().isEmpty());
    }
}
