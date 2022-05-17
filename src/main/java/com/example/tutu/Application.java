package com.example.tutu;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Application extends javafx.application.Application {
    private static Stage stg;

    @Override
    public void start(Stage stage) throws Exception {

        stg=stage;
        Parent root = FXMLLoader.load(getClass().getResource("Menu.fxml"));

        Scene scene = new Scene(root, Color.CORAL);
        scene.getStylesheets().add(getClass().getResource("main.css").toExternalForm());

        Image icon = new Image("file:src/main/resources/Images/cat.jpg");

        stage.setScene(scene);
        stage.setTitle("Tutu!");
        stage.getIcons().add(icon);
        stage.setWidth(1200);
        stage.setHeight(800);
        stage.setResizable(false);
        stage.show();
    }

    public void changeScene(String fxml) throws IOException{
        Parent pane= FXMLLoader.load(Objects.requireNonNull(getClass().getResource(fxml)));
        stg.getScene().setRoot(pane);

    }

    public static void main(String[] args) {
        launch(args);
    }
}