package org.example.status;

import org.example.Pokemon;

public interface Statut {

    String getName();

    boolean canAttack(Pokemon pokemon);

    // Function to call each end of turn with pokemone on parameters
    void applyEndOfTurn(Pokemon pokemon);
}
