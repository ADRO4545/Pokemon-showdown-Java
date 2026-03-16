package org.example;

public class Sunglasses implements Item{

    @Override
    public String getName() {
        return "Sunglasses";
    }


    public double effectBeforeAttack(Pokemon pokemonAttack,
                                     Pokemon pokemonDefend,
                                     Attack a) {

        Type typeAttack=a.getType();
        double finalDamage=a.calculateDamage(pokemonAttack,pokemonDefend);

        if(typeAttack.getName().equals("Dark")){
            finalDamage=finalDamage*1.2;
        }

        return finalDamage;



    }
}
