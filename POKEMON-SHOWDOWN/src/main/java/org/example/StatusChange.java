package org.example;

public class StatusChange extends Attack {
    Status newstatus;
    int proba;

    public StatusChange(String name, int power, String category,
                       Type type, int proba, Status newstatus) {
        super(name, power, category, type);
        this.proba = proba;
        this.newstatus = newstatus;
    }

    public void receiveDamage(Pokemon pokemonAttack, Pokemon pokemonDefend){
        super.receiveDamage(pokemonAttack,pokemonDefend);
        this.isChangeState(pokemonDefend);
    }


    public void isChangeState(Pokemon pokemonDefend) {

        int valueProbability = (int) (Math.random() * 100);

        if (valueProbability < this.proba) {

            pokemonDefend.setStatus(this.newstatus);
        }

    }
}
