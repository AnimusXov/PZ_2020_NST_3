package org.main;

import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import jfxtras.styles.jmetro.JMetroStyleClass;
import org.entities.TaskEntity;
import org.entities.UserEntity;
import org.hibernateutil.HibernateUtil;
import org.service.GenericServiceImpl;
import org.service.IGenericService;

import java.util.List;

public class TasksController {
    public ChoiceBox actionBox;
    public TableView<TaskEntity> tasksList;

    public TableColumn<Object, Object> name;
    public TableColumn<Object, Object> index;
    public TableColumn<Object, Object> quantity;
    public TableColumn<Object, Object> count;
    public TableColumn<Object, Object> status;
    public TableColumn<Object, Object> priority;
    public AnchorPane anchorPane;


    public void initialize() {

        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        index.setCellValueFactory(new PropertyValueFactory<>("index"));
        quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        count.setCellValueFactory(new PropertyValueFactory<>("done"));
        status.setCellValueFactory(new PropertyValueFactory<>("status"));
        priority.setCellValueFactory(new PropertyValueFactory<>("piority"));

        IGenericService<TaskEntity> taskService = new GenericServiceImpl<>(
                TaskEntity.class, HibernateUtil.getSessionFactory());



        actionBox.getItems().removeAll(actionBox.getItems());
        actionBox.getItems().addAll("Zmień Stan", "Raportuj", "Gen. Raport", "Wstrzymaj");
        actionBox.getSelectionModel().select("Zmień Stan");

        anchorPane.getStyleClass().add(JMetroStyleClass.BACKGROUND);
        tasksList.getItems().addAll(taskService.getAll());


    }
}
