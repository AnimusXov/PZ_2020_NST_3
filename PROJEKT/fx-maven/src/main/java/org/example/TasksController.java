package org.example;

import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;

import java.util.ArrayList;

public class TasksController {
    public ChoiceBox actionBox;
    public ListView tasksList;



    public void initialize() {
        tasksList.setEditable(true);
        Task task = new Task(1,"Detal","12.INVO.1120/15",20,5,"W realizacji");
        actionBox.getItems().removeAll(actionBox.getItems());
        actionBox.getItems().addAll("Zmień Stan", "Raportuj", "Gen. Raport", "Wstrzymaj");
        actionBox.getSelectionModel().select("Zmień Stan");
        ArrayList <String> testlist = new ArrayList<>();
        testlist.add("test1");
        testlist.add("test2");
        testlist.add("test3");
        testlist.add(task.toString());
        tasksList.getItems().addAll(testlist);
    }
}
