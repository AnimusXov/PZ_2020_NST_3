package org.main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.AnchorPane;
import jfxtras.styles.jmetro.JMetroStyleClass;
import org.reportgenerator.DocTemplate;
import org.reportgenerator.ReportGen;
import org.utils.ServiceUtils;

import java.io.IOException;

public class ReportConfigurationController {
    public AnchorPane anchorPane;
    public CheckBox check_task;
    public CheckBox check_employee;
    public Button generate_report;
    public CheckBox check_warehouse;
    public ChoiceBox<String> choiceBox_priority;
    public ChoiceBox<String> choiceBox_status;

    public void initialize(){
        choiceBox_priority.getItems().addAll(TasksController.priority_list);
        choiceBox_status.getItems().addAll(TasksController.status_list);
        anchorPane.getStyleClass().add(JMetroStyleClass.BACKGROUND);
    }


    @FXML
    private void handleGenerateButtonAction(ActionEvent event) throws IOException, IllegalAccessException {
        DocTemplate doc = new DocTemplate();
        ReportGen.initialize();
        if(check_task.isSelected())
            new ReportGen().parameterizedArrayGenerator(new ServiceUtils().getTaskService(),
                    choiceBox_status.getSelectionModel().getSelectedItem(),doc);
            if(check_employee.isSelected())
                new ReportGen().employeeToTableConverter(doc);
             doc.getDoc().close();


    }
}
