package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MenuController {

    @FXML
    public void newWindow(ActionEvent event) {
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/team-pokemon.fxml"));
            Parent root = loader.load();


            Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            Scene scene = new Scene(root);

            primaryStage.setTitle("Team Pokémons");
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (Exception e) {
            System.err.println("ERREUR : Impossible de charger le fichier FXML !");
            e.printStackTrace();
        }


    }



}
