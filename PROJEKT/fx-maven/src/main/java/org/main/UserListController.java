package org.main;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import jfxtras.styles.jmetro.JMetroStyleClass;

public class UserListController {
    public AnchorPane anchorPane;


    @FXML
    void initialize(){
        anchorPane.getStyleClass().add(JMetroStyleClass.BACKGROUND);
    }
}
