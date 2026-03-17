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

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

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
    @FXML private ImageView imgT1P1;
    @FXML private ImageView imgT1P2;
    @FXML private ImageView imgT1P3;
    @FXML private ImageView imgT1P4;
    @FXML private ImageView imgT2P1;
    @FXML private ImageView imgT2P2;
    @FXML private ImageView imgT2P3;
    @FXML private ImageView imgT2P4;
    @FXML private ComboBox<String> itemT1P1;
    @FXML private ComboBox<String> itemT1P2;
    @FXML private ComboBox<String> itemT1P3;
    @FXML private ComboBox<String> itemT1P4;

    @FXML private ComboBox<String> itemT2P1;
    @FXML private ComboBox<String> itemT2P2;
    @FXML private ComboBox<String> itemT2P3;
    @FXML private ComboBox<String> itemT2P4;


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
            ComboBox<String> currentCombo = namesCombosPoke.get(i);
            Label currentLabel = listLabels.get(i);
            String pokemonChoisi = currentCombo.getValue();
            ImageView currentImage=listImages().get(i);
            currentLabel.setText(pokemonChoisi);
            String imagePath = "/images/" + pokemonChoisi + ".png";
            Image img = new Image(getClass().getResource(imagePath).toExternalForm());
            currentImage.setImage(img);
        }
    }

    public void startBattle(ActionEvent event){
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


}
