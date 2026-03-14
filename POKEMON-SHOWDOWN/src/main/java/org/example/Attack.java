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

    public int[] setupCombatStats (Pokemon pokemonAttack, Pokemon pokemonDefend){
        int attackStat;
        int defenseStat;

        if (this.category.equals("special")) {

            attackStat = pokemonAttack.getSpecialAttack();
            defenseStat = pokemonDefend.getSpecialDefense();


        } else {
            attackStat = pokemonAttack.getClassicAttack();
            defenseStat = pokemonDefend.getClassicDefense();
        }

        int[] tableValue={attackStat, defenseStat};

        return tableValue;
    }

    public double calculateDamage(Pokemon pokemonAttack, Pokemon pokemonDefend) {

        Random random = new Random();
        double damage;
        int[] tableValue=setupCombatStats(pokemonAttack,pokemonDefend);
        damage=this.power * ((double) tableValue[0] / tableValue[1])
                        * (random.nextInt(85, 100) / 100.0);

        return damage;
    }

    public void receiveDamage(Pokemon pokemonAttack, Pokemon pokemonDefend){

        pokemonDefend.setHp(pokemonDefend.getHp()-
                calculateDamage(pokemonAttack, pokemonDefend));
    }

}
