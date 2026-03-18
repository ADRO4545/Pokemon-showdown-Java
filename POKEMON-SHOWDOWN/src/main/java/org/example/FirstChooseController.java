package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.util.Arrays;
import java.util.List;

public class FirstChooseController {

    @FXML
    private ImageView imgPlayer1, imgPlayer2, imgPlayer3, imgPlayer4;
    @FXML
    private Button btnPlayer1, btnPlayer2, btnPlayer3, btnPlayer4;

    private List<String> playerTeamNames;
    private List<String> enemyTeamNames; // To keep !! to transfer enemy data to fight part

    public void setTeamsData(List<String> playerNames, List<String> enemyNames) {
        this.playerTeamNames = playerNames;
        this.enemyTeamNames = enemyNames;

        displayPlayerTeam();
    }

    private void displayPlayerTeam() {
        List<ImageView> playerImages = Arrays.asList(imgPlayer1, imgPlayer2, imgPlayer3, imgPlayer4);
        List<Button> playerButtons = Arrays.asList(btnPlayer1, btnPlayer2, btnPlayer3, btnPlayer4);

        for (int i = 0; i < 4; i++) {
            if (i < playerTeamNames.size() && isPokemonValid(playerTeamNames.get(i))) {
                String pokemonName = playerTeamNames.get(i);
                setImage(playerImages.get(i), pokemonName);
                playerButtons.get(i).setText(pokemonName);
            } else {
                playerImages.get(i).setVisible(false);
                playerButtons.get(i).setVisible(false);
            }
        }
    }

    private void setImage(ImageView imageView, String pokemonName) {
        String imagePath = "/images/" + pokemonName + ".png";
        var resource = getClass().getResource(imagePath);
        if (resource != null) {
            imageView.setImage(new Image(resource.toExternalForm()));
        }
    }

    private boolean isPokemonValid(String name) {
        return name != null && !name.equals("Choisir un Pokemon") && !name.trim().isEmpty();
    }

    @FXML
    public void choosePokemon1(ActionEvent event) {
        launchFight(event, 0);
    }

    @FXML
    public void choosePokemon2(ActionEvent event) {
        launchFight(event, 1);
    }

    @FXML
    public void choosePokemon3(ActionEvent event) {
        launchFight(event, 2);
    }

    @FXML
    public void choosePokemon4(ActionEvent event) {
        launchFight(event, 3);
    }

    private void launchFight(ActionEvent event, int leadIndex) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fight.fxml"));
            Parent root = loader.load();
            FightController fightController = loader.getController();
            fightController.initData(playerTeamNames, enemyTeamNames, leadIndex);
            Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            primaryStage.setScene(new Scene(root));
            primaryStage.setTitle("Fight !");
            primaryStage.show();

        } catch (Exception e) {
            System.err.println("ERREUR : Impossible de charger fight.fxml");
            e.printStackTrace();
        }
    }
}