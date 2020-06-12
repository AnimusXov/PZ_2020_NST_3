package org.main;

import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.*;
import javafx.scene.layout.AnchorPane;
import javafx.util.converter.ShortStringConverter;
import jfxtras.styles.jmetro.JMetroStyleClass;
import org.entities.DepartmentsEntity;
import org.entities.TaskEntity;
import org.hibernate.Session;
import org.hibernateutil.HibernateUtil;
import org.service.GenericServiceImpl;
import org.service.IGenericService;
import org.utils.ServiceUtils;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

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
    public TextField done_txtField;
    public ComboBox<String> comboBox;
    public ComboBox<DepartmentsEntity> comboBox_dep;
    public ComboBox<String> action_Box_status;
    public ComboBox<String> actionBox_priority;
    public TableColumn<TaskEntity, String> dep;
    public TextField quantity_txtField;
    public Button taskDoneButton;


    ServiceUtils utils = new ServiceUtils();
    IGenericService<TaskEntity> taskService = new GenericServiceImpl<>(
            TaskEntity.class, HibernateUtil.getSessionFactory());
    public static final String[] priority_list = {"","Niski","Średni","Wysoki"};
    public static final  String[]   status_list = {"","Zakończony" ,"Oczekujący","W Realizacji"};
    public int dep_number;




    @FXML
    ObservableList<DepartmentsEntity> comboBoxForTableCell(){
        ObservableList<DepartmentsEntity> dep_names = FXCollections.observableArrayList();
        dep_names.addAll(utils.getDepService().getAll());
        dep_number = dep_names.size();
        return dep_names;
    }

    @FXML
    void accessCheck() {
        if (LoginController.grantAccess == 1) {
            add_task.setDisable(true);
            delete_task.setDisable(true);
            comboBox.setDisable(true);
        }
    }
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
        tasksList.getItems().clear();
        tasksList.getItems().addAll(taskService.getAll());
        tasksList.refresh();
        session.close();
    }
    /* Add new Task */
    @FXML
    private void handleAddButtonAction(ActionEvent event) throws IOException {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        TaskEntity emp_task = new TaskEntity();

        emp_task.setName(name_txtField.getText());
        emp_task.setIndex(index_txtField.getText());
        emp_task.setQuantity(Short.valueOf(quantity_txtField.getText()));
        emp_task.setDone(Short.valueOf(done_txtField.getText()));
        emp_task.setStatus(action_Box_status.getSelectionModel().getSelectedItem());
        emp_task.setPiority(actionBox_priority.getSelectionModel().getSelectedItem());

        DepartmentsEntity emp_dep = session.get(DepartmentsEntity.class,
                comboBox_dep.getSelectionModel().getSelectedIndex()+1);
        Set<TaskEntity> taskSet = new HashSet<TaskEntity>();



        taskSet.add(emp_task);
        emp_dep.setTask(taskSet);
        emp_task.setDepartament(emp_dep);

        session.update(emp_dep);
        session.persist(emp_task);
        session.getTransaction().commit();
        tasksList.getItems().add(emp_task);
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
    @FXML
    private void handleTaskDoneButtonAction(ActionEvent event){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
       TaskEntity temp = tasksList.getSelectionModel().getSelectedItem();
       int test = temp.getDepartament().getDepId();
        if(test>dep_number){
            temp.getDepartament().setDepId(1);
        }
        else {
          temp.getDepartament().setDepId(test+1);
            System.out.println(temp);
        }
      utils.getTaskService().update(temp);
session.close();
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
    public void changeDepartmentCellEvent(TableColumn.CellEditEvent cellEditEvent){
        TaskEntity taskSelected = tasksList.getSelectionModel().getSelectedItem();
        taskSelected.setDepartament((DepartmentsEntity) cellEditEvent.getNewValue());
    }

    String value;

    @FXML
    void columnsConfigurator(ObservableList dep_names){
        comboBox_dep.getItems().addAll(utils.getDepService().getAll());
        actionBox_priority.getItems().addAll(priority_list);
        action_Box_status.getItems().addAll(status_list);

        /* Cell factory cell -> TaskEntity fields */
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        index.setCellValueFactory(new PropertyValueFactory<>("index"));
        quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        count.setCellValueFactory(new PropertyValueFactory<>("done"));
        status.setCellValueFactory(new PropertyValueFactory<>("status"));
        priority.setCellValueFactory(new PropertyValueFactory<>("piority"));
        dep.setCellValueFactory(cellData ->
                new SimpleObjectProperty<>(cellData.getValue().getDepartament().getDep_name()));

        /* Editing values in cells */
        name.setCellFactory(TextFieldTableCell.forTableColumn());
        index.setCellFactory(TextFieldTableCell.forTableColumn());
        quantity.setCellFactory(TextFieldTableCell.forTableColumn(new ShortStringConverter()));
        count.setCellFactory(TextFieldTableCell.forTableColumn(new ShortStringConverter()));
        status.setCellFactory(ChoiceBoxTableCell.forTableColumn(status_list));
        priority.setCellFactory(ChoiceBoxTableCell.forTableColumn(priority_list));
        dep.setCellFactory(ComboBoxTableCell.forTableColumn(dep_names));

        comboBox.getItems().add("Generuj Raport");
        tasksList.getItems().addAll(taskService.getAll());
        getData();
    }
    @FXML
    void getData(){
        if(LoginController.grantAccess==1){
           tasksList.getItems().removeIf(taskEntity -> !taskEntity.getDepartament().getDep_name().equals(LoginController.userDepName));
           System.out.println("deleted  \n");
           tasksList.refresh();
        }


    }


    public void initialize() throws NoSuchFieldException {
        accessCheck();
        columnsConfigurator(comboBoxForTableCell());
        anchorPane.getStyleClass().add(JMetroStyleClass.BACKGROUND);

    }

}
