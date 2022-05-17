package com.example.tutu;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import com.example.tutu.benchmark.benchmark_FP;

import java.io.IOException;

public class Menu {

    @FXML
    private Button button_DigitsOfPi;
    @FXML
    private Button button_FixedPoint;
    @FXML
    private Button button_Results;
    @FXML
    private Label label_Cuteness;

    benchmark_FP bench=new benchmark_FP();

    public Menu(){}



    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    public void switchToDigits (ActionEvent event) throws IOException {

        Application app=new Application();
        app.changeScene("Digits.fxml");
        /*Parent root = FXMLLoader.load(getClass().getResource("Digits.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();

        scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("main.css").toExternalForm());
        stage.setScene(scene);
        stage.show();*/
    }

    /*@FXML
    public void switchToFloating (ActionEvent event) throws IOException{

        Parent root = FXMLLoader.load(getClass().getResource("Floating.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("main.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }*/

    @FXML
    public void benchmark_FixedPoint() throws IOException{
        double MOPS= bench.run();
        label_Cuteness.setText(Double.toString(MOPS));

    }

    @FXML
    public void switchToResults(ActionEvent event) throws IOException{}


}
