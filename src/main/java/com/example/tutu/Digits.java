package com.example.tutu;

import com.example.tutu.benchmark.logger.TimeUnit;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import com.example.tutu.benchmark.benchmark_PI_GL;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Digits implements Initializable {

   ObservableList<String> digits = FXCollections.observableArrayList("1000","5000","10000");

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
    private ImageView cat;
    @FXML
    private Label paw;

    benchmark_PI_GL bench= new benchmark_PI_GL();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        choice_Digits.setItems(digits);
        choice_Digits.setValue("1000");
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

        int digits;
        String choice=choice_Digits.getValue();
        if(choice.equals("1000"))
            digits=1000;
        else if(choice.equals("5000"))
            digits=5000;
        else
            digits=10000;


        long miliseconds=bench.run(digits);
        paw.setText(Long.toString(miliseconds));
        paw.setFont(new Font("Cooper Black",30));
        paw.setAlignment(Pos.CENTER);
    }

    @FXML
    public void benchmarkMonteCarlo(ActionEvent event) throws IOException{
        Application app=new Application();
        app.changeScene("Menu.fxml");
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
        label_MC.setText("Describe Monte Carlo algorithm or whatever other algorithm we choose to do");
    }

    @FXML
    public void clearMC(MouseEvent event) throws  IOException{
        label_MC.setText("");
    }

}
