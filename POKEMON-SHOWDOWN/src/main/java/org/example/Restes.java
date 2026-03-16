package org.example;

public class Restes implements Item {
    public String getName() {
        return "Restes";
    }

    public void effectEndTour(Pokemon p) {
            double healthvalue = p.getMaxHp() * 0.08;
            p.setHp(p.getHp() + healthvalue);
         if (p.getHp()>p.getMaxHp()){
            p.setHp(p.getMaxHp());
        }
    }
}

