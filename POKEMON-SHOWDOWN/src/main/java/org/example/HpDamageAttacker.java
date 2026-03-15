package org.example;

public class HpDamageAttacker extends Attack {
    int proba;
    double coef;



    public HpDamageAttacker(String name, int power, String category,
                              Type type,int proba, double coef) {
        super(name, power, category, type);
        this.proba = proba;
        this.coef = coef;
    }

    public void receiveDamage(Pokemon pokemonAttack, Pokemon pokemonDefend){
        super.receiveDamage(pokemonAttack,pokemonDefend);
        this.getDamageAttacker(pokemonAttack, pokemonDefend);
    }


    public void getDamageAttacker (Pokemon pokemonAttack, Pokemon pokemonDefend) {

        pokemonAttack.setHp(pokemonAttack.getHp()-pokemonDefend.getMaxHp()* this.coef);
    }
}







