package org.example.status;

import org.example.Pokemon;

public class Paralysie implements Statut {

    public String getName() {
        return "Paralysie";
    }

    public boolean canAttack(Pokemon pokemon) {
        return Math.random() >= 0.25;
    }

    public int modifySpeed(int baseSpeed) {
        return baseSpeed / 2;
    }
}
