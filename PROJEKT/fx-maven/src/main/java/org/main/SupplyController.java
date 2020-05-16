package org.main;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;
import javafx.util.converter.IntegerStringConverter;
import jfxtras.styles.jmetro.JMetroStyleClass;
import org.entities.SupplyEntity;
import org.entities.TaskEntity;
import org.hibernate.Session;
import org.hibernateutil.HibernateUtil;
import org.service.GenericServiceImpl;
import org.service.IGenericService;

import java.io.IOException;

public class SupplyController {
    public Button add_supply;
    public Button delete_supply;
    public Button edit_supply;
    public TableView<SupplyEntity> supply_tableView;
    public TableColumn<SupplyEntity, String> name;
    public TableColumn metal;
    public TableColumn wood;
    public TableColumn composite;
    public TableColumn marble;
    public TableColumn stone;
    public TextField metal_txt_field;
    public TextField wood_txt_field;
    public TextField composite_txt_field;
    public TextField marble_txt_field;
    public TextField stone_txt_field;
    public AnchorPane anchorPane;
    public TextField name_txt_field;
    ObservableList<SupplyEntity> listForDb = FXCollections.observableArrayList();
    IGenericService<SupplyEntity> supplyService = new GenericServiceImpl<>(
            SupplyEntity.class, HibernateUtil.getSessionFactory());
    @FXML
    private void handleEditButtonAction(ActionEvent event) throws IOException {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        for (SupplyEntity supply:supply_tableView.getItems()
             ) {session.update(supply);
        }
        session.getTransaction().commit();
        session.close();
        supply_tableView.refresh();
    }
    @FXML
    private void handleAddButtonAction(ActionEvent event) throws IOException {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        SupplyEntity emp_supply = new SupplyEntity();
        emp_supply.setName(name_txt_field.getText());
        emp_supply.setMetallicMaterials(Integer.parseInt(metal_txt_field.getText()));
        emp_supply.setWoodenMaterials(Integer.parseInt(wood_txt_field.getText()));
        emp_supply.setComposites(Integer.parseInt(composite_txt_field.getText()));
        emp_supply.setMarble(Integer.parseInt(marble_txt_field.getText()));
        emp_supply.setStoneMaterials(Integer.parseInt(stone_txt_field.getText()));
        supplyService.save(emp_supply);
        session.close();
        supply_tableView.getItems().add(emp_supply);
        supply_tableView.refresh();


    }


    @FXML
    private void handleDeleteButtonAction(ActionEvent event) throws  IOException{
       Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
       SupplyEntity emp_supply = supply_tableView.getSelectionModel().getSelectedItem();
       supplyService.delete(emp_supply);
       session.getTransaction().commit();
       session.close();
       supply_tableView.getItems().remove(emp_supply);
       supply_tableView.refresh();
    }






    boolean checkIfValid(Integer emp){
        return emp!=null && emp>0;
    }



    public void changeNameCellEvent(TableColumn.CellEditEvent cellEditEvent){
        SupplyEntity supplySelected = supply_tableView.getSelectionModel().getSelectedItem();
        supplySelected.setName((String) cellEditEvent.getNewValue());



    }

    public void changeMetalCellEvent(TableColumn.CellEditEvent cellEditEvent){
        SupplyEntity supplySelected = supply_tableView.getSelectionModel().getSelectedItem();
        Integer  emp = (int) cellEditEvent.getNewValue();
        if(checkIfValid(emp)){
        supplySelected.setMetallicMaterials(emp);
        }

    }
    public void changeWoodCellEvent(TableColumn.CellEditEvent cellEditEvent){
        SupplyEntity supplySelected = supply_tableView.getSelectionModel().getSelectedItem();
        Integer  emp = (int) cellEditEvent.getNewValue();
        if(checkIfValid(emp))
        supplySelected.setWoodenMaterials(emp);
    }
    public void changeCompositesCellEvent(TableColumn.CellEditEvent cellEditEvent){
        SupplyEntity supplySelected = supply_tableView.getSelectionModel().getSelectedItem();
        Integer  emp = (int) cellEditEvent.getNewValue();
        if(checkIfValid(emp))
        supplySelected.setComposites(emp);
    }
    public void changeMarbleCellEvent(TableColumn.CellEditEvent cellEditEvent){
        SupplyEntity supplySelected = supply_tableView.getSelectionModel().getSelectedItem();
        Integer  emp = (int) cellEditEvent.getNewValue();
        if(checkIfValid(emp))
        supplySelected.setMarble(emp);
    }
    public void changeStoneCellEvent(TableColumn.CellEditEvent cellEditEvent){
        SupplyEntity supplySelected = supply_tableView.getSelectionModel().getSelectedItem();
        Integer  emp = (int) cellEditEvent.getNewValue();
        if(checkIfValid(emp))
        supplySelected.setStoneMaterials(emp);
    }

    @FXML
    void initialize() {

        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        metal.setCellValueFactory(new PropertyValueFactory<Object, Object>("metallicMaterials"));
        wood.setCellValueFactory(new PropertyValueFactory<>("woodenMaterials"));
        composite.setCellValueFactory(new PropertyValueFactory<>("composites"));
        marble.setCellValueFactory(new PropertyValueFactory<>("marble"));
        stone.setCellValueFactory(new PropertyValueFactory<>("stoneMaterials"));


        name.setCellFactory(TextFieldTableCell.forTableColumn());
        metal.setCellFactory(TextFieldTableCell.<SupplyEntity, Integer>forTableColumn(new IntegerStringConverter()));
        wood.setCellFactory(TextFieldTableCell.<SupplyEntity, Integer>forTableColumn(new IntegerStringConverter()));
        composite.setCellFactory(TextFieldTableCell.<SupplyEntity, Integer>forTableColumn(new IntegerStringConverter()));
        marble.setCellFactory(TextFieldTableCell.<SupplyEntity, Integer>forTableColumn(new IntegerStringConverter()));
        stone.setCellFactory(TextFieldTableCell.<SupplyEntity, Integer>forTableColumn(new IntegerStringConverter()));

        supply_tableView.getItems().addAll(supplyService.getAll());

        anchorPane.getStyleClass().add(JMetroStyleClass.BACKGROUND);

    }
}
