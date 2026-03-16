package org.example.status;

import org.example.Pokemon;

public class Poison implements Statut {

    public String getName() {
        return "Poison";
    }

    public boolean canAttack(Pokemon pokemon) {
        return true;
    }

    public void applyEndOfTurn(Pokemon pokemon) {
        double damage = pokemon.getHp() / 8.0;
        pokemon.setHp(pokemon.getHp() - damage);
    }
}
