package org.example;

import org.example.status.Brulure;
import org.example.status.Paralysie;
import org.example.status.Poison;
import org.example.status.Statut;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/menu.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);

            primaryStage.setTitle("Pokémon Game");
            primaryStage.setScene(scene);
            primaryStage.show(); // Display the window

        } catch (Exception e) {
            System.err.println("ERROR: Unable to load the FXML file!");
            e.printStackTrace();
        }

    }



    public static void main(String[] args) {

        launch(args);

    }
}
