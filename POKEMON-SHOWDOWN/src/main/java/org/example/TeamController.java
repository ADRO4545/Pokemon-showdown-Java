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
    private Label nomT1P1;
    @FXML
    private Label nomT1P2;
    @FXML
    private Label nomT1P3;
    @FXML
    private Label nomT1P4;

    @FXML
    private ImageView imgT1P1;
    @FXML
    private ImageView imgT1P2;
    @FXML
    private ImageView imgT1P3;
    @FXML
    private ImageView imgT1P4;

    @FXML
    private ComboBox<String> itemT1P1;
    @FXML
    private ComboBox<String> itemT1P2;
    @FXML
    private ComboBox<String> itemT1P3;
    @FXML
    private ComboBox<String> itemT1P4;

    // AAttack team 1
    @FXML
    private ComboBox<String> atk1T1P1;
    @FXML
    private ComboBox<String> atk2T1P1;
    @FXML
    private ComboBox<String> atk3T1P1;
    @FXML
    private ComboBox<String> atk4T1P1;

    @FXML
    private ComboBox<String> atk1T1P2;
    @FXML
    private ComboBox<String> atk2T1P2;
    @FXML
    private ComboBox<String> atk3T1P2;
    @FXML
    private ComboBox<String> atk4T1P2;

    @FXML
    private ComboBox<String> atk1T1P3;
    @FXML
    private ComboBox<String> atk2T1P3;
    @FXML
    private ComboBox<String> atk3T1P3;
    @FXML
    private ComboBox<String> atk4T1P3;

    @FXML
    private ComboBox<String> atk1T1P4;
    @FXML
    private ComboBox<String> atk2T1P4;
    @FXML
    private ComboBox<String> atk3T1P4;
    @FXML
    private ComboBox<String> atk4T1P4;

    private ComboBox<String> comboT2P1 = new ComboBox<>();
    private ComboBox<String> comboT2P2 = new ComboBox<>();
    private ComboBox<String> comboT2P3 = new ComboBox<>();
    private ComboBox<String> comboT2P4 = new ComboBox<>();

    private Label nomT2P1 = new Label();
    private Label nomT2P2 = new Label();
    private Label nomT2P3 = new Label();
    private Label nomT2P4 = new Label();

    private ImageView imgT2P1 = new ImageView();
    private ImageView imgT2P2 = new ImageView();
    private ImageView imgT2P3 = new ImageView();
    private ImageView imgT2P4 = new ImageView();

    private ComboBox<String> itemT2P1 = new ComboBox<>();
    private ComboBox<String> itemT2P2 = new ComboBox<>();
    private ComboBox<String> itemT2P3 = new ComboBox<>();
    private ComboBox<String> itemT2P4 = new ComboBox<>();

    // attack team 2
    private ComboBox<String> atk1T2P1 = new ComboBox<>();
    private ComboBox<String> atk2T2P1 = new ComboBox<>();
    private ComboBox<String> atk3T2P1 = new ComboBox<>();
    private ComboBox<String> atk4T2P1 = new ComboBox<>();

    private ComboBox<String> atk1T2P2 = new ComboBox<>();
    private ComboBox<String> atk2T2P2 = new ComboBox<>();
    private ComboBox<String> atk3T2P2 = new ComboBox<>();
    private ComboBox<String> atk4T2P2 = new ComboBox<>();

    private ComboBox<String> atk1T2P3 = new ComboBox<>();
    private ComboBox<String> atk2T2P3 = new ComboBox<>();
    private ComboBox<String> atk3T2P3 = new ComboBox<>();
    private ComboBox<String> atk4T2P3 = new ComboBox<>();

    private ComboBox<String> atk1T2P4 = new ComboBox<>();
    private ComboBox<String> atk2T2P4 = new ComboBox<>();
    private ComboBox<String> atk3T2P4 = new ComboBox<>();
    private ComboBox<String> atk4T2P4 = new ComboBox<>();

    private HashMap<String, Pokemon> allPokemons;



    @FXML
    public void initialize() {

        HashMap<String, Type> type = Controller.findAllCoefType();
        HashMap<String, Status> status = Controller.findAllStatut();
        HashMap<String, Pokemon> pokemons = Controller.findAllPokemon(type, status);
        HashMap<String, Item> objectsCatalog = new HashMap<>();

        Controller.findAllAttacks(type, pokemons, status);

        objectsCatalog.put("Restes", new Restes());
        objectsCatalog.put("NormalJewel", new NormalJewel());
        objectsCatalog.put("Sunglasses", new Sunglasses());
        objectsCatalog.put("Ball", new Ball());
        objectsCatalog.put("BaiePrine", new BaiePrine());

        List<ComboBox<String>> namesCombosPoke = this.listCombosPoke();
        List<ComboBox<String>> namesCombosObject = this.listCombosObject();

        for (ComboBox<String> cp : namesCombosPoke) {
            cp.getItems().add("Choisir un Pokemon");
            for (Pokemon p : pokemons.values()) {
                String nom = p.getName();
                cp.getItems().add(nom);
            }
            cp.getSelectionModel().select("Choisir un Pokemon");
        }

        for (ComboBox<String> co : namesCombosObject) {
            co.getItems().add("Choisir un Objet");
            co.getItems().addAll(objectsCatalog.keySet());
            co.getSelectionModel().select("Choisir un Objet");
        }

        this.allPokemons = pokemons;

        setupPokemonSelectionListeners();

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

    public List<ComboBox<String>> getAttackCombosForSlot(int slotIndex) {
        switch (slotIndex) {
            case 0:
                return Arrays.asList(atk1T1P1,
                        atk2T1P1,
                        atk3T1P1,
                        atk4T1P1);
            case 1:
                return Arrays.asList(atk1T1P2,
                        atk2T1P2,
                        atk3T1P2,
                        atk4T1P2);
            case 2:
                return Arrays.asList(atk1T1P3,
                        atk2T1P3,
                        atk3T1P3,
                        atk4T1P3);
            case 3:
                return Arrays.asList(atk1T1P4,
                        atk2T1P4,
                        atk3T1P4,
                        atk4T1P4);
            case 4:
                return Arrays.asList(atk1T2P1,
                        atk2T2P1,
                        atk3T2P1,
                        atk4T2P1);
            case 5:
                return Arrays.asList(atk1T2P2,
                        atk2T2P2,
                        atk3T2P2,
                        atk4T2P2);
            case 6:
                return Arrays.asList(atk1T2P3,
                        atk2T2P3,
                        atk3T2P3,
                        atk4T2P3);
            case 7:
                return Arrays.asList(atk1T2P4,
                        atk2T2P4,
                        atk3T2P4,
                        atk4T2P4);
            default:
                return new ArrayList<>();
        }
    }

    private void setupPokemonSelectionListeners() {
        List<ComboBox<String>> pokemonCombos = listCombosPoke();
        for (int i = 0; i < pokemonCombos.size(); i++) {
            final int slotIndex = i;
            ComboBox<String> combo = pokemonCombos.get(i);
            combo.valueProperty().addListener((observable, oldValue, newValue) -> {
                handlePokemonSelectionChange(slotIndex, newValue);
            });
        }
    }

    private void handlePokemonSelectionChange(int slotIndex, String newPokemonName) {
        List<ComboBox<String>> attackCombos = getAttackCombosForSlot(slotIndex);

        // Clear previous attacks
        for (ComboBox<String> atkCombo : attackCombos) {
            atkCombo.getItems().clear();
            atkCombo.getSelectionModel().clearSelection();
        }

        if (isValidPokemonSelection(newPokemonName)) {
            Pokemon selectedPokemon = allPokemons.get(newPokemonName);
            if (selectedPokemon != null) {
                populateAttackCombos(attackCombos, selectedPokemon.getListAttacks());
            }
        }
    }

    private void populateAttackCombos(List<ComboBox<String>> attackCombos,
            List<Attack> pokemonAttacks) {
        List<String> attackNames = new ArrayList<>();
        attackNames.add("Choisir une Attaque");
        for (Attack atk : pokemonAttacks) {
            attackNames.add(atk.getName());
        }

        for (ComboBox<String> atkCombo : attackCombos) {
            atkCombo.getItems().addAll(attackNames);
            atkCombo.getSelectionModel().select("Choisir une Attaque");
        }
    }

    public void putPokemon() {
        List<ComboBox<String>> namesCombosPoke = this.listCombosPoke();
        List<Label> listLabels = this.listLabels();
        List<ImageView> images = this.listImages();

        for (int i = 0; i < namesCombosPoke.size(); i++) {
            updateSinglePokemonDisplay(namesCombosPoke.get(i),
                    listLabels.get(i),
                    images.get(i));
        }
    }

    private void updateSinglePokemonDisplay(ComboBox<String> combo,
            Label label,
            ImageView imageView) {
        String selectedPokemon = combo.getValue();

        if (isValidPokemonSelection(selectedPokemon)) {
            displayPokemon(selectedPokemon, label, imageView);
        } else {
            clearPokemonDisplay(label, imageView);
        }
    }

    private boolean isValidPokemonSelection(String pokemonName) {
        return pokemonName != null &&
                !pokemonName.equals("Choisir un Pokemon") &&
                !pokemonName.trim().isEmpty();
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

    private List<Pokemon> buildTeam(int startIndex) {
        List<Pokemon> team = new ArrayList<>();
        List<ComboBox<String>> combosPoke = this.listCombosPoke();
        List<ComboBox<String>> combosItem = this.listCombosObject(); // <-- NOUVEAU : On récupère les combos d'objets

        // On recrée rapidement notre petit catalogue d'objets pour pouvoir les distribuer
        HashMap<String, Item> objectsCatalog = new HashMap<>();
        objectsCatalog.put("Restes", new Restes());
        objectsCatalog.put("NormalJewel", new NormalJewel());
        objectsCatalog.put("Sunglasses", new Sunglasses());
        objectsCatalog.put("Ball", new Ball());
        objectsCatalog.put("BaiePrine", new BaiePrine());

        for (int i = startIndex; i < startIndex + 4; i++) {
            ComboBox<String> currentPokeCombo = combosPoke.get(i);

            if (isPokemonSelected(currentPokeCombo)) {
                String pokemonName = currentPokeCombo.getValue();
                Pokemon basePoke = allPokemons.get(pokemonName);
                Pokemon realPoke = new Pokemon(basePoke);

                // 1. Ajout des attaques (ton code actuel)
                List<ComboBox<String>> attackCombos = getAttackCombosForSlot(i);
                for (ComboBox<String> atkCombo : attackCombos) {
                    if (isAttackSelected(atkCombo)) {
                        String atkName = atkCombo.getValue();
                        for(Attack atk : basePoke.getListAttacks()) {
                            if(atk.getName().equals(atkName)) {
                                realPoke.addAttack(atk);
                                break;
                            }
                        }
                    }
                }



                team.add(realPoke);
            }
        }
        return team;
    }

    public void startBattle(ActionEvent event) {
        if (!areBothTeamsValid() || !areAttacksValid()) {
            return;
        }

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/firstchoose.fxml"));
            Parent root = loader.load();
            FirstChooseController chooseController = loader.getController();


            List<Pokemon> playerTeam = buildTeam(0); // 0 = index de départ pour l'équipe 1
            List<Pokemon> enemyTeam = buildTeam(4);  // 4 = index de départ pour l'équipe 2

            // On envoie les VRAIS Pokémon
            chooseController.setTeamsData(playerTeam, enemyTeam);

            Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            primaryStage.setScene(new Scene(root));
            primaryStage.setTitle("Choix du premier Pokémon");
            primaryStage.show();

        } catch (Exception e) {
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
                assignRandomAttacksForSlot(i + 4, random);
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

    private void assignRandomAttacksForSlot(int slotIndex, Random random) {
        List<ComboBox<String>> attackCombos = getAttackCombosForSlot(slotIndex);

        if (attackCombos.isEmpty()) return;

        // On récupère la liste des attaques disponibles (en ignorant "Choisir une Attaque" à l'index 0)
        List<String> availableAttacks = attackCombos.get(0).getItems();
        int nbAttaquesReelles = availableAttacks.size() - 1;

        if (nbAttaquesReelles <= 0) return;

        // 1. On crée un "chapeau" avec les numéros de toutes les attaques possibles (1, 2, 3...)
        List<Integer> indexPossibles = new ArrayList<>();
        for (int i = 1; i <= nbAttaquesReelles; i++) {
            indexPossibles.add(i);
        }

        // 2. On secoue le chapeau pour tout mélanger
        java.util.Collections.shuffle(indexPossibles, random);

        // 3. On distribue les attaques aux 4 cases sans jamais remettre un numéro dans le chapeau
        for (int i = 0; i < attackCombos.size(); i++) {
            ComboBox<String> atkCombo = attackCombos.get(i);
            atkCombo.setDisable(true); // On bloque la modification pour l'équipe 2

            if (i < indexPossibles.size()) {
                // On pioche le numéro suivant dans notre liste mélangée
                atkCombo.getSelectionModel().select(indexPossibles.get(i));
            } else {
                // S'il n'y a plus de numéros dans le chapeau (le Pokémon a moins de 4 attaques)
                atkCombo.getSelectionModel().select("Choisir une Attaque");
            }
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

    private boolean areAttacksValid() {
        List<ComboBox<String>> combosPoke = this.listCombosPoke();

        for (int i = 0; i < combosPoke.size(); i++) {
            ComboBox<String> currentPokeCombo = combosPoke.get(i);

            if (isPokemonSelected(currentPokeCombo)) {
                List<ComboBox<String>> attackCombos = getAttackCombosForSlot(i);
                boolean hasAtLeastOneAttack = false;
                List<String> selectedAttacks = new ArrayList<>(); // Mémoire pour les doublons

                String pokemonName = currentPokeCombo.getValue();
                String teamName = (i < 4) ? "L'équipe 1" : "L'équipe 2";

                for (ComboBox<String> atkCombo : attackCombos) {
                    if (isAttackSelected(atkCombo)) {
                        hasAtLeastOneAttack = true;
                        String attackName = atkCombo.getValue();

                        // Appel de la petite fonction pour vérifier les doublons
                        if (isAttackDuplicated(selectedAttacks, attackName, pokemonName, teamName)) {
                            return false;
                        }

                        selectedAttacks.add(attackName);
                    }
                }

                if (!hasAtLeastOneAttack) {
                    showError("Attaques manquantes", teamName +
                            " a un problème : le Pokémon " +
                            pokemonName +
                            " doit avoir au moins une attaque !");
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isAttackDuplicated(List<String> memoryList, String attackName, String pokemonName,
            String teamName) {
        if (memoryList.contains(attackName)) {
            showError("Attaque en double", teamName + " a un problème : le Pokémon " + pokemonName
                    + " possède plusieurs fois l'attaque '" + attackName + "' !");
            return true;
        }
        return false;
    }

    /**
     * Check if an v alid attack is selected
     */
    private boolean isAttackSelected(ComboBox<String> comboBox) {
        String value = comboBox.getValue();
        return value != null &&
                !value.equals("Choisir une Attaque") &&
                !value.trim().isEmpty();
    }
}
