package org.example;

public class NormalJewel implements Item {

    @Override
    public String getName() {
        return "NormalJewel";
    }

    @Override
    public double effectBeforeDefense(Pokemon pokemonAttack,
                                      Pokemon pokemonDefend,
                                      Attack a) {

        double finalDamage = a.calculateDamage(pokemonAttack, pokemonDefend);

        if(a.getType().getName().equals("Normal")){
            finalDamage=finalDamage*1.5;
            pokemonAttack.setItem(null);
        }

        return finalDamage;


    }


}
