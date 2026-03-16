package org.example;

public class NormalJewel implements Item {

    @Override
    public String getName() {
        return "NormalJewel";
    }

    @Override
    public double effectBeforeDefense(Pokemon holder,
            Attack attack,
            double damage) {

        double finalDamage = damage;

        if (attack.getType().getName().equals("Normal")) {
            finalDamage = finalDamage * 1.5;
            holder.setItem(null);
        }

        return finalDamage;

    }

}
