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

    public Type getType() {
        return this.type;
    }

    public double getPower() {
        return this.power;
    }

    public void setPower(double power) {
        this.power = power;
    }

    public int[] setupCombatStats(Pokemon pokemonAttack, Pokemon pokemonDefend) {
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
        if (pokemonDefend.getType2() != null) {
            coefficient *= type.getCoef(pokemonDefend.getType2());
        }
        double damage;
        int[] tableValue = setupCombatStats(pokemonAttack, pokemonDefend);
        double statusCoef = 0;
        if (pokemonDefend.getStatus() != null) {
            statusCoef = pokemonDefend.getStatus().getCoefDamage();
        }
        damage = this.power * ((double) tableValue[0] / tableValue[1]) * coefficient *
                (random.nextInt(85, 100) / 100.0) + pokemonDefend.getMaxHp() * statusCoef;

        // Effet de l'Objet Avant Attaque
        if (pokemonAttack.getItem() != null) {
            damage = pokemonAttack.getItem().effectBeforeAttack(pokemonAttack, pokemonDefend, this);
        }

        return damage;
    }

    public void receiveDamage(Pokemon pokemonAttack, Pokemon pokemonDefend) {
        double degatsBruts = calculateDamage(pokemonAttack, pokemonDefend);

        // Effet de l'Objet Avant Défense
        if (pokemonDefend.getItem() != null) {
            degatsBruts = pokemonDefend.getItem().effectBeforeDefense(pokemonDefend, this, degatsBruts);
        }
        if (pokemonAttack.getItem() != null) {
            degatsBruts = pokemonAttack.getItem().effectBeforeDefense(pokemonAttack, this, degatsBruts);
        }

        pokemonDefend.setHp(pokemonDefend.getHp() - degatsBruts);
    }

    public String getName() {
        return this.name;
    }

    public String getCategory() {
        return category;
    }

    public String toString() {
        return name + " (power=" + power + ", category=" + category + ", type=" + type.getName() + ")";
    }
}
