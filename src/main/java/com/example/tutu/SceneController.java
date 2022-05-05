package com.example.tutu;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    public void switchToDigits (ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("digits.fxml"));
        Image icon = new Image("C:\\Users\\HP\\IdeaProjects\\Tutu\\src\\cat.jpg");
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();

        scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("main.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

    public void switchToFloating (ActionEvent event) throws IOException{

        Parent root = FXMLLoader.load(getClass().getResource("Floating.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("main.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

    public void switchToMain (ActionEvent event) throws IOException{

        Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("main.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

}
