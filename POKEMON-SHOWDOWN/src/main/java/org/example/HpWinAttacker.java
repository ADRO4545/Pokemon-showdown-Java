package org.example;

public class HpWinAttacker extends Attack {
    int proba;
    double coef;



    public HpWinAttacker(String name, int power, String category,
                       Type type, int proba, double coef) {
        super(name, power, category, type);
        this.proba = proba;
        this.coef = coef;
    }

    public void receiveDamage (Pokemon pokemonAttack, Pokemon pokemonDefend) {
        super.receiveDamage(pokemonAttack,pokemonDefend);
        this.winHp(pokemonAttack, pokemonDefend);
    }

    public void winHp (Pokemon pokemonAttack, Pokemon pokemonDefend){
        pokemonAttack.setHp(pokemonAttack.getHp() + calculateDamage(pokemonAttack, pokemonDefend)*this.coef);
    }




}







