package com.example.tutu;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
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
    @FXML
    private ImageView cat;
    @FXML
    private Label labelResult;

    benchmark_FP bench=new benchmark_FP();

    public Menu(){
    }



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

    @FXML
    public void switchToResults (ActionEvent event) throws IOException{

        Application app=new Application();
        app.changetoResult(event);
        /*Parent root = FXMLLoader.load(getClass().getResource("Results.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("main.css").toExternalForm());
        stage.setScene(scene);
        stage.show();*/
    }

    @FXML
    public void benchmark_FixedPoint() throws IOException, InterruptedException {
        Results results = new Results();
        double MOPS= bench.run();
        labelResult.setId("id2");
        labelResult.setText("Score: " + Double.toString(MOPS));
        results.writeResults(Double.toString(MOPS),"src/resultsFixed.txt");
        labelResult.setAlignment(Pos.CENTER);
        cat.setId("id");

    }

    @FXML
    public  void describeDP(MouseEvent event) throws IOException{
        cat.setId("id");
        label_Cuteness.setFont(new Font("Cooper Black",30));
        label_Cuteness.setText("This benchmark tries to stress the CPU by computing a large number of digits of the transcendental number PI, using a spigot algorithm.");
    }

    @FXML
    public  void describeFP(MouseEvent event) throws IOException{
        cat.setId("id");
        label_Cuteness.setFont(new Font("Cooper Black",30));
        label_Cuteness.setText("This benchmark method will run the integer arithmetic test: it uses a wide array of operators between multiple local variables.");
    }


    @FXML
    public void clear(MouseEvent event) throws  IOException{
        cat.setId("id2");
        label_Cuteness.setFont(new Font("Cooper Black",74));
        label_Cuteness.setText("");
    }
}
