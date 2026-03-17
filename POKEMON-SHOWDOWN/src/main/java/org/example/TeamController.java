package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.control.Alert;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class TeamController {

    @FXML
    private ComboBox<String> comboT1P1;
    @FXML
    private ComboBox<String> comboT1P2;
    @FXML
    private ComboBox<String> comboT1P3;
    @FXML
    private ComboBox<String> comboT1P4;
    @FXML
    private ComboBox<String> comboT2P1;
    @FXML
    private ComboBox<String> comboT2P2;
    @FXML
    private ComboBox<String> comboT2P3;
    @FXML
    private ComboBox<String> comboT2P4;
    @FXML
    private Label nomT1P1;
    @FXML
    private Label nomT1P2;
    @FXML
    private Label nomT1P3;
    @FXML
    private Label nomT1P4;
    @FXML
    private Label nomT2P1;
    @FXML
    private Label nomT2P2;
    @FXML
    private Label nomT2P3;
    @FXML
    private Label nomT2P4;
    @FXML
    private ImageView imgT1P1;
    @FXML
    private ImageView imgT1P2;
    @FXML
    private ImageView imgT1P3;
    @FXML
    private ImageView imgT1P4;
    @FXML
    private ImageView imgT2P1;
    @FXML
    private ImageView imgT2P2;
    @FXML
    private ImageView imgT2P3;
    @FXML
    private ImageView imgT2P4;
    @FXML
    private ComboBox<String> itemT1P1;
    @FXML
    private ComboBox<String> itemT1P2;
    @FXML
    private ComboBox<String> itemT1P3;
    @FXML
    private ComboBox<String> itemT1P4;

    @FXML
    private ComboBox<String> itemT2P1;
    @FXML
    private ComboBox<String> itemT2P2;
    @FXML
    private ComboBox<String> itemT2P3;
    @FXML
    private ComboBox<String> itemT2P4;

    @FXML
    public void initialize() {

        HashMap<String, Type> type = Controller.findAllCoefType();
        HashMap<String, Status> status = Controller.findAllStatut();
        HashMap<String, Pokemon> pokemons = Controller.findAllPokemon(type, status);
        HashMap<String, Item> objectsCatalog = new HashMap<>();
        objectsCatalog.put("Restes", new Restes());
        objectsCatalog.put("NormalJewel", new NormalJewel());
        objectsCatalog.put("Sunglasses", new Sunglasses());
        objectsCatalog.put("Ball", new Ball());
        objectsCatalog.put("BaiePrine", new BaiePrine());

        List<ComboBox<String>> namesCombosPoke = this.listCombosPoke();
        List<ComboBox<String>> namesCombosObject = this.listCombosObject();

        for (ComboBox<String> cp : namesCombosPoke) {
            for (Pokemon p : pokemons.values()) {
                String nom = p.getName();
                cp.getItems().add(nom);
            }
            cp.getSelectionModel().select("Choisir un Pokemon");
        }

        for (ComboBox<String> co : namesCombosObject) {
            co.getItems().addAll(objectsCatalog.keySet());
            co.getSelectionModel().select("Choisir un Objet");
        }

        // Generate random enemy team (Team 2)
        generateRandomEnemyTeam(pokemons, objectsCatalog);
    }

    public List<Label> listLabels() {
        return Arrays.asList(nomT1P1, nomT1P2, nomT1P3, nomT1P4,
                nomT2P1, nomT2P2, nomT2P3, nomT2P4);
    }

    public List<ComboBox<String>> listCombosPoke() {
        return Arrays.asList(comboT1P1, comboT1P2, comboT1P3,
                comboT1P4, comboT2P1, comboT2P2, comboT2P3, comboT2P4);
    }

    public List<ComboBox<String>> listCombosObject() {
        return Arrays.asList(itemT1P1, itemT1P2, itemT1P3, itemT1P4,
                itemT2P1, itemT2P2, itemT2P3, itemT2P4);
    }

    public List<ImageView> listImages() {
        return Arrays.asList(imgT1P1, imgT1P2, imgT1P3, imgT1P4,
                imgT2P1, imgT2P2, imgT2P3, imgT2P4);
    }

    public void putPokemon() {
        List<ComboBox<String>> namesCombosPoke = this.listCombosPoke();
        List<Label> listLabels = this.listLabels();
        List<ImageView> images = this.listImages();

        for (int i = 0; i < namesCombosPoke.size(); i++) {
            updateSinglePokemonDisplay(namesCombosPoke.get(i), listLabels.get(i), images.get(i));
        }
    }

    private void updateSinglePokemonDisplay(ComboBox<String> combo, Label label, ImageView imageView) {
        String selectedPokemon = combo.getValue();

        if (isValidPokemonSelection(selectedPokemon)) {
            displayPokemon(selectedPokemon, label, imageView);
        } else {
            clearPokemonDisplay(label, imageView);
        }
    }

    private boolean isValidPokemonSelection(String pokemonName) {
        return pokemonName != null && !pokemonName.equals("Choisir un Pokemon") && !pokemonName.trim().isEmpty();
    }

    private void displayPokemon(String pokemonName, Label label, ImageView imageView) {
        label.setText(pokemonName);
        String imagePath = "/images/" + pokemonName + ".png";
        var resource = getClass().getResource(imagePath);
        
        if (resource != null) {
            imageView.setImage(new Image(resource.toExternalForm()));
        } else {
            // Prevent crash if image doesn't exist
            imageView.setImage(null);
        }
    }

    private void clearPokemonDisplay(Label label, ImageView imageView) {
        label.setText("?");
        imageView.setImage(null);
    }

    public void startBattle(ActionEvent event) {
        if (!areBothTeamsValid()) {
            return;
        }

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fight.fxml"));
            Parent root = loader.load();

            Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            Scene scene = new Scene(root);

            primaryStage.setTitle("Fight");
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (Exception e) {
            System.err.println("ERREUR : Impossible de charger le fichier FXML !");
            e.printStackTrace();
        }
    }

    /**
     * Checks if a team has at least 3 Pokémon.
     * 
     * @param startIndex the starting index in the ComboBox list (0 for Team 1, 4
     *                   for Team 2)
     */
    private boolean isTeamValid(int startIndex) {
        int count = 0;
        List<ComboBox<String>> combosPoke = this.listCombosPoke();
        for (int i = startIndex; i < startIndex + 4; i++) {
            if (isPokemonSelected(combosPoke.get(i))) {
                count++;
            }
        }
        return count >= 3;
    }

    /**
     * Checks if a Pokémon name has been selected in the ComboBox.
     */
    private boolean isPokemonSelected(ComboBox<String> comboBox) {
        String value = comboBox.getValue();
        return value != null && !value.equals("Choisir un Pokemon")
                &&
                !value.trim().isEmpty();
    }

    /**
     * Displays an error dialog.
     */
    private void showError(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    /**
     * Generates a random enemy team with 3 or 4 Pokémon and assigns items randomly.
     */
    private void generateRandomEnemyTeam(HashMap<String, Pokemon> pokemons,
            HashMap<String, Item> objectsCatalog) {

        List<String> pokemonNames = new ArrayList<>(pokemons.keySet());
        List<String> itemNames = new ArrayList<>(objectsCatalog.keySet());
        Random random = new Random();

        List<ComboBox<String>> combosT2Poke = Arrays.asList(comboT2P1,
                comboT2P2,
                comboT2P3,
                comboT2P4);
        List<ComboBox<String>> combosT2Item = Arrays.asList(itemT2P1,
                itemT2P2,
                itemT2P3,
                itemT2P4);

        int numPokemonT2 = 3 + random.nextInt(2); // Choose 3 or 4 randomly

        for (int i = 0; i < 4; i++) {
            // Disable interaction for Team 2
            combosT2Poke.get(i).setDisable(true);
            combosT2Item.get(i).setDisable(true);

            if (i < numPokemonT2) {
                assignRandomPokemon(combosT2Poke.get(i),
                        pokemonNames,
                        random);
                assignRandomItem(combosT2Item.get(i),
                        itemNames,
                        random);
            }
        }

        // Update images immediately for Team 2
        putPokemon();
    }

    /**
     * Assigns a random Pokémon to the given ComboBox.
     */
    private void assignRandomPokemon(ComboBox<String> combo,
            List<String> pokemonNames,
            Random random) {
        String randomPoke = pokemonNames.get(random.nextInt(
                pokemonNames.size()));
        combo.getSelectionModel().select(randomPoke);
    }

    /**
     * Randomly assigns an item or none.
     */
    private void assignRandomItem(ComboBox<String> combo,
            List<String> itemNames,
            Random random) {
        if (random.nextBoolean() && !itemNames.isEmpty()) {
            String randomItem = itemNames.get(random.nextInt(
                    itemNames.size()));
            combo.getSelectionModel().select(randomItem);
        } else {
            combo.getSelectionModel().select("Choisir un Objet");
        }
    }

    /**
     * Checks if both Team 1 and Team 2 are valid.
     * Displays an error message and returns false if they are not.
     */
    private boolean areBothTeamsValid() {
        if (!isTeamValid(0)) {
            showError("Incomplete Team 1", "Team 1 must have at least 3 Pokémon!");
            return false;
        }
        if (!isTeamValid(4)) {
            showError("Incomplete Team 2", "Team 2 must have at least 3 Pokémon!");
            return false;
        }
        return true;
    }
}
