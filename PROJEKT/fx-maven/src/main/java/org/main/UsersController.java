package org.main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;
import javafx.util.converter.IntegerStringConverter;
import javafx.util.converter.ShortStringConverter;
import jfxtras.styles.jmetro.JMetroStyleClass;
import org.entities.EmployeeEntity;
import org.entities.TaskEntity;
import org.entities.UserEntity;
import org.hibernate.Session;
import org.hibernateutil.HibernateUtil;
import org.service.GenericServiceImpl;
import org.service.IGenericService;

import java.io.IOException;
import java.io.Serializable;

public class UsersController {
    public Button add;
    public Button more_info;
    public Button edit;
    public Button delete;
    public AnchorPane anchorPane;
    public TableColumn<UserEntity, String> username;
    public TableColumn<UserEntity, String> password;
    public TableColumn<UserEntity, Integer> access_level;
    public TableView<UserEntity> userList;
    public TextField username_textField;
    public TextField password_textField;
    public TextField accessLevel_textField;
    public TextField name_textField;
    public TextField surname_textField;
    public Label information_label;
    public TableColumn<EmployeeEntity, String> employee_name;
    public TableColumn<EmployeeEntity, String> employee_surname;
    public TableView<EmployeeEntity> employeeList;

    IGenericService<UserEntity> usersService = new GenericServiceImpl<>(
            UserEntity.class, HibernateUtil.getSessionFactory());
    IGenericService<EmployeeEntity> employeeSerive = new GenericServiceImpl<>(
            EmployeeEntity.class, HibernateUtil.getSessionFactory());


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

            session.persist(emp_user);
            session.getTransaction().commit();
            //  employeeSerive.save(emp_employee);
            //  usersService.save(emp_user);
            userList.getItems().add(emp_user);

            session.close();
            userList.refresh();

            information_label.setText("Dodano Użytkownika Pomyślnie");
        }
        else
            information_label.setText("Wypełnij wszystkie pola");
    }
    @FXML
    private void handleEditButtonAction(ActionEvent event) throws IOException {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        for (UserEntity emp_user:userList.getItems()
        ) {usersService.update(emp_user);
        };

        session.close();


        userList.refresh();
    }
    @FXML
    private void handleDeleteButtonAction(ActionEvent event) throws  IOException{
        UserEntity userEntity = userList.getSelectionModel().getSelectedItem();
        usersService.delete(userEntity);
        userList.getItems().remove(userEntity);
        userList.refresh();
    }
    @FXML
    private void handleMoreInfoButtonAction(ActionEvent event) throws  IOException{
     employeeList.getItems().clear();
     employeeList.getItems().add(userList.getSelectionModel().getSelectedItem().getEmployeeEntity());
     employeeList.refresh();


    }

    public void changeUserNameCellEvent(TableColumn.CellEditEvent cellEditEvent){
        UserEntity userSelected = userList.getSelectionModel().getSelectedItem();
        userSelected.setUsername((String) cellEditEvent.getNewValue());
        usersService.update(userSelected);



    }
    public void changePasswordCellEvent(TableColumn.CellEditEvent cellEditEvent){
        UserEntity userSelected = userList.getSelectionModel().getSelectedItem();
        userSelected.setPassword((String) cellEditEvent.getNewValue());
        usersService.update(userSelected);

    }
    public void changeAccessLevelCellEvent(TableColumn.CellEditEvent cellEditEvent){
        UserEntity userSelected = userList.getSelectionModel().getSelectedItem();
        int emp = (int) cellEditEvent.getNewValue();
        userSelected.setAccess_level(emp);
        usersService.update(userSelected);
    }

    public void initialize() {

        username.setCellValueFactory(new PropertyValueFactory<>("username"));
        password.setCellValueFactory(new PropertyValueFactory<>("password"));
        access_level.setCellValueFactory(new PropertyValueFactory<>("access_level"));
        userList.getItems().addAll(usersService.getAll());

        employee_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        employee_surname.setCellValueFactory(new PropertyValueFactory<>("surname"));

        username.setCellFactory(TextFieldTableCell.forTableColumn());
        password.setCellFactory(TextFieldTableCell.forTableColumn());
        access_level.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));

        anchorPane.getStyleClass().add(JMetroStyleClass.BACKGROUND);
    }


    boolean  checkIfEmpty(){
        return !(username_textField.getText().isBlank() || password_textField.getText().isBlank() || accessLevel_textField.getText().isBlank() ||
                name_textField.getText().isBlank() || surname_textField.getText().isBlank()) && (Integer.parseInt(accessLevel_textField.getText())>0
                && Integer.parseInt(accessLevel_textField.getText())<4);
    }
}
