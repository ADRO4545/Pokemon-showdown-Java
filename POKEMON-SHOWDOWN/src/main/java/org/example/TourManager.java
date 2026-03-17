package org.example;

public class TourManager {

    /**
     * Make attack and return true if one of the pokemon is KO
     */
    public static boolean executerAttaques(Pokemon pokemon1, Pokemon pokemon2) {
        Main.jouerTour(pokemon1, pokemon2);
        if (isPokemonKO(pokemon1, pokemon2))
            return true;

        Main.jouerTour(pokemon2, pokemon1);
        if (isPokemonKO(pokemon1, pokemon2))
            return true;

        return false;
    }

    public static boolean isPokemonKO(Pokemon pokemon1, Pokemon pokemon2) {
        return pokemon1.getHp() <= 0 || pokemon2.getHp() <= 0;
    }

    public static void makeEffectsObjectsAfterAttack(Pokemon attaquant, Pokemon defenseur) {
        if (defenseur.getItem() != null) {
            defenseur.getItem().effectAfterStatus(defenseur);
        }
        if (attaquant.getItem() != null) {
            attaquant.getItem().effectAfterStatus(attaquant);
        }
    }
}
