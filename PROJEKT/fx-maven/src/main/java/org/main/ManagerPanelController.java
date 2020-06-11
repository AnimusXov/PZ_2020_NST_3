package org.main;

import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;
import jfxtras.styles.jmetro.JMetroStyleClass;
import org.entities.DepartmentsEntity;
import org.entities.EmployeeEntity;
import org.hibernate.Session;
import org.hibernateutil.HibernateUtil;
import org.utils.ServiceUtils;

import java.io.IOException;

public class ManagerPanelController {


    public AnchorPane anchorPane;
    public TableView<EmployeeEntity> employee_list;
    public TableColumn<EmployeeEntity, String> firstCol;
    public TableColumn<EmployeeEntity, String> secondCol;
    public TableColumn<EmployeeEntity, String> thirdCol;
    public ChoiceBox<DepartmentsEntity> select_dep;
    public Button confirm_changes;


    ServiceUtils utils = new ServiceUtils();

    @FXML
    private void handleConfirmButtonAction(ActionEvent event) throws IOException {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        for (EmployeeEntity temp_emp:employee_list.getItems())
        { utils.getEmployeeService().update(temp_emp);
         }
        employee_list.refresh();

session.close();
    }
    @FXML
    private ObservableList depListConfigurator(){
        ObservableList<DepartmentsEntity> dep_names = FXCollections.observableArrayList();
        dep_names.addAll(utils.getDepService().getAll());
        return dep_names;
    }

    @FXML
    public void changeNameCellEvent(TableColumn.CellEditEvent cellEditEvent){
        EmployeeEntity employeeSelected = employee_list.getSelectionModel().getSelectedItem();
        employeeSelected.setName((String) cellEditEvent.getNewValue());
    }
    @FXML
    public void changeSurnameCellEvent(TableColumn.CellEditEvent cellEditEvent){
        EmployeeEntity employeeSelected = employee_list.getSelectionModel().getSelectedItem();
        employeeSelected.setSurname((String) cellEditEvent.getNewValue());
    }
    public void changeDepartmentCellEvent(TableColumn.CellEditEvent cellEditEvent){
        EmployeeEntity empSelected = employee_list.getSelectionModel().getSelectedItem();
        empSelected.setDepartament((DepartmentsEntity) cellEditEvent.getNewValue());
    }


    @FXML
    void ColumnsConfigurator(ObservableList dep_names){
        firstCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        secondCol.setCellValueFactory(new PropertyValueFactory<>("surname"));
        thirdCol.setCellValueFactory(cellData ->
                new SimpleObjectProperty<>(cellData.getValue().getDepartament().getDep_name()));

        firstCol.setCellFactory(TextFieldTableCell.forTableColumn());
        secondCol.setCellFactory(TextFieldTableCell.forTableColumn());
        thirdCol.setCellFactory(ComboBoxTableCell.forTableColumn(dep_names));
        employee_list.getItems().addAll(utils.getEmployeeService().getAll());

    }


    @FXML
    void initialize() {
        ColumnsConfigurator(depListConfigurator());
        anchorPane.getStyleClass().add(JMetroStyleClass.BACKGROUND);
    }
}
