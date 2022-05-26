package com.example.tutu;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Application extends javafx.application.Application {
    private static Stage stg;
    private Parent root;
    private Scene scene;

    @Override
    public void start(Stage stage) throws Exception {

        stg=stage;
        Parent root = FXMLLoader.load(getClass().getResource("Menu.fxml"));

        Scene scene = new Scene(root, Color.CORAL);
        scene.getStylesheets().add(getClass().getResource("main.css").toExternalForm());

        Image icon = new Image("file:src/main/resources/Images/cat.png");

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

    public void changetoResult(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Results.fxml"));
        root = loader.load();

        Results rd = loader.getController();
        rd.readResults("src/results.txt");

        stg = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stg.setScene(scene);
        stg.show();
        root.requestFocus();
    }

    public static void main(String[] args) {
        launch(args);
    }
}