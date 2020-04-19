package org.main;

import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import jfxtras.styles.jmetro.JMetroStyleClass;

public class TasksController {
    public ChoiceBox actionBox;
    public TableView<Task> tasksList;
    public TableColumn<Object, Object> id;
    public TableColumn<Object, Object> name;
    public TableColumn<Object, Object> index;
    public TableColumn<Object, Object> quantity;
    public TableColumn<Object, Object> count;
    public TableColumn<Object, Object> status;
    public TableColumn<Object, Object> priority;
    public AnchorPane anchorPane;


    public void initialize() {
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        index.setCellValueFactory(new PropertyValueFactory<>("index"));
        quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        count.setCellValueFactory(new PropertyValueFactory<>("done"));
        status.setCellValueFactory(new PropertyValueFactory<>("status"));
        priority.setCellValueFactory(new PropertyValueFactory<>("priority"));

        Task task = new Task(1,"Wyrób Metalowy","11.INVO.1120/15",3,1,"W realizacji","Wysoki");
        Task task2 = new Task(2,"Wyrób Drewniany","12.INVO.1195/16",20,20,"Gotowy","Sredni");
        Task task3 = new Task(3,"Wyrób Kompozytowy","13.INVO.1132/18",100,45,"Przerwany","Niski");

        actionBox.getItems().removeAll(actionBox.getItems());
        actionBox.getItems().addAll("Zmień Stan", "Raportuj", "Gen. Raport", "Wstrzymaj");
        actionBox.getSelectionModel().select("Zmień Stan");

        anchorPane.getStyleClass().add(JMetroStyleClass.BACKGROUND);
        tasksList.getItems().add(task);
        tasksList.getItems().add(task2);
        tasksList.getItems().add(task3);

    }
}
