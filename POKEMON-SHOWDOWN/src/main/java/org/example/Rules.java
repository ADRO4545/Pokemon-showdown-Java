package org.example;

public class Rules {

    /**
     * 
     * @param pokemon1
     * @param pokemon2
     * @return true if pokemon1 begin, false if pokemon2 begin
     */

    public boolean whoBegin(Pokemon pokemon1, Pokemon pokemon2) {
        if (pokemon1.getSpeed() > pokemon2.getSpeed()) {
            return true;
        } else {
            return false;
        }
    }

    public Pokemon[] whoStart(Pokemon pokemon1, Pokemon pokemon2) {
        if (whoBegin(pokemon1, pokemon2)) {
            return new Pokemon[] { pokemon1, pokemon2 };
        } else {
            return new Pokemon[] { pokemon2, pokemon1 };
        }
    }

    // public void loop(Pokemon[] pokemon) {
    // Pokemon pokemon1 = pokemon[0];
    // Pokemon pokemon2 = pokemon[1];

    // pokemon1.attack(pokemon2);
    // // Tout le reste

    // pokemon2.attack(pokemon1);
    // // Tout le reste

    // }

}
