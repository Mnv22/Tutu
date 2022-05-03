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

public class Application extends javafx.application.Application {
    @Override
    public void start(Stage stage) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));

        //Group root = new Group();
        Scene scene = new Scene(root, Color.CORAL);
        scene.getStylesheets().add(getClass().getResource("main.css").toExternalForm());

        Image icon = new Image("C:\\Users\\HP\\IdeaProjects\\Tutu\\src\\cat.jpg");

        Text text = new Text();
        text.setText("Tutu is best cat.");
        text.setX(50);
        text.setY(50);
        text.setFont(Font.font("Verdana",50));
        text.setFill(Color.DARKGREEN);

        //root.getChildren().add(text);

        stage.setScene(scene);
        stage.setTitle("Tutu!");
        stage.getIcons().add(icon);
        stage.setWidth(1200);
        stage.setHeight(800);
        //stage.setFullScreen(true);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}