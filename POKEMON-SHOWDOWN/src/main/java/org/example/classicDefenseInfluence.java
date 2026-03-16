package org.example;

public class classicDefenseInfluence extends Attack {

    int proba;
    double coef;

    public classicDefenseInfluence(String name, int power, String category,
                           Type type, int proba, double coef) {
        super(name, power, category, type);
        this.proba = proba;
        this.coef = coef;
    }

    public void receiveDamage(Pokemon pokemonAttack, Pokemon pokemonDefend){
        super.receiveDamage(pokemonAttack,pokemonDefend);

        this.classicDefenseDamage(pokemonDefend);
    }

    public void classicDefenseDamage(Pokemon pokemonDefend){
        int valueProbability = (int) (Math.random() * 100);

        if (valueProbability < this.proba) {

            pokemonDefend.setClassicDefense((int) (pokemonDefend.getClassicDefense() - (pokemonDefend.getClassicDefenseMax() * this.coef)));
        }

    }
}


