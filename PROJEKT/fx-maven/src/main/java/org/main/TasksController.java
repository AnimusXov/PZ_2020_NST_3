package org.main;

import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.ChoiceBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.util.converter.IntegerStringConverter;
import javafx.util.converter.ShortStringConverter;
import jfxtras.styles.jmetro.JMetroStyleClass;
import org.entities.SupplyEntity;
import org.entities.TaskEntity;
import org.hibernate.Session;
import org.hibernateutil.HibernateUtil;
import org.reportgenerator.ReportGen;
import org.service.GenericServiceImpl;
import org.service.IGenericService;

import java.io.IOException;
import java.util.List;

public class TasksController {
    public ChoiceBox actionBox;
    public TableView<TaskEntity> tasksList;

    public TableColumn<TaskEntity, String> name;
    public TableColumn<TaskEntity, String> index;
    public TableColumn<TaskEntity, Short> quantity;
    public TableColumn<TaskEntity, Short> count;
    public TableColumn<TaskEntity, String> status;
    public TableColumn<TaskEntity, String> priority;
    public AnchorPane anchorPane;
    public Button add_task;
    public Button delete_task;
    public Button confirm_changes;
    public TextField name_txtField;
    public TextField index_txtField;
    public TextField quanity_txtField;
    public TextField done_txtField;
    public TextField status_txtField;
    public TextField priority_txtField;
    public ComboBox<String> comboBox;


    IGenericService<TaskEntity> taskService = new GenericServiceImpl<>(
            TaskEntity.class, HibernateUtil.getSessionFactory());
    public static final String[] priority_list = {"Brak","Niski","Średni","Wysoki"};
    public static final  String[]   status_list = {"Zakończony" ,"Oczekujący","W Realizacji"};


    @FXML
    void accessCheck() {
        switch (LoginController.grantAccess) {
            case 1:
                add_task.setDisable(true);
                delete_task.setDisable(true);
                break;
        }}
    @FXML
    /* ComboBox listener */
    private void comboAction(ActionEvent event) throws IOException, IllegalAccessException {
            Object selected = comboBox.getSelectionModel().getSelectedItem();
            if(selected.toString().equals("Generuj Raport"))
                new MainController().openNewWindow("reportconfiguration.fxml");




    }

    @FXML
    private void handleEditButtonAction(ActionEvent event) throws IOException {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        for (TaskEntity taskEntity:tasksList.getItems()
        ) {taskService.update(taskEntity);
        };

        session.close();


        tasksList.refresh();
    }

    @FXML
    private void handleAddButtonAction(ActionEvent event) throws IOException {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        TaskEntity emp_entity = new TaskEntity();
        emp_entity.setName(name_txtField.getText());
        emp_entity.setIndex(index_txtField.getText());
        emp_entity.setQuantity(Short.valueOf(quanity_txtField.getText()));
        emp_entity.setDone(Short.valueOf(done_txtField.getText()));
        emp_entity.setStatus(status_txtField.getText());
        emp_entity.setPiority(priority_txtField.getText());
        taskService.save(emp_entity);
        tasksList.getItems().add(emp_entity);
        session.close();
        tasksList.refresh();

    }


    @FXML
    private void handleDeleteButtonAction(ActionEvent event) throws  IOException{
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        TaskEntity emp_task = tasksList.getSelectionModel().getSelectedItem();
        taskService.delete(emp_task);
        tasksList.getItems().remove(emp_task);
        session.close();
        tasksList.refresh();
    }


    public void changeNameCellEvent(TableColumn.CellEditEvent cellEditEvent){
        TaskEntity taskSelected = tasksList.getSelectionModel().getSelectedItem();
        taskSelected.setName((String) cellEditEvent.getNewValue());



    }
    public void changeIndexCellEvent(TableColumn.CellEditEvent cellEditEvent){
        TaskEntity taskSelected = tasksList.getSelectionModel().getSelectedItem();
        taskSelected.setIndex((String) cellEditEvent.getNewValue());


    }
    public void changeQuantityCellEvent(TableColumn.CellEditEvent cellEditEvent){
        TaskEntity taskSelected = tasksList.getSelectionModel().getSelectedItem();
        Short emp = (Short) cellEditEvent.getNewValue();
        taskSelected.setQuantity(emp);


    }
    public void changeCountCellEvent(TableColumn.CellEditEvent cellEditEvent){
        TaskEntity taskSelected = tasksList.getSelectionModel().getSelectedItem();
        Short emp = (Short) cellEditEvent.getNewValue();
        taskSelected.setDone((emp));


    }
    public void changeStatusCellEvent(TableColumn.CellEditEvent cellEditEvent){
        TaskEntity taskSelected = tasksList.getSelectionModel().getSelectedItem();
        taskSelected.setStatus((String) cellEditEvent.getNewValue());
    }

    public void changePriorityCellEvent(TableColumn.CellEditEvent cellEditEvent){
        TaskEntity taskSelected = tasksList.getSelectionModel().getSelectedItem();
        taskSelected.setPiority((String) cellEditEvent.getNewValue());

    }
    String value;



    public void initialize() {
        accessCheck();
        /* Cell factory cell -> TaskEntity fields */
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        index.setCellValueFactory(new PropertyValueFactory<>("index"));
        quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        count.setCellValueFactory(new PropertyValueFactory<>("done"));
        status.setCellValueFactory(new PropertyValueFactory<>("status"));
        priority.setCellValueFactory(new PropertyValueFactory<>("piority"));


        /* Editing values in cells */
        name.setCellFactory(TextFieldTableCell.forTableColumn());
        index.setCellFactory(TextFieldTableCell.forTableColumn());
        quantity.setCellFactory(TextFieldTableCell.forTableColumn(new ShortStringConverter()));
        count.setCellFactory(TextFieldTableCell.forTableColumn(new ShortStringConverter()));
        status.setCellFactory(ChoiceBoxTableCell.forTableColumn(status_list));
        priority.setCellFactory(ChoiceBoxTableCell.forTableColumn(priority_list));
        /*  Adding choices to combo box */
        comboBox.getItems().add("Generuj Raport");
        comboBox.getItems().add("Opcja2");
        comboBox.getItems().add("Opcja3");
        /* Event handling for ComboBox */


        anchorPane.getStyleClass().add(JMetroStyleClass.BACKGROUND);
        tasksList.getItems().addAll(taskService.getAll());


    }

}
