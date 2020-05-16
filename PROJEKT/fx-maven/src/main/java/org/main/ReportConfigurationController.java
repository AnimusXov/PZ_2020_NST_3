package org.main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.AnchorPane;
import jfxtras.styles.jmetro.JMetroStyleClass;
import org.reportgenerator.DocTemplate;
import org.reportgenerator.ReportGen;

import java.io.IOException;

public class ReportConfigurationController {
    public AnchorPane anchorPane;
    public CheckBox check_task;
    public CheckBox check_employee;
    public Button generate_report;

    public void initialize(){
        anchorPane.getStyleClass().add(JMetroStyleClass.BACKGROUND);
    }


    @FXML
    private void handleGenerateButtonAction(ActionEvent event) throws IOException, IllegalAccessException {
        DocTemplate doc = new DocTemplate();
        ReportGen.initialize();
        if(check_task.isSelected())
            new ReportGen().taskToTableConverter(doc);
            if(check_employee.isSelected())
                new ReportGen().employeeToTableConverter(doc);
             doc.getDoc().close();


    }
}
