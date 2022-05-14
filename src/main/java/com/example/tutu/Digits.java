package com.example.tutu;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;

public class Digits {

    @FXML
    private Button button_Stop;
    @FXML
    private Button button_GL;
    @FXML
    private Button button_MC;
    @FXML
    private Button button_Back;
    @FXML
    private Label label_GL;

    @FXML
    public void switchToMain (ActionEvent event) throws IOException {
    Application app=new Application();
    app.changeScene("Menu.fxml");
    /*
        Parent root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("main.css").toExternalForm());
        stage.setScene(scene);
        stage.show();

     */
    }

    @FXML
    public void stop(ActionEvent event) throws IOException {}

    @FXML
    public void benchmarkGaussLegendre(ActionEvent event) throws IOException{}

    @FXML
    public void benchmarkMonteCarlo(ActionEvent event) throws IOException{}

    @FXML
    public  void describeGL(ActionEvent event) throws IOException{
        label_GL.setText("It is notable for being rapidly convergent, with only 25 iterations producing 45 million correct digits of π. However, the drawback is that it is computer memory-intensive");
    }
}
