package org.example;

public class Ball implements Item {
    @Override
    public String getName() {
        return "Ball";
    }

    public double effectBeforeDefense(Pokemon pokemonAttack,
                                      Pokemon pokemonDefend,
                                      Attack a) {

        double finalDamage = a.calculateDamage(pokemonAttack, pokemonDefend);

        if (a.getType().getName().equals("Ground")) {
            finalDamage = 0;

        } else {
            pokemonAttack.setItem(null);
        }
        return finalDamage;
    }
}
