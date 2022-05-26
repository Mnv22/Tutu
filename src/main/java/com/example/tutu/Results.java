package com.example.tutu;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import java.io.*;
import java.util.Scanner;

public class Results {

    @FXML
    private Label title;
    @FXML
    private Label results;
    @FXML
    private ImageView cat;

    @FXML
    public void switchToMain (ActionEvent event) throws IOException {
        Application app=new Application();
        app.changeScene("Menu.fxml");
    }

    public void resultsDigits() {
        cat.setId("id");
        title.setText("Digits of Pi Results");
        readResults("src/resultsDigits.txt");
    }

    public void resultsFixed() {
        cat.setId("id");
        title.setText("Fixed Point Results");
        readResults("src/resultsFixed.txt");
    }

    @FXML
    public void readResults(String path) {

        try {
            File file = new File(path);
            Scanner scanner = new Scanner(file);
            String text = "";
            while (scanner.hasNextLine()) {
                text = text + scanner.nextLine() +"\n";
            }
            results.setText(text);
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void writeResults(String text, String path) {
        try {
            FileWriter fw = new FileWriter(path, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(text);
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
