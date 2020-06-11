package org.main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.AnchorPane;
import jfxtras.styles.jmetro.JMetroStyleClass;
import org.entities.DepartmentsEntity;
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
    public CheckBox checkBox_depForEmp;
    public ChoiceBox<DepartmentsEntity> choiceBox_dep;
    public CheckBox isDep;
    public CheckBox isPio;
    public CheckBox isStatus;
    ServiceUtils utils = new ServiceUtils();
    String priority;
    String status;
    DepartmentsEntity dep;
    boolean priority_status;
    boolean status_status;
    boolean dep_status;

    public void initialize(){
        choiceBox_priority.getItems().addAll(TasksController.priority_list);
        choiceBox_status.getItems().addAll(TasksController.status_list);
        choiceBox_status.setValue("");
        choiceBox_priority.setValue("");
        anchorPane.getStyleClass().add(JMetroStyleClass.BACKGROUND);
        choiceBox_dep.getItems().addAll(utils.getDepService().getAll());


    }

    private void getParamValues(){
        priority =  choiceBox_priority.getSelectionModel().getSelectedItem();
        status   = choiceBox_status.getSelectionModel().getSelectedItem();
        dep = choiceBox_dep.getSelectionModel().getSelectedItem();
    }
    private void getCheckBoxStates(){
       priority_status = isPio.isSelected();
       status_status = isStatus.isSelected();
        dep_status = isDep.isSelected();
    }

    @FXML
    private void handleGenerateButtonAction(ActionEvent event) throws IOException, IllegalAccessException {
        DocTemplate doc = new DocTemplate();
        ReportGen.initialize();
        if(check_task.isSelected()) {
            getParamValues();
            getCheckBoxStates();
            new ReportGen().parameterizedArrayGenerator(new ServiceUtils().getTaskService(),
                    priority, status, dep,
                    priority_status, status_status, dep_status, doc);
        }

            if(check_employee.isSelected())
                new ReportGen().employeeToTableConverter(doc,checkBox_depForEmp.isSelected());

            if(check_warehouse.isSelected())
                 new ReportGen().WarehouseTableGenerator(doc);


        doc.getDoc().close();



    }
}
