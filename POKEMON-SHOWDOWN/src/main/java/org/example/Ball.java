package org.example;

public class Ball implements Item {
    @Override
    public String getName() {
        return "Ball";
    }

    public double effectBeforeDefense(Pokemon holder,
            Attack attack,
            double damage) {

        double finalDamage = damage;

        if (attack.getType().getName().equals("Ground")) {
            finalDamage = 0;

        } else {
            holder.setItem(null);
        }
        return finalDamage;
    }
}
