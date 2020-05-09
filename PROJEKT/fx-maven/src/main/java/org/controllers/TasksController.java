package org.controllers;

import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import jfxtras.styles.jmetro.JMetroStyleClass;
import org.entities.TaskEntity;
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

    private void setTableEditable() {
        tasksList.setEditable(true);
        // allows the individual cells to be selected
        tasksList.getSelectionModel().cellSelectionEnabledProperty().set(true);
        // when character or numbers pressed it will start edit in editable
        // fields
        tasksList.setOnKeyPressed(event -> {
            if (event.getCode().isLetterKey() || event.getCode().isDigitKey()) {
                editFocusedCell();
            } else if (event.getCode() == KeyCode.RIGHT
                    || event.getCode() == KeyCode.TAB) {
                tasksList.getSelectionModel().selectNext();
                event.consume();
            } else if (event.getCode() == KeyCode.LEFT) {
                selectPrevious();
                event.consume();
            }
        });
    }

    @SuppressWarnings("unchecked")
    private void editFocusedCell() {
        final TablePosition<TaskEntity, ?> focusedCell = tasksList
                .focusModelProperty().get().focusedCellProperty().get();
        tasksList.edit(focusedCell.getRow(), focusedCell.getTableColumn());
    }

    @SuppressWarnings("unchecked")
    private void selectPrevious() {
        if (tasksList.getSelectionModel().isCellSelectionEnabled()) {

            TablePosition<TaskEntity, ?> pos = tasksList.getFocusModel()
                    .getFocusedCell();
            if (pos.getColumn() - 1 >= 0) {
                // przejdz do poprzedniego
                tasksList.getSelectionModel().select(pos.getRow(),
                        getTableColumn(pos.getTableColumn(), -1));
            } else if (pos.getRow() < tasksList.getItems().size()) {
                // zapakuj koniec
                tasksList.getSelectionModel().select(pos.getRow() - 1,
                        tasksList.getVisibleLeafColumn(
                                tasksList.getVisibleLeafColumns().size() - 1));
            }
        } else {
            int focusIndex = tasksList.getFocusModel().getFocusedIndex();
            if (focusIndex == -1) {
                tasksList.getSelectionModel().select(tasksList.getItems().size() - 1);
            } else if (focusIndex > 0) {
                tasksList.getSelectionModel().select(focusIndex - 1);
            }
        }
    }

    private TableColumn<TaskEntity, ?> getTableColumn(
            final TableColumn<TaskEntity, ?> column, int offset) {
        int columnIndex = tasksList.getVisibleLeafIndex(column);
        int newColumnIndex = columnIndex + offset;
        return tasksList.getVisibleLeafColumn(newColumnIndex);
    }
    public void initialize() {
        setTableEditable();
        editFocusedCell();
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
