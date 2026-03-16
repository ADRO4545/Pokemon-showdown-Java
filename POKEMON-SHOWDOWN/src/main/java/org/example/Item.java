package org.example;

import org.example.Attack;
import org.example.Pokemon;

public interface Item {
    String getName();

    default void effectEndTour(Pokemon p) {
    }

    default double effectBeforeAttack(Pokemon pokemonAttack,
                                      Pokemon pokemonDefend,
                                      Attack a ) {
        return a.calculateDamage(pokemonAttack,pokemonDefend);
    }

    default double effectBeforeDefense(Pokemon p,
                                       Attack a,
                                       double degats) {
        return degats;
    }

    default void effectAfterStatus(Pokemon p) {
    }
}