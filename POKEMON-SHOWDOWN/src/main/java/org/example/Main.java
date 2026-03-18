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

import java.util.HashMap;

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

        // Load data from the database
        HashMap<String, Status> allStatus = Controller.findAllStatut();
        HashMap<String, Type> allTypes = Controller.findAllCoefType();
        HashMap<String, Pokemon> allPokemon = Controller.findAllPokemon(allTypes, allStatus);
        HashMap<String, Attack> allAttacks = Controller.findAllAttacks(allTypes, allPokemon, allStatus);

        Pokemon pokemon1init = allPokemon.get("Ectoplasma");
        Pokemon pokemon2init = allPokemon.get("Carchacrok");

        // determine who start
        Rules rules = new Rules();
        Pokemon[] order = rules.whoStart(pokemon1init, pokemon2init);
        Pokemon pokemon1 = order[0];
        Pokemon pokemon2 = order[1];

        System.out.println("Pokemon 1 (starts) : " + pokemon1);
        System.out.println("Pokemon 2 : " + pokemon2);

        // game loop
        while (!TourManager.isPokemonKO(pokemon1, pokemon2)) {

            if (TourManager.executerAttaques(pokemon1, pokemon2)) {
                break;
            }

            // End of turn item effects
            TourManager.applyEndOfTurnItem(pokemon1);
            TourManager.applyEndOfTurnItem(pokemon2);

            // End of turn status damage
            TourManager.applyEndOfTurnStatus(pokemon1);
            TourManager.applyEndOfTurnStatus(pokemon2);

            // Check KO after status
            if (TourManager.isPokemonKO(pokemon1, pokemon2))
                break;
        }

        // Battle Result
        System.out.println("\n=== END OF BATTLE ===");
        System.out.println(pokemon1.getName() + " HP = " + pokemon1.getHp());
        System.out.println(pokemon2.getName() + " HP = " + pokemon2.getHp());
        if (pokemon1.getHp() > 0) {
            System.out.println(pokemon1.getName() + " wins!");
        } else {
            System.out.println(pokemon2.getName() + " wins!");
        }
    }
}
