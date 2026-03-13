package org.example;

import java.util.Random;

public class Attack {
    private String name;
    // private Type type;
    private int power;
    private String category;

    public Attack(String name, int power, String category) {
        this.name = name;
        this.power = power;
        this.category = category;
    }

    public void attack(Pokemon pokemonAttack, Pokemon pokemonDefend) {
        Random random = new Random();
        pokemonDefend.setHp((int) (pokemonDefend.getHp()
                - this.power * ((double) pokemonAttack.getClassicAttack() / pokemonDefend.getClassicDefense())
                        * (random.nextInt(85, 100) / 100.0)));
    }

}
