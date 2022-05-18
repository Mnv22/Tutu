package com.example.tutu;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

public class Results {
    @FXML
    public void switchToMain (ActionEvent event) throws IOException {
        Application app=new Application();
        app.changeScene("Menu.fxml");
    }
}
