package org.example;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        // status
        HashMap<String, Status> allStatus = Controller.findAllStatut();

        // types and coefficient efficacity
        HashMap<String, Type> allTypes = Controller.findAllCoefType();

        // Pokemon chagre from bdd
        HashMap<String, Pokemon> allPokemon = Controller.findAllPokemon(allTypes, allStatus);

        // 4. Charger les attaques et les associer aux pokémon
        HashMap<String, Attack> allAttacks = Controller.findAllAttacks(allTypes, allPokemon, allStatus);

        // Retrieve 2 Specific Pokemon
        Pokemon pokemon1 = allPokemon.get("Pikachu");
        Pokemon pokemon2 = allPokemon.get("Dracaufeu");

        System.out.println("\n=== Premier Pokémon ===");
        if (pokemon1 != null) {
            System.out.println(pokemon1);
            System.out.println("  Attaques : ");
            for (Attack a : pokemon1.getListAttacks()) {
                System.out.println("    - " + a);
            }
        } else {
            System.out.println("Pikachu non trouvé dans la base de données.");
        }

        System.out.println("\n=== Deuxième Pokémon ===");
        if (pokemon2 != null) {
            System.out.println(pokemon2);
            System.out.println("  Attaques : ");
            for (Attack a : pokemon2.getListAttacks()) {
                System.out.println("    - " + a);
            }
        } else {
            System.out.println("Dracaufeu non trouvé dans la base de données.");
        }

    }
}