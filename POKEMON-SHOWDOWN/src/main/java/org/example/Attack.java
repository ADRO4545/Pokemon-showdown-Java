package org.example;

import java.util.Random;

public class Attack {
    private String name;
    private double power;
    private String category;
    private Type type;

    public Attack(String name, int power, String category, Type type) {
        this.name = name;
        this.power = power;
        this.category = category;
        this.type = type;
    }

    public Type getType(){
        return this.type;
    }

    public double getPower(){
        return this.power;
    }

    public void setPower(double power){
        this.power=power;
    }

    public int[] setupCombatStats (Pokemon pokemonAttack, Pokemon pokemonDefend){
        int attackStat;
        int defenseStat;

        if (this.category.equals("speciale")) {
            attackStat = pokemonAttack.getSpecialAttack();
            defenseStat = pokemonDefend.getSpecialDefense();
        } else {
            attackStat = pokemonAttack.getClassicAttack();
            defenseStat = pokemonDefend.getClassicDefense();
        }

        int[] tableValue = { attackStat, defenseStat };
        return tableValue;
    }

    public double calculateDamage(Pokemon pokemonAttack, Pokemon pokemonDefend) {
        Random random = new Random();
        double coefficient = type.getCoef(pokemonDefend.getType());
        double damage;
        int[] tableValue = setupCombatStats(pokemonAttack, pokemonDefend);
        double statusCoef = 0;
        if (pokemonDefend.getStatus() != null) {
            statusCoef = pokemonDefend.getStatus().getCoefDamage();
        }
        damage = this.power * ((double) tableValue[0] / tableValue[1]) * coefficient *
                (random.nextInt(85, 100) / 100.0) + pokemonDefend.getMaxHp() * statusCoef;

        return damage;
    }

    public void receiveDamage(Pokemon pokemonAttack, Pokemon pokemonDefend) {
        pokemonDefend.setHp(pokemonDefend.getHp() -
                calculateDamage(pokemonAttack, pokemonDefend));
    }

    public String getName() {
        return name;
    }

    public int getPower() {
        return power;
    }

    public String getCategory() {
        return category;
    }

    public Type getType() {
        return type;
    }

    public String toString() {
        return name + " (power=" + power + ", category=" + category + ", type=" + type.getName() + ")";
    }
}
