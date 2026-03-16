package org.example.status;

import org.example.Pokemon;

public class Brulure implements Statut {

    public String getName() {
        return "Brulure";
    }

    public boolean canAttack(Pokemon pokemon) {
        return true;
    }

    public void applyEndOfTurn(Pokemon pokemon) {
        double damage = pokemon.getHp() / 16.0;
        pokemon.setHp(pokemon.getHp() - damage);
    }

    public double modifyAttackPower(double basePower, String category) {
        if (category == "physique") {
            return basePower / 2.0;
        }
        return basePower;
    }
}
