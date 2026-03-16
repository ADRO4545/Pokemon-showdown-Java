package org.example;

import org.example.Attack;
import org.example.Pokemon;

public interface Item {
    String getName();

    default void effectEndTour(Pokemon holder) {
    }

    default double effectBeforeAttack(Pokemon attacker,
                                      Pokemon defender,
                                      Attack attack ) {
        return attack.calculateDamage(attacker, defender);
    }

    default double effectBeforeDefense(Pokemon holder,
                                       Attack attack,
                                       double damage) {
        return damage;
    }

    default void effectAfterStatus(Pokemon holder) {
    }
}