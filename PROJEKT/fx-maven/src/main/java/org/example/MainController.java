package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {
    public Button userList;
    public Button manageUsers;
    public Button activeUsers;
    public Button taskList;

    @FXML
    void accessCheck() {
        switch (PrimaryController.grantAccess) {
            case 1:
                userList.setDisable(true);
                manageUsers.setDisable(true);
                activeUsers.setDisable(true);
                break;
            case 2:
                userList.setDisable(true);
                manageUsers.setDisable(true);
                break;


        }

    }

    @FXML
    private void openTasksWindow() throws IOException {

        FXMLLoader fxmlLoader = new
                FXMLLoader(getClass().getResource("tasks.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();

        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(new Scene(root1));
        stage.setResizable(false);

        stage.show();


    }




    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        openTasksWindow();



    }



    @FXML
    void initialize() {
        accessCheck();


    }
}
