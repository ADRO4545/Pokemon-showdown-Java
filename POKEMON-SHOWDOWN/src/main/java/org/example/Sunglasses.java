package org.example;

public class Sunglasses implements Item {

    @Override
    public String getName() {
        return "Sunglasses";
    }

    public double effectBeforeAttack(Pokemon attacker,
            Pokemon defender,
            Attack attack) {

        Type typeAttack = attack.getType();
        double finalDamage = attack.calculateDamage(attacker, defender);

        if (typeAttack.getName().equals("Dark")) {
            finalDamage = finalDamage * 1.2;
        }

        return finalDamage;

    }
}
