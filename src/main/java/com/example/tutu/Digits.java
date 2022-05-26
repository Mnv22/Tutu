package com.example.tutu;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import com.example.tutu.benchmark.benchmark_PI_GL;
import com.example.tutu.benchmark.benchmark_PI_MC;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class Digits implements Initializable {

    //ObservableList<String> digits = FXCollections.observableArrayList("1000","5000","10000");
   // ObservableList<String> points = FXCollections.observableArrayList("100000","1000000","999999999");

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
    private Label label_MC;
    @FXML
    private ChoiceBox<String> choice_Digits;
    @FXML
    private ChoiceBox<String> choice_Points;
    @FXML
    private ImageView cat;
    @FXML
    private Label paw;

    @FXML
    private TextField no_of_points;

    @FXML
    private TextField no_of_digits;

    benchmark_PI_GL bench= new benchmark_PI_GL();

    benchmark_PI_MC benchMC= new benchmark_PI_MC();

   @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //choice_Digits.setItems(digits);
        //choice_Digits.setValue("1000");
    }

    @FXML
    public void switchToMain (ActionEvent event) throws IOException {
    Application app=new Application();
    app.changeScene("Menu.fxml");
    }

    @FXML
    public void stop(ActionEvent event) throws IOException {
        bench.stop();
        label_GL.setText("Cancelled");
    }

    @FXML
    public void benchmarkGaussLegendre(ActionEvent event) throws IOException, InterruptedException {
        paw.setText("Loading...");

        int digits = Integer.parseInt(no_of_digits.getText().toString());

        long miliseconds=bench.run(digits);

        paw.setText(Long.toString(miliseconds));
        paw.setFont(new Font("Cooper Black",30));
        paw.setAlignment(Pos.CENTER);
    }

    @FXML
    public void benchmarkMonteCarlo(ActionEvent event) throws IOException, InterruptedException {


        int points = Integer.parseInt(no_of_points.getText().toString());



        long miliseconds=benchMC.run(points);
        paw.setText(Long.toString(miliseconds));
        paw.setFont(new Font("Cooper Black",30));
        paw.setAlignment(Pos.CENTER);
    }

    @FXML
    public  void describeGL(MouseEvent event) throws IOException{
        label_GL.setText("It is notable for being rapidly convergent, with only 25 iterations producing 45 million correct digits of π. However, the drawback is that it is computer memory-intensive");
    }

    @FXML
    public void clearGL(MouseEvent event) throws  IOException{
        label_GL.setText("");
    }


    @FXML
    public  void describeMC(MouseEvent event) throws IOException{
        label_MC.setText("Monte Carlo method is a multiple probability simulation, used to estimate possible outcomes by generating multiple points in an area. The result is more accurate with the more points are generated.");
    }

    @FXML
    public void clearMC(MouseEvent event) throws  IOException{
        label_MC.setText("");
    }

}
